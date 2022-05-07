package realLei.kafkademo;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author lei
 * @date 07/13/2021 2:39 PM
 */
public class KafkaConsumer_SubscribeAndAssign {

    private static final String brokerList = "node1:9092,node2:9093,node3:9094";
    private static final String topic = "TOPIC1";
    private static final String groupId = "some.random.group.id";
    private static final AtomicBoolean isRunning = new AtomicBoolean(true);

    public static Properties initConfig() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        return properties;
    }

    public static void main(String[] args) {
        Properties properties = initConfig();
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        // subscribeDemo(consumer);

        assignDemo(consumer);
    }

    public static void subscribeDemo(KafkaConsumer<String, String> consumer) {
        consumer.subscribe(Arrays.asList(topic));

        try {
            while (isRunning.get()){
                ConsumerRecords<String, String> records =  consumer.poll(Duration.ofSeconds(1L));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("topic: "+record.topic()+", partition: "+record.partition()+", offset: "+record.offset());
                    System.out.println("key= "+record.key() + ", value= "+record.value());
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }

    public static void assignDemo(KafkaConsumer<String, String> consumer) {
        TopicPartition tp = new TopicPartition(topic, 0);
        consumer.assign(Arrays.asList(tp));
        long lastConsumedOffset = -1;

        while (isRunning.get()){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1L));
            if (records.isEmpty()) break;

            List<ConsumerRecord<String, String>> partitionRecords = records.records(tp);
            lastConsumedOffset =  partitionRecords.get(partitionRecords.size() - 1).offset();
            consumer.commitSync(); // commit

            System.out.println("consumed offset is: " + lastConsumedOffset);
            System.out.println();

            OffsetAndMetadata offsetAndMetadata = consumer.committed(tp);
            System.out.println("committed offset is: " + offsetAndMetadata.offset());
            System.out.println();

            long position = consumer.position(tp);
            System.out.println("offset of next record: " + position);


        }
    }
}

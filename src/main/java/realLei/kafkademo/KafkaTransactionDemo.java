package realLei.kafkademo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.errors.ProducerFencedException;

import java.util.Properties;

/**
 * @author lei
 * @date 02/03/2021 10:06 AM
 */
public class KafkaTransactionDemo {

    private static final String brokerList = "node1:9092,node2:9093,node3:9094";
    private static final String topic = "TOPIC1";

    private static final String TRANSACTION_ID = "19999";

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        properties.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, TRANSACTION_ID);

        Producer<String, String> producer = new KafkaProducer<String, String>(properties);

        producer.initTransactions();
        producer.beginTransaction();

        try {

            ProducerRecord<String, String> record1 = new ProducerRecord(topic, "************** 1 **************");
            ProducerRecord<Object, String> record2 = new ProducerRecord(topic, "************** 2 **************");
            ProducerRecord<Object, String> record3 = new ProducerRecord(topic, "************** 3 **************");

            //
            producer.commitTransaction();

        } catch (ProducerFencedException pe) {
            producer.abortTransaction();
        }
    }
}

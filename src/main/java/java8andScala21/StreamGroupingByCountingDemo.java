package java8andScala21;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author lei
 * @date 07/06/2021 5:37 PM
 */
public class StreamGroupingByCountingDemo {
    public static void main(String[] args) {
        //3 apple, 2 banana, others 1
        List<String> items =
                Arrays.asList("apple", "pear", "apple", "banana", "blueberry", "pear",
                        "apple", "orange", "banana", "papaya", "blueberry", "pear");
        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting())
                );
        System.out.println(result);
    }
}

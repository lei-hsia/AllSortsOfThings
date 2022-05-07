package ap.extra;

import java.util.Arrays;
import java.util.List;

/**
 * @author lei
 * @date 03/28/2022 11:20 AM
 */
public class ArrayAsListDeo {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3, 5);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
        return;
    }
}

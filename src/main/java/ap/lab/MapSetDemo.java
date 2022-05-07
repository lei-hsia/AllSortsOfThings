package ap.lab;

import java.util.*;

/**
 * @author lei
 * @date 02/12/2022 8:49 PM
 */
public class MapSetDemo {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1); integers.add(2); integers.add(2);
        integers.add(1); integers.add(5);
        integers.add(1); integers.add(4);

        // how many times each number appears in this arrayList
        // keep a record of this: 1 -> 3; 2 -> 2; 4 ->5
        /*
         *   use a map to keep record of frequency of each number: <number, freq>
                Map: <key, value>
         * */
        // number -> freq
        Map<Integer, Integer> map = new HashMap<>();

        Set<Integer> set = new HashSet<>();

        for (int i : integers) {
            set.add(i);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        /*for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            System.out.println(entry);
        }*/

        for (int i : set) {
            System.out.print(i + " ");
        }

        for (int num : integers) {
            if (num >> 1 == 0) {
                integers.add(num);
            }
        }

        int[] arr = new  int[2];
        Arrays.sort(arr);
    }
}

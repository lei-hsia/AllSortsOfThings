package ap.extra;

import org.omg.CORBA.INTERNAL;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lei
 * @date 04/06/2022 3:39 PM
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] nums = {9, 4, 3, 6, 7, 2, 1, 8, 5};
        for(int i : nums) {
            pq.offer(i);
            if (pq.size() > 4) {
                pq.poll();
            }
        }
//        System.out.println(pq.peek()); // 6

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " "); // 6 7 8 9
        }

        System.out.println();
        System.out.println("*****************");

        PriorityQueue<int[]> pq1 = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Map.Entry<Integer, Integer>> pq2 = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        Map<Integer, Integer> m = new HashMap<>();
        m.put(2, 5); m.put(3, 3); m.put(1, 9); m.put(5, 2);


        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            pq2.offer(e);
            if (pq2.size() > 3) {
                pq2.poll();
            }
        }
        List<Map.Entry<Integer, Integer>> res = new ArrayList<>();
        while (res.size() < 3) {
            res.add(pq2.poll());
        }

        for (Map.Entry<Integer, Integer> e: res) {
            System.out.print(e + " ");
        }

    }
}

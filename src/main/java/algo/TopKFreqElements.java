package algo;

import java.util.*;

/**
 * @author lei
 * @date 03/18/2022 4:46 PM
 */
public class TopKFreqElements {
    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // now pq contains k elements of highest freq
        List<Integer> res = new ArrayList();
        while (res.size() < k) {
            res.add(pq.poll().getKey());
        }

        return new int[2];
    }
}

package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author lei
 * @date 05/07/2022 5:09 PM
 */
public class L373kSmallestSumPair {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]+a[1] - b[0]-b[1]);
        int n1 = nums1.length, n2 = nums2.length;
        List<List<Integer>> res = new ArrayList();
        if (n1 == 0 || n2 == 0) return res;

        for (int i = 0; i < n1 && i < k; ++i) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (k -- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            List<Integer> tmp = new ArrayList();
            tmp.add(cur[0]); tmp.add(cur[1]);
            res.add(tmp);
            if (cur[2] == n2 - 1) continue;
            pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2]  + 1});
        }

        return res;
    }

    /*
    [1,7,11]
    [2,4,6]
    3
    * */
    public static void main(String[] args) {
        kSmallestPairs(new int[]{1, 7, 11}, new int[]{2,4,6}, 3);
    }
}

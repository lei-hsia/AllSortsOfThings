package algo.c;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lei
 * @date 04/22/2022 10:27 AM
 */
public class DiskSpaceMin {
    public static int[] maxOfMin(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<int[]> deque = new ArrayDeque<int[]>();

        for(int i = 0; i < n; i++){
            while(!deque.isEmpty() && i-deque.getFirst()[1] >= k) deque.pollFirst();
            while(!deque.isEmpty() && deque.getLast()[0] > nums[i]) deque.pollLast();

            deque.addLast(new int[]{nums[i],i});
            if(i >= k-1) res[i-k+1] = deque.getFirst()[0];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] spaces = {8, 2, 4, 6};
        int k = 2;
        int[] ints = maxOfMin(spaces, k);
        int max = Integer.MIN_VALUE;
        for (int anInt : ints) {
            System.out.print(anInt + " ");
            if (max < anInt) max = anInt;
        }
        System.out.println("max: " + max);
    }
}

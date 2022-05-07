package algo.c;

/**
 * @author lei
 * @date 04/21/2022 2:50 PM
 *
 * Ways to sum to N using Natural Numbers up to K with repetitions allowed
 *
 * Given two integers N and K, the task is to find the total number of ways
 * of representing N as the sum of positive integers in the range [1, K],
 * where each integer can be chosen multiple times.
 *
 *  Input: total = 8, k = 2
 *  To reach a weight of 8, there are 5 different ways that items with weights between 1 and 2 can be combined:
 *
 * [1,1,1,1,1,1,1,1]
 * [1,1,1,1,1,1,2]
 * [1,1,1,1,2,2]
 * [1,1,2,2,2]
 * [2,2,2,2]
 * Output: 5
 *
 * Constraints
 * 1 <= total <= 1000
 * 1 <= k <= 100
 *
 * https://www.geeksforgeeks.org/ways-to-sum-to-n-using-natural-numbers-up-to-k-with-repetitions-allowed/
 * https://algo.monster/problems/ways_to_sum
 * https://www.1point3acres.com/bbs/thread-771123-1-1.html    << 2d array
 */
public class Ways2Sum1D {
/*
*   Considering dp[i] stores the total number of ways for representing i as the sum of
*   integers lying in the range [1, K], then the transition of states can be defined as:
        For i in the range [1, K] and for every j in the range [1, N]
        The value of dp[j] is equal to (dp[j]+ dp[j – i]), for all j ≥ i.
* */

    //  ways to represent N as the sum of integers over the range [1, K]
    public static int numOfWays(int n, int k) {
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i = 1; i < k + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (j >= i) {
                    dp[j] = dp[j] + dp[j - i];
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numOfWays(8, 2));
        System.out.println(numOfWays(100, 3));
        System.out.println(numOfWays(1000, 20));
    }
}

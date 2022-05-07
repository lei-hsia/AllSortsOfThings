package algo.c;

/**
 * @author lei
 * @date 04/21/2022 3:04 PM
 */
public class Ways2Sum2D {
    /*
    *   dp[i][j]: # ways sum up to j, using first i-th elements from nums = [1, 2, ..., k]
    * */
    public static int numOfWays(int total, int k) {
        int[] nums = new int[k+1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }

        int[][] dp = new int[k+1][total + 1];
        for (int i = 0; i < k+1; i++) {
            dp[i][0] = 1;
        }

        int multi;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= total; j++) {
                multi = 0;
                while (j >= multi * nums[i-1]) {
                    dp[i][j] += dp[i-1][j - multi * nums[i-1]];
                    multi++;
                }
            }
        }

        return dp[k][total];
    }

    public static void main(String[] args) {
        System.out.println(numOfWays(8, 2));
        System.out.println(numOfWays(100, 3));
        System.out.println(numOfWays(1000, 20));
    }
}

package algo.c;

import java.util.Arrays;

/**
 * @author lei
 * @date 04/22/2022 3:50 PM
 */
public class GlobalMax {
    /*
    *   An array, given subsequence length m;
    *   globalMax := min(abs of all pair diff)
    *
    *   @param: n: size of array; m: subsequence length
    * */
    public static int findMax(int n, int[] arr, int m) {
        Arrays.sort(arr);
        int left = 0, right = arr[n-1];
        int res = 0;

        while (left <= right) {
            // min diff = mid
            int mid = (left + right) / 2;
            if (existSubsequence(arr, m, mid)) {
                res = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return res;
    }

    private static boolean existSubsequence(int[] arr, int m, int mid) {
        int n = arr.length;
        int count = 1;
        int prev = arr[0]; // going to be prev recorded number

        for (int i = 1; i < n; ++i) {
            if (arr[i] - prev >= mid) {
                prev = arr[i];
                count++;
                if (count == m)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findMax(4, new int[]{2, 3, 5, 9}, 3));
    }
}

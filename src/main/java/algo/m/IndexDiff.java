package algo.m;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lei
 * @date 04/23/2022 3:22 PM
 */
public class IndexDiff {
    public static int solution(int[] A) {
        int N = A.length;
        int result = 0;
        Map<Integer, Integer> val2Index = new HashMap<>();

        Map<Integer, Boolean> secondVisited = new HashMap<>();

        int j = N-1;

        for (int i = 0; i < N; i++) {
            if (val2Index.containsKey(A[i]) && !secondVisited.get(A[i])) {
                //result = Math.max(result, i - val2Index.get(A[i]));
                j = N-1;
                while (A[j] != A[i]) {
                    --j;
                }
                result = Math.max(result, j - val2Index.get(A[i]));
                secondVisited.put(A[i], true);
            }
            else {
                val2Index.put(A[i], i);
                secondVisited.put(A[i], false);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 6, 2, 2, 6, 6, 1}));
    }
}

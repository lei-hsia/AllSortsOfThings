package algo.c;

/**
 * @author lei
 * @date 04/22/2022 2:22 PM
 */
public class ThrottleGateway {
    public static int numDrop(int[] reqTime) {
        int onePtr = 0, tenPtr = 0, minPtr = 0;
        int count = 0;

        for (int i = 0; i < reqTime.length; i++) {
            int t = reqTime[i];
            while (t - reqTime[minPtr] >= 60) {
                minPtr++;
            }
            while (t - reqTime[tenPtr] >= 10) {
                tenPtr++;
            }
            if (t != reqTime[onePtr]) {
                onePtr = i;
            }
            if (i - minPtr >= 60 || i - tenPtr >= 20 || i - onePtr >= 3) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numDrop(new int[]{1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,11,11,11,11}));
    }
}

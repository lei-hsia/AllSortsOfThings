package ap.chapter7;

/**
 * @author lei
 * @date 01/07/2022 6:38 PM
 */
public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] arr = {2,3,5,7,11,13,17,19,23,29,31,37,41};
        System.out.println(binarySearch(arr, 31));
        System.out.println(Math.round(-4.5));
    }

    private static int binarySearch(int[] arr, int x) {

        int left = 0,  right = arr.length - 1;
        while (left <= right) {
            int m = left + (right - left) / 2;

            if (arr[m] == x) return m;
            if (arr[m] < x)
                left = m + 1;
            else right = m - 1;
        }
        // If we reach here, element is not present
        return -1;
    }

}

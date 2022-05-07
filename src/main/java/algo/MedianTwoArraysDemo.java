package algo;

/**
 * @author lei
 * @date 03/18/2022 3:22 PM
 */
public class MedianTwoArraysDemo {
    public static void main(String[] args) {
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2;
    }

    private static double getKth(int[] a, int aStart, int[] b, int bStart, int k) {

        int m = a.length, n = b.length;
        if (aStart >= m) return b[bStart + k - 1];
        if (bStart >= n) return a[aStart + k - 1];
        if (k == 1) return Math.min(a[aStart], b[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < m) aMid = a[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < n) bMid = b[bStart + k/2 - 1];

        if (aMid < bMid)
            return getKth(a, aStart + k/2, b, bStart, k - k/2);
        else
            return getKth(a, aStart, b, bStart + k/2, k - k/2);
    }
}

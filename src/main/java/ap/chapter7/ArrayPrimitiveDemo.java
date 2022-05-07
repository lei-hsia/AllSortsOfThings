package ap.chapter7;

import java.util.Arrays;

/**
 * @author lei
 * @date 01/07/2022 10:10 AM
 */
public class ArrayPrimitiveDemo {
    public static void main(String[] args) {

        int[]  nums1 = new int[3];
        int[]  nums2 = new int[3];
        Arrays.fill(nums1, 1);
        Arrays.fill(nums2, 1);
        /*
         * primitive type:
         *   enhanced for loop : replace element;
         *   >>> doesn't pass array/object address, i.e. not modifying original array;
         *   but create a copy of nums1
         *
         * THIS IS WHY: Do not use enhanced for loop to replace/remove elements
         * */
        for (int i: nums1) {
            i = 4;
        }
        /*
         * primitive type:
         *   typical for loop: modify nums2 object reference/address, change values OK
         * */
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = 4;
        }
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : nums2) {
            System.out.print(num + " ");
        }
    }
}

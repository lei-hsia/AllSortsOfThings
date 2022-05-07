package ap.extra;

/**
 * @author lei
 * @date 04/16/2022 7:00 PM
 */
public class KthLargestElement{
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length -1 ;
        while (left <= right) {
            int mid = quickSelect(nums, left, right);
            if (mid == k - 1)
                return nums[mid];
            else if (mid > k - 1) {
                right = mid  - 1;
            }
            else
                left = mid + 1;
        }

        return -1;
    }

    private int quickSelect(int[] nums, int left, int right) {
        int pivot = nums[left];

        while (left < right) {
            while (left < right && pivot >= nums[right]) --right;
            nums[left] = nums[right];
            while (left < right && pivot <= nums[left]) ++left;
            nums[right] = nums[left];
        }

        nums[left] = pivot;
        return left;
    }
}
package SearchInsertPosition;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        boolean flag = false;
        while(l < r) {
            int mid = (l+r)/2;
            if (nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        if (!flag) {
            int i = 0;
            while(target > nums[i] && i < nums.length - 1) {
                i++;
            }
            if ( i == nums.length - 1 && target > nums[i]) {
                return i + 1;
            } else {
                return i;
            }
        }
        return -1;
    }
}

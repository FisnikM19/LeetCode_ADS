package RemoveElement;

import java.util.Scanner;

public class Solution {
    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] nums = new int[size];

        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        int val = sc.nextInt();

        int k = removeElement(nums, val);

        int[] expectedNums = new int[k];
        for (int i = 0; i < k; i++) {
            expectedNums[i] = nums[i];
        }

        System.out.print("{");
        for (int i = 0; i < k - 1; i++) {
            System.out.print(expectedNums[i] + ", ");
        }
        System.out.println(expectedNums[k - 1] + "}");
    }
}

package Remove_Duplicates_SortedArray;

// The Intuition is to use two pointers, i and j, to iterate through the array.
// The variable j is used to keep track of the current index where a unique element should be placed.
// The initial value of j is 1 since the first element in the array is always unique and doesn't need to be changed.
//
// Explanation:
// The code starts iterating from i = 1 because we need to compare each element with its previous element to check for duplicates.
//
// The main logic is inside the for loop:
//
// If the current element nums[i] is not equal to the previous element nums[i - 1], it means we have encountered a new unique element.
// In that case, we update nums[j] with the value of the unique element at nums[i],
// and then increment j by 1 to mark the next position for a new unique element.
// By doing this, we effectively overwrite any duplicates in the array and only keep the unique elements.
// Once the loop finishes, the value of j represents the length of the resulting array with duplicates removed.
//
// Finally, we return j as the desired result.

import java.util.Scanner;

public class Solution {
    public static int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
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

        int k = removeDuplicates(nums);

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

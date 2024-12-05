package ContainsDuplicates;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i != map.get(nums[i])) {
                return true;
            }

            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(containsDuplicate(arr));
    }
}

package MajorityElement;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static int majorityElement(int[] nums) {

        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        if (n != 1) {
            for (int num : nums) {
                if (!map.containsKey(num)) {
                    map.put(num, 1);
                } else {
                    map.put(num, map.get(num) + 1);
                    if (map.get(num) > n / 2) {
                        return num;
                    }
                }
            }
        }

        return nums[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(majorityElement(arr));
    }
}

package FirstOccurence;

import java.util.Scanner;

public class Solution {
    public static int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        // Edge case: if needle is empty, we return 0 as per problem conventions
        if (needleLength == 0) {
            return 0;
        }

        // Loop through haystack only up to the point where needle could fit
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            // Check if substring of haystack starting at i matches needle
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }
        }

        // Return -1 if needle is not found in haystack
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String haystack = sc.next();
        String needle = sc.next();

        int occurrence = strStr(haystack, needle);

        System.out.println(occurrence);
    }
}

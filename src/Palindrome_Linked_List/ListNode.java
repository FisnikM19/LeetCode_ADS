package Palindrome_Linked_List;


import java.util.ArrayList;

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();


        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int l = 0;
        int r = list.size() - 1;

        while (l <= r) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
// Time complexity: O(n)
// Space complexity: O(n)

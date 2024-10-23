package HasCycle;
// Given head, the head of a linked list, determine if the linked list has a cycle in it.
//
// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
// Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
//
// Return true if there is a cycle in the linked list. Otherwise, return false.

// Example 1
// Input: head = [3,2,0,-4], pos = 1
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
//
// Example 2
// Input: head = [1,2], pos = 0
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
//
// Example 3
// Input: head = [1], pos = -1
// Output: false
// Explanation: There is no cycle in the linked list.


// Definition for singly-linked list.

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    // Helper function to create a linked list with a cycle
    public static ListNode createListWithCycle(int[] values, int pos) {
        if (values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        ListNode cycleNode = null;

        if (pos == 0) {
            cycleNode = head; // Mark the head as the start of the cycle
        }

        // Build the linked list
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;

            // Save the reference to the node where the cycle starts
            if (i == pos) {
                cycleNode = current;
            }
        }

        // Create the cycle
        if (pos != -1) {
            current.next = cycleNode;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: Input: head = [3, 2, 0, -4], pos = 1
        int[] values1 = {3, 2, 0, -4};
        int pos1 = 1;
        ListNode head1 = createListWithCycle(values1, pos1);
        System.out.println("Example 1: " + solution.hasCycle(head1)); // Output: true

        // Example 2: Input: head = [1, 2], pos = 0
        int[] values2 = {1, 2};
        int pos2 = 0;
        ListNode head2 = createListWithCycle(values2, pos2);
        System.out.println("Example 2: " + solution.hasCycle(head2)); // Output: true

        // Example 3: Input: head = [1], pos = -1
        int[] values3 = {1};
        int pos3 = -1;
        ListNode head3 = createListWithCycle(values3, pos3);
        System.out.println("Example 3: " + solution.hasCycle(head3)); // Output: false
    }
}


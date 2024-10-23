package AddTwoNumbersSLL;

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    // Function to add two numbers represented as linked lists
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);  // Placeholder for the result linked list
        ListNode tail = head;
        int carry = 0;

        // Loop until both lists are processed or there's a carry left
        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;  // Extract the current digit
            carry = sum / 10;  // Compute the carry

            // Create a new node for the current digit and move the tail
            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            // Move to the next nodes in the lists, if available
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return head.next;  // Return the result, skipping the placeholder node
    }

    // Helper method to create a linked list from an array
    private static ListNode createList(int[] nums) {
        ListNode head = new ListNode(0);  // Placeholder node
        ListNode tail = head;
        for (int num : nums) {
            tail.next = new ListNode(num);  // Append new node to the list
            tail = tail.next;
        }
        return head.next;  // Return the actual head (skipping placeholder)
    }

    // Helper method to print the linked list
    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example input: l1 = [2, 4, 3], l2 = [5, 6, 4]
        int[] arr1 = {2, 4, 3};
        int[] arr2 = {5, 6, 4};

        Solution solution = new Solution();

        // Create linked lists from arrays
        ListNode l1 = createList(arr1);
        ListNode l2 = createList(arr2);

        // Add the two numbers
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result
        System.out.print("Result: ");
        printList(result);  // Expected output: 7 -> 0 -> 8
    }
}

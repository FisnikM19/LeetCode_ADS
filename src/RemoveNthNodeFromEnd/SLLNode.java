package RemoveNthNodeFromEnd;
// In order to solve this problem in only one pass and O(1) extra space, however, we would need to find a way to both reach the end of the list
// with one pointer and also reach the nth node from the end simultaneously with a second pointer.
//
// To do that, we can simply stagger our two pointers by n nodes by giving the first pointer (fast) a head start before starting the second pointer (slow).
// Doing this will cause slow to reach the nth node from the end at the same time that fast reaches the end.

// Since we will need access to the node before the target node in order to remove the target node, we can use fast.next == null as our exit condition,
// rather than fast == null, so that we stop one node earlier.
//
// This will unfortunately cause a problem when n is the same as the length of the list, which would make the first node the target node,
// and thus make it impossible to find the node before the target node.
// If that's the case, however, we can just return head.next without needing to stitch together the two sides of the target node.
//
// Otherwise, once we successfully find the node before the target, we can then stitch it together with the node after the target, and then return head.

// Example 1:
// Input: head = [1, 2, 3, 4, 5], n = 2
// Output: [1, 2, 3, 5];

// Example 2:
// Input: head = [1], n = 1
// Output: []

import java.util.Scanner;

// Example 3:
// Input: head = [1,2], n = 1
// Output: [1]
public class SLLNode {
    int val;
    SLLNode next;

    SLLNode() {}
    SLLNode(int val) { this.val = val; }
    SLLNode(int val, SLLNode next) {
        this.val = val;
        this.next = next;
    }

    // Method to remove the nth node from the end of the list
    public SLLNode removeNthFromEnd(SLLNode head, int n) {
        SLLNode fast = head;
        SLLNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If n is the same as the length of the list, return the second node
        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the nth node
        slow.next = slow.next.next;
        return head;
    }

    // Method to print the linked list
    public static void printList(SLLNode head) {
        SLLNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to create the linked list from an array of values
    public static SLLNode createList(int[] values) {
        if (values.length == 0) return null;
        SLLNode head = new SLLNode(values[0]);
        SLLNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new SLLNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for the list
        System.out.println("Enter the number of elements in the list:");
        int size = scanner.nextInt();
        int[] values = new int[size];
        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < size; i++) {
            values[i] = scanner.nextInt();
        }

        // Create the list
        SLLNode list = createList(values);

        // Get input for n
        System.out.println("Enter the value of n (position from the end to remove):");
        int n = scanner.nextInt();

        // Remove the nth node from the end
        SLLNode result = list.removeNthFromEnd(list, n);

        // Print the modified list
        System.out.println("Modified list after removing the nth node from the end:");
        printList(result);

        scanner.close();
    }
}

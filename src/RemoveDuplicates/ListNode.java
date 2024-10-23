package RemoveDuplicates;

// Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
// Input: head = [1,1,2,3,3]
// Output: [1,2,3]

// Definition for singly-linked list.
import java.util.Scanner;

public class ListNode {
    int val;
    ListNode next;

    // Constructors
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // Method to delete duplicates from a sorted linked list
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;

        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next; // Skip the duplicate node
            } else {
                head = head.next; // Move to the next distinct node
            }
        }

        return res;
    }

    // Method to create a linked list from an array of values
    public static ListNode createList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // Method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the list
        System.out.println("Enter the number of elements in the list:");
        int size = scanner.nextInt();
        int[] values = new int[size];
        System.out.println("Enter the elements of the sorted list:");
        for (int i = 0; i < size; i++) {
            values[i] = scanner.nextInt();
        }

        // Create the list
        ListNode list = createList(values);

        // Delete duplicates
        ListNode result = deleteDuplicates(list);

        // Print the modified list
        System.out.println("List after removing duplicates:");
        printList(result);

        scanner.close();
    }
}


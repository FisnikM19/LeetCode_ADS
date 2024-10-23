package MergeTwoSortedList;
// You are given the heads of two sorted linked lists list1 and list2.
//
// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
//
// Return the head of the merged linked list.

// Example 1:
// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]

// Example 2:
// Input: list1 = [], list2 = []
// Output: []

// Example 3:
// Input: list1 = [], list2 = [0]
// Output: [0]

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

    // Method to merge two sorted linked lists
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }

        if (list1 == null) {
            return list2;
        }
        return list1;
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

        // Input for the first list
        System.out.println("Enter the number of elements in the first list:");
        int size1 = scanner.nextInt();
        int[] values1 = new int[size1];
        System.out.println("Enter the elements of the first list:");
        for (int i = 0; i < size1; i++) {
            values1[i] = scanner.nextInt();
        }

        // Input for the second list
        System.out.println("Enter the number of elements in the second list:");
        int size2 = scanner.nextInt();
        int[] values2 = new int[size2];
        System.out.println("Enter the elements of the second list:");
        for (int i = 0; i < size2; i++) {
            values2[i] = scanner.nextInt();
        }

        // Create the two linked lists
        ListNode list1 = createList(values1);
        ListNode list2 = createList(values2);

        // Merge the two lists
        ListNode mergedList = mergeTwoLists(list1, list2);

        // Print the merged list
        System.out.println("Merged list:");
        printList(mergedList);

        scanner.close();
    }
}

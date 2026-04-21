/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // // Dummy node before head
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;

        // ListNode fast = dummy;
        // ListNode slow = dummy;

        // // Move fast n+1 steps ahead
        // for (int i = 0; i <= n; i++) {
        //     fast = fast.next;
        // }

        // // Move both until fast reaches end
        // while (fast != null) {
        //     fast = fast.next;
        //     slow = slow.next;
        // }

        // // Delete the node
        // slow.next = slow.next.next;

        // return dummy.next; // new head




// Edge case: empty list
        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        // Move fast n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If fast is null, it means we need to remove the head
        if (fast == null) {
            return head.next;
        }

        // Move both until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove nth node
        slow.next = slow.next.next;

        return head;
    }

}
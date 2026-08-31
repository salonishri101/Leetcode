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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;
        int prev = -1;

        int minDist = Integer.MAX_VALUE;

        ListNode p = head;
        ListNode curr = head.next;
        ListNode next = curr.next;

        int index = 1;

        while (next != null) {

            // Critical point
            if ((curr.val > p.val && curr.val > next.val) ||
                (curr.val < p.val && curr.val < next.val)) {

                if (first == -1) {
                    first = index;
                } else {
                    minDist = Math.min(minDist, index - prev);
                }

                prev = index;
            }

            p = curr;
            curr = next;
            next = next.next;
            index++;
        }

        // Less than 2 critical points
        if (first == prev) {
            return new int[]{-1, -1};
        }

        int maxDist = prev - first;

        return new int[]{minDist, maxDist};
    }
}
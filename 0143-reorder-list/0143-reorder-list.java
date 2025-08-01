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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;

        ListNode prev = null;
        ListNode curr = mid.next;
        mid.next = null;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode leftHead = head;
        ListNode rightHead = prev;
        ListNode leftNext;
        ListNode rightNext;

        while(leftHead != null && rightHead != null){
            leftNext = leftHead.next;
            leftHead.next = rightHead;
            rightNext = rightHead.next;
            rightHead.next = leftNext;

            leftHead = leftNext;
            rightHead = rightNext;
        }
    }
}
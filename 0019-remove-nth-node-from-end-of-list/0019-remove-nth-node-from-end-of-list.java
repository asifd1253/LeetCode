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
    int length(ListNode head){
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            temp = temp.next;
            len++;
        }

        return len;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = length(head);

        if(len == n){
            head = head.next;
            return head;
        }

        ListNode prev = head;
        for(int i=0; i<len-n-1; i++){
            prev = prev.next;
        }

        prev.next = prev.next.next;

        return head;
    }
}
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
        if(head==null || head.next==null){
            return;
        }

        ListNode prev=null;
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode head2=prev.next;
        prev.next=null;

        prev=null;
        ListNode cur=head2;
        ListNode cnext=null;

        while(cur!=null){
            cnext=cur.next;
            cur.next=prev;
            prev=cur;
            cur=cnext;
        }

        head2=prev;

        ListNode ans=new ListNode(-1);
        ListNode res=ans;

        while(head!=null&&head2!=null){
            res.next=head;
            head=head.next;
            res=res.next;
            res.next=head2;
            head2=head2.next;
            res=res.next;
        }

        while(head!=null){
            res.next=head;
            head=head.next;
            res=res.next;
        }

        while(head2!=null){
            res.next=head2;
            head2=head2.next;
            res=res.next;
        }

        head=ans.next;
    }
}
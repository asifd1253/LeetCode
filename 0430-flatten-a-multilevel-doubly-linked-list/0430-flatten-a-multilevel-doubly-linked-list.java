/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        for(Node temp = head; temp != null; temp = temp.next){
            if(temp.child != null){
                Node after = temp.next;
                temp.next = temp.child;
                temp.next.prev = temp;
                temp.child = null;

                Node curr = temp;
                while(curr.next != null){
                    curr = curr.next;
                }

                curr.next = after;
                
                if(after != null){
                    after.prev = curr;
                }
                
            }
        }

        return head;
    }
}
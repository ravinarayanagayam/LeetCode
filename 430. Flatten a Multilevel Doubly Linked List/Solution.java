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

        Node dummyHead = head;

        while (null != dummyHead) {
            if (null != dummyHead.child) {
                Node child = dummyHead.child;
                Node next = dummyHead.next;
                Node childTail = child;
                while (null != childTail.next)
                    childTail = childTail.next;
                dummyHead.child = null;
                dummyHead.next = child;
                childTail.next = next;
                child.prev = dummyHead;
                if (null != next)
                    next.prev = childTail;
            }
            dummyHead = dummyHead.next;
        }
        return head;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l1.val == 0)
            return l2;
        if (l2 == null || l2.val == 0)
            return l1;
        int length1 = 0, length2 = 0;
        ListNode dl1 = l1;
        ListNode dl2 = l2;

        while (dl1 != null) {
            length1++;
            dl1 = dl1.next;
        }

        while (dl2 != null) {
            length2++;
            dl2 = dl2.next;
        }

        int[] a1 = new int[length1];
        int[] a2 = new int[length2];
        dl1 = l1;
        dl2 = l2;
        int i = 0;
        while (dl1 != null) {
            a1[i++] = dl1.val;
            dl1 = dl1.next;
        }
        i = 0;
        while (dl2 != null) {
            a2[i++] = dl2.val;
            dl2 = dl2.next;
        }

        int carry = 0;
        ListNode result = new ListNode(-1);
        while (length1 > 0 && length2 > 0) {
            int r = a1[length1 - 1] + a2[length2 - 1] + carry;
            ListNode tail = new ListNode(r % 10);
            if (result.next != null) {
                ListNode pt = result.next;
                tail.next = pt;
            }
            result.next = tail;
            carry = r / 10;
            length1--;
            length2--;
        }

        while (length1 > 0) {
            int r = a1[length1 - 1] + carry;
            ListNode tail = new ListNode(r % 10);
            if (result.next != null) {
                ListNode pt = result.next;
                tail.next = pt;
            }
            result.next = tail;
            carry = r / 10;
            length1--;
        }

        while (length2 > 0) {
            int r = a2[length2 - 1] + carry;
            ListNode tail = new ListNode(r % 10);
            if (result.next != null) {
                ListNode pt = result.next;
                tail.next = pt;
            }
            result.next = tail;
            carry = r / 10;
            length2--;
        }

        if (carry > 0) {
            ListNode tail = new ListNode(carry);
            ListNode pt = result.next;
            tail.next = pt;
            result.next = tail;
        }

        return result.next;

    }
}
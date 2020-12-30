package Leetcode.medium;
/*
* Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes. Only nodes itself may be changed.

        Input: head = [1,2,3,4]
        Output: [2,1,4,3]

        Input: head = []
        Output: []

        Input: head = [1]
        Output: [1]
* */

public class _24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;

    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.print();
        System.out.println(" ");
        _24_SwapNodesInPairs fucn = new _24_SwapNodesInPairs();
        ListNode newh = fucn.swapPairs(n);
        newh.print();
    }


}

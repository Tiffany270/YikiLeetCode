package Leetcode.medium;

/*
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example:
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.

*/



public class _02Add_Two_Numbers {
    /*
     * Loop a LinkList:
     *       [1] Store 'head' first, it's important: Node cur = node;
     *       [2] do sth with current node : cur.next = new ListNode(x)
     *       [3]loop it: cur = cur.next;
     * */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);// to store result
        ListNode cur = node;

        int carry = 0;

        while (l1 != null || l2 != null) {

            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry; // add all together

            // [cur.next]
            // skip current node.val, create an newNode for result
            // must store your result to next node,
            // then return node.next is ok
            // (because store in current node would have an extra loop, which would create a extra node.)

            cur.next = new ListNode(sum % 10);//now cur.next.val = sum%10
            carry = sum > 9 ? 1 : 0; // or sum/10 is ok, because carry is an Integer
            cur = cur.next;

            if (l1 != null)
                l1 = l1.next; // the point would stop at 'next' and never loop

            if (l2 != null)
                l2 = l2.next;
        }

        // consider a situation of l1(1,2)+l2(1,9), you need to add a node
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return node.next;
    }

    public static void main(String[] args) {
        _02Add_Two_Numbers Two_Numbers = new _02Add_Two_Numbers();
        ListNode listNode1 = new ListNode(1);
//        listNode1.add(4);
//        listNode1.add(3);

        ListNode listNode2 = new ListNode(9);
        listNode2.add(9);
//        listNode2.add(7);

        ListNode node = Two_Numbers.addTwoNumbers(listNode1, listNode2);
        node.print();


    }


}

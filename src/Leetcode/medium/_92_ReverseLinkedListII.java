package Leetcode.medium;

/*
 Given the head of a singly linked list and two integers left and right where left <= right,
 reverse the nodes of the list from position left to position right, and return the reversed list.

        Example 1:
        Input: head = [1,2,3,4,5], left = 2, right = 4
        Output: [1,4,3,2,5]

        Example 2:
        Input: head = [5], left = 1, right = 1
        Output: [5]


 注意反转链表是 [left,right] 里面元素全部反转！不是单个
*
* */
public class _92_ReverseLinkedListII {

    boolean stop;
    ListNode left;

    public ListNode reverseBetween(ListNode head,
                                   int left,
                                   int right) {
        this.left = head;
        this.stop = false;
        this.recur(head, left, right);
        return head;

    }

    public void recur(ListNode right, int m, int n) {
        if (n == 1) return;

        right = right.next;
        if (m > 1) this.left = this.left.next;

        this.recur(right, m - 1, n - 1);
        if (this.left == right || right.next == this.left) {
            this.stop = true;
        }
        if(!this.stop){
            int temp = this.left.val;
            this.left.val = right.val;
            right.val = temp;
            this.left = this.left.next;
        }


    }

    // tip reverse the single link

    ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head; // a -> b -> c
                               // a -> b -x- c ====> a<->b
        head.next = null; // b->a->null     // h   next  next.next (断掉重连）
        return last;
    }


}

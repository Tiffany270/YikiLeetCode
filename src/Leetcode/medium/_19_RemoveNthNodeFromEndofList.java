package Leetcode.medium;

/*
* Given the head of a linked list, remove the nth node from the end of the list and return its head.
*
            Input: head = [1,2,3,4,5], n = 2
            Output: [1,2,3,5]

            Input: head = [1], n = 1
            Output: []

            Input: head = [1,2], n = 1
            Output: [1]


* */

/*
 * Solution ：
 * remove = L-n+1
 *  D->1->2->3->4->null
 *  D ++ stop in ( L-n + 1 ), D -> ( L-n + 2 )
 *  makes D - > header.next.next;
 * */
public class _19_RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode D = new ListNode(0);
        D.next = head;
        int len = 0;
        ListNode count = head;
        while (count != null) {
            len++;
            count = count.next;
        }
        int stop = len - n;
        ListNode p = D;
        while (stop > 0) {
            stop--;
            p = p.next;
        }
        p.next = p.next.next;


        return D.next;//back for the header
    }
}

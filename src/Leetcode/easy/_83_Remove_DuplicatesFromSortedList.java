package Leetcode.easy;

public class _83_Remove_DuplicatesFromSortedList {


    /*
     * Solution: change 'next' pointer of cur node so that skips the duplicate node
     * */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if(cur.next.val == cur.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }

        }


        return head;

    }
}

package CodingInterviews;


/*
* 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

                示例1：

                输入：1->2->4, 1->3->4
                输出：1->1->2->3->4->4

* */

import java.util.List;

// 双指针即可，注意下循环的条件，已经添加链表的话需要一个伪头
public class _21_MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode L = l1;
        ListNode R = l2;

        ListNode res = new ListNode();
        ListNode header = res;
        while (L!= null && R!= null) {
            if (L.val < R.val) {
                header.next = L;
                L = L.next;
            } else {
                header.next = R;
                R = R.next;
            }
            header = header.next;
        }

        header.next = L != null ? L : R;
        return res.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        _21_MergeTwoLists func = new _21_MergeTwoLists();
        func.mergeTwoLists(l1, l2);
    }
}

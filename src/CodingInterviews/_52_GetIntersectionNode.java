package CodingInterviews;

/*
* 输入两个链表，找出它们的第一个公共节点。
        （例子写的什么乱七八糟的）

* */
public class _52_GetIntersectionNode {

    /*
     * Solution:
     * 两个链表长度分别为L1+C、L2+C， C为公共部分的长度
     * 第一个人走了L1+C步后，回到第二个人起点走L2步；
     * 第2个人走了L2+C步后，回到第一个人起点走L1步。
     * 当两个人走的步数都为L1+L2+C时就两个家伙就相爱了
     *
     * 双指针 A1 跑完跑去走A2 A2跑完跑去走A1 碰到一样的就意味着 conflict 了（太强了吧，why my math is that weak！！！！）
     * */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;

    }
}

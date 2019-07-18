package CodingInterviews;

import com.sun.tools.javac.Main;

//反转链表
public class ReverseLinkList {

    static public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //递归思路
    //从尾部开始，把当前节点的下一个节点的next指向自己
    //如4->5 变为4<->5互相指了呗
    //然后避免圈出现，把4->5变为4->null,这样不就剩下4<-5
    //然后递归递归递归……
    static public ListNode ReverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = ReverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //非递归思路：
    //防止链表断裂，在转变指向（如0->1->2转为0<-1 2）的时候，临时保存2，
    //方便prev head next往下一个节点移动的时候找到2重新变为head（原head是1）

    static public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null;
        ListNode pPrev = null;
        ListNode pHead = head;

        while (pHead != null) {
            ListNode pTempNext = pHead.next;
            if (pTempNext == null) {
                newHead = pHead;
            }
            pHead.next = pPrev;
            //移动
            pPrev = pHead;
            pHead = pTempNext;

        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(4);

        head.next = t1;
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;

        ListNode newhead = ReverseList(head);
        System.out.println(newhead.val);
        System.out.println(newhead.next.val);
        System.out.println(newhead.next.next.val);
        System.out.println(newhead.next.next.next.val);
        System.out.println(newhead.next.next.next.next.val);

    }

}


package CodingInterviews;

/*
* 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

            示例:
            输入: 1->2->3->4->5->NULL
            输出: 5->4->3->2->1->NULL
 

* */
//反转链表
public class _24_ReverseLinkList {

    static public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*递归思路
    把当前节点的下一个节点的next指向自己

    如4->5 变为4<->5互相指了呗
    然后避免圈出现要把原方向断掉：把4->5变为4->null,这样不就剩下4<-5（就是指向空）
    然后递归递归递归……*/
    public ListNode ReverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = ReverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /*
    非递归思路：
    防止链表断裂，在转变指向（如 0 -> 1 -> 2转为 0 <- 1 2）的时候，临时保存2，
    方便prev head next往下一个节点移动的时候找到2重新变为head（原head是1）
        */
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;    // 预设一个prev
        ListNode pHead = head;   //循环用
        ListNode newHead = null; //新的头

        while(pHead!=null){
            ListNode temp = pHead.next;

            if(temp==null){
                newHead = pHead;
            }
            pHead.next = prev; //反转指针
            prev = pHead;   // 移动
            pHead = temp;   // 移动

        }

        return newHead;

    }

}


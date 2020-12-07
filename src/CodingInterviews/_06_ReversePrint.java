package CodingInterviews;

import java.util.LinkedList;

/*
* 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

            示例 1：
            输入：head = [1,3,2]
            输出：[2,3,1]

* */
public class _06_ReversePrint {

    // 压栈后出栈

    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }

        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();

        }


        return res;
    }
}

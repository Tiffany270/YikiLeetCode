package CodingInterviews;

import java.util.LinkedList;

/*
*  这题目有毒 :)
* 用两个栈实现一个队列。
* 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
* 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

        示例 1：
        输入：
        ["CQueue","appendTail","deleteHead","deleteHead"]
        [[],[3],[],[]]
        输出：[null,null,3,-1]

    题目解读：
    [[],[3],[],[]]对应上面的方法，是上面方法的参数。
    CQueue和deleteHead方法不需要指定数字，只有添加才需要指定数字

        1.创建队列，返回值为null
        2.将3压入栈，返回值为null
        3.将栈底的元素删除，也就是消息队列中先进来的元素，所以是deleteHead，返回该元素的数值，所以为3
        4.继续删除栈底的元素，但是没有元素了，所以返回-1
        所以就有了下面的输出 输出：[null,null,3,-1]

* */
public class _09_CQueue {

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */

    /*
     * 其他：
     * 使用java的同学请注意，如果你使用Stack的方式来做这道题，会造成速度较慢；
     * 原因的话是Stack继承了Vector接口，而Vector底层是一个Object[]数组，那么就要考虑空间扩容和移位的问题了。
     * 可以使用LinkedList来做Stack的容器，因为LinkedList实现了Deque接口，所以Stack能做的事LinkedList都能做，
     * 其本身结构是个双向链表，扩容消耗少。
     * 但是我的意思不是像100%代码那样直接使用一个LinkedList当做队列，那确实是快，但是不符题意
     *
     * API: linkedList add 添加在尾部
     *      linkedList push 添加在头部
     * */
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;

    public _09_CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.add(value);

    }

    public int deleteHead() {
        if (this.stack2.isEmpty()) {
            if (stack1.isEmpty()) return -1;
            while (!this.stack1.isEmpty()) {
                this.stack2.add(this.stack1.pop());
            }

            return stack2.pop();
        }

        return this.stack2.pop();
    }

    public static void main(String[] args) {
        _09_CQueue obj = new _09_CQueue();
        obj.appendTail(3);
        int param_2 = obj.deleteHead();
    }

}

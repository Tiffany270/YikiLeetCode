package CodingInterviews;

import java.util.Stack;

public class _30_MinStack {

    Stack<Integer> A; //All elements
    Stack<Integer> B; // if B's top < ele, push to B

    public _30_MinStack() {
        A = new Stack<Integer>();
        B = new Stack<Integer>();

    }

    public void push(int x) {
        A.push(x);
        if (B.empty() || B.peek() >= x) {// must >= , in case to pop a repeat ele
            B.push(x);
        }

    }

    public void pop() {

        if(A.peek().equals(B.peek())){
            B.pop();
        }
        A.pop();// if u need your pop first, pls make your order is correct

        /* or ues below
        *  if(A.pop().equals(B.peek())
        * */

    }

    public int top() {

        return A.peek();

    }

    public int min() {
        return B.peek();

    }

    public static void main(String[] args) {
        _30_MinStack minStack = new _30_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min(); //  --> 返回 -3.
        minStack.pop();
        minStack.top();   //   --> 返回 0.
        minStack.min();  // --> 返回 -2.

    }
}

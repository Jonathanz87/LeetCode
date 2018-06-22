/*
    problem 155
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
    Example:
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();   --> Returns -3.
    minStack.pop();
    minStack.top();      --> Returns 0.
    minStack.getMin();   --> Returns -2.
 */


import java.util.LinkedList;

public class MinStack {
    private LinkedList<Integer> minStack;
    private LinkedList<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        minStack = new LinkedList<>();
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.add(x);
        Integer last = minStack.peekLast();
        if(last == null || x <= last){
            minStack.add(x);
        }
    }

    public void pop() {
        Integer n = stack.pollLast();
        if(n.equals(minStack.getLast())){
            minStack.pollLast();
        }
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return minStack.getLast();
    }
}

package model;

import exceptions.MyException;

import java.util.EmptyStackException;
import java.util.Stack;

public class MyStack<T> implements MyIStack<T> {
    Stack<T> stack;
    public MyStack() {
        this.stack = new Stack<T>();
    }
    public  T pop() throws MyException {
        try {
            return stack.pop();
            }
        catch (EmptyStackException e)
            {
            throw new MyException("stack empty");
            }
    }
    public  void push(T v){

        stack.push(v);
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        for (T item: stack) {
            string.append(item).append("\n");
        }
        return string.toString();
    }
}

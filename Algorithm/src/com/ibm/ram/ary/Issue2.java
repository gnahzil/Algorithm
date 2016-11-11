package com.ibm.ram.ary;

import java.util.Stack;

public class Issue2 {

	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;
	
	public Issue2() {
		stackPush = new Stack<Integer>();
		stackPop = new Stack<Integer>();
	}
	
	public void add(int newNum) {
		while(!stackPop.isEmpty()) {
			stackPush.push(stackPop.pop());
		}
		stackPush.push(newNum);
	}
	
	public int poll() {
		if (stackPush.isEmpty() && stackPop.isEmpty()) {
			throw new RuntimeException("Your queue is empty.");
		}
		while(!stackPush.isEmpty()) {
			stackPop.push(stackPush.pop());
		}
		return stackPop.pop();
	}
	
	public int peek() {
		if (stackPush.isEmpty() && stackPop.isEmpty()) {
			throw new RuntimeException("Your queue is empty.");
		}
		while(!stackPush.isEmpty()) {
			stackPop.push(stackPush.pop());
		}
		return stackPop.peek();
	}
	
	public static void main(String[] args) {
		Issue2 tsq = new Issue2();
		tsq.add(3);
		tsq.add(4);
		tsq.add(1);
		System.out.println(tsq.peek());
		System.out.println(tsq.poll());
	}

}

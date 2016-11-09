package com.ibm.ram.ary;

import java.util.Stack;

public class MyStack1 {
	
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public MyStack1() {
		stackData = new Stack<Integer>();
		stackMin = new Stack<Integer>();
	}
	
	public void push(int newNum) {
		if (stackMin.isEmpty()) {
			stackMin.push(newNum);
		} else if (stackMin.peek() >= newNum) {
			stackMin.push(newNum);
		}
		stackData.push(newNum);
	}
	
	public int pop() {
		if (stackMin.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		int value = stackData.pop();
		if (stackMin.peek() == value) {
			stackMin.pop();
		}
		return value;
	}
	
	public int getMin() {
		return stackMin.peek();
	}
	
	public static void main(String[] args) {
		MyStack1 ms = new MyStack1();
		ms.push(2);
		ms.push(3);
		ms.push(1);
		ms.push(1);
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
	}

}

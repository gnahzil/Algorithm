package com.ibm.ram.ary;

import java.util.Stack;

public class Issue3 {

	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int value = stack.pop();
		if (stack.isEmpty()) {
			return value;
		}
		int last = getAndRemoveLastElement(stack);
		stack.push(value);
		return last;
	}
	
	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int value = getAndRemoveLastElement(stack);
		
		reverse(stack);
		stack.push(value);
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack1 = new Stack<Integer>();
		stack1.push(3);
		stack1.push(2);
		stack1.push(1);
		reverse(stack1);
		System.out.println(stack1);
	}

}

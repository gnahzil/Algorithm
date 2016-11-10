package com.ibm.ram.ary;

import java.util.Stack;

public class Issue5 {
	
	private Stack<Integer> stackData;
	private Stack<Integer> stackHelp;
	
	public Issue5() {
		this.stackData = new Stack<Integer>();
		this.stackHelp = new Stack<Integer>();
	}
	
	public void sortStack() {	
		while(!stackData.isEmpty()) {
			int value = stackData.pop();
			while(!stackHelp.isEmpty()) {
				if (stackHelp.peek() >=  value) {
					stackHelp.push(value);
					break;
				} else {
					stackData.push(stackHelp.pop());
				}
			}
			if (stackHelp.isEmpty())
				stackHelp.push(value);
		}
		while (!stackHelp.isEmpty()) {
			stackData.push(stackHelp.pop());
		}
	}
	
	public void sortStack2(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<Integer>();
		while(!stack.isEmpty()) {
			int value = stack.pop();
			while(!help.isEmpty() && help.peek() < value) {
				stack.push(help.pop());
			}
			help.push(value);
		}
		while(!help.isEmpty()) {
			stack.push(help.pop());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Issue5 i5 = new Issue5();
		i5.stackData.push(3);
		i5.stackData.push(4);
		i5.stackData.push(2);
		i5.stackData.push(1);
		i5.stackData.push(15);
		i5.sortStack();
		System.out.println(i5.stackData);
	}

}

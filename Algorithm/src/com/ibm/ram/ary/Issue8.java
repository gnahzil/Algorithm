package com.ibm.ram.ary;

import java.util.HashMap;
import java.util.Stack;

public class Issue8 {

	public class Node {
		public int value;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.value = data;
		}
	}
	
	public Node getMaxTree(int[] arr) {
		//������Ԫ��ʵ����ΪNode�ڵ�
		Node[] nArr = new Node[arr.length];
		for (int i=0; i<nArr.length; i++) {
			//nArr[i].value = arr[i];
			nArr[i] = new Node(arr[i]);
		}
		
		//����һ������ջ
		Stack<Node> stack = new Stack<Node>();
		
		//��������HashMap��lBigMap�洢��ߵ�һ�������������rBigMap�洢�ұߵ�һ�����������
		HashMap<Node, Node> lBigMap = new HashMap<Node, Node>();
		HashMap<Node, Node> rBigMap = new HashMap<Node, Node>();
		
		//��ʼ������Ѱ��ÿ������ߵ�һ�����������
		for (int i=0; i<nArr.length; i++) {
			//Node curNode = nArr[i];
			while (!stack.isEmpty() && stack.peek().value < nArr[i].value) {
				stack.pop();
			}
			if (stack.isEmpty())
				lBigMap.put(nArr[i], null);
			else 
				lBigMap.put(nArr[i], stack.peek());
			stack.push(nArr[i]);
		}
		stack.clear();
		
		//���������Ѱ��ÿ�����ұߵ�һ�����������
		for (int i=nArr.length-1; i>-1; i--) {
			while (!stack.isEmpty() && stack.peek().value < nArr[i].value) {
				stack.pop();
			}
			if (stack.isEmpty())
				rBigMap.put(nArr[i], null);
			else
				rBigMap.put(nArr[i], stack.peek());
			stack.push(nArr[i]);
		}
		
		//����lBigMap��rBigMap����MaxTree
		Node head = null;
		for (int i=0; i<arr.length; i++) {
			Node curNode = nArr[i];
			Node left = lBigMap.get(curNode);
			Node right = rBigMap.get(curNode);
			if (left == null && right == null) {
				head = curNode;
			} else if (left == null) {
				if (right.left == null)
					right.left = curNode;
				else
					right.right = curNode;
			} else if (right == null) {
				if (left.left == null)
					left.left = curNode;
				else
					left.right = curNode;
			} else {
				Node parent = left.value < right.value ? left : right;
				if (parent.left == null)
					parent.left = curNode;
				else
					parent.right = curNode;
			}
		}
		return head;
	}
	
	
	public static void main(String[] args) {
		Issue8 i8 = new Issue8();
		System.out.println(i8.getMaxTree(new int[]{3,4,5,1,2}).value);
	}

}

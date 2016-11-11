package com.ibm.ram.ary;

import java.util.Stack;

public class Issue9 {

	//�ָ��ÿһ�У�����ÿһ�������ж��ٸ�1����¼��һ������height��
	public static int maxRecSize(int[][] map) {
		if (map == null || map.length == 0 || map[0].length == 0) {
			return 0;
		}
		int maxArea = 0;
		int[] height = new int[map[0].length];
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[0].length; j++) {
				height[j] = map[i][j] == 0 ? 0 : height[j]+1;
			}
			maxArea = Math.max(maxRecFromBottom(height), maxArea);
		}
		return maxArea;
	}
	
	//��Էָ������ÿ�У����м��㵱ǰ�ָ������γɵ�������
	public static int maxRecFromBottom(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		//��ÿ��ֵѹ��ջ�У������ջ��������������������������
		for (int i=0; i<height.length; i++) {
			while(!stack.isEmpty() && height[stack.peek()] >= height[i]) {
				int j = stack.pop();
				int k = stack.peek();
				maxArea = Math.max(maxArea, (i-k-1)* height[j]);
			}
			stack.push(i);
		}
		//��ջ��ʣ������ӵ�����������������ʱ�������������������ĩβ��
		while(!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			maxArea = Math.max(maxArea, (height.length-k-1)*height[j]);
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

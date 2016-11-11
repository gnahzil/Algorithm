package com.ibm.ram.ary;

import java.util.Stack;

public class Issue9 {

	//分割出每一行，计算每一行上面有多少个1，记录在一个数组height内
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
	
	//针对分割出来的每行，进行计算当前分割行能形成的最大面积
	public static int maxRecFromBottom(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		//将每个值压近栈中，计算出栈的柱子向左向右扩大后的最大面积
		for (int i=0; i<height.length; i++) {
			while(!stack.isEmpty() && height[stack.peek()] >= height[i]) {
				int j = stack.pop();
				int k = stack.peek();
				maxArea = Math.max(maxArea, (i-k-1)* height[j]);
			}
			stack.push(i);
		}
		//将栈中剩余的柱子弹出计算最大面积，此时柱子向右最大扩大到数组末尾了
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

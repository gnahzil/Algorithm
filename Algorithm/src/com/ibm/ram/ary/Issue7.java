package com.ibm.ram.ary;

import java.util.LinkedList;

public class Issue7 {
	
	//∏¥‘”∂»O(n*w)
	public static int[] getMaxWin(int[] arr, int w) {
		int[] res = new int[arr.length-w+1];
		for ( int i = 0; i < arr.length - w +1; i++ ) {
			int max = arr[i];
			for ( int j=i; j < i+w; j++) {
				if (max < arr[j])
					max = arr[j];
			}
			res[i] = max;
		}
		return res;
	}
	
	//∏¥‘”∂»O(n)
	public static int[] getMaxWin2(int[] arr, int w) {
		if (arr == null || w < 1 || arr.length < w) {
			return null;		
		}
		int[] res = new int[arr.length-w+1];
		int index = 0;
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		for (int i=0; i<arr.length; i++) {
			while(!qmax.isEmpty() && arr[qmax.peekLast()] < arr[i]) {
				qmax.pollLast();
			}
			qmax.addLast(i);
			if (qmax.peekFirst() == i-w) {
				qmax.pollFirst();
			}
			if ( i >= w-1) {
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] res = getMaxWin2(new int[]{4,3,5,4,3,3,6,7}, 3);
		for (int i=0; i<res.length; i++)
		System.out.println(res[i]);
	}
}

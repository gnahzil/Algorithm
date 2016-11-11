package com.ibm.ram.ary;

import java.util.LinkedList;

public class Issue10 {

	public static int getNum(int[] arr, int num) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		
		int res = 0;
		
		//生成qmin和qmax的双端队列
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		
		//生成两个指针
		int i=0,j=0;
		while (i<arr.length) {
			while (j<arr.length) {
				while(!qmin.isEmpty() && arr[qmin.peekLast()] > arr[j]) {
					qmin.pollLast();
				}
				qmin.addLast(j);
				while(!qmax.isEmpty() && arr[qmax.peekLast()] < arr[j]) {
					qmax.pollLast();
				}
				qmax.addLast(j);
				if ((qmax.peekFirst()-qmin.peekFirst()) > num) {
					break;
				}
				j++;
			}
			if (qmin.peekFirst() == i)
				qmin.pollFirst();
			if (qmax.peekFirst() == i)
				qmax.pollFirst();
			res += j-i;
			i++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

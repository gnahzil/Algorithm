package com.ibm.ram.ary;

import java.util.Stack;

public class Issue6 {
	
	//递归实现
	public static int hanoiProblem1(int num, String left, String mid, String right) {
		if (num < 1) {
			return 0;
		}
		return process(num, left, mid, right, left, right);
	}
	
	public static int process(int num, String left, String mid, String right, String from, String to) {
		if ( num == 1 ) {
			if ( from.equals(mid) || to.equals(mid) ) {
				System.out.println("Move 1 from " + from + " to " + to);
				return 1;
			} else {
				System.out.println("Move 1 from " + from + " to " + mid);
				System.out.println("Move 1 from " + mid + " to " + to);
				return 2;
			}
		}
		if ( from.equals(mid) || to.equals(mid) ) {
			String another = from.equals(left) || to.equals(left) ? right : left;
			int part1 = process(num-1, left, mid, right, from ,another);
			int part2 = 1;
			System.out.println("Move " + num + " from " + from + " to " + to);
			int part3 = process(num-1, left, mid, right, another, to);
			return part1 + part2 + part3;
		} else {
			int part1 = process(num-1, left, mid, right, from, to);
			System.out.println("Move " + num + " from " + from + " to " + mid);
			int part2 = 1;
			int part3 = process(num-1, left, mid ,right, to, from);
			System.out.println("Move " + num + " from " + mid + " to " + to);
			int part4= 1;
			int part5 = process(num-1, left, mid ,right, from ,to);
			return part1+part2+part3+part4+part5;
		}
	}
	
	//非递归实现
	public enum Action {
		No, LToM, MToL, MToR, RToM
	}
	
	public static int hanoiProblem2(int num, String left, String mid, String right) {
		Stack<Integer> ls = new Stack<Integer>();
		Stack<Integer> ms = new Stack<Integer>();
		Stack<Integer> rs = new Stack<Integer>();
		ls.push(Integer.MAX_VALUE);
		ms.push(Integer.MAX_VALUE);
		rs.push(Integer.MAX_VALUE);
		for ( int i=num; i > 0; i-- ) {
			ls.push(i);
		}
		Action[] curAction = {Action.No};
		int step = 0;
		while(rs.size() < num + 1) {
			step += fStackToStack(curAction, Action.MToL, Action.LToM, ls, ms, left, mid)
					+ fStackToStack(curAction, Action.LToM, Action.MToL, ms, ls, mid, left)
					+ fStackToStack(curAction, Action.MToR, Action.RToM, rs, ms, right, mid)
					+ fStackToStack(curAction, Action.RToM, Action.MToR, ms, rs, mid, right);
		}
		return step;
	}
	
	public static int fStackToStack(Action[] curAction, Action preNoAction, Action nowAction,
									Stack<Integer> fStack, Stack<Integer> tStack,
									String from, String to) {
		if (curAction[0] != preNoAction && fStack.peek() < tStack.peek()) {
			tStack.push(fStack.pop());
			System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
			curAction[0] = nowAction;
			return 1;
		}
		return 0;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//hanoiProblem1(2, "left", "mid", "right");
		hanoiProblem2(2, "left", "mid", "right");
	}

}

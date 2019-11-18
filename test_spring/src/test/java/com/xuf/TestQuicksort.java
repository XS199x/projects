package com.xuf;

import com.xuf.utils.DateUtil;

/**
 * Title: TestQuicksort
 * Description: TODO
 *
 * @author xuf
 * @version V1.0
 * @date 2019-11-18
 */
public class TestQuicksort {
	
	public static int[] ints;
	
	/**
	 * 快速排序
	 * @param left
	 * @param right
	 */
	public static void quickSort(int left, int right) {
		
		int i, j, t, temp;
		if (left > right) {
			return;
		}
		
		temp = ints[left];
		i = left;
		j = right;
		while (i != j) {
			while (temp >= ints[j] && i < j) {
				j--;
			}
			
			while (temp <= ints[i] && i < j) {
				i++;
			}
			
			t = ints[i];
			ints[i] = ints[j];
			ints[j] = t;
		}
		
		ints[left] = ints[i];
		ints[i] = temp;
		
		quickSort(left, i - 1);
		quickSort(i + 1, right);
		
	}
	
	/**
	 * 生成随机数
	 * @param n
	 * @param m
	 */
	private static void setInts(int n, int m) throws Exception{
		ints = new int[n];
//		for (int i = 0; i < n; i = (i + m <= n ? i + m : n)) {
//			int tn = i;
//			Thread thread = new Thread(()->{
//				for (int j = tn; j < (tn + m <= n ? tn + m : n); j++) {
//					ints[j]= (int)(Math.random()*n);
//				}
//			});
//			thread.start();
//			thread.setName("ttt"+i);
//			thread.join();
//		}
		for (int i = 0; i < n; i++) {
			ints[i]= (int)(Math.random()*n);
		}
	}
	
	public static void main(String[] args) throws Exception{
		int k = 100000000;
		System.out.println("生成随机数开始："+ DateUtil.getNowDateDefault());
		setInts(k,10000000);
		System.out.println("生成随机数结束："+ DateUtil.getNowDateDefault());
		System.out.println("\n\n\n");
		System.out.println("快速排序开始："+ DateUtil.getNowDateDefault());
		quickSort(0,k-1);
		System.out.println("快速排序结束："+ DateUtil.getNowDateDefault());
	}
	
}

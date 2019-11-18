package com.xuf;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Title: AtomicTest
 * Description: TODO
 *
 * @author xuf
 * @version V1.0
 * @date 2019-10-17
 */
public class AtomicTest {
	public static AtomicInteger race = new AtomicInteger();
	
	public static void increase(){
		race.incrementAndGet();
	}
	
	private static final int THREAD_COUNT = 20;
	
	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			new Thread(()->{
				for (int j = 0; j < 100; j++) {
					increase();
					System.out.println(Thread.currentThread().getName()+":"+race);
				}
			}).start();
		}
		while (Thread.activeCount() >1){
			Thread.yield();
		}
		System.out.println(race);
	}
}

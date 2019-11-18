package com.xuf;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Title: TestSync
 * Description: TODO
 *
 * @author xuf
 * @version V1.0
 * @date 2019-10-14
 */
public class TestSync {
	
	public static void main(String[] args) {
		
		Runnable runnable = ()->{
			int a = 0;
			a++;
			System.out.println(Thread.currentThread().getName()+" a:"+a);
		};
		ExecutorService executorService = Executors.newFixedThreadPool(16);
		for (int i = 0; i < 30; i++) {
			System.out.println(Thread.currentThread().getName()+" i:"+i);
			executorService.execute(runnable);
		}
	}
}

package com.user.thread;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTestCases extends Thread{
	
	
	
	private static ExecutorService CC = Executors.newFixedThreadPool(3);
	
	@Override
	public void run() {
		System.out.println("Thread is running: " + Thread.currentThread().getName());
		ThreadMethod();
	}
	
	public static void ThreadMethod() {
		
		
		Runnable printOdd = () ->{
			
			System.out.println("Ok");
//			for(int i=0;i<5;i++) {
			int i=0;
			boolean flag = true;
			while(flag) {
				
				synchronized (ThreadTestCases.class) {
					LocalDateTime currentDateTime = LocalDateTime.now();
					System.out.println("Value::"+i+"::"+Thread.currentThread().getName()+"Time::"+currentDateTime);
					i++;
					
					if(i==5) {
						flag=false;
					}
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
			
		} ;
		
		CC.submit(printOdd);
		
		CC.shutdown();
		
	}

}

package com.user.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        System.out.println("Pooling Utility Started...");

        PoolingUtility utility = new PoolingUtility();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Create 10 Worker Threads
        for (int i = 1; i <= 3; i++) {
        	System.out.println("Calling Thread::"+i);
            executor.submit(new WorkerTask(utility));

        }

    }

}
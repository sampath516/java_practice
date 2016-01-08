package com.java.threads.locks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		Queue<Task> queue = new LinkedList<Task>();
		Lock lock = new ReentrantLock();
		Condition waitingPool = lock.newCondition();
		Producer producer = new Producer(queue, 5, lock, waitingPool);
		Consumer consumer = new Consumer(queue, lock, waitingPool);
		ExecutorService producerExecutor  = Executors.newSingleThreadExecutor();
		ExecutorService consumerExecutor  = Executors.newSingleThreadExecutor();
		producerExecutor.execute(producer);
		consumerExecutor.execute(consumer);
	}
	
	private static void start_v1(){
		Queue<Task> queue = new LinkedList<Task>();
		Lock lock = new ReentrantLock();
		Condition waitingPool = lock.newCondition();
		Producer producer = new Producer(queue, 5, lock, waitingPool);
		Consumer consumer = new Consumer(queue, lock, waitingPool);
		Thread prodThread1 = new Thread(producer, "Producer-1");
		Thread prodThread2 = new Thread(producer, "Producer-2");
		Thread consThread1 = new Thread(consumer, "Consumer-1");
		Thread consThread2 = new Thread(consumer, "Consumer-2");
		prodThread1.start();
		prodThread2.start();
		consThread1.start();
		consThread2.start();
	}
}

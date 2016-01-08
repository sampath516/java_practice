package com.java.threads.pc.wait_notify;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		Queue<Task> queue = new LinkedList<Task>();
		Producer producer = new Producer(queue, 5);
		Consumer consumer = new Consumer(queue);
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

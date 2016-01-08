package com.java.threads.pc.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.java.threads.pc.wait_notify.Task;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		BlockingQueue<Task> queue = new ArrayBlockingQueue<Task>(1);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		Thread prodThread = new Thread(producer); 
		Thread consThread = new Thread(consumer);
		prodThread.start();
		consThread.start();
	}

}

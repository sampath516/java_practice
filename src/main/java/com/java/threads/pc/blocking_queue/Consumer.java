package com.java.threads.pc.blocking_queue;

import java.util.concurrent.BlockingQueue;

import com.java.threads.pc.wait_notify.Task;

public class Consumer implements Runnable {
	private BlockingQueue<Task> queue;

	public Consumer(BlockingQueue<Task> queue) {
		this.queue = queue;
	}

	public void run() {

		while (true) {
			try {
				Task t = queue.take();
				System.out.println("Task is completed: " + t.getTaskName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

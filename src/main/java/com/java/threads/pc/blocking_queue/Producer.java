package com.java.threads.pc.blocking_queue;

import java.util.concurrent.BlockingQueue;

import com.java.threads.pc.wait_notify.Task;

public class Producer implements Runnable {
	private BlockingQueue<Task> queue;

	public Producer(BlockingQueue<Task> queue) {
		this.queue = queue;
	}

	public void run() {
		while (true) {
			for (int i = 1; i < 51; i++) {
				try {
					queue.put(new Task("Task-" + i));
					System.out.println("Producer has added Task-" + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			break;
		}

	}

}

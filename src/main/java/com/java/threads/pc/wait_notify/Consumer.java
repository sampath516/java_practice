package com.java.threads.pc.wait_notify;

import java.util.Queue;

public class Consumer implements Runnable {
	// Queue with single slot
	private Queue<Task> queue;

	public Consumer(Queue<Task> queue) {
		this.queue = queue;
	}

	public void run() {
		while (true) {
			try {
				performTask();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private void performTask() throws InterruptedException {

		synchronized (queue) {
			while (queue.isEmpty()) {
				System.out.println("Queue is empty. Consumer Thread("+Thread.currentThread().getName() +")  is going to wait");
				queue.wait();
			}
			Task t = queue.remove();
			System.out.println("Consumer Thread ("+Thread.currentThread().getName() +")  has completed task: " + t.getTaskName());
			queue.notifyAll();
		}

	}

}

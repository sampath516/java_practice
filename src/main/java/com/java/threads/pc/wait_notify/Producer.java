package com.java.threads.pc.wait_notify;

import java.util.Queue;

public class Producer implements Runnable {
	// Queue with single slot
	private Queue<Task> queue;
	private final int size;

	public Producer(Queue<Task> queue, int size) {
		this.queue = queue;
		this.size = size;
	}

	public void run() {
		int i = 0;
		while (true) {
			try {
				addTask("Task=" + i++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	private void addTask(String taskName) throws InterruptedException {
		synchronized (queue) {
			while (queue.size() >= size) {
				System.out.println("Queue is full. Producer Thread("+Thread.currentThread().getName() +") is going to wait");
				queue.wait();
			}
			System.out.println("Producer Thread("+Thread.currentThread().getName() +") is adding task" + taskName);
			queue.notifyAll();
			queue.add(new Task(taskName));
		}
	}

}

package com.java.threads.locks;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {
	// Queue with single slot
	private Queue<Task> queue;
	private final int size;
	private Lock lock;
	private Condition waitingPool;

	public Producer(Queue<Task> queue, int size, Lock lock, Condition waitingPool) {
		this.queue = queue;
		this.size = size;
		this.lock = lock;
		this.waitingPool = waitingPool;
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
		lock.lock();
		try {
			while (queue.size() >= size) {
				System.out.println("Queue is full. Producer Thread(" + Thread.currentThread().getName()
						+ ") is going to wait");
				waitingPool.await();
			}
			System.out.println("Producer Thread(" + Thread.currentThread().getName() + ") is adding task" + taskName);
			waitingPool.signalAll();
			queue.add(new Task(taskName));
		} finally {
			lock.unlock();

		}

	}

}

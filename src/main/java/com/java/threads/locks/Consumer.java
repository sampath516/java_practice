package com.java.threads.locks;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable {
	// Queue with single slot
	private Queue<Task> queue;
	private Lock lock;
	private Condition waitingPool;

	public Consumer(Queue<Task> queue, Lock lock, Condition waitingPool) {
		this.queue = queue;
		this.lock = lock;
		this.waitingPool = waitingPool;
	}

	public void run() {
		while (true) {
			try {
				performTask();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private void performTask() throws InterruptedException {
		lock.lock();
		try {
			while (queue.isEmpty()) {
				System.out.println("Queue is empty. Consumer Thread(" + Thread.currentThread().getName()
						+ ")  is going to wait");
				waitingPool.await();
			}
			Task t = queue.remove();
			System.out.println("Consumer Thread (" + Thread.currentThread().getName() + ")  has completed task: "
					+ t.getTaskName());
			waitingPool.signalAll();
		} finally {
			lock.unlock();
		}
	}

}

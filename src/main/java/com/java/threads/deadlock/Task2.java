package com.java.threads.deadlock;

public class Task2 implements Runnable {

	public void run() {
		synchronized (String.class) {
			System.out.println("Acquired lock on String");
			synchronized (Integer.class) {
				System.out.println("Acquired lock on Integer");
			}
		}

	}

}

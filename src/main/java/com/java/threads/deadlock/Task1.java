package com.java.threads.deadlock;

public class Task1 implements Runnable {

	public void run() {
		synchronized (Integer.class) {
			System.out.println("Acquired lock on Integer");
			synchronized (String.class) {
				System.out.println("Acquired lock on String");
			}
		}

	}

}

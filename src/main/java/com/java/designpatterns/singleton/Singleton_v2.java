package com.java.designpatterns.singleton;
/**
 * Instance will be created on first invocation of getInstance
 * @author sampath
 *
 */
public class Singleton_v2 {

	private volatile static Singleton_v2 uniqueInstance;

	private Singleton_v2() {

	}

	public static synchronized Singleton_v2 getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton_v2();
		}
		return uniqueInstance;
	}

}

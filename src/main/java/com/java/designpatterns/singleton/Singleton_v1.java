package com.java.designpatterns.singleton;
/**
 *  Eager Loading: Instance will be created while loading the class itself
 *
 */
public class Singleton_v1 {
	private static Singleton_v1 uniqueInstance = new Singleton_v1();

	private Singleton_v1() {

	}

	public static Singleton_v1 getInstance() {
		return uniqueInstance;
	}

}

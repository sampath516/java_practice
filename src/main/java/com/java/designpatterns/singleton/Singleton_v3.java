package com.java.designpatterns.singleton;

import java.io.Serializable;

/**
 * Instance will be created on first invocation of getInstance method.
 * Also synchronization will be used only the first time.
 * @author sampath
 *
 */
public class Singleton_v3  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5374802328123062077L;
	private volatile static Singleton_v3 uniqueInstance;

	private Singleton_v3() {

	}
	
	public static Singleton_v3 getInstance() {
		if (uniqueInstance == null) {
			synchronized (Singleton_v3.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Singleton_v3();
				}
			}
		}
		return uniqueInstance;
	}

}

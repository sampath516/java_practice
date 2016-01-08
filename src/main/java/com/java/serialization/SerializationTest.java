package com.java.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Assert;

import com.java.designpatterns.singleton.Singleton_v3;

public class SerializationTest {

	public static void main(String args[]) throws IOException, ClassNotFoundException {

		serliazationWithsingleTon();
	}

	private static void testSerliazationWithHierarchy() throws FileNotFoundException, IOException,
			ClassNotFoundException {
		Department department = new Department("d1", "dn1");
		NewEmployee emp1 = new NewEmployee("Samp", "001", 100000, department);

		try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("emp.ser"))) {
			oo.writeObject(emp1);
		}
		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("emp.ser"))) {
			NewEmployee emp = (NewEmployee) oi.readObject();
			System.out.println(emp.getDepartment().getName());
			System.out.println(emp.getName());

		}
	}

	private static void serliazationWithsingleTon() throws FileNotFoundException, IOException, ClassNotFoundException {

		Singleton_v3 signleton1 = Singleton_v3.getInstance();
		Singleton_v3 signleton2 = Singleton_v3.getInstance();
		Assert.assertTrue(signleton1 == signleton2);

		try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("singleTon.ser"))) {
			oo.writeObject(signleton1);
		}

		Singleton_v3 signleton3 = null;
		Singleton_v3 signleton4 = null;
		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("singleTon.ser"))) {
			signleton3 = (Singleton_v3) oi.readObject();
		}
		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("singleTon.ser"))) {
			signleton4 = (Singleton_v3) oi.readObject();
		}

		Assert.assertTrue(signleton3 == signleton4);
	}

}

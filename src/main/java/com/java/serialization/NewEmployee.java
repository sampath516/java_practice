package com.java.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class NewEmployee extends Employee implements Serializable {

	private static final long serialVersionUID = -4752505464414656855L;
	

	public NewEmployee(String name, String id, float salary, Department department) {
		super(name, id, salary, department);
	}
	

	private void writeObject(ObjectOutputStream oo) throws IOException {
		oo.defaultWriteObject();
		oo.writeObject(this.department.getId());
		oo.writeObject(department.getName());
	}

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
		String id = (String) ois.readObject();
		String name = (String) ois.readObject();
		department = new Department(id, name);
	}

}

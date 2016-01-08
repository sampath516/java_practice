package com.java.treeset;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		
		SortedSet<Employee> treeSet = new TreeSet<Employee>();
		Employee e1 = new Employee(1, 10000);
		Employee e2 = new Employee(2, 20000);
		Employee e3 = new Employee(1, 10000);
		Employee e4 = new Employee(4, 40000);
		Employee e5 = new Employee(1, 10000);

		treeSet.add(e1);
		treeSet.add(e2);
		System.out.println(treeSet.add(e3));
		System.out.println(treeSet.contains(e4));
		System.out.println(treeSet.contains(e5));

	}

}

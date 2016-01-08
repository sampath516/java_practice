package com.java8;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class AppleProcessing {

	public static void main(String[] args) {
		List<Apple> apples = getApplesList();
		System.out.println("**********Apples************");
		printApples(apples);
		System.out.println();
		System.out.println("**********Java7: Green Apples************");
		printApples(filterGreenApplesJava7(apples));
		System.out.println();
		System.out.println("**********Java7: Heavy Weight Apples************");
		printApples(filterHeavyWieghtApplesJava7(apples));
		System.out.println();
		System.out.println("**********Java8 Metohd References: Green Apples************");		
		printApples(filterJava8(apples,Apple::isGreenApple));
		printApples(filterJava8(apples,(Apple a) -> "green".equals(a.getColor())));

		System.out.println();
		System.out.println("**********Java8 Metohd References: Heavy Weight Apples************");
		printApples(filterJava8(apples,Apple::isHeavyWeightApple));
		
		System.out.println();
		System.out.println("**********Java8 Lamdas: Green Apples************");		
		printApples(filterJava8(apples,(Apple a) -> "green".equals(a.getColor())));
		
		System.out.println();
		System.out.println("**********Java8 Streams+Lamdas: Green Apples************");		
		printApples(apples.stream().filter((Apple a) -> "green".equals(a.getColor())).collect(toList()));
		
		System.out.println();
		System.out.println("**********Java7 Sorting: Sort by color************");		
		Collections.sort(apples);
		printApples(apples);
		
		System.out.println();
		System.out.println("**********Java7 Sorting: Sort by weight************");		
		Collections.sort(apples, new AppleWeightComparator());
		printApples(apples);
		
		System.out.println();
		System.out.println("**********Java8 Sorting: Sort by color************");		
		printApples(apples.stream().sorted().collect(toList()));
		
		System.out.println();
		System.out.println("**********Java8 Sorting: Sort by weight************");		
		printApples(apples.stream().sorted(new AppleWeightComparator()).collect(toList()));	
		
	}

	public static List<Apple> filterJava8(List<Apple> apples, Predicate<Apple> p) {
		List<Apple> filteredApples = new ArrayList<Apple>();
		for (Apple a : apples) {
			if (p.test(a)) {
				filteredApples.add(a);
			}
		}
		return filteredApples;
	}

	public static List<Apple> getApplesList() {
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple("green", 400, "t1"));
		apples.add(new Apple("yellow", 200, "t1"));
		apples.add(new Apple("green", 200, "t2"));

		apples.add(new Apple("brown", 300, "t1"));

		apples.add(new Apple("green", 500, "t3"));

		apples.add(new Apple("green", 100, "t2"));
		apples.add(new Apple("yellow", 250, "t1"));
		return apples;
	}

	public static void printApples(List<Apple> apples) {
		for (Apple a : apples) {
			System.out.println("Color:" + a.getColor() + " weight:"
					+ a.getWeight() + " Type:" + a.getType());
		}
	}

	public static List<Apple> filterGreenApplesJava7(List<Apple> appleList) {
		List<Apple> greenApples = new ArrayList<Apple>();
		for (Apple a : appleList) {
			if ("green".equals(a.getColor())) {
				greenApples.add(a);
			}
		}
		return greenApples;
	}

	public static List<Apple> filterHeavyWieghtApplesJava7(List<Apple> appleList) {
		List<Apple> heavyWieghtApples = new ArrayList<Apple>();
		for (Apple a : appleList) {
			if (a.getWeight() > 300) {
				heavyWieghtApples.add(a);
			}
		}
		return heavyWieghtApples;
	}

}

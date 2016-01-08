package com.java8;

public class Apple implements Comparable<Apple> {
	private String color;
	private Float weight;
	private String type;

	public Apple(String color, float weight, String type) {
		this.color = color;
		this.weight = weight;
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isGreenApple() {
		return "green".equals(color);
	}

	public boolean isHeavyWeightApple() {
		return weight > 300;
	}

	@Override
	public int compareTo(Apple otherApple) {
		return this.color.compareTo(otherApple.getColor());
	}
	
	

}

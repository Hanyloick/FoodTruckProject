package com.Skilldistillery.foodtruck.entities;

public class FoodTruck {
	private String name;
	private String foodType;
	private double rating;
	private int ID;
	private static int nextID;
//constructors
	public FoodTruck() {

	}

	public FoodTruck(String name, String foodType, int rating, int id) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		this.ID = id;
	}
//getters/settersß

	public String getName() {
		return name;
	}

	public int getId() {
		return ID;
	}

	public void setId(int id) {
		this.ID = id + nextID;
	}

	//create and increment the new id number so they change
	public static int getNextID() {
		return nextID;
	}
	public static void setNextID(int nextID) {
		FoodTruck.nextID = nextID;
		nextID++;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating2) {
		this.rating = rating2;
	}

	public int getiD(int i) {
		return ID;
	}
	

//toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FoodTruck [");
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (foodType != null) {
			builder.append("foodType=");
			builder.append(foodType);
			builder.append(", ");
		}
		builder.append("rating=");
		builder.append(rating);
		builder.append(", id=");
		builder.append(ID);
		builder.append("]");
		return builder.toString();
	}

}

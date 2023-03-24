package com.Skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.Skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
	//array of food trucks.
	private FoodTruck[] fleet;
	
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);	
		FoodTruckApp fta = new FoodTruckApp();
		fta.run();
		sc.close();
	}
	public void run() {
		
	}
}

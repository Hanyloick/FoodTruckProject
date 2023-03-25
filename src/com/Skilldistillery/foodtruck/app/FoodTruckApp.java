package com.Skilldistillery.foodtruck.app;

import java.util.Arrays;
import java.util.Scanner;

import com.Skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
	// array of food trucks for up to 5 trucks
	private FoodTruck[] fleet;

	public static void main(String[] args) {
		FoodTruckApp fta = new FoodTruckApp();
		fta.run(fta);
	}

	public void run(FoodTruckApp fta) {
		Scanner sc = new Scanner(System.in);
		boolean quit = true;
		System.out.println("Please enter information for your trucks");
		getFoodTruckInfo(sc);
		while (quit) {

			fta.displayMenu();
			quit = fta.userChoice(sc, fleet);
		}
		sc.close();

	}

//	The user is prompted to input the name, food type, and rating for up to five food trucks. For each set of input, a FoodTruck object is created, 
//	its fields set to the user's input, and it is added to the array. The truck id is not input by the user, 
//	but instead assigned automatically in the FoodTruck constructor from a static field that is incremented as each truck is created.
	public FoodTruck[] getFoodTruckInfo(Scanner sc) {
		String foodType = "";
		double rating = 0;
		System.out.println("How many food trucks do you want to enter?");
		int ix = sc.nextInt();
		sc.nextLine();

		FoodTruck[] fleet = new FoodTruck[ix];

		for (int i = 0; i < fleet.length; i++) {
			System.out.println("Enter " + ix + " names or \"quit\" to stop entering trucks:");
			ix--;
			String truckName = sc.nextLine();
//If the user inputs quit for the food truck name, input ends immediately and the program continues.
			if (truckName.equalsIgnoreCase("quit")) {
				FoodTruck[] exitArr = Arrays.copyOf(fleet, i);// <----if user quits return the current copy of the []
				return exitArr;

			} else {
				System.out.println("Enter type of food:");
				foodType = sc.nextLine();

				do {
					System.out.println("Enter rating \"0-5\"):");
					rating = sc.nextDouble();
					if (rating > 5 || rating < 0) {
						System.out.println("out of range. try again.");
					}
				} while (rating > 5 || rating < 0);
				sc.nextLine();

				fleet[i] = new FoodTruck();
				fleet[i].setName(truckName);
				fleet[i].setFoodType(foodType);
				fleet[i].setRating(rating);
				fleet[i].getId();
			}
		}
		return fleet;

	}
	
//	After input is complete, the user sees a menu from which they can choose to:
//
//		List all existing food trucks.
//		See the average rating of food trucks.
//		Display the highest-rated food truck.
//		Quit the program.


	public void displayMenu() {
		System.out.println("enter 1-4");
		System.out.println("1. show the fleet");
		System.out.println("2. show the best truck");
		System.out.println("3. show the average rating");
		System.out.println("4. you quitter -_-");
	}

	public boolean userChoice(Scanner sc, FoodTruck[] fleet) {

		int input;
		do {
			System.out.println("Enter your selection (1-4): ");
			 input = sc.nextInt();

			if (input < 1 || input > 4) {
				System.out.println("Your selection was out of range. Please try again.");
			}
		} while (input >= 4 || input <= 1);

		

		switch (input) {
		case 1:
			displayTruckInfo(fleet);
			break;
		case 2:
			displayAverageRating(fleet);
			break;
		case 3:
			displayHighestRated(fleet);
			break;
		case 4:
			System.out.println("Thank you");
			return false;
		}

		return true;
	}

	public void displayTruckInfo(FoodTruck[] fleet) {
		for (int i = 0; i < fleet.length; i++) {
			System.out.println(fleet[i].toString());
		}

	}

	public void displayAverageRating(FoodTruck[] fleet) {
		double totalRatings = 0;
		for (int i = 0; i < fleet.length; i++) {
			totalRatings += fleet[i].getRating();
		}
		double avg = totalRatings / fleet.length * 1.0;
		double showAvg = Math.round(avg) * 100 / 100; // <--round for readability
		System.out.println("the Average is " + showAvg);

	}

	public void displayHighestRated(FoodTruck[] fleet) {
		double highestRating = fleet[0].getRating(); // <----initialized to the rating of index 0

		for (int i = 9; i < fleet.length; i++) {
			if (fleet[i].getRating() > highestRating) { // compare that value to the array
				highestRating = fleet[i].getRating(); // reassign when a higher value is found

			}
		}
		int counter = 0;
		for (int i = 0; i < fleet.length; i++) { // <---counter variable in case of no winners
			counter++;
		}

		if (counter > 1) { // if counter > 0 there's no winners
			System.out.println(counter + "tied for 1st");
		} else {
			System.out.println("the best is: ");
		}

		for (int i = 0; i < fleet.length; i++) { // find any matches
			if (highestRating == fleet[i].getRating()) {
				System.out.println(fleet[i].toString());
			}
		}

	}

}

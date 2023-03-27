package com.Skilldistillery.foodtruck.app;

//import java.util.Arrays;
//import java.util.Iterator;
import java.util.Scanner;

import com.Skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	public static void main(String[] args) {
		FoodTruckApp fta = new FoodTruckApp();
		fta.run(fta);
	}

	public void run(FoodTruckApp fta) {
		Scanner sc = new Scanner(System.in);
		boolean on = true;
		FoodTruck[] fleet = getFoodTruckInfo(sc);
		System.out.println("Please enter information for your trucks");

		while (on) {

			fta.displayMenu(sc);
			on = fta.userChoice(sc, fleet);
		}
		sc.close();

	}

	public FoodTruck[] getFoodTruckInfo(Scanner sc) {
		double rating = 0;
		FoodTruck[] fleet = new FoodTruck[5];
		for (int i = 0; i < fleet.length; i++) {
			System.out.println("Enter names or \"quit\" to stop entering trucks:");
			String truckName = sc.nextLine();
//If the user inputs quit for the food truck name, input ends immediately and the program continues.
			if (truckName.equalsIgnoreCase("quit")) {
				FoodTruck[] exitArr = copyFleet(fleet);
//				FoodTruck[] exitArr = Arrays.copyOf(fleet, i);// <----if user quits return the current copy of the []
				//Arrays.copyOf() copies the specified array by truncating the remaing length
				return exitArr;
			} else {
				System.out.println("Enter type of food:");
				String foodType = sc.nextLine();

				do {
					System.out.println("Enter rating \"0-5\"");
					rating = sc.nextDouble();
					if (rating > 5 || rating < 0) {
						System.out.println("Out of range. Try again.");
					}
				} while (rating > 5 || rating < 0);
				sc.nextLine();

				fleet[i] = new FoodTruck();
				fleet[i].setName(truckName);
				fleet[i].setFoodType(foodType);
				fleet[i].setRating(rating);
				fleet[i].setId(i);
			}
		}
		return fleet;

	}

	public void displayMenu(Scanner sc) {
		System.out.println();
		System.out.println("enter 1-4");
		System.out.println("1. Show the fleet");
		System.out.println("2. Show the best truck");
		System.out.println("3. Show the average rating");
		System.out.println("4. You quitter -_-");
		System.out.println();
	}

	public boolean userChoice(Scanner sc, FoodTruck[] fleet) {

		int input;
		do {
			System.out.println("Enter 1-4");
			input = sc.nextInt();

			if (input < 1 || input > 4) {
				System.out.println("Out of range. Please try again.");
			}
		} while (input > 4 || input < 1);

		switch (input) {
		case 1:
			displayTruckInfo(fleet);
			break;
		case 2:

			displayHighestRated(fleet);
			break;
		case 3:
			displayAverageRating(fleet);
			break;
		case 4:
			System.out.println("Thank you!");
			return false;
		}

		return true;
	}

	public void displayTruckInfo(FoodTruck[] fleet) {
		for (int i = 0; i < fleet.length; i++) {
			System.out.println(fleet[i]);
		}

	}

	public void displayHighestRated(FoodTruck[] fleet) {
		double highestRating = fleet[0].getRating(); // <----initialized to the rating of index 0

		for (int i = 0; i < fleet.length; i++) {
			if (fleet[i].getRating() > highestRating) { // compare that value to the array
				highestRating = fleet[i].getRating(); // reassign when a higher value is found

			}
		}
		int counter = 0;
		for (int i = 0; i < fleet.length; i++) { // <---counter variable in case of no winners
			if (highestRating == fleet[i].getRating())
				counter++;
		}

		if (counter > 1) { // if counter > 0 there's no winners
			System.out.println(counter + "Tied for 1st");
		} else {
			System.out.println("The best is: ");
		}

		for (int i = 0; i < fleet.length; i++) { // find any matches
			if (highestRating == fleet[i].getRating()) {
				System.out.println(fleet[i]);
			}
		}

	}

	public void displayAverageRating(FoodTruck[] fleet) {
		double totalRatings = 0;
		for (int i = 0; i < fleet.length; i++) {
			totalRatings += fleet[i].getRating();
		}
		double avg = totalRatings / fleet.length;
		System.out.printf("The Average is " + "%,.2f", +avg);

	}

	public FoodTruck[] copyFleet(FoodTruck[] fleet) {
		FoodTruck[] copyFleet = new FoodTruck[getArrayLength(fleet)];
		for (int i = 0; i < copyFleet.length; i++) {
			if (fleet[i] != null) {
				copyFleet[i] = fleet[i];
			}
		}
		return copyFleet;
	}

	public int getArrayLength(FoodTruck[] fleet) {
		int counter = 0;
		for (int i = 0; i < fleet.length; i++) {
			if (fleet[i] != null) {
				counter++;
			}
		}
		return counter;
	}

}

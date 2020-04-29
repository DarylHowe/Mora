import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * InputValidation - An instantiable class which validate if the user has
 * entered a valid input.
 */

public class InputValidation {

	
    private ArrayList<String> validNumbersArrayList = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));

	/**
	 * A constructor for InputValidation.
	 */
	public InputValidation() {

	}

	
	/**
	 * A method which checks the user has chosen to be the even or odd player and returns their choice.
	 * 
	 * @param input The input entered by the user.
	 * @return boolean If true, the player is even else the player is odd.
	 */
	public boolean playerTypeValidation(String input) {

		while (!input.equals("0") && !input.equals("1")) {

			System.out.println("");
			System.out.println("You have entered an invalid choice. Please choose again.");
			System.out.println("Enter 0 to be the 'Even' player, enter 1 to be the 'Odd' player!");

			Scanner input01 = new Scanner(System.in);
			input = input01.nextLine();
		}

		if (input.equals("0")) {
			return true;
		} else {
			return false;
		}

	}

	
	/**
	 * A method which checks the user has entered a number between 1 and 10 and returns their choice.
	 * 
	 * @param 	input	The input entered by the user.
	 * @return 	int 	The number entered by the user.
	 */
	public int playerFingersValidation(String input) {

		// while the input is not on the list..
		while (!validNumbersArrayList.contains(input)) {

			System.out.println(
					"You have entered an invalid choice. Please enter a valid number (1-10) of fingers you wish show.");

			Scanner input01 = new Scanner(System.in);
			input = input01.nextLine();
		}

		int inputAsInt = Integer.parseInt(input);
		return inputAsInt;
	}


	/**
	 * A method which checks the user has correctly chosen whether they would like to player again or not.
	 * 
	 * @param 	input 	A string input entered by the user.
	 * @return 	int 	The number entered by the user..
	 */
	public int playAgainValidation(String input) {

		while (!input.equals("0") && !input.equals("1")) {

			System.out.println("You have entered an invalid choice. Please choose again.");
			System.out.println("Would you like to play another game? Enter 0 for 'Yes' and 1 for 'No");

			Scanner input01 = new Scanner(System.in);
			input = input01.nextLine();
		}

		int inputAsInt = Integer.parseInt(input);
		return inputAsInt;
	}

}

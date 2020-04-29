/**
 * Mora - A turn based game bases on luck where the player plays against the computer to score points. 
 * Author @ Daryl Howe 01/04/2020
 */

import java.util.Scanner;

public class MoraApp {

	public static void main(String[] args) {
		
		
		String playerType;
		
		int totalFingers;
		int playAgainInt;

		boolean playerIsEven = false;
		boolean playerWinsRound = false;
		
		Player player;
		Player computer;
		
		InputValidation inputValidation = new InputValidation();
		GameManager gameManager = new GameManager();
		
		// Display welcome and state rules/addition rules		
		System.out.println("Welcome to Mora!");
		System.out.println("");
		System.out.println("------------------");
		System.out.println("Rules:");
		System.out.println("At the beginning of each game - choose to be the odd or even player.");
		System.out.println("At each round you show a certain number of fingers on your hands. Your opponent (the computer!) will do the same.");
		System.out.println("The total of all fingers shown will be calculated.");
		System.out.println("If the total number of fingers is ODD and you are the ODD player - you WIN!.");
		System.out.println("If the total number of fingers is EVEN and you are the EVEN player - you WIN!.");
		System.out.println("The winner of each round recieves 3 points.");
		System.out.println("Whichever player is closest to the total fingers on show recieves 2 addition bonus points.");
		System.out.println("The first player to reach 12 points wins!");
		System.out.println("");
		System.out.println("Lastly..");
		System.out.println("You cannot show 0 fingers!");
		System.out.println("If both players show the same number of fingers bonus points will not be given to either player as they will both be the same distance from the total fingers on show!");
		System.out.println("------------------");
		System.out.println("");
		

		// Do once and the while the user wants to keep playing again after the game is over..
		do {

			// Prompt user..
			System.out.println("Enter 0 to be 'Even' player, enter 1 to be 'Odd' player!");
			Scanner input01 = new Scanner(System.in);
			playerType = input01.nextLine();

			// Check the user has entered a valid choice.
			playerIsEven = inputValidation.playerTypeValidation(playerType);

			// If the player chose even..
			if (playerIsEven) {

				player = new Player(true);
				computer = new Player(false);

				System.out.println("");
				System.out.println("Player is even!");
				System.out.println("Computer is odd!");

				// If the player chose odd..
			} else {

				player = new Player(false);
				computer = new Player(true);

				System.out.println("");
				System.out.println("Player is odd!");
				System.out.println("Computer is even!");
			}

			// Do once and then while player or computer has not reached a score of 12 or greater..
			do {

				// Display the game and round number.
				System.out.println("------------------");
				System.out.println("");
				System.out.println("Game number: " + gameManager.getGameNumber());
				System.out.println("Round number: " + gameManager.getRoundNumber());
				System.out.println("");

				// Prompt user..
				System.out.println("Enter the number of fingers you wish to show.");
				Scanner input02 = new Scanner(System.in);
				String playerNumberOfFingersString = input02.nextLine();

				// When the choice is valid set it to the player number of fingers.
				int playerFingersAsInt = inputValidation.playerFingersValidation(playerNumberOfFingersString);
				player.setNumberOfFingers(playerFingersAsInt);

				// Generate computer fingers
				computer.generateRandomNumberOfFingers();

				// Display both player and computers choice.
				System.out.println("");
				System.out.println("Player choice: " + player.getNumberOfFingers());
				System.out.println("Computer choice: " + computer.getNumberOfFingers());

				// Calculate and display the total number of fingers on show.
				totalFingers = gameManager.getTotalFingers(player.getNumberOfFingers(), computer.getNumberOfFingers());
				System.out.println("Total fingers on show: " + totalFingers);
				System.out.println("");

				// Check who won the round.
				playerWinsRound = gameManager.checkRoundWinner(player.getIsEvenPlayer());

				// If the player won the round..
				if (playerWinsRound) {
					player.winsRound();
					
				} else {
					computer.winsRound();
				}

				// Check player and computer distances from total fingers.
				int distanceWinner = gameManager.checkDistancesFromTotalFingers(player.getNumberOfFingers(), computer.getNumberOfFingers());
				
				// If the distance winner is the player..
				if (distanceWinner == 0) {
					player.winClosestToTotal();
					System.out.println("");
					System.out.println("Player has the closest amount of fingers on show to the total. +2 points for player.");

					// If the distance winner is the computer..
				} else if (distanceWinner == 1) {
					computer.winClosestToTotal();
					System.out.println("");
					System.out.println("Computer has the closest amount of fingers on show to the total. +2 points for computer.");
				
					// If the distance winner is a draw..
				} else {
					System.out.println("Both players displayed the same amount of fingers. Neither player receives any addition points!");
				}

				System.out.println("");
				System.out.println("Player Stats:");
				player.displayRoundStats();

				System.out.println("");
				System.out.println("Computer Stats:");
				computer.displayRoundStats();

				// Increment the round number by 1.
				gameManager.setRoundNumber(gameManager.getRoundNumber() + 1);
				
			} while (player.getCurrentGameScore() < 12 && computer.getCurrentGameScore() < 12);

			// Determine who won the game.
			int gameWinner = gameManager.determineGameWinner(player.getCurrentGameScore(), computer.getCurrentGameScore());

			if (gameWinner == 0) {
				System.out.println("Player won this game!");
				player.winsGame();

			} else if (gameWinner == 1) {
				System.out.println("Computer won this game!");
				computer.winsGame();

			} else {
				System.out.println("Game ends as a draw!!");
			}

			player.resetStats();
			computer.resetStats();

			System.out.println("------------------");
			System.out.println("Game " + gameManager.getGameNumber() + ": " + "Game Stats");

			System.out.println("");
			System.out.println("Player Stats:");
			player.displayGameStats();

			System.out.println("");
			System.out.println("Computer Stats:");
			computer.displayGameStats();

			// Prompt user..
			System.out.println("");
			System.out.println("Would you like to play another game? Enter 0 for 'Yes' and 1 for 'No");
			Scanner input03 = new Scanner(System.in);
			String playAgain = input03.nextLine();

			// When the input is valid set'playAgainInt' = to the input.
			playAgainInt = inputValidation.playAgainValidation(playAgain);

			if (playAgainInt == 0) {
				System.out.println("You chose to play another game!");
				System.out.println("");
				gameManager.setRoundNumber(1);
				gameManager.setGameNumber((gameManager.getGameNumber()) + 1);
			} else {
				System.out.println("Player would like to exit the entire game.");
				System.out.println("");
			}

		} while (playAgainInt == 0);

		System.out.println("Thank you for playing Mora!");
		System.out.println("Author @ Daryl Howe - howedaryl@hotmail.com");

	}
}

/**
 * 
 * GameManager - an instantiable class that keeps track of the game. 
 */
public class GameManager {

	private int roundNumber = 1;
	private int gameNumber = 1;	
	private int totalFingers;
		
	
	/**
	 * A constructor for the GameManager.
	 */
	public GameManager() {
	}

	/**
	 * A method to total the number of fingers on show.
	 * 
	 * @param playerNumberOfFingers   The player number of fingers.
	 * @param computerNumberOfFingers The computer number of fingers.
	 * @return
	 */
	public int getTotalFingers(int playerNumberOfFingers, int computerNumberOfFingers) {

		totalFingers = playerNumberOfFingers + computerNumberOfFingers;
		return totalFingers;
	}

	/**
	 * A method to determine who the winner of a round is.
	 * 
	 * @param playerIsEven boolean which to set if the player is the even or odd.
	 * @return boolean returns true if round is won by player.
	 */
	public boolean checkRoundWinner(boolean playerIsEven) {

		// If total fingers is even..
		if ((totalFingers % 2) == 0) {
			System.out.println("The total number of fingers is even.");

			// If player is even..
			if (playerIsEven) {

				System.out.println("Player wins the round. +3 points for player.");
				return true;
			} else {

				System.out.println("Computer wins the round! +3 points for computer.");
				return false;
			}
		}

		// If total fingers is odd..
		else {
			System.out.println("The total number of fingers is odd.");

			if (!playerIsEven) {

				System.out.println("Player wins the round. +3 points for player.");
				return true;
			} else {

				System.out.println("Computer wins the round! +3 points for computer.");
				return false;
			}
		}

	}

	/**
	 * A method to check who chose the number of fingers closest to total.
	 * 
	 * @param playerNumberOfFingers
	 * @param computerNumberOfFingers
	 * @return int where 0 = player wins, 1 = computer wins, 2 = draw.
	 */
	public int checkDistancesFromTotalFingers(int playerNumberOfFingers, int computerNumberOfFingers) {

		int playerDistanceFromTotal = totalFingers - playerNumberOfFingers;
		int computerDistanceFromTotal = totalFingers - computerNumberOfFingers;

		int outcome;

		// If player is closer..
		if (playerDistanceFromTotal < computerDistanceFromTotal) {

			outcome = 0;

		} else if ((playerDistanceFromTotal > computerDistanceFromTotal)) {

			outcome = 1;
		} else {

			outcome = 2;
		}
		return outcome;
	}

	/**
	 * A method to check which player has won the game.
	 * 
	 * @param playerScore   The current score of the player.
	 * @param computerScore The current score of the computer.
	 * @return int where 0 = player wins, 1 = computer wins, 2 = draw.
	 */
	public int determineGameWinner(int playerScore, int computerScore) {

		int gameWinnerOutcome;

		// If the player score is great than 12 and greater than the computers score..
		if (playerScore >= 12 && playerScore > computerScore) {

			gameWinnerOutcome = 0;
		} else if (computerScore >= 12 && computerScore > playerScore) {

			gameWinnerOutcome = 1;
		} else {

			gameWinnerOutcome = 2;
		}

		return gameWinnerOutcome;
	}
	
	
	// Setters & Getters
	public int getRoundNumber() {
		return roundNumber;
	}

	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}

	public int getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}
}

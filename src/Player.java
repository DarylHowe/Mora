import java.util.Random;

/**
 * Player - an instantiable class to hold a player information such as:
 * If the player is even or odd. 
 * The players current number of fingers. 
 */

public class Player {

	private boolean isEvenPlayer;
	private int numberOfFingers;
	private int currentGameScore = 0;
	private int totalRoundsWon = 0;
	private int totalGamesWon = 0;

	/**
	 * A constructor for a Player.
	 * 
	 * @param isEvenPlayer a boolean which states if the player is even. If false, player is odd.
	 */
	public Player(boolean isEvenPlayer) {
		this.isEvenPlayer = isEvenPlayer;
	}

	
	/**
	 * A method to generate a random number to represent a randomly chosen number of fingers.
	 */
	public int generateRandomNumberOfFingers() {
		Random rand = new Random();
		numberOfFingers = rand.nextInt(10) + 1;
		return numberOfFingers;
	}

	
	/**
	 * A method to adjust the players stats when a round is won.
	 */
	public void winsRound() {
		currentGameScore += 3;
		totalRoundsWon++;
	}

	
	/**
	 * A method to adjust the players stats when the player wins closest to total
	 * fingers.
	 */
	public void winClosestToTotal() {
		currentGameScore += 2;
	}

	
	/**
	 * A method to adjust the players stats when a game is won.
	 */
	public void winsGame() {
		totalGamesWon++;
	}

	
	/**
	 * A method which displays the players stats at the end of a round.
	 */
	public void displayRoundStats() {
		System.out.println("Current game score: " + currentGameScore);
		System.out.println("Total rounds won: " + totalRoundsWon);
		System.out.println("Total games won: " + totalGamesWon);
	}

	
	/**
	 * A method which displays the players stats at the end of a game.
	 */
	public void displayGameStats() {
		System.out.println("Total rounds won: " + totalRoundsWon);
		System.out.println("Total games won: " + totalGamesWon);
	}

	
	/**
	 * A method to reset the player stats after a game has been played.
	 */
	public void resetStats() {
		currentGameScore = 0;
	}

	
	
	
	// Setters & Getters

	public void setNumberOfFingers(int numberOfFingers) {
		this.numberOfFingers = numberOfFingers;
	}

	public int getNumberOfFingers() {
		return numberOfFingers;
	}

	public boolean getIsEvenPlayer() {
		return isEvenPlayer;
	}

	public int getCurrentGameScore() {
		return currentGameScore;
	}

}
package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

public class Game implements Serializable {

	/**
	 * This is the Game java bean for a Mastermind Game Application
	 * by Michael Juarez-Sweeney
	 */
	private static final long serialVersionUID = 20191123L;

	public enum GamePegs {
		GREEN, YELLOW, RED, BLUE, PURPLE, ORANGE;
	}

	private static final int MAX_GUESSES = 12;
	private static final int CODE_LEN = 4;
	private static final String[] COLORS;
	static {
		GamePegs[] pegs = GamePegs.values();
		COLORS = new String[pegs.length];
		for(int i = 0; i < COLORS.length; i++) {
			COLORS[i]= pegs[i].toString(); 
		}
	}
	private GamePegs[] gameCode;
	private int[][] hints;
	private GamePegs[][] guesses;
	private int numGuesses;
	Random random = new Random();

	/**
	 * A method that returns the number of guesses that have been made.
	 * @return number of guesses
	 */
	public int getNumGuesses() {
		return numGuesses;
	}
	
	/**
	 *  A method that returns the master code of the game to be guessed.
	 * @return game code
	 */
	public GamePegs[] getGameCode() {
		return gameCode;
	}
	
	/**
	 * A method that returns an array of the possible color choices
	 * @return colors
	 */
	public String[] getColors() {
		return COLORS;
	}

	/**
	 * A method that returns an array of all guesses that have been made.
	 * @return guesses
	 */
	public GamePegs[][] getGuesses() {
		return Arrays.copyOf(guesses, numGuesses);
	}

	/**
	 * Game class to string method.
	 */
	@Override
	public String toString() {
		return "GameCode: " + Arrays.toString(gameCode) + "\n" + "Guesses: " + Arrays.deepToString(guesses);
	}
	
	
	private GamePegs[] generateCode() {
		GamePegs[] gameCode = new GamePegs[4];
		for (int i = 0; i < 4; i++) {
			gameCode[i] = (GamePegs.values()[random.nextInt(GamePegs.values().length)]);
		}
		return gameCode;
	}
	/**
	 * Constructor for Game class.
	 */
	public Game() {
		reset();
	}
	
	/**
	 * A method that resets the game.
	 */
	public void reset() {
		gameCode = new GamePegs[CODE_LEN];
		guesses = new GamePegs[MAX_GUESSES][];
		numGuesses = 0;
		gameCode = generateCode();
		hints = new int[MAX_GUESSES][];		
	}

	/**
	 * A method that take a parameter 'guess' from user make a guess in the game.
	 * @param guess
	 */
	public void makeGuess(GamePegs[] guess) {
		guesses[numGuesses] = guess.clone();
		checkCode(guess);
		numGuesses++;
	}

	private int[] checkCode(GamePegs[] guess) {
		int [] keyPegs = new int[2];
		boolean[] codeMatched = new boolean[4];
		boolean[] guessMatched = new boolean[4];
		
		
		
		for (int i = 0; i < gameCode.length; i++) {
			if (!codeMatched[i] && guess[i].equals(gameCode[i])) {
				keyPegs[0]++;
				codeMatched[i] = true;
				guessMatched[i] = true;
			} 
		}
		for (int c = 0; c < gameCode.length; c++) {
			for (int g = 0; g < gameCode.length; g++) {
				if (!codeMatched[c] && !guessMatched[g] && guess[g].equals(gameCode[c])) {
					keyPegs[1]++;
					guessMatched[g] = true;
					codeMatched[c] = true;
					break;
				}
			}

		}
		hints[numGuesses] = keyPegs;
		return keyPegs;

	}
	
	/**
	 * A method that gets an array that contains all the hints that have been given.
	 * @return hints
	 */
	public int[][] getHints() {
		return hints.clone();
	}
	
	/**
	 * A method that sets the game code for testing.
	 * @param gameCode
	 */
	public void setGameCode(GamePegs[] gameCode) {
		this.gameCode = gameCode;
	}
	
	/**
	 * A method that determines if the previous guess resulted in a win
	 * @return
	 */
	public boolean isWinner() {
		return hints[numGuesses - 1][0] == 4;	
	}
	
	/**
	 * A getter for the max guesses
	 * @return MAX_GUESSES
	 */
	public int getMaxGuesses() {
		return MAX_GUESSES;
	}

	/**
	 * A method that check if the game is over based on a guess or the number of guesses.
	 * @return
	 */
	public boolean isOver() {
		return numGuesses >= MAX_GUESSES || (numGuesses > 0 && hints[numGuesses - 1][0] == 4);
	}
}

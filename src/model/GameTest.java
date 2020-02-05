package model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import model.Game.GamePegs;

class GameTest {

	@Test
	void testMatch() {
		Game game = new Game();
		GamePegs[] gameCode = {GamePegs.BLUE, GamePegs.GREEN, GamePegs.RED, GamePegs.RED};
		GamePegs[] guess = {GamePegs.BLUE, GamePegs.GREEN, GamePegs.RED, GamePegs.RED};
		game.setGameCode(gameCode);
		game.makeGuess(guess);
		assertEquals(1, game.getNumGuesses());
		
	}
	
	@Test
	void testGameOver1() {
		Game game = new Game();
		GamePegs[] gameCode = {GamePegs.BLUE, GamePegs.GREEN, GamePegs.RED, GamePegs.RED};
		GamePegs[] guess = {GamePegs.BLUE, GamePegs.GREEN, GamePegs.RED, GamePegs.RED};
		game.setGameCode(gameCode);
		game.makeGuess(guess);
		assertArrayEquals(new int [] {4, 0}, game.getHints()[game.getNumGuesses() - 1]);
		assertTrue(game.isOver());
	}
	
	@Test
	void testGameOver2() {
		Game game = new Game();
		GamePegs[] gameCode = {GamePegs.BLUE, GamePegs.GREEN, GamePegs.RED, GamePegs.RED};
		GamePegs[] guess1 = {GamePegs.YELLOW, GamePegs.YELLOW, GamePegs.BLUE, GamePegs.BLUE};
		GamePegs[] guess2 = {GamePegs.YELLOW, GamePegs.YELLOW, GamePegs.BLUE, GamePegs.BLUE};
		GamePegs[] guess3 = {GamePegs.YELLOW, GamePegs.YELLOW, GamePegs.BLUE, GamePegs.BLUE};
		GamePegs[] guess4 = {GamePegs.YELLOW, GamePegs.YELLOW, GamePegs.BLUE, GamePegs.BLUE};
		GamePegs[] guess5 = {GamePegs.YELLOW, GamePegs.YELLOW, GamePegs.BLUE, GamePegs.BLUE};
		GamePegs[] guess6 = {GamePegs.YELLOW, GamePegs.YELLOW, GamePegs.BLUE, GamePegs.BLUE};
		GamePegs[] guess7 = {GamePegs.YELLOW, GamePegs.YELLOW, GamePegs.BLUE, GamePegs.BLUE};
		GamePegs[] guess8 = {GamePegs.YELLOW, GamePegs.YELLOW, GamePegs.BLUE, GamePegs.BLUE};
		GamePegs[] guess9 = {GamePegs.YELLOW, GamePegs.YELLOW, GamePegs.BLUE, GamePegs.BLUE};
		GamePegs[] guess10 = {GamePegs.YELLOW, GamePegs.YELLOW, GamePegs.BLUE, GamePegs.BLUE};
		GamePegs[] guess11 = {GamePegs.YELLOW, GamePegs.YELLOW, GamePegs.BLUE, GamePegs.BLUE};
		GamePegs[] guess12 = {GamePegs.YELLOW, GamePegs.YELLOW, GamePegs.BLUE, GamePegs.BLUE};
		game.setGameCode(gameCode);
		game.makeGuess(guess1);
		game.makeGuess(guess2);
		game.makeGuess(guess3);
		game.makeGuess(guess4);
		game.makeGuess(guess5);
		game.makeGuess(guess6);
		game.makeGuess(guess7);
		game.makeGuess(guess8);
		game.makeGuess(guess9);
		game.makeGuess(guess10);
		game.makeGuess(guess11);
		game.makeGuess(guess12);
		assertTrue(game.isOver());
	}
	
	@Test
	void testKeys1() {
		Game game = new Game();
		GamePegs[] gameCode = {GamePegs.RED, GamePegs.GREEN, GamePegs.GREEN, GamePegs.RED};
		GamePegs[] guess1 = {GamePegs.GREEN, GamePegs.RED, GamePegs.RED, GamePegs.GREEN};
		game.setGameCode(gameCode);
		game.makeGuess(guess1);
		assertArrayEquals(new int [] {0, 4}, game.getHints()[game.getNumGuesses() - 1]);
		
	}
	
	@Test
	void testKeys2() {
		Game game = new Game();
		GamePegs[] gameCode = {GamePegs.RED, GamePegs.GREEN, GamePegs.GREEN, GamePegs.RED};
		GamePegs[] guess1 = {GamePegs.RED, GamePegs.GREEN, GamePegs.RED, GamePegs.GREEN};
		game.setGameCode(gameCode);
		game.makeGuess(guess1);
		assertArrayEquals(new int [] {2, 2}, game.getHints()[game.getNumGuesses() - 1]);
		
	}
	
	@Test
	void testKeys3() {
		Game game = new Game();
		GamePegs[] gameCode = {GamePegs.RED, GamePegs.GREEN, GamePegs.GREEN, GamePegs.RED};
		GamePegs[] guess1 = {GamePegs.ORANGE, GamePegs.ORANGE, GamePegs.ORANGE, GamePegs.ORANGE};
		game.setGameCode(gameCode);
		game.makeGuess(guess1);
		assertArrayEquals(new int [] {0, 0}, game.getHints()[game.getNumGuesses() - 1]);
		
	}
	
	@Test
	void testKeys4() {
		Game game = new Game();
		GamePegs[] gameCode = {GamePegs.RED, GamePegs.GREEN, GamePegs.GREEN, GamePegs.RED};
		GamePegs[] guess1 = {GamePegs.RED, GamePegs.RED, GamePegs.ORANGE, GamePegs.ORANGE};
		game.setGameCode(gameCode);
		game.makeGuess(guess1);
		assertArrayEquals(new int [] {1, 1}, game.getHints()[game.getNumGuesses() - 1]);
		
	}
	
	@Test
	void testKeys5() {
		Game game = new Game();
		GamePegs[] gameCode = {GamePegs.RED, GamePegs.GREEN, GamePegs.PURPLE, GamePegs.RED};
		GamePegs[] guess1 = {GamePegs.GREEN, GamePegs.BLUE, GamePegs.BLUE, GamePegs.GREEN};
		game.setGameCode(gameCode);
		game.makeGuess(guess1);
		assertArrayEquals(new int [] {0, 1}, game.getHints()[game.getNumGuesses() - 1]);
		
	}
	@Test
	void testKeys6() {
		Game game = new Game();
		GamePegs[] gameCode = {GamePegs.RED, GamePegs.BLUE, GamePegs.GREEN, GamePegs.YELLOW};
		GamePegs[] guess1 = {GamePegs.RED, GamePegs.RED, GamePegs.ORANGE, GamePegs.ORANGE};
		game.setGameCode(gameCode);
		game.makeGuess(guess1);
		assertArrayEquals(new int [] {1, 0}, game.getHints()[game.getNumGuesses() - 1]);
		
	}
	
	
	
	
}

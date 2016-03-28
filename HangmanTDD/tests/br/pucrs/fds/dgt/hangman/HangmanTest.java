package br.pucrs.fds.dgt.hangman;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.pucrs.fds.dgt.hangman.Engine.Hangman;
import br.pucrs.fds.dgt.hangman.Engine.HangmanState;

public class HangmanTest {

    private Hangman game;

    @Before
    public void setUp() {
	game = new Hangman("hangman");
    }

    @Test
    public void testSecretIsHangman() {
	assertEquals("hangman", game.getSecret());
    }

    @Test
    public void testSecretIsMalandro() {
	Hangman game = new Hangman("malandro");
	assertEquals("malandro", game.getSecret());
    }

    @Test
    public void testGuessE() {
	game.setGuess('E');
	assertEquals("e", game.getMisses());
    }

    @Test
    public void testGuessEAndThenGuessT() {
	game.setGuess('E');
	game.setGuess('T');
	assertEquals("e,t", game.getMisses());
    }

    @Test
    public void testGuessEAndThenGuessTAndThenGuessA() {
	game.setGuess('E');
	game.setGuess('T');
	game.setGuess('A');
	assertEquals("e,t", game.getMisses());
    }

    @Test
    public void testGetWord() {
	assertEquals("-------", game.getWord());
    }

    @Test
    public void testGuessAAndThenGetWord() {
	game.setGuess('A');
	assertEquals("-a---a-", game.getWord());
    }

    @Test
    public void testGuessAAndThenGetWordAndThenGetWord() {
	game.setGuess('A');
	game.setGuess('H');
	assertEquals("ha---a-", game.getWord());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSecretIsNull() {
	new Hangman(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSecretIsEmpty() {
	new Hangman("");
    }

    @Test
    public void testTries() {
	game.setGuess('E');
	game.setGuess('I');
	game.setGuess('O');
	game.setGuess('R');
	game.setGuess('S');
	game.setGuess('T');
	assertEquals("e,i,o,r,s,t", game.getMisses());
	assertEquals(0, game.getTries());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGuessRepeatedLetterWrong() {
	game.setGuess('E');
	game.setGuess('E');
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGuessRepeatedLetterGood() {
	game.setGuess('H');
	game.setGuess('H');
    }
    
    @Test(expected = IllegalStateException.class)
    public void testWinGameAndThenGuess() {
	game.setGuess('H');
	game.setGuess('A');
	game.setGuess('G');
	game.setGuess('N');
	game.setGuess('M');
	game.setGuess('K');

    }

    @Test(expected = IllegalStateException.class)
    public void testGuessWord() {
	game.setGuessWord("hangman");
	game.setGuessWord("malandro");
    }

    @Test()
    public void testGuessWordWin() {
	Hangman game = new Hangman("hangman");
	game.setGuessWord("hangman");
	assertEquals(HangmanState.WIN, game.getState());
	assertEquals(1, game.getWins());
    }

    @Test()
    public void testGuessWordLose() {
	Hangman game = new Hangman("hangman");
	game.setGuessWord("malandro");
	assertEquals(HangmanState.LOSE, game.getState());
	assertEquals(1, game.getLoses());
    }

    @Test
    public void testGuessOnGame() {
	game.setGuess('A');
	assertTrue(game.onGame());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGuessWordIsNull() {
	game.setGuessWord(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGuessIsEmpty() {
	game.setGuessWord("");
    }

    @Test
    public void testResetGame() {
	game.resetHangman("malandro");
	assertEquals("malandro", game.getSecret());
	assertEquals("--------", game.getWord());
	assertEquals(6, game.getTries());
	assertEquals("", game.getMisses());
	assertTrue(game.onGame());
    }
    @Test
    public void testWinGame() {
	game.setGuess('H');
	game.setGuess('A');
	game.setGuess('G');
	game.setGuess('N');
	game.setGuess('M');
	assertEquals(HangmanState.WIN, game.getState());;
    }
}

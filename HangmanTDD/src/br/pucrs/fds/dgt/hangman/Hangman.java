
package br.pucrs.fds.dgt.hangman;

import br.pucrs.fds.dgt.hangman.Utils.StringUtils;

/**
 * @author Homero Oliveira
 * 
 *
 */
public class Hangman {

    private String secret;
    private String misses;
    private String word;
    private HangmanState state;
    private int tries;
    private int wins;
    private int loses;

    public Hangman(String secret) {
	create(secret);
    }

    private void create(String secret) {
	StringUtils.nonNullOrEmpty(secret);
	this.secret = secret;
	misses = "";
	word = "";
	initWord(secret);
	tries = 6;
	state = HangmanState.GAMEON;
    }

    /**
     * Cria a representação da variavel secret exemplo: hangman == -------
     * 
     * @param secret
     */
    private void initWord(String secret) {
	for (int i = 0; i < secret.length(); i++) {
	    word += "-";
	}
    }

    private void checkState() {
	if (word.equalsIgnoreCase(secret)) {
	    state = HangmanState.WIN;
	} else if (tries == 0) {
	    state = HangmanState.LOSE;
	}
    }

    private void notOnGame() {
	if (!(onGame())) {
	    throw new IllegalStateException("O jogo já acabou.");
	}
    }

    /**
     * @param guess
     * @throws IllegalStateException
     *             Se a pessoa ganhou ou perdeu e tentar colocar um letra
     * @throws IllegalArgumentException
     *             Se a letra já foi digitada
     */
    public void setGuess(char guess) {
	char guessLowerCase = Character.toLowerCase(guess);

	if (misses.contains(Character.toString(guessLowerCase)) || word.contains(Character.toString(guessLowerCase))) {
	    throw new IllegalArgumentException("A letra já foi digitada");
	}

	notOnGame();

	if (!secret.contains(String.valueOf(guessLowerCase))) {
	    wrongGuess(guessLowerCase);
	} else {
	    goodGuess(guessLowerCase);
	}
	checkState();
    }

    private void goodGuess(char guessToLowerCase) {
	String newWord = "";
	for (int i = 0; i < secret.length(); i++) {
	    if (secret.charAt(i) == guessToLowerCase) {
		newWord += guessToLowerCase;
	    } else
		newWord += word.charAt(i);
	}
	word = newWord;
    }

    private void wrongGuess(char guessToLowerCase) {
	if (!misses.isEmpty())
	    misses += ",";
	misses += guessToLowerCase;
	tries--;
    }

    /**
     * Chutar a palavra se tiver errada perde o jogo, caso contrario ganha o
     * jogo
     * 
     * @param word
     */
    public void setGuessWord(String word) {
	StringUtils.nonNullOrEmpty(word);// Verifica se word é nula ou vazia
	notOnGame();// Verifica se o estado não é GAMEON

	if (word.equalsIgnoreCase(secret)) {
	    this.word = word;
	    state = HangmanState.WIN;
	    wins++;
	} else {
	    tries = 0;
	    state = HangmanState.LOSE;
	    loses++;
	}

    }

    /**
     * Recomeça o jogo com outra palavra, mantendo wins e loses
     * 
     * @param word
     */
    public void resetHangman(String newSecret) {
	create(newSecret);
    }

    /**
     * @return Se o objeto está em GAMEON.
     */
    public boolean onGame() {
	return state == HangmanState.GAMEON;
    }

    /**
     * @return secret
     */
    public String getSecret() {
	return secret;
    }

    /**
     * @return misses
     */
    public String getMisses() {

	return misses;
    }

    /**
     * @return word
     */
    public String getWord() {
	return word;
    }

    /**
     * @return tries
     */
    public int getTries() {
	return tries;
    }

    /**
     * @return state
     */
    public HangmanState getState() {
	return state;
    }

    /**
     * @return wins
     */
    public int getWins() {
	return wins;
    }

    /**
     * @return loses
     */
    public int getLoses() {
	return loses;
    }

}

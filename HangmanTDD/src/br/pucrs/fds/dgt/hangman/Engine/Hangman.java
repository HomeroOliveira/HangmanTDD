
package br.pucrs.fds.dgt.hangman.Engine;

import br.pucrs.fds.dgt.hangman.Utils.StringUtils;

/**
 * @author Homero Oliveira
 * 
 */
public class Hangman {

	private String secret;
	private StringBuilder misses;
	private StringBuilder word;
	private HangmanState state;
	private int tries;
	private int wins;
	private int loses;

	public Hangman(String secret) {
		initHangman(secret);
	}

	private void initHangman(String secret) {
		StringUtils.nonNullOrEmpty(secret);
		this.secret = secret;
		misses = new StringBuilder();
		word = new StringBuilder(secret.length());
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
			word.append("-");
		}
	}

	private void checkState() {
		if (getWord().equalsIgnoreCase(secret)) {
			state = HangmanState.WIN;
		} else if (tries == 0) {
			state = HangmanState.LOSE;
		}
	}

	private void isNotOnGame() {
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
		String guessString = Character.toString(guessLowerCase);

		if (getWord().contains(guessString) || getMisses().contains(guessString)) {
			throw new IllegalArgumentException("A letra já foi digitada");
		}

		isNotOnGame();

		if (!secret.contains(guessString)) {
			wrongGuess(guessLowerCase);
		} else {
			goodGuess(guessLowerCase);
		}
		
		checkState();
	}

	private void goodGuess(char guess) {
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess) {
				word.setCharAt(i, guess);
			}
		}

	}

	private void wrongGuess(char guess) {
		if (!getMisses().isEmpty()) {
			misses.append(",");
		}
		misses.append(guess);
		tries--;
	}

	/**
	 * Chuta a palavra se tiver errada perde o jogo, caso contrario ganha o jogo
	 * 
	 * @param word
	 * @throws IllegalArgumentException
	 *             Se a word for nula ou vazia
	 * @throws IllegalStateException
	 *             Se o jogador já perdeu ou ganho
	 */
	public void setGuessWord(String word) {
		StringUtils.nonNullOrEmpty(word);// Verifica se word é nula ou vazia
		isNotOnGame();// Verifica se o estado não é GAMEON

		if (word.equalsIgnoreCase(secret)) {
			this.word = new StringBuilder(word);
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
		initHangman(newSecret);
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

		return misses.toString();
	}

	/**
	 * @return word
	 */
	public String getWord() {
		return word.toString();
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

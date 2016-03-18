
package br.pucrs.fds.dgt.hangman;

/**
 * @author Homero Oliveira
 * @author
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
	checkNullOrEmpty(secret);
	this.secret = secret;
	misses = "";
	word = "";
	initWord(secret);
	tries = 6;
	state = HangmanState.GAMEON;
    }

    private void checkNullOrEmpty(String word) {
	if (word == null || word.isEmpty())
	    throw new IllegalArgumentException("A palavra não pode ser nula ou vazia!");
    }

    private void initWord(String secret) {
	for (int i = 0; i < secret.length(); i++) {
	    word += "-";
	}
    }

    public String getSecret() {
	return secret;
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

	if (misses.contains(Character.toString(guessLowerCase))||
		     word.contains(Character.toString(guessLowerCase))) {
	    throw new IllegalArgumentException("A letra já foi digitada");
	}

	checkNotOnGame();

	if (!secret.contains(String.valueOf(guessLowerCase))) {
	    wrongGuess(guessLowerCase);
	} else {
	    goodGuess(guessLowerCase);
	}
	checkState();
    }

    private void checkState() {
	if (isWin()) {
	    state = HangmanState.WIN;
	} else if (isLose()) {
	    state = HangmanState.LOSE;
	}
    }

    private boolean isWin() {
	return word.equalsIgnoreCase(secret);
    }

    private boolean isLose() {
	return tries == 0;
    }

    private void checkNotOnGame() {
	if (!(onGame())) {
	    throw new IllegalStateException("O jogo já acabou.");
	}
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

    public String getMisses() {

	return misses;
    }

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
     * Chutar a palavra se tiver errada perde o jogo, caso contrario ganha o
     * jogo
     * 
     * @param word
     */
    public void setGuessWord(String word) {
	checkNullOrEmpty(word);// Verifica se word é nula ou vazia
	checkNotOnGame();// Verifica se o estado  não é GAMEON 

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
	word = "";
	misses = "";
	tries = 6;
	initWord(newSecret);
	secret = newSecret;
	state = HangmanState.GAMEON;

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

    /**
     * @return Se o objeto está em GAMEON.
     */
    public boolean onGame() {
	return state == HangmanState.GAMEON;
    }
}

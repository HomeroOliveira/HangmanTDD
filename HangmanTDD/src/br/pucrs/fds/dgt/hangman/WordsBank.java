package br.pucrs.fds.dgt.hangman;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordsBank {

    private List<String> words;
    private Random rnd;
    private static final String EMPTY = "";

    public WordsBank() {
	words = new ArrayList<>();
	rnd = new Random();
    }

    /**
     * Se não tiver nenhuma palavra retorna uma string vazia
     * 
     * @return word
     */
    public String getWord() {
	if (!words.isEmpty()) {
	    Collections.shuffle(words, rnd);
	    return words.get(0);
	}
	return EMPTY;
    }

    public void setWords(List<String> words) {
	this.words = words;
    }

    public void setInputStream(InputStream in) throws IOException {
	try (Scanner scanner = new Scanner(in)) {
	    while (scanner.hasNextLine()) {
		words.add(scanner.nextLine());
	    }
	}

    }

    public void setInputStream(Path in) throws IOException {
	words = Files.readAllLines(in);
    }
}

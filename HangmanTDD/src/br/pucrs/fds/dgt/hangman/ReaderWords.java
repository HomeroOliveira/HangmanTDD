package br.pucrs.fds.dgt.hangman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class ReaderWords {
    
    private List<String> words;
    private Random rnd;
    
    public ReaderWords(Path filePath) {
	try {
	   words = Files.readAllLines(filePath);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	rnd = new Random();
    }
    
    public String getWord() {
	int index = rnd.nextInt(words.size());
	return words.get(index);
    }
}

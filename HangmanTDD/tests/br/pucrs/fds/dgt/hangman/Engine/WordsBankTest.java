package br.pucrs.fds.dgt.hangman.Engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class WordsBankTest {

    private WordsBank wb;
    private String pathRelativo;
    private Path pathAbsoluto;

    @Before
    public void setUp() throws Exception {
	wb = new WordsBank();
	pathRelativo = "br/pucrs/fds/dgt/hangman/Resource/test.txt";
	pathAbsoluto = Paths.get("bin//br//pucrs//fds//dgt//hangman//Resource//test.txt");

    }

    @Test
    public void testGetEmptyWordNoResorce() {
	assertEquals("", wb.getWord());
    }

    @Test
    public void testResource() throws Exception {
	InputStream in = ClassLoader.getSystemResourceAsStream(pathRelativo);
	wb.setInputStream(in);
	List<String> words = Arrays.asList("hangman", "game");
	assertTrue(words.contains(wb.getWord()));
    }

    @Test
    public void testPathResource() throws IOException {
	wb.setInputStream(pathAbsoluto);
	List<String> words = Arrays.asList("hangman", "game");
	assertTrue(words.contains(wb.getWord()));
    }

}

package br.pucrs.fds.dgt.hangman.Utils;

import java.util.Objects;

public class StringUtils {
    /**
     * Checa a string.
     * 
     * @param word
     * @throws IllegalArgumentException
     *             se o objeto � null ou se a string inicializada � com ""
     */
    public static void nonNullOrEmpty(String word) {
	if (Objects.isNull(word) || word.isEmpty())
	    throw new IllegalArgumentException("A palavra n�o pode ser nula ou vazia!");
    }
}

package br.pucrs.fds.dgt.hangman.Utils;

import java.util.Objects;

public class StringUtils {
    /**
     * Checa a string.
     * 
     * @param string
     * @throws IllegalArgumentException
     *             se o objeto é null ou se a string inicializada é com ""
     */
    public static void nonNullOrEmpty(String string) {
	if (Objects.isNull(string) || string.isEmpty())
	    throw new IllegalArgumentException("Não pode ser nula ou vazia!");
    }
}

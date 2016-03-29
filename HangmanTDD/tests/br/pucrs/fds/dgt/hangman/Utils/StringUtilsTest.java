package br.pucrs.fds.dgt.hangman.Utils;

import org.junit.Test;

public class StringUtilsTest {

    @Test(expected = IllegalArgumentException.class)
    public void testIsNull() {
	StringUtils.nonNullOrEmpty(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsEmpty() {
	StringUtils.nonNullOrEmpty("");
    }

}

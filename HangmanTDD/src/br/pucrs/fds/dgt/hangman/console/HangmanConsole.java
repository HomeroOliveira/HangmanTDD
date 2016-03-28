package br.pucrs.fds.dgt.hangman.Console;

import java.util.Scanner;

import br.pucrs.fds.dgt.hangman.Engine.Hangman;
import br.pucrs.fds.dgt.hangman.Engine.HangmanState;

public class HangmanConsole {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	menu();
    }

    private static void menu() {
	System.out.println("Aperte: \n1-Iniciar Jogo.\n2-Sair");
	int escolha = in.nextInt();
	if (escolha == 1) {
	    startHangman();
	} else {
	    System.exit(0);
	}
    }

    private static void startHangman() {
	Hangman game = new Hangman("hangman");
	System.out.println("\f#----Hangman----#");
	while (game.onGame()) {
	    System.out.println("Word: " + game.getWord());
	    System.out.print("Guess: ");
	    char guess = in.next().charAt(0);
	    try {
		game.setGuess(guess);
		System.out.println("Misses: " + game.getMisses());
		System.out.println("Tries: " + game.getTries() + "\n");
	    } catch (IllegalArgumentException ex) {
		System.out.println(ex.getMessage());
	    }
	}
	resultHagman(game);
    }

    private static void resultHagman(Hangman game) {
	if (game.getState() == HangmanState.WIN) {
	    System.out.println("Você Ganhou !!!");
	} else {
	    System.out.println("Você Perdeu !!!");
	}
    }

}

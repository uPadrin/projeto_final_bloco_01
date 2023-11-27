package ecommerce;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce.util.Cores;

public class Menu {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int op;

		while (true) {

			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_PURPLE_BOLD_BRIGHT);
			System.out.println("o---------------------------------------------------o");
			System.out.println("|                                                   |");
			System.out.println("|                  Pereira Games                    |");
			System.out.println("|                                                   |");
			System.out.println("o---------------------------------------------------o");
			System.out.println("|                                                   |");
			System.out.println("|           1 - Adicionar Produto                   |");
			System.out.println("|           2 - Listar todos os produtos            |");
			System.out.println("|           3 - Buscar Produto por ID               |");
			System.out.println("|           4 - Atualizar Produto                   |");
			System.out.println("|           5 - Apagar Produto                      |");
			System.out.println("|           0 - Sair                                |");
			System.out.println("|                                                   |");
			System.out.println("o---------------------------------------------------o");
			System.out.println("|            Entre com a opção desejada:            |");
			System.out.println("o---------------------------------------------------o" + Cores.TEXT_RESET);

			try {
				op = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores Inteiros");
				sc.nextLine();
				op = 9;
			}
			if (op == 0) {
				System.out
						.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "\nPereira Games Tudo sobre Game você encotra aqui!");
				sobre();
				System.exit(0);
			}
			switch (op) {
			case 1:

				System.out.println("Adicionar Produto\n\n");

				keyPress();
				break;
			case 2:

				System.out.println("Listar todos os produtos\n\n");

				keyPress();
				break;
			case 3:

				System.out.println("Buscar Produto por ID\n\n");

				keyPress();
				break;
			case 4:

				System.out.println("Atulizar Produto\n\n");

				keyPress();
				break;
			case 5:

				System.out.println("Apaga Produto\n\n");

				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
	}

	public static String tema = Cores.TEXT_PURPLE_BOLD_BRIGHT;

	public static void sobre() {
		System.out.println(tema);
		System.out.println("\no-------------------------------------------------------o");
		System.out.println("|Projeto Desenvolvido por:                              |");
		System.out.println("|Bryan S Vieira - bryan.vieira2013@gmail.com            |");
		System.out.println("|github.com/uPadrin                                     |");
		System.out.println("o-------------------------------------------------------o");
	}

	public static void keyPress() {
		try {
			System.out.println("\nPressione a tecla Enter para continaur...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla inválida!");
		}
	}

}

package ecommerce;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import ecommerce.Controller.ProdutoController;
import ecommerce.model.Console;
import ecommerce.model.Jogo;
import ecommerce.model.Produto;
import ecommerce.util.Cores;

public class Menu {

	static Scanner sc = new Scanner(System.in);
	static String tema = Cores.TEXT_YELLOW_BRIGHT;

	public static void main(String[] args) {

		int op, tipo, numero;
		String nome, genero, marca, data;
		float preco;

		ProdutoController produtos = new ProdutoController();
		Console cc1 = new Console(produtos.gerarNum(), "PS5", 2, 5000.00f, "2000", "Sony");
		produtos.cadastrar(cc1);
		
		while (true) {

			System.out.println(tema);
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
				System.out.println(tema + "\nPereira Games Tudo sobre Game você encotra aqui!");
				sobre();
				System.exit(0);
			}
			switch (op) {
			case 1:

				System.out.println("Adicionar Produto\n");

				System.out.println("Digite o nome do Produto: ");
				sc.skip("\\R");
				nome = sc.nextLine();

				System.out.println("Digite o tipo do Produto (1 - Jogo ou 2 - Console: ");
				tipo = sc.nextInt();

				System.out.println("Digite valor do Produto: ");
				preco = sc.nextFloat();

				System.out.println("Data de lançamento: ");
				sc.skip("\\R");
				data = sc.nextLine();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o gênero: ");
					genero = sc.nextLine();
					produtos.cadastrar(new Jogo(produtos.gerarNum(), nome, tipo, preco, data, genero));
				}
				case 2 -> {
					System.out.println("Digite o marca: ");
					marca = sc.nextLine();
					produtos.cadastrar(new Console(produtos.gerarNum(), nome, tipo, preco, data, marca));
				}
				}

				keyPress();
				break;
			case 2:

				System.out.println("Listar todos os produtos\n");
				produtos.listarTodas();
				
				keyPress();
				break;
			case 3:

				System.out.println("Buscar Produto por ID\n");

				System.out.println("Digite o ID do produto: ");
				numero = sc.nextInt();
				produtos.procurarPorNumero(numero);
				
				keyPress();
				break;
			case 4:

				System.out.println("Atulizar Produto\n");

				System.out.println("Digite o ID do produto: ");
				numero = sc.nextInt();
				
				Optional <Produto> produto = produtos.buscarColle(numero);
				
				if(produto.isPresent()) {
					
					System.out.println("Digite o nome do Produto: ");
					sc.skip("\\R");
					nome = sc.nextLine();

					System.out.println("Digite valor do Produto: ");
					preco = sc.nextFloat();

					System.out.println("Data de lançamento: ");
					sc.skip("\\R");
					data = sc.nextLine();
					
					tipo = produto.get().getTipo();
					
					switch (tipo) {
					
					case 1 -> {
						System.out.println("Digite o limita da conta");
						genero = sc.nextLine();
						produtos.atualizar(new Jogo(numero, nome, tipo, preco, data, genero));
					}
					case 2 -> {
						System.out.println("Digite o marca: ");
						marca = sc.nextLine();
						produtos.atualizar(new Console(numero, nome, tipo, preco, data, marca));
					}
					}
				} else
					System.out.println("A conta numero: " + produto.get() + " não foi encontrada");
				
			
				keyPress();
				break;
			case 5:

				System.out.println("Apaga Produto\n");
				
				System.out.println("Digite o ID do produto: ");
				numero = sc.nextInt();
				produtos.deletar(numero);
				
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
	}

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

package Menus;

import java.util.Scanner;

import Entidades.BancoCentral;

public class MenuAgencia {
	
	public static void menuAgencia(BancoCentral bancoCentral, Scanner scanner) {
		int opcaoMenuAgencias;
		System.out.println("\n----- MENU AGÊNCIAS ----\n");
		do {
			System.out.println("Escolha um campo que deseje acessar...");
			System.out.println("[1] -> Cadastrar Agencia");
			System.out.println("[2] -> Editar Agencia");
			System.out.println("[3] -> Excluir Agencia");
			System.out.println("[4] -> Pesquisar Agencia");
			System.out.println("[0] -> Voltar ao Menu Inicial");
			System.out.println("\nDigite um opção:");
			opcaoMenuAgencias = Integer.parseInt(scanner.nextLine());
			switch(opcaoMenuAgencias){
				case 0:
					System.out.println("\n	Voltando ao Menu Inicial...");
					break;
				case 1:
					bancoCentral.cadastrarAgencia();
					break;
				case 2:
					bancoCentral.editarAgencia();
					break;
				case 3:
					bancoCentral.deletarAgencia();
					break;
				case 4:
					bancoCentral.encontrarAgencia();
					break;
				default:
					System.out.println("opção invalida!!!");
					break;
			}
		} while(opcaoMenuAgencias != 0);
	}
}

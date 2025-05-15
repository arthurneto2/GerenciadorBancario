package Menus;

import java.util.Scanner;

import Entidades.BancoCentral;
import Gerenciadores.GerenciadorCorrente;

public class MenuCorrente {
	
	public static void menuCorrente(BancoCentral bancoCentral, Scanner scanner) {
		GerenciadorCorrente gerenciadorCorrente = new GerenciadorCorrente(bancoCentral, scanner); 
		int opcaoMenuCorrente;
		System.out.println("\n----- MENU CONTAS ----\n");
		do {
			System.out.println("Escolha um campo que deseje acessar...");
			System.out.println("[1] -> Cadastrar Corrente");
			System.out.println("[2] -> Editar Corrente");
			System.out.println("[3] -> Excluir Corrente");
			System.out.println("[4] -> Pesquisar Corrente");
			System.out.println("[5] -> Sacar");
			System.out.println("[6] -> Depositar");
			System.out.println("[7] -> Ver Saldo");
			System.out.println("[0] -> Voltar ao Menu Inicial");
			System.out.println("\nDigite um opção:");
			opcaoMenuCorrente= Integer.parseInt(scanner.nextLine());
			switch(opcaoMenuCorrente){
				case 0:
					System.out.println("\n	Voltando ao Menu Inicial...");
					break;
				case 1:
					gerenciadorCorrente.cadastrarCorrente();
					break;
				case 2:
					gerenciadorCorrente.editarCorrente();
					break;
				case 3:
					gerenciadorCorrente.deleteCorrente();
					break;
				case 4:
					gerenciadorCorrente.encontrarCorrente();
					break;
				case 5:
					gerenciadorCorrente.sacarDinheiro();
					break;
				case 6:
					gerenciadorCorrente.depositarDinheiro();
					break;
				case 7:
					gerenciadorCorrente.saldo();
					break;
				default:
					System.out.println("opção invalida!!!");
					break;
			}
		} while(opcaoMenuCorrente!= 0);
	}
}

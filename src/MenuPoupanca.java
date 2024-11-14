import java.util.Scanner;

public class MenuPoupanca {
	public void menuPoupanca(BancoCentral bancoCentral, Scanner scanner) {
		GerenciadorPoupanca gerenciadorPoupanca = new GerenciadorPoupanca(bancoCentral, scanner); 
		int opcaoMenuPoupanca;
		System.out.println("\n----- MENU CONTAS ----\n");
		do {
			System.out.println("Escolha um campo que deseje acessar...");
			System.out.println("[1] -> Cadastrar Poupanca");
			System.out.println("[2] -> Editar Poupanca");
			System.out.println("[3] -> Excluir Poupanca");
			System.out.println("[4] -> Pesquisar Poupanca");
			System.out.println("[5] -> Sacar");
			System.out.println("[6] -> Depositar");
			System.out.println("[7] -> Ver Saldo");
			System.out.println("[0] -> Voltar ao Menu Inicial");
			System.out.println("\nDigite um opção:");
			opcaoMenuPoupanca= Integer.parseInt(scanner.nextLine());
			switch(opcaoMenuPoupanca){
				case 0:
					System.out.println("\n	Voltando ao Menu Inicial...");
					break;
				case 1:
					gerenciadorPoupanca.cadastrarPoupanca();
					break;
				case 2:
					gerenciadorPoupanca.editarPoupanca();
					break;
				case 3:
					gerenciadorPoupanca.deletePoupanca();
					break;
				case 4:
					gerenciadorPoupanca.encontrarPoupanca();
					break;
				case 5:
					gerenciadorPoupanca.sacarDinheiro();
					break;
				case 6:
					gerenciadorPoupanca.depositarDinheiro();
					break;
				case 7:
					gerenciadorPoupanca.saldo();
					break;
				default:
					System.out.println("opção invalida!!!");
					break;
			}
		} while(opcaoMenuPoupanca!= 0);
	}
}

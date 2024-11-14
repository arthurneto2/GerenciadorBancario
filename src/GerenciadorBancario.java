import java.util.Scanner;

public class GerenciadorBancario {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BancoCentral bancoCentral = new BancoCentral(scanner);
		MenuAgencia menuAgencia = new MenuAgencia();
		MenuFuncionario menuFuncionario = new MenuFuncionario();
		MenuCorrente menuCorrente = new MenuCorrente();
		MenuPoupanca menuPoupanca = new MenuPoupanca();
		MenuCliente menuClientes = new MenuCliente();
		System.out.println("\n### Gerenciador Bancario ###\n");
		System.out.println("\n----- MENU INICIAL -----\n");
		int opcaoMenuInicia;
		do {
			System.out.println("Escolha um campo que deseje acessar...");
			System.out.println("[1] -> Agências");
			System.out.println("[2] -> Contas Correntes");
			System.out.println("[3] -> Contas Poupanças");
			System.out.println("[4] -> Funcionários");
			System.out.println("[5] -> Clientes");
			System.out.println("[0] -> SAIR");
			System.out.println("\nDigite um opção:");

			opcaoMenuInicia = Integer.parseInt(scanner.nextLine());
			switch (opcaoMenuInicia) {
			case 0:
				System.out.println("\nENCERRANDO PROGRAMA...");
				break;
			case 1:
				menuAgencia.menuAgencia(bancoCentral, scanner);
				break;
			case 2:
				menuCorrente.menuCorrente(bancoCentral, scanner);
				break;
			case 3:
				menuPoupanca.menuPoupanca(bancoCentral, scanner);
				break;
			case 4:
				menuFuncionario.menuFuncionario(bancoCentral, scanner);
				break;
			case 5:
				menuClientes.menuCliente(bancoCentral, scanner);
			default:
				System.out.println("Opção invalida!!!");
				break;
			}
		} while (opcaoMenuInicia != 0);
		scanner.close();
	}

}

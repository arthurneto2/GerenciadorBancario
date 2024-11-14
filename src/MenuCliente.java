import java.util.Scanner;

public class MenuCliente {
	public void menuCliente(BancoCentral bancoCentral, Scanner scanner) {
		GerenciadorClientes gerenciadorClientes = new GerenciadorClientes(bancoCentral, scanner); 
		int opcaoMenuClientes;
		System.out.println("\n----- MENU CLIENTE ----\n");
		do {
			System.out.println("Escolha um campo que deseje acessar...");
			System.out.println("[1] -> Cadastrar Cliente");
			System.out.println("[2] -> Editar Cliente");
			System.out.println("[3] -> Excluir Cliente");
			System.out.println("[4] -> Pesquisar Cliente");
			System.out.println("[0] -> Voltar ao Menu Inicial");
			System.out.println("\nDigite um opção:");
			opcaoMenuClientes = Integer.parseInt(scanner.nextLine());
			switch(opcaoMenuClientes){
				case 0:
					System.out.println("\n	Voltando ao Menu Inicial...");
					break;
				case 1:
					gerenciadorClientes.cadastrarCliente();
					break;
				case 2:
					gerenciadorClientes.editarCliente();;
					break;
				case 3:
					gerenciadorClientes.deleteCliente();
					break;
				case 4:
					gerenciadorClientes.encontrarCliente();;
					break;
				default:
					System.out.println("opção invalida!!!");
					break;
			}
		} while(opcaoMenuClientes != 0);
	}
}

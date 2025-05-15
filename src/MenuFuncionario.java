import java.util.Scanner;

public class MenuFuncionario {
	public static void menuFuncionario(BancoCentral bancoCentral, Scanner scanner) {
		GerenciadorFuncionairos gerenciadorFuncionarios = new GerenciadorFuncionairos(bancoCentral, scanner); 
		int opcaoMenuFuncionarios;
		System.out.println("\n----- MENU FUNCIONÁRIOS ----\n");
		do {
			System.out.println("Escolha um campo que deseje acessar...");
			System.out.println("[1] -> Cadastrar Funcionário");
			System.out.println("[2] -> Editar Funcionário");
			System.out.println("[3] -> Excluir Funcionário");
			System.out.println("[4] -> Pesquisar Funcionário");
			System.out.println("[0] -> Voltar ao Menu Inicial");
			System.out.println("\nDigite um opção:");
			opcaoMenuFuncionarios = Integer.parseInt(scanner.nextLine());
			switch(opcaoMenuFuncionarios){
				case 0:
					System.out.println("\n	Voltando ao Menu Inicial...");
					break;
				case 1:
					gerenciadorFuncionarios.cadastrarFuncionario();
					break;
				case 2:
					gerenciadorFuncionarios.editarFuncionario();;
					break;
				case 3:
					gerenciadorFuncionarios.deleteFuncionario();
					break;
				case 4:
					gerenciadorFuncionarios.encontrarFuncionario();
					break;
				default:
					System.out.println("opção invalida!!!");
					break;
			}
		} while(opcaoMenuFuncionarios != 0);
	}
}

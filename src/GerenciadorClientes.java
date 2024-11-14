
import java.util.Scanner;

public class GerenciadorClientes {
	private BancoCentral bancoCentral;
	private Scanner scanner;

	public GerenciadorClientes(BancoCentral bancoCentral, Scanner scanner) {
		super();
		this.bancoCentral = bancoCentral;
		this.scanner = scanner;
	}

	public void cadastrarCliente() {
		System.out.println("\nPara cadastras um novo Cliente é necessário criar uma nova conta antes...\n");
	}

	public Cliente encontrarCliente() {
		String cpf;
		Agencia auxAgencia = bancoCentral.encontrarAgencia();
		do {
			System.out.println("Digite o CPF do cliente que deseja acessar:");
			cpf = scanner.nextLine();
			for (Corrente contaCorrente : auxAgencia.getCorrenteArray()) {
				if (contaCorrente.getCliente().getCpf().equals(cpf)) {
					visualizarCliente(contaCorrente.getCliente());
					return contaCorrente.getCliente();
				}
			}
			for (Poupanca contaPoupanca : auxAgencia.getPoupancaArray()) {
				if (contaPoupanca.getCliente().getCpf().equals(cpf)) {
					visualizarCliente(contaPoupanca.getCliente());
					return contaPoupanca.getCliente();
				}
				System.out.println("\nFuncionario não encontrado...\n");
			}
		} while (true);

	}

	public void editarCliente() {
		int opcao;
		System.out.println("\n----- EDITAR CLIENTE -----\n");
		Cliente cliente = this.encontrarCliente();
		System.out.println(cliente.toString());
		do {
			System.out.println("\nEscolha uma das opções que deseja editar...");
			System.out.println("[1] -> Editar CPF");
			System.out.println("[2] -> Editar Nome");
			System.out.println("[3] -> Editar Cidade");
			System.out.println("[4] -> Editar Estado");
			System.out.println("[5] -> Editar Rua");
			System.out.println("[6] -> Editar Bairro");
			System.out.println("[7] -> Editar RG");
			System.out.println("[8] -> Editar senha");
			System.out.println("[0] -> SAIR");
			System.out.println("\nDigite um opção:");
			opcao = Integer.parseInt(scanner.nextLine());
			switch (opcao) {
			case 0:
				System.out.println("\nVoltando ao MENU CLIENTES...");
				break;
			case 1:
				System.out.println("\nDigite o novo CPF:");
				cliente.setCpf(scanner.nextLine());
				System.out.println("\nCPF atualizado com sucesso...");
				break;
			case 2:
				System.out.println("\nDigite o novo Nome:");
				cliente.setNome(scanner.nextLine());
				System.out.println("\nNome atualizado com sucesso...");
				break;
			case 3:
				System.out.println("\nDigite a nova Cidade:");
				cliente.getEndereco().setCidade(scanner.nextLine());
				System.out.println("\nCidade atualizado com sucesso...");
				break;
			case 4:
				System.out.println("\nDigite o novo Estado:");
				cliente.getEndereco().setEstado(scanner.nextLine());
				System.out.println("\nEstado atualizado com sucesso...");
				break;
			case 5:
				System.out.println("\nDigite a nova Rua:");
				cliente.getEndereco().setRua(scanner.nextLine());
				System.out.println("\nRua atualizado com sucesso...");
				break;
			case 6:
				System.out.println("\nDigite o novo Bairro:");
				cliente.getEndereco().setBairro(scanner.nextLine());
				System.out.println("\nBairro atualizado com sucesso...");
				break;
			case 7:
				System.out.println("\nDigite o novo RG:");
				cliente.setRg(scanner.nextLine());
				System.out.println("\nBairro atualizado com sucesso...");
				break;
			case 8:
				System.out.println("\nDigite a nova senha:");
				cliente.setSenha(scanner.nextLine());
				System.out.println("\nSenha atualizada com sucesso...");
				break;
			default:
				System.out.println("\nOpção invalida!!!");
				break;
			}
		} while (opcao != 0);
	}

	public void deleteCliente() {
		System.out.println("Para excluir um cliente é necessario que exclua a sua conta...");
	}

	public void visualizarCliente(Cliente auxCliente) {
		System.out.println("\n" + auxCliente.toString() + "\n");
	}
}

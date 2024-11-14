import java.util.Scanner;

public class GerenciadorCorrente {
	private BancoCentral bancoCentral;
	private Scanner scanner;

	public GerenciadorCorrente(BancoCentral bancoCentral, Scanner scanner) {
		this.bancoCentral = bancoCentral;
		this.scanner = scanner;
	}

	public void cadastrarCorrente() {
		if (this.bancoCentral.getAgenciaArray().size() > 0) {
			System.out.println("\n----- CADASTRO DE CONTAS -----\n");
			Agencia agencia = bancoCentral.encontrarAgencia();
			Cliente cliente = new Cliente(scanner);
			Corrente novoCorrente = new Corrente(scanner, cliente, agencia);
			agencia.getCorrenteArray().add(novoCorrente);
		} else {
			System.out.println("Impossivel cadastrar Conta, seu banco ainda não possui nem uma agência...");
		}
	}

	public Corrente encontrarCorrente() {
		int IdNumero;
		Agencia agencia = bancoCentral.encontrarAgencia();
		do {
			System.out.println("Digite o ID da Conta Corrente que deseja acessar:");
			IdNumero = Integer.parseInt(scanner.nextLine());
			for (Corrente auxCorrente : agencia.getCorrenteArray()) {
				if (auxCorrente.getIdNumero() == IdNumero) {
					visualizarCorrente(auxCorrente);
					return auxCorrente;
				}
			}
			System.out.println("\nConta não encontrada!!!\n");
		} while (true);
	}

	public void editarCorrente() {
		int opcao;
		System.out.println("\n----- EDITAR CONTA CORRENTE -----\n");
		Corrente corrente = this.encontrarCorrente();
		System.out.println(corrente.toString());
		do {
			System.out.println("\nEscolha uma das opções que deseja editar...");
			System.out.println("[1] -> Editar ID");
			System.out.println("[2] -> Editar Agência");
			System.out.println("[0] -> SAIR");
			System.out.println("\nDigite um opção:");
			opcao = Integer.parseInt(scanner.nextLine());
			switch (opcao) {
			case 0:
				System.out.println("\nVoltando ao MENU CONTA...");
				break;
			case 1:
				System.out.println("\nDigite o novo ID:");
				corrente.setIdNumero(Integer.parseInt(scanner.nextLine()));
				System.out.println("\nID atualizado com sucesso...");
				break;
			case 2:
				Agencia agencia;
				for(Corrente auxCorrente : corrente.getAgencia().getCorrenteArray()) {
					if (auxCorrente == corrente) {
						corrente.getAgencia().getCorrenteArray().remove(corrente);
						break;
					}
				}
				System.out.println("\nAgora vamos procurar uma nova agência para sua Conta...\n");
				agencia = bancoCentral.encontrarAgencia();
				corrente.setAgencia(agencia);
				agencia.getCorrenteArray().add(corrente);
			default:
				System.out.println("\nOpção invalida!!!");
				break;
			}
		} while (opcao != 0);
	}

	public void deleteCorrente() {
		Corrente corrente = encontrarCorrente();
		for (Corrente auxCorrente : corrente.getAgencia().getCorrenteArray()) {
			if (auxCorrente == corrente) {
				corrente.getAgencia().getCorrenteArray().remove(corrente);
				break;
			}
		}
		System.out.println("\nConta Corrente deletada com sucesso!!!\n");
	}

	public void visualizarCorrente(Corrente auxCorrente) {
		System.out.println("\n" + auxCorrente.toString() + "\n");
	}

	public void sacarDinheiro() {
		if (this.bancoCentral.getAgenciaArray().size() > 0) {
			String senha;
			Corrente corrente = encontrarCorrente();
			senha = scanner.nextLine();
			if (senha.equals(corrente.getCliente().getSenha())) {
				System.out.println("Digite a senha: ");
				corrente.sacar(scanner);
			} else {
				System.out.println("Senha invalida...");
			}
		} else {
			System.out.println("Seu banco ainda não possui nem uma agência cadastrada...");
		}
	}

	public void depositarDinheiro() {
		if (this.bancoCentral.getAgenciaArray().size() > 0) {
			Corrente corrente = encontrarCorrente();
			corrente.depositar(scanner);
		} else {
			System.out.println("Seu banco ainda não possui nem uma agência cadastrada...");
		}
	}

	public void saldo() {
		if (this.bancoCentral.getAgenciaArray().size() > 0) {
			String senha;
			Corrente corrente = encontrarCorrente();
			senha = scanner.nextLine();
			if (senha.equals(corrente.getCliente().getSenha())) {
				System.out.println("Digite a senha: ");
				corrente.visualizarSaldo();
			} else {
				System.out.println("Senha invalida...");
			}
		} else {
			System.out.println("Seu banco ainda não possui nem uma agência cadastrada...");
		}
	}

	public BancoCentral getBancoCentral() {
		return bancoCentral;
	}

	public void setBancoCentral(BancoCentral bancoCentral) {
		this.bancoCentral = bancoCentral;
	}

}

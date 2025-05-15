package Gerenciadores;
import java.util.Scanner;

import Entidades.Agencia;
import Entidades.BancoCentral;
import Entidades.Funcionario;

public class GerenciadorFuncionairos {
	private BancoCentral bancoCentral;
	private Scanner scanner;

	public GerenciadorFuncionairos(BancoCentral bancoCentral, Scanner scanner) {
		super();
		this.bancoCentral = bancoCentral;
		this.scanner = scanner;
	}

	public void cadastrarFuncionario() {
		if (this.bancoCentral.getAgenciaArray().size() > 0) {
			System.out.println("\n----- CADASTRO DE FUNCIONÁRIOS -----\n");
			Agencia agencia = bancoCentral.encontrarAgencia();
			Funcionario novoFuncionario = new Funcionario(scanner, agencia);
			agencia.getFuncuinariosArray().add(novoFuncionario);
		} else {
			System.out.println("Impossivel cadastrar funcionário, seu banco ainda não possui nem uma agência...");
		}
	}

	public Funcionario encontrarFuncionario() {
		String cpf;
		Agencia auxAgencia = bancoCentral.encontrarAgencia();
		do {
			System.out.println("Digite o CPF do funcionario que deseja acessar:");
			cpf = scanner.nextLine();
			for (Funcionario auxFuncionario : auxAgencia.getFuncuinariosArray()) {
				if (auxFuncionario.getCpf() == cpf) {
					visualizarFuncionário(auxFuncionario);
					return auxFuncionario;
				}
			}
			System.out.println("\nFuncionario não encontrado!!!\n");
		} while (true);
	}

	public void editarFuncionario() {
		int opcao;
		System.out.println("\n----- EDITAR FUNCIONÁRIO -----\n");
		Funcionario funcionario = this.encontrarFuncionario();
		System.out.println(funcionario.toString());
		do {
			System.out.println("\nEscolha uma das opções que deseja editar...");
			System.out.println("[1] -> Editar CPF");
			System.out.println("[2] -> Editar Nome");
			System.out.println("[3] -> Editar Cidade");
			System.out.println("[4] -> Editar Estado");
			System.out.println("[5] -> Editar Rua");
			System.out.println("[6] -> Editar Bairro");
			System.out.println("[7] -> Editar Função");
			System.out.println("[8] -> Editar Agência");
			System.out.println("[9] -> Editar RG");
			System.out.println("[0] -> SAIR");
			System.out.println("\nDigite um opção:");
			opcao = Integer.parseInt(scanner.nextLine());
			switch (opcao) {
			case 0:
				System.out.println("\nVoltando ao MENU FUNCIONARIOS...");
				break;
			case 1:
				System.out.println("\nDigite o novo CPF:");
				funcionario.setCpf(scanner.nextLine());
				System.out.println("\nCPF atualizado com sucesso...");
				break;
			case 2:
				System.out.println("\nDigite o novo Nome:");
				funcionario.setNome(scanner.nextLine());
				System.out.println("\nNome atualizado com sucesso...");
				break;
			case 3:
				System.out.println("\nDigite a nova Cidade:");
				funcionario.getEndereco().setCidade(scanner.nextLine());
				System.out.println("\nCidade atualizado com sucesso...");
				break;
			case 4:
				System.out.println("\nDigite o novo Estado:");
				funcionario.getEndereco().setEstado(scanner.nextLine());
				System.out.println("\nEstado atualizado com sucesso...");
				break;
			case 5:
				System.out.println("\nDigite a nova Rua:");
				funcionario.getEndereco().setRua(scanner.nextLine());
				System.out.println("\nRua atualizado com sucesso...");
				break;
			case 6:
				System.out.println("\nDigite o novo Bairro:");
				funcionario.getEndereco().setBairro(scanner.nextLine());
				System.out.println("\nBairro atualizado com sucesso...");
				break;
			case 7:
				System.out.println("\nDigite a nova Função:");
				funcionario.setFuncao(scanner.nextLine());
				System.out.println("\nFuncão atualizada com sucesso...");
				break;
			case 8:
				Agencia agencia;
				for (Funcionario auxFuncionario : funcionario.getAgencia().getFuncuinariosArray()) {
					if (auxFuncionario == funcionario) {
						funcionario.getAgencia().getFuncuinariosArray().remove(funcionario);
						break;
					}
				}
				System.out.println("\nAgora vamos procurar uma nova agência para seu funcionário...\n");
				agencia = bancoCentral.encontrarAgencia();
				funcionario.setAgencia(agencia);
				agencia.getFuncuinariosArray().add(funcionario);
			default:
				System.out.println("\nOpção invalida!!!");
				break;
			}
		} while (opcao != 0);
	}

	public void deleteFuncionario() {
		Funcionario funcionario = encontrarFuncionario();
		for (Funcionario auxFuncionario : funcionario.getAgencia().getFuncuinariosArray()) {
			if (auxFuncionario == funcionario) {
				funcionario.getAgencia().getFuncuinariosArray().remove(funcionario);
				break;
			}
		}
		System.out.println("\nFuncionario deletado com sucesso!!!\n");
	}

	public void visualizarFuncionário(Funcionario auxFuncionario) {
		System.out.println("\n" + auxFuncionario.toString() + "\n");
	}

	public BancoCentral getBancoCentral() {
		return bancoCentral;
	}

	public void setBancoCentral(BancoCentral bancoCentral) {
		this.bancoCentral = bancoCentral;
	}

}

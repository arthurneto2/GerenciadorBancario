package Gerenciadores;
import java.util.Scanner;

import Entidades.Agencia;
import Entidades.BancoCentral;
import Entidades.Cliente;
import Entidades.Poupanca;

public class GerenciadorPoupanca {
	private BancoCentral bancoCentral;
	private Scanner scanner;

	public GerenciadorPoupanca(BancoCentral bancoCentral, Scanner scanner) {
		this.bancoCentral = bancoCentral;
		this.scanner = scanner;
	}

	public void cadastrarPoupanca() {
		if (this.bancoCentral.getAgenciaArray().size() > 0) {
			System.out.println("\n----- CADASTRO DE CONTAS -----\n");
			Agencia agencia = bancoCentral.encontrarAgencia();
			Cliente cliente = new Cliente(scanner);
			Poupanca novoPoupanca = new Poupanca(scanner, cliente, agencia);
			agencia.getPoupancaArray().add(novoPoupanca);
		} else {
			System.out.println("Impossivel cadastrar Conta, seu banco ainda não possui nem uma agência...");
		}
	}

	public Poupanca encontrarPoupanca() {
		int IdNumero;
		Agencia agencia = bancoCentral.encontrarAgencia();
		do {
			System.out.println("Digite o ID da Conta Poupanca que deseja acessar:");
			IdNumero = Integer.parseInt(scanner.nextLine());
			for (Poupanca auxPoupanca : agencia.getPoupancaArray()) {
				if (auxPoupanca.getIdNumero() == IdNumero) {
					visualizarPoupanca(auxPoupanca);
					return auxPoupanca;
				}
			}
			System.out.println("\nConta não encontrada!!!\n");
		} while (true);
	}

	public void editarPoupanca() {
		int opcao;
		System.out.println("\n----- EDITAR CONTA POUPANÇA -----\n");
		Poupanca poupanca = this.encontrarPoupanca();
		System.out.println(poupanca.toString());
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
				poupanca.setIdNumero(Integer.parseInt(scanner.nextLine()));
				System.out.println("\nID atualizado com sucesso...");
				break;
			case 2:
				Agencia agencia;
				for (Poupanca auxPoupanca : poupanca.getAgencia().getPoupancaArray()) {
					if (auxPoupanca == poupanca) {
						poupanca.getAgencia().getPoupancaArray().remove(poupanca);
						break;
					}
				}
				System.out.println("\nAgora vamos procurar uma nova agência para sua Conta...\n");
				agencia = bancoCentral.encontrarAgencia();
				poupanca.setAgencia(agencia);
				agencia.getPoupancaArray().add(poupanca);
			default:
				System.out.println("\nOpção invalida!!!");
				break;
			}
		} while (opcao != 0);
	}

	public void deletePoupanca() {
		Poupanca poupanca = encontrarPoupanca();
		for (Poupanca auxPoupanca : poupanca.getAgencia().getPoupancaArray()) {
			if (poupanca == auxPoupanca) {
				poupanca.getAgencia().getPoupancaArray().remove(poupanca);
				break;
			}
		}
		System.out.println("\nConta Poupança deletada com sucesso!!!\n");
	}

	public void visualizarPoupanca(Poupanca auxPoupanca) {
		System.out.println("\n" + auxPoupanca.toString() + "\n");
	}

	public void sacarDinheiro() {
		if (this.bancoCentral.getAgenciaArray().size() > 0) {
			String senha;
			Poupanca poupanca = encontrarPoupanca();
			senha = scanner.nextLine();
			if (senha.equals(poupanca.getCliente().getSenha())) {
				System.out.println("Digite a senha: ");
				poupanca.sacar(scanner);
			} else {
				System.out.println("Senha invalida...");
			}
		} else {
			System.out.println("Seu banco ainda não possui nem uma agência cadastrada...");
		}
	}

	public void depositarDinheiro() {
		if (this.bancoCentral.getAgenciaArray().size() > 0) {
			Agencia agencia = bancoCentral.encontrarAgencia();
			if (agencia.getPoupancaArray().size() > 0) {
				Poupanca poupanca = encontrarPoupanca();
				poupanca.depositar(scanner);
			} else {
				System.out.println("Agência não possui contas cadastradas...");
			}
		} else {
			System.out.println("Seu banco ainda não possui nem uma agência cadastrada...");
		}
	}

	public void saldo() {
		if (this.bancoCentral.getAgenciaArray().size() > 0) {
			String senha;
			Poupanca poupanca = encontrarPoupanca();
			senha = scanner.nextLine();
			if (senha.equals(poupanca.getCliente().getSenha())) {
				System.out.println("Digite a senha: ");
				poupanca.visualizarSaldo();
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
import java.util.Scanner;
import java.util.ArrayList;

public class BancoCentral {
	private ArrayList<Agencia> agenciaArray;
	private Scanner scanner;

	public BancoCentral(Scanner scanner) {
		this.agenciaArray = new ArrayList<Agencia>();
		this.scanner = scanner;
	}

	public void cadastrarAgencia() {
		Agencia novaAgencia;
		Funcionario novoFuncionario;
		System.out.println("\n----- CADASTRO DE AGÊNCIAS -----\n");
		novaAgencia = new Agencia(this.scanner);
		agenciaArray.add(novaAgencia);
		System.out.println("\nAdicione um funcionário a sua agência!\n");
		novoFuncionario = new Funcionario(scanner, novaAgencia);
		novaAgencia.getFuncuinariosArray().add(novoFuncionario);
		System.out.println("\nAgência cadastradada com sucesso...\n");
	}

	public Agencia encontrarAgencia() {
		int codigo;
		do {
			System.out.println("Digite o código da agência que deseja acessar:");
			codigo = Integer.parseInt(scanner.nextLine());
			for (Agencia auxAgencia : agenciaArray) {
				if (auxAgencia.getCodigo() == codigo) {
					visualizarAgencias(auxAgencia);
					return auxAgencia;
				}
			}
			System.out.println("\nAgencia não encontrada!!!\n");
		} while (true);
	}

	public void editarAgencia() {
		int opcao;
		Agencia auxAgencia = null;
		System.out.println("\n----- EDITAR AGÊNCIA -----\n");
		auxAgencia = encontrarAgencia();
		if (auxAgencia != null) {
			System.out.println(auxAgencia.toString());
			do {
				System.out.println("\nEscolha uma das opções que deseja editar...");
				System.out.println("[1] -> Editar Codigo");
				System.out.println("[2] -> Editar Nome");
				System.out.println("[3] -> Editar Cidade");
				System.out.println("[4] -> Editar Estado");
				System.out.println("[5] -> Editar Rua");
				System.out.println("[6] -> Editar Bairro");
				System.out.println("[7] -> Editar CEP");
				System.out.println("[0] -> SAIR");
				System.out.println("\nDigite um opção:");
				opcao = Integer.parseInt(scanner.nextLine());
				switch (opcao) {
				case 0:
					System.out.println("\nVoltando ao MENU AGENCIAS...");
					break;
				case 1:
					System.out.println("\nDigite o novo Código:");
					auxAgencia.setCodigo(Integer.parseInt(scanner.nextLine()));
					System.out.println("\nCódigo atualizado com sucesso...");
					break;
				case 2:
					System.out.println("\nDigite o novo Nome:");
					auxAgencia.setNome(scanner.nextLine());
					System.out.println("\nNome atualizado com sucesso...");
					break;
				case 3:
					System.out.println("\nDigite a nova Cidade:");
					auxAgencia.getEndereco().setCidade(scanner.nextLine());
					System.out.println("\nCidade atualizado com sucesso...");
					break;
				case 4:
					System.out.println("\nDigite o novo Estado:");
					auxAgencia.getEndereco().setEstado(scanner.nextLine());
					System.out.println("\nEstado atualizado com sucesso...");
					break;
				case 5:
					System.out.println("\nDigite a nova Rua:");
					auxAgencia.getEndereco().setRua(scanner.nextLine());
					System.out.println("\nRua atualizado com sucesso...");
					break;
				case 6:
					System.out.println("\nDigite o novo Bairro:");
					auxAgencia.getEndereco().setBairro(scanner.nextLine());
					System.out.println("\nBairro atualizado com sucesso...");
					break;
				case 7:
					System.out.println("\nDigite o novo CEP:");
					auxAgencia.getEndereco().setCep(Integer.parseInt(scanner.nextLine()));
					System.out.println("\nCEP atualizado com sucesso...");
					break;
				default:
					System.out.println("\nOpção invalida!!!");
					break;
				}
			} while (opcao != 0);
		}
	}

	public void deletarAgencia() {
		Agencia agencia = encontrarAgencia();
		for (Agencia auxAgencia : agenciaArray) {
			if (auxAgencia == agencia) {
				agenciaArray.remove(agencia);
				break;
			}
		}
		System.out.println("\nAgencia deletada com sucesso!!!\n");
	}

	public void visualizarAgencias(Agencia auxAgencia) {
		System.out.println("\n" + auxAgencia.toString() + "\n");
	}

	public ArrayList<Agencia> getAgenciaArray() {
		return agenciaArray;
	}

	public void setAgenciaArray(ArrayList<Agencia> agenciaArray) {
		this.agenciaArray = agenciaArray;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
}

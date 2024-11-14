import java.util.Scanner;

public class Funcionario extends Associado{
	private String funcao;
	private Agencia agencia;
	
	
	public Funcionario(Scanner scanner, Agencia agencia) {
		super(scanner);
		System.out.println("Digite a função do funcionário:");
		this.funcao = scanner.nextLine();
		this.agencia = agencia;
	}
	
	@Override
	public String toString() {
		return "Funcionario:\n" + super.toString() + "\n Função: " + funcao + "\n Agencia:"
				+ agencia.getNome();
	}

	public String getFuncao() {
		return funcao;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}



	public Agencia getAgencia() {
		return agencia;
	}


	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	
}

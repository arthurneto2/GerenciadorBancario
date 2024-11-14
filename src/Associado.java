import java.util.Scanner;

public abstract class Associado {
	private String cpf;
	private String nome;
	private String rg;
	private Endereco endereco;
	
	public Associado(Scanner scanner) {
		System.out.println("Digite o CPF:");
		this.cpf = scanner.nextLine();
		System.out.println("Digite o Nome:");
		this.nome = scanner.nextLine();
		System.out.println("Digite o RG:");
		this.rg = scanner.nextLine();
		this.endereco = new Endereco(scanner);
	}
	
	@Override
	public String toString() {
		return " CPF: " + cpf + "\n Nome: " + nome + "\n RG: " + rg + endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}

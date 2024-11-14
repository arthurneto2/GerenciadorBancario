import java.util.Scanner;

public class Cliente extends Associado{	
	private String senha;
	
	
	public Cliente(Scanner scanner) {
		super(scanner);
		System.out.println("Digite a senha do cliente:");
		this.senha = scanner.nextLine();
	}
	
	@Override
	public String toString() {
		return "Cliente:\n"+ super.toString();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

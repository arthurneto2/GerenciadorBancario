import java.util.Scanner;

public class Endereco {
	private String cidade;
	private String estado;
	private String rua;
	private String bairro;
	private int cep;
	
	
	public Endereco(Scanner scanner) {
		System.out.println("Digite a cidade:");
		this.cidade = scanner.nextLine();
		System.out.println("Digite o estado:");
		this.estado = scanner.nextLine();
		System.out.println("Digite a rua:");
		this.rua = scanner.nextLine();
		System.out.println("Digite o bairro:");
		this.bairro = scanner.nextLine();
		System.out.println("Digite o CEP da agência:");
		this.cep = Integer.parseInt(scanner.nextLine());
	}
	
	
	@Override
	public String toString() {
		return "\n Cidade: " + cidade + "\n Estado: " + estado + "\n Rua: "
				+ rua + "\n Bairro: " + bairro + "\n CEP: " + cep;
	}


	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	
	
}

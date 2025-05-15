package Entidades;
import java.util.Scanner;
import java.util.ArrayList;

public class Agencia {
	private int codigo;
	private String nome;
	private Endereco endereco;
	private ArrayList<Corrente> correnteArray;
	private ArrayList<Poupanca> poupancaArray;
	private ArrayList<Funcionario> funcuinariosArray;
	
	public Agencia(Scanner scanner) {
		System.out.println("Digite o código da agência:");
		this.codigo = Integer.parseInt(scanner.nextLine());
		System.out.println("Digite o Nome da agência:");
		this.nome = scanner.nextLine();
		this.endereco = new Endereco(scanner);
		this.correnteArray = new ArrayList<Corrente>();
		this.poupancaArray = new ArrayList<Poupanca>();
		this.funcuinariosArray = new ArrayList<Funcionario>();
	}
	
	@Override
	public String toString() {
		return "Agencia:\n" + " Codigo: " + codigo + "\n Nome: " + nome + endereco + "\n Funcionario cadastrados: "
				+ funcuinariosArray.size() + "\n Contas correntes cadastradas: " + correnteArray.size() + "\n Contas poupanças cadastradas: " + poupancaArray.size();
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}		
	public ArrayList<Funcionario> getFuncuinariosArray() {
		return funcuinariosArray;
	}
	public void setFuncuinariosArray(ArrayList<Funcionario> funcuinariosArray) {
		this.funcuinariosArray = funcuinariosArray;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Corrente> getCorrenteArray() {
		return correnteArray;
	}
	public void setCorrenteArray(ArrayList<Corrente> correnteArray) {
		this.correnteArray = correnteArray;
	}
	public ArrayList<Poupanca> getPoupancaArray() {
		return poupancaArray;
	}
	public void setPoupancaArray(ArrayList<Poupanca> poupancaArray) {
		this.poupancaArray = poupancaArray;
	}
}

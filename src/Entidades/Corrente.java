package Entidades;
import java.util.Scanner;

public class Corrente extends Conta{
	private double taxa;
	private double limite;
	private double dataEmprestimo;
	
	public Corrente(Scanner scanner, Cliente cliente, Agencia agencia) {
		super(scanner, cliente, agencia);
	}
	public double getTaxa() {
		return taxa;
	}
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	public double getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(double dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
	
	
}

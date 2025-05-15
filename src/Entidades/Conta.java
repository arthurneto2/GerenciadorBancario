package Entidades;
import java.util.Scanner;

public abstract class Conta {
	private int idNumero;
	private Agencia agencia;
	private Cliente cliente;
	private double saldo;

	public Conta(Scanner scanner, Cliente cliente, Agencia agencia) {
		System.out.println("Digite o ID da conta");
		this.idNumero = Integer.parseInt(scanner.nextLine());
		this.agencia = agencia;
		this.cliente = cliente;
		this.saldo = 0;
	}

	@Override
	public String toString() {
		return "Conta:\n idNumero: " + idNumero + "\n Agencia: " + agencia.getNome() + "\n Cliente:"
				+ cliente.getNome();
	}

	public void sacar(Scanner scanner) {
		int valor;
		visualizarSaldo();
		System.out.println("Digite o valor que deseja sacar:");
		valor = Integer.parseInt(scanner.nextLine());
		if (valor <= this.saldo) {
			this.saldo -= valor;
			visualizarSaldo();
			System.out.println("\nValor sacado com sucesso!!!\n");
		} else {
			System.out.println("Valor de saque maior que o disponível...");
		}
	}

	public void depositar(Scanner scanner) {
		int valor;
		visualizarSaldo();
		System.out.println("Digite o valor que deseja depositar:");
		valor = Integer.parseInt(scanner.nextLine());
		this.saldo += valor;
		System.out.println("\nValor depositado com sucesso!!!\n");
		visualizarSaldo();
	}

	public void visualizarSaldo() {
		System.out.println("\nSALDO ATUAL: " + this.saldo + "\n");
	}

	public int getIdNumero() {
		return idNumero;
	}

	public void setIdNumero(int idNumero) {
		this.idNumero = idNumero;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}

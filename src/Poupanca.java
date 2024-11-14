import java.util.Date;
import java.util.Scanner;

public class Poupanca extends Conta{
	private Date aniversario;
	private double rendimento;
	public Poupanca(Scanner scanner, Cliente cliente, Agencia agencia) {
		super(scanner, cliente, agencia);
		// TODO Auto-generated constructor stub
	}
	public Date getAniversario() {
		return aniversario;
	}
	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}
	public double getRendimento() {
		return rendimento;
	}
	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}
	
}

import javax.swing.JOptionPane;
import lombok.*;

@Getter

public abstract class Conta implements IConta{
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected Banco banco;

	public Conta(Cliente cliente, Banco banco) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.banco = banco;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		this.saldo -= valor;		
	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;		
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	@Override
	public void verificarSaldo(double saldo) {
		if(this.getSaldo() < 0) {
			String[] options = new String[] {"Sim", "Não", "Cancelar"};
			int resposta = JOptionPane.showOptionDialog(null, 
					"Deseja encerrar a conta Ag." + this.getAgencia() + " Nº " + this.getNumero() + "?",
					"Sistema Informa", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, options, options[0]);
			
			switch(resposta) {
			case 0:
				System.out.println("Conta Agencia " + this.getAgencia() + 
						" Número: " + this.getNumero() +
						" foi encerrada por saldo negativo.");
			break;
			case 1:
				System.out.println("Conta entrou no especial.");
			break;
			default:
				System.out.println("Nada");
			break;
			}
		}		
	}

	protected void imprimirInfoComuns() {
		System.out.println(String.format("Banco: %s", this.banco.getNome()));
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Conta: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		verificarSaldo(this.getSaldo());
	}	
	
}


public interface IConta {

	void sacar(double valor);
	
	void depositar(double valor);
	
	public void transferir(double valor, Conta contaDestino);
	
	void imprimirExtrato();
	
	void verificarSaldo(double saldo);
	
}

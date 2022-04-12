
public class Main {

	public static void main(String[] args) {
		Cliente rodrigo = new Cliente();
		rodrigo.setNome("Rodrigo");
		
		Conta cc = new ContaCorrente(rodrigo);
		Conta cp = new ContaPoupanca(rodrigo);
		
		cc.depositar(200);
		cc.transferir(150, cp);

		cc.imprimirExtrato();
		cp.imprimirExtrato();
	}

}


public class Main {

	public static void main(String[] args) {
		Banco bancoBradesco = new Banco();
		bancoBradesco.setNome("Banco Bradesco");
		
		Banco bancoBrasil = new Banco();
		bancoBrasil.setNome("Banco do Brasil");
		
		Cliente rodrigo = new Cliente();
		rodrigo.setNome("Rodrigo");
		
		Conta cc = new ContaCorrente(rodrigo, bancoBradesco);
		Conta cp = new ContaPoupanca(rodrigo, bancoBrasil);
		
		cc.depositar(200);
		cc.transferir(150, cp);

		cc.imprimirExtrato();
		cp.imprimirExtrato();
		
		cc.transferir(100, cp);
		cc.imprimirExtrato();
		cp.imprimirExtrato();
		
		cp.sacar(300);
		cp.imprimirExtrato();
	}

}

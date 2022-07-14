package bancoDigital;

public class Main {
    public static void main(String[] args) {
        Cliente rafael = new Cliente();
        rafael.setNome("Rafael");

        Conta cc = new ContaCorrente(rafael);
        Conta cp = new ContaPoupanca(rafael);

        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }
}

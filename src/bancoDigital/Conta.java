package bancoDigital;

public abstract class Conta implements IConta{
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    private Cliente cliente;

    protected double limite;



    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.limite = 1000;
    }

    @Override
    public void sacar(double valor){
        if (this.podeSacar(valor)) {
            saldo -= valor;
        } else {
            System.out.println(String.format("O Valor %.2f passou o limite", valor));
        }
    }

    private Boolean podeSacar(Double valorASacar){
        Double valorDisponivelSaque = this.saldo + this.limite;
        return valorASacar <= valorDisponivelSaque;
    }

    @Override
    public void depositar(double valor){
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino){
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns(){
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));

    }

    public int getAgencia() {
        return agencia;
    }

    public double getLimite() {
        return limite;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}

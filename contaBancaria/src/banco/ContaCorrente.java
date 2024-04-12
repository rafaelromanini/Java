package banco;

public class ContaCorrente {
    private int numero;
    private double saldo;
    private Status status;
    private double limite;

    // Construtor da classe ContaCorrente
    public ContaCorrente(int numero, double saldo, Status status, double limite) {
        this.numero = numero;
        this.saldo = saldo;
        this.status = status;
        this.limite = limite;
    }

    // Método para realizar saque
    public boolean realizarSaque(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
            return false;
        } else if (valor <= saldo + limite || status == Status.ESPECIAL) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            return true;
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
            return false;
        }
    }

    // Método para depositar dinheiro
    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito.");
        } else {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        }
    }

    // Método para consultar saldo
    public double consultarSaldo() {
        return saldo;
    }

    // Método para verificar se a conta está usando o cheque especial
    public boolean verificarUsoChequeEspecial() {
        return saldo < 0;
    }
}

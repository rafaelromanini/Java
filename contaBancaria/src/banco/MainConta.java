package banco;

import java.util.Scanner;

public class MainConta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao banco Innova!");

        // Criando uma conta corrente com status normal e saldo zero
        ContaCorrente conta = new ContaCorrente(12345, 0.0, Status.NORMAL, 500.0);

        int opcao;
        do {
            // Exibindo o menu de opções
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Realizar saque");
            System.out.println("2. Depositar dinheiro");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Verificar uso do cheque especial");
            System.out.println("5. Sair");

            // Lendo a opção do usuário
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Opção para realizar saque
                    System.out.println("Digite o valor que deseja sacar:");
                    double valorSaque = scanner.nextDouble();
                    conta.realizarSaque(valorSaque);
                    break;
                case 2:
                    // Opção para depositar dinheiro
                    System.out.println("Digite o valor que deseja depositar:");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    // Opção para consultar saldo
                    System.out.println("Saldo atual: R$" + conta.consultarSaldo());
                    break;
                case 4:
                    // Opção para verificar uso do cheque especial
                    if (conta.verificarUsoChequeEspecial()) {
                        System.out.println("A conta está usando o cheque especial.");
                    } else {
                        System.out.println("A conta não está usando o cheque especial.");
                    }
                    break;
                case 5:
                    // Opção para sair do programa
                    System.out.println("Obrigado por utilizar nosso banco!");
                    break;
                default:
                    // Mensagem de opção inválida
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }
        } while (opcao != 5); // Repetir o loop até que o usuário escolha sair

        // Fechando o scanner
        scanner.close();

    }
}
import java.util.Scanner;

public class Banco {
    String nomeCliente;
    String tipoDeConta;
    Double saldoInicial;

    public void informacoes() {
        System.out.println("""
                ***************************************************
                Bem vindo ao seu banco pessoal.
                Dados iniciais do cliente
                
                Nome:           %s
                Tipo de conta:  %s
                Saldo inicial:  R$ %.2f
                ***************************************************
                """.formatted(nomeCliente, tipoDeConta, saldoInicial));
    }
    public void deposito() {
        System.out.println("Digite abaixo o valor a depositar.");

        Scanner leitor = new Scanner(System.in);
        double valorDeposito = leitor.nextDouble();

        if (valorDeposito > 0) {
            saldoInicial += valorDeposito;
            System.out.println("Deposito realizado!     Saldo atualizado: R$ %.2f".formatted(saldoInicial));
        } else if (valorDeposito == 0) {
            System.out.println("Entendi! não deseja depositar agora.");
        } else {
            System.out.println("Valor inválido! tente novamente.");
            deposito();
        }
    }
    public void saque() {
        System.out.println("Digite abaixo o valor do saque.");

        Scanner leitor = new Scanner(System.in);
        double valorSaque = leitor.nextDouble();

        if (valorSaque > 0 && valorSaque <= saldoInicial) {
            saldoInicial -= valorSaque;
            System.out.println("Saque realizado!     Saldo atualizado: R$ %.2f".formatted(saldoInicial));
        } else if (valorSaque > saldoInicial) {
            System.out.println("Valor inválido! o valor de saque é maior que o saldo disponível no momento.");
            saque();
        } else if (valorSaque == 0) {
            System.out.println("Entendi! não deseja sacar agora");
        } else {
            System.out.println("Valor inválido! tente novamente.");
            saque();
        }
    }

    public void operacao() {
        System.out.println("""
                
                Operações (digite uma das opções para continuar)
                1- Consultar saldo
                2- Depositar valor
                3- Sacar Valor
                4- Sair
                """);

        Scanner leitor = new Scanner(System.in);
        int opcao = leitor.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Saldo disponível: R$ %.2f \n".formatted(saldoInicial));
                operacao();
                break;
            case 2:
                deposito();
                operacao();
                break;
            case 3:
                saque();
                operacao();
                break;
            case 4:
                System.out.println("Sistema encerrado! Volte sempre.");
                break;
            default:
                System.out.println("Opção inválida! tente novamente.");
                operacao();
                break;
        }
    }
}

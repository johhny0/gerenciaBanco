package com.unopar.gerenciabanco;

import java.util.Scanner;

/**
 * @author Johhny
 */
public class GerenciaBanco {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ContaBancaria conta = carregarConta();

        conta.exibirDadosCliente();

        int opcao;
        do {
            exibirMenu();

            try {
                opcao = scanner.nextInt();

                movimentacao(opcao, conta);
            } catch (Exception e) {
                opcao = 4;
                System.out.println(e.getMessage());
            }

        } while (opcao != 4);
    }

    private static void movimentacao(int opcao, ContaBancaria conta) {
        switch (opcao) {
            case 1 ->
                conta.consultarSaldo();

            case 2 -> {
                System.out.print("Informe o valor do deposito: R$ ");
                double valorDeposito = scanner.nextDouble();
                conta.depositar(valorDeposito);
            }

            case 3 -> {
                System.out.print("Informe o valor do saque: R$ ");
                double valorSaque = scanner.nextDouble();
                conta.sacar(valorSaque);
            }

            case 4 -> {
                System.out.println("Obrigado por utilizar nosso sistema bancario!");
                System.out.println("Ate logo, " + conta.getNome() + "!");
            }

            default ->
                System.out.println("Opcao invalida! Tente novamente.");
        }
    }

    private static ContaBancaria carregarConta() {
        System.out.println(" ======================================== ");
        System.out.println(" ==== BEM-VINDO AO SISTEMA BANCARIO ==== ");
        System.out.println(" ======================================== ");

        System.out.print("Informe seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe seu sobrenome: ");
        String sobrenome = scanner.nextLine();

        System.out.print("Informe seu CPF: ");
        String cpf = scanner.nextLine();

        return new ContaBancaria(nome, sobrenome, cpf);
    }

    private static void exibirMenu() {
        System.out.println(" ======================================== ");
        System.out.println(" ================= MENU ================= ");
        System.out.println(" ======================================== ");
        System.out.println("1 - Consultar Saldo");
        System.out.println("2 - Realizar Deposito");
        System.out.println("3 - Realizar Saque");
        System.out.println("4 - Encerrar");
        System.out.print("Escolha uma opcao: ");
    }
}

package com.unopar.gerenciabanco;

/**
 * @author Johhny
 */
public class ContaBancaria {

    private final String nome;
    private final String sobrenome;
    private final String cpf;
    private double saldo;

    public ContaBancaria(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0.0;
    }

    public void consultarSaldo() {
        System.out.printf("Saldo atual: R$ %.2f\n", this.saldo);
    }

    public void depositar(Double valor) {
        if (valor != null && valor > 0) {
            this.saldo += valor;
            System.out.printf("Deposito de R$ %.2f realizado com sucesso!\n", valor);
            consultarSaldo();
        } else {
            System.out.println("Valor de deposito invalido!");
        }
    }

    public void sacar(Double valor) {
        if (valor != null && valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado com sucesso!\n", valor);
            consultarSaldo();
        } else if (valor == null || valor <= 0) {
            System.out.println("Valor de saque invalido!");
        } else {
            System.out.println("Saldo insuficiente para o saque!");
        }
    }

    public void exibirDadosCliente() {
        System.out.println("______________________________");
        System.out.println("Dados do Cliente:");
        System.out.println("Nome: " + this.nome + " " + this.sobrenome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("______________________________");

    }

    public String getNome() {
        return this.nome;
    }
}

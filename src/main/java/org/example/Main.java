package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        TipoCobertura cobertura = new TipoCobertura("Completa");

        Titular titular = new Titular("111.111.111-11", "João Silva",
                LocalDate.of(1985, 5, 10), cobertura);

        Dependente filho = new Dependente("222.222.222-22", "Pedro Silva",
                LocalDate.of(2005, 3, 15), cobertura);

        Aposentado aposentado = new Aposentado("333.333.333-33", "Maria Souza",
                LocalDate.of(1955, 8, 20), cobertura);

        titular.adicionarDependente(filho);

        System.out.println(titular.gerarResumoContrato());

        System.out.println("\nMensalidade Aposentado: R$ " +
                String.format("%.2f", aposentado.calcularMensalidade()));
    }
}
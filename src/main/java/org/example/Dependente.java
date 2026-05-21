package org.example;

import java.time.LocalDate;

public class Dependente extends Beneficiario implements CalcularMensalidade {

    public Dependente(String cpf, String nome, LocalDate dataDeNascimento, TipoCobertura tipoCobertura) {
        super(cpf, nome, dataDeNascimento, tipoCobertura);
    }

    @Override
    public double calcularMensalidade() {
        return calcularMensalidadeBase() * 0.70; // regra 5: 70% da faixa etária
    }
}
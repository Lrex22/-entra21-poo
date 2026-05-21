package org.example;

import java.time.LocalDate;

public class Aposentado extends Titular implements CalcularMensalidade {

    public Aposentado(String cpf, String nome, LocalDate dataDeNascimento, TipoCobertura tipoCobertura) {
        super(cpf, nome, dataDeNascimento, tipoCobertura);
    }

    @Override
    public double calcularMensalidade() {
        return calcularMensalidadeBase() * 0.80; // regra 3: 20% de desconto
    }
}

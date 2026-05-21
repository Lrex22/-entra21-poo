package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Titular extends Beneficiario implements CalcularMensalidade {
    private List<Dependente> dependentes = new ArrayList<>();

    public Titular(String cpf, String nome, LocalDate dataDeNascimento, TipoCobertura tipoCobertura) {
        super(cpf, nome, dataDeNascimento, tipoCobertura);
    }

    public void adicionarDependente(Dependente d) {
        if (dependentes.size() >= 3)
            throw new IllegalStateException("Limite de 3 dependentes atingido.");
        if (d.getIdade() > 24)
            throw new IllegalArgumentException("Dependente deve ter até 24 anos.");
        dependentes.add(d);
    }

    public List<Dependente> getDependentes() { return dependentes; }

    @Override
    public double calcularMensalidade() {
        return calcularMensalidadeBase();
    }

    public String gerarResumoContrato() {
        StringBuilder sb = new StringBuilder();
        sb.append("Titular: ").append(getNome()).append(" | CPF: ").append(getCpf()).append("\n");
        double total = calcularMensalidade();
        for (Dependente d : dependentes) {
            sb.append("Dependente: ").append(d.getNome())
                    .append(" | R$ ").append(String.format("%.2f", d.calcularMensalidade())).append("\n");
            total += d.calcularMensalidade();
        }
        sb.append("Total mensal: R$ ").append(String.format("%.2f", total));
        return sb.toString();
    }
}
package org.example;

import java.time.LocalDate;
import java.time.Period;

public abstract class Beneficiario {
    private final String cpf;
    private String nome;
    private LocalDate dataDeNascimento;
    private TipoCobertura tipoCobertura;


    public Beneficiario(String cpf, String nome, LocalDate dataDeNascimento, TipoCobertura tipoCobertura) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.tipoCobertura = tipoCobertura;
    }


    public int getIdade() {
        return Period.between(dataDeNascimento, LocalDate.now()).getYears();
    }

    public double calcularMensalidadeBase() {
        int idade = getIdade();
        if (idade <= 18) return 180.00;
        else if (idade <= 59) return 340.00;
        else return 620.00;
    }

    public boolean podeAcionarCobertura(String tipoAcionamento) {
        if (tipoAcionamento.equalsIgnoreCase("internacao")) {
            return false; // Dependente não pode; subclasses sobrescrevem
        }
        return true;
    }


    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public TipoCobertura getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(TipoCobertura tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }
}
    


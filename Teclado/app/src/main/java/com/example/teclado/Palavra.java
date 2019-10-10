package com.example.teclado;

public class Palavra {
    private int ocorrencia;
    private String palavra;

    public int getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(int ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public Palavra(String palavra, int ocorrencia) {
        this.ocorrencia = ocorrencia;
        this.palavra = palavra;
    }

    public Palavra(String palavra) {
        this.ocorrencia = 1;
        this.palavra = palavra;
    }

    public Palavra() {
    }
}

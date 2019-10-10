package com.example.teclado;

public class Teclado {
    private String atual;
    private String proximo;
    private String anterior;

    public Teclado(String atual, String proximo, String anterior) {
        this.atual = atual;
        this.proximo = proximo;
        this.anterior = anterior;
    }

    public String getAtual() {
        return atual;
    }

    public void setAtual(String atual) {
        this.atual = atual;
    }

    public String getProximo() {
        return proximo;
    }

    public void setProximo(String proximo) {
        this.proximo = proximo;
    }

    public String getAnterior() {
        return anterior;
    }

    public void setAnterior(String anterior) {
        this.anterior = anterior;
    }

    public Teclado() {
    }
}

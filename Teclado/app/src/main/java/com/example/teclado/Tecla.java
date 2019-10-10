package com.example.teclado;

import java.util.ArrayList;

public class Tecla {
    private ArrayList<Teclado> teclas;

    public Tecla() {
        teclas = new ArrayList<>();
        teclas.add(new Teclado("A", "B", "palavra4"));
        teclas.add(new Teclado("B", "C", "A"));
        teclas.add(new Teclado("C", "D", "B"));
        teclas.add(new Teclado("D", "E", "C"));
        teclas.add(new Teclado("E", "F", "D"));
        teclas.add(new Teclado("F", "G", "E"));
        teclas.add(new Teclado("G", "H", "F"));
        teclas.add(new Teclado("H", "I", "G"));
        teclas.add(new Teclado("I", "J", "H"));
        teclas.add(new Teclado("J", "K", "I"));
        teclas.add(new Teclado("K", "L", "J"));
        teclas.add(new Teclado("L", "M", "K"));
        teclas.add(new Teclado("M", "N", "L"));
        teclas.add(new Teclado("N", "O", "M"));
        teclas.add(new Teclado("O", "P", "N"));
        teclas.add(new Teclado("P", "Q", "O"));
        teclas.add(new Teclado("Q", "R", "P"));
        teclas.add(new Teclado("R", "S", "Q"));
        teclas.add(new Teclado("S", "T", "R"));
        teclas.add(new Teclado("T", "U", "S"));
        teclas.add(new Teclado("U", "V", "T"));
        teclas.add(new Teclado("V", "W", "U"));
        teclas.add(new Teclado("W", "X", "V"));
        teclas.add(new Teclado("X", "Y", "W"));
        teclas.add(new Teclado("Y", "Z", "X"));
        teclas.add(new Teclado("Z", "OK", "Y"));
        teclas.add(new Teclado("OK", "__", "Z"));
        teclas.add(new Teclado("__", "<", "OK"));
        teclas.add(new Teclado("<", "A", "__"));
        teclas.add(new Teclado("palavra1", "palavra2", "<"));
        teclas.add(new Teclado("palavra2", "palavra3", "palavra1"));
        teclas.add(new Teclado("palavra3", "palavra4", "palavra2"));
        teclas.add(new Teclado("palavra4", "A", "palavra3"));
    }

    public ArrayList<Teclado> getTeclas() {
        return teclas;
    }

    public void setTeclas(ArrayList<Teclado> teclas) {
        this.teclas = teclas;
    }
}

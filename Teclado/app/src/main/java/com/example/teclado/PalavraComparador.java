package com.example.teclado;

import java.util.Comparator;

public class PalavraComparador implements Comparator<Palavra> {
    public int compare(Palavra c1, Palavra c2){
        if(c1 == null || c2 == null)
            throw new ClassCastException("null");

        String  nome1 = c1.getPalavra(), nome2 = c2.getPalavra();
        return nome1.compareTo(nome2);
    }
}
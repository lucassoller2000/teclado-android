package com.example.teclado;

import java.util.Comparator;

class OcorrenciaComparator implements Comparator<Palavra> {
    public int compare(Palavra p1, Palavra p2){
        if(p1.getOcorrencia() > p2.getOcorrencia()) return -1;
        if(p1.getOcorrencia() < p2.getOcorrencia()) return 1;
        return 0;
    }
}
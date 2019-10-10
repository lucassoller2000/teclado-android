package com.example.teclado;

import android.content.Context;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Dicionario {
    private Context context;

    public Dicionario(Context context){
        this.context = context;
        criarDicionario();
    }

    public void gravar ( String data ) {
        try {
            FileOutputStream fOut = context.openFileOutput ( "arquivo.txt" , Context.MODE_PRIVATE ) ;
            OutputStreamWriter osw = new OutputStreamWriter ( fOut ) ;
            osw.append(data);
            osw.flush ( ) ;
            osw.close ( ) ;
        } catch ( Exception e ) {
            e.printStackTrace ( ) ;
        }
    }

    public void criarDicionario(){
        String palavras ="abacate;0#abacateiro;0#abacaxi;0#abafado;0#abandonar;0#abelha;0#" +
                "baba;0#baboseira;0#babuíno;0#bacalhau;0#bacana;0#bota;0#\n" +
                "cabana;0#cabeça;0#cabeleireiro;0#cabelo;0#cabide;0#cabo;0#\n" +
                "dicionario;0#dizer;0#dado;0#dia;0#duende;0#dois;0#" +
                "elefante;0#elegante;0#ele;0#educar;0#emergir;0#este;0#" +
                "faca;0#foca;0#figo;0#furadeira;0#ferro;0#feliz;0#" +
                "gato;0#gado;0#gelo;0#grilo;0#galinha;0#ganhar;0#" +
                "hoje;0#havaiano;0#helicoptero;0#hipopotamo;0#hino;0#habil;0#" +
                "igreja;0#ilha;0#iguana;0#indio;0#igual;0#isto;0#" +
                "jogo;0#jogador;0#jantar;0#jegue;0#juiz;0#jarra;0#";
        String textoLido = ler();
        if(textoLido.length() == 0){
            gravar(textoLido+palavras);
        }
    }

    public void aumentarOcorrencia ( String data ) {
            String [] textos = ler().split("#");
            String texto = "";
            for(String s : textos){
                String t = s;
                if(s.startsWith(data+";")){
                    String [] partes = t.split(";");
                    int ocorrencia = Integer.parseInt(partes[1])+1;
                    t = partes[0]+";"+ocorrencia;
                }
                texto = texto.concat(t).concat("#");
            }
            gravar(texto);
    }

    public String ler ( ) {
        StringBuffer datax = new StringBuffer();
        try {
            FileInputStream fIn = context.openFileInput ( "arquivo.txt" ) ;
            InputStreamReader isr = new InputStreamReader ( fIn ) ;
            BufferedReader buffreader = new BufferedReader ( isr ) ;

            String readString = buffreader.readLine ( ) ;
            while ( readString != null ) {
                datax.append(readString);
                readString = buffreader.readLine ( ) ;
            }

            isr.close ( ) ;
        } catch ( IOException ioe ) {
            ioe.printStackTrace ( ) ;
        }
        return datax.toString() ;
    }
}
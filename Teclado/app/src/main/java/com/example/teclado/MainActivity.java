package com.example.teclado;

import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private MultiAutoCompleteTextView actTexto;
    private TextView tvA;
    private TextView aux;
    private TextView tvApagar;
    private TextView tvEnter;
    private TextView tvEspaco;
    private TextView tvSelecionado;
    private ArrayList<Teclado> teclas;
    private ArrayList<TextView> textViews;
    private TextView tvProximo;
    private TextView tvAnterior;
    private Dicionario dicionario;
    private TextView tvPalavra1;
    private TextView tvPalavra2;
    private TextView tvPalavra3;
    private TextView tvPalavra4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.inicializaComponente();
        actTexto = findViewById(R.id.act_texto);
        actTexto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        actTexto.setThreshold(1);
        tvA.setBackgroundResource(R.drawable.border);

        SpaceTokenizer tokenizer = new SpaceTokenizer();

        this.actTexto.setTokenizer(tokenizer);

        tvProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvSelecionado.setBackgroundResource(R.drawable.textview);
                if(tvSelecionado.getId() == R.id.tv_apagar){
                    if(!tvPalavra1.getText().toString().equals("-")){
                        tvSelecionado = tvPalavra1;
                    }else{
                        tvSelecionado = tvA;
                    }
                }else if(tvSelecionado.getId() == R.id.tv_palavra1){
                    if(!tvPalavra2.getText().toString().equals("-")){
                        tvSelecionado = tvPalavra2;
                    }else{
                        tvSelecionado = tvA;
                    }
                }else if(tvSelecionado.getId() == R.id.tv_palavra2){
                    if(!tvPalavra3.getText().toString().equals("-")){
                        tvSelecionado = tvPalavra3;
                    }else{
                        tvSelecionado = tvA;
                    }
                }else if(tvSelecionado.getId() == R.id.tv_palavra3){
                    if(!tvPalavra4.getText().toString().equals("-")){
                        tvSelecionado = tvPalavra4;
                    }else{
                        tvSelecionado = tvA;
                    }
                }else if(tvSelecionado.getId() == R.id.tv_palavra4){
                    tvSelecionado = tvA;
                }else{
                    tvSelecionado = encontrarProximaLetra(true);
                }
                tvSelecionado.setBackgroundResource(R.drawable.border);
            }
        });

        tvAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvSelecionado.setBackgroundResource(R.drawable.textview);
                if(tvSelecionado.getId() == R.id.tv_a){
                    if(!tvPalavra4.getText().toString().equals("-")){
                        tvSelecionado = tvPalavra4;
                    }else{
                        if(!tvPalavra3.getText().toString().equals("-")){
                            tvSelecionado = tvPalavra3;
                        }else{
                            if(!tvPalavra2.getText().toString().equals("-")){
                                tvSelecionado = tvPalavra2;
                            }else{
                                if(!tvPalavra1.getText().toString().equals("-")){
                                    tvSelecionado = tvPalavra1;
                                }else{
                                    tvSelecionado = tvApagar;
                                }
                            }
                        }
                    }
                }
                else if(tvSelecionado.getId() == R.id.tv_palavra4){
                    if(!tvPalavra3.getText().toString().equals("-")){
                        tvSelecionado = tvPalavra3;
                    }else{
                        tvSelecionado = tvApagar;
                    }
                }else if(tvSelecionado.getId() == R.id.tv_palavra3){
                    if(!tvPalavra2.getText().toString().equals("-")){
                        tvSelecionado = tvPalavra2;
                    }else{
                        tvSelecionado = tvApagar;
                    }
                }else if(tvSelecionado.getId() == R.id.tv_palavra2){
                    if(!tvPalavra1.getText().toString().equals("-")){
                        tvSelecionado = tvPalavra1;
                    }else{
                        tvSelecionado = tvApagar;
                    }
                }else if(tvSelecionado.getId() == R.id.tv_palavra1){
                    tvSelecionado = tvApagar;
                }else{
                    tvSelecionado = encontrarProximaLetra(false);
                }
                tvSelecionado.setBackgroundResource(R.drawable.border);
            }
        });

        for(final TextView t : textViews){
            t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(t.getId() == R.id.tv_palavra1 || t.getId() == R.id.tv_palavra2 || t.getId() == R.id.tv_palavra3 || t.getId() == R.id.tv_palavra4){
                        if(!t.getText().toString().equals("-")) {
                            String texto = t.getText().toString();
                            String[] palavrasDicionario = dicionario.ler().split("#");
                            for (String s : palavrasDicionario) {
                                String[] partes = s.split(";");
                                if (partes[0].equals(texto)) {
                                    dicionario.aumentarOcorrencia(partes[0]);
                                    break;
                                }
                            }
                            String textoInput = actTexto.getText().toString();
                            String[] textoSplit = textoInput.split(" ");
                            String ultimo = textoSplit[textoSplit.length - 1];
                            String substring = textoInput.substring(0, textoInput.length() - ultimo.length());
                            texto = substring + texto + " ";
                            adicionarTexto(texto);
                            tvSelecionado.setBackgroundResource(R.drawable.textview);
                            tvSelecionado = tvA;
                            tvSelecionado.setBackgroundResource(R.drawable.border);
                        }

                    }else{
                        String texto = actTexto.getText().toString() + t.getText().toString().toLowerCase();
                        adicionarTexto(texto);
                    }
                }
            });
        }

        tvApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apagarLetra();
            }
        });

        tvEspaco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actTexto.clearFocus();
                inserirEspaco();
                actTexto.requestFocus(1);
            }
        });

        tvEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoTecla = tvSelecionado.getText().toString();
                if(!textoTecla.equals("OK")){
                    if(textoTecla.equals("__")){
                        actTexto.clearFocus();
                        inserirEspaco();
                        actTexto.requestFocus(1);
                    }else if (textoTecla.equals("<")){
                        apagarLetra();
                    }else if (tvSelecionado.getId() == tvPalavra1.getId() || tvSelecionado.getId() == tvPalavra2.getId() || tvSelecionado.getId() == tvPalavra3.getId() || tvSelecionado.getId() == tvPalavra4.getId()){
                        if(!textoTecla.equals("-")) {
                            String textoInput = actTexto.getText().toString();
                            String[] textoSplit = textoInput.split(" ");
                            String ultimo = textoSplit[textoSplit.length - 1];
                            String substring = textoInput.substring(0, textoInput.length() - ultimo.length());
                            dicionario.aumentarOcorrencia(textoTecla);
                            textoTecla = substring + textoTecla + " ";
                            adicionarTexto(textoTecla);
                            tvSelecionado.setBackgroundResource(R.drawable.textview);
                            tvSelecionado = tvA;
                            tvSelecionado.setBackgroundResource(R.drawable.border);
                        }
                    }else{
                        String texto = actTexto.getText().toString() + tvSelecionado.getText().toString().toLowerCase();
                        adicionarTexto(texto);
                    }
                }
            }
        });
    }

    public void adicionarTexto(String texto){
        String [] textos = texto.split(" ");
        String ultimo = "";
        if(textos.length > 0){
            ultimo = textos[textos.length-1];
        }

        ArrayList<Palavra> palavras = new ArrayList<>();
        ArrayList<String> palavrasOrganizadas = new ArrayList<>();
        boolean mostrar = false;
        String [] palavrasDicionario = dicionario.ler().split("#");

        for(String s : palavrasDicionario){
            String [] partes = s.split(";");
            if(partes[0].startsWith(ultimo)){
                palavras.add(new Palavra(partes[0], Integer.parseInt(partes[1])));
                mostrar = true;
            }
        }

        Collections.sort(palavras, new PalavraComparador());
        Collections.sort(palavras, new OcorrenciaComparator());

        for(Palavra p : palavras) {
            palavrasOrganizadas.add(p.getPalavra());
            if (palavrasOrganizadas.size() == 4) {
                break;
            }
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, palavrasOrganizadas);
        actTexto.clearFocus();
        actTexto.setAdapter(arrayAdapter);
        actTexto.setText(texto);
        actTexto.requestFocus(1);
        tvPalavra1.setText("-");
        tvPalavra2.setText("-");
        tvPalavra3.setText("-");
        tvPalavra4.setText("-");
        if(mostrar && !texto.endsWith(" ") && texto.length()>0){
            if(palavrasOrganizadas.size()> 0){
                tvSelecionado.setBackgroundResource(R.drawable.textview);
                tvSelecionado = tvPalavra1;
                tvSelecionado.setBackgroundResource(R.drawable.border);
                tvPalavra1.setText(palavrasOrganizadas.get(0));
                if(palavrasOrganizadas.size() > 1) {
                    tvPalavra2.setText(palavrasOrganizadas.get(1));
                    if(palavrasOrganizadas.size() > 2){
                        tvPalavra3.setText(palavrasOrganizadas.get(2));
                        if(palavrasOrganizadas.size() > 3){
                            tvPalavra4.setText(palavrasOrganizadas.get(3));

                        }
                    }

                }
            }

        }
    }

    public TextView encontrarProximaLetra(boolean proxima){
        for(Teclado t: teclas){
            String letra;
            if(proxima){
                letra = t.getProximo();
            }else{
                letra = t.getAnterior();
            }
            if(t.getAtual().equals(tvSelecionado.getText().toString())){
                return encontrarProximaTecla(letra);
            }
        }
        return  null;
    }

    public TextView encontrarProximaTecla(String letra){
        for(TextView t: textViews){
            if(t.getText().toString().equals(letra)){
                return  t;
            }
        }
        return  null;
    }

    public void apagarLetra(){
        String texto = actTexto.getText().toString();
        if(texto.length() > 0){
            texto = texto.substring(0, texto.length()-1);
            adicionarTexto(texto);
        }
    }

    public void inserirEspaco(){
        String texto = actTexto.getText().toString();
        texto = texto + " ";
        actTexto.setText(texto);
        String [] textos = actTexto.getText().toString().split(" ");
        boolean presente = false;
        if(!actTexto.getText().toString().equals(" ") && !actTexto.getText().toString().endsWith("  ")) {
            String ultimo = textos[textos.length - 1];
            String [] palavrasDicionario = dicionario.ler().split("#");
            for(String s : palavrasDicionario){
                String [] partes = s.split(";");
                if(partes[0].equals(ultimo)){
                    presente = true;
                    dicionario.aumentarOcorrencia(partes[0]);
                    break;
                }
            }
            if(!presente){
                dicionario.gravar(dicionario.ler()+ultimo+";1#");
            }
        }

        tvPalavra1.setText("-");
        tvPalavra2.setText("-");
        tvPalavra3.setText("-");
        tvPalavra4.setText("-");
    }

    private void inicializaComponente() {
        this.actTexto = findViewById(R.id.act_texto);
        this.tvProximo = findViewById(R.id.tv_proximo);
        this.tvAnterior = findViewById(R.id.tv_anterior);
        this.dicionario = new Dicionario(getApplicationContext());
        this.teclas = new Tecla().getTeclas();

        textViews = new ArrayList<>();
        textViews.add(tvA = findViewById(R.id.tv_a));
        textViews.add(aux = findViewById(R.id.tv_b));
        textViews.add(aux = findViewById(R.id.tv_c));
        textViews.add(aux = findViewById(R.id.tv_d));
        textViews.add(aux = findViewById(R.id.tv_e));
        textViews.add(aux = findViewById(R.id.tv_f));
        textViews.add(aux = findViewById(R.id.tv_g));
        textViews.add(aux = findViewById(R.id.tv_h));
        textViews.add(aux = findViewById(R.id.tv_i));
        textViews.add(aux = findViewById(R.id.tv_j));
        textViews.add(aux = findViewById(R.id.tv_k));
        textViews.add(aux = findViewById(R.id.tv_l));
        textViews.add(aux = findViewById(R.id.tv_m));
        textViews.add(aux = findViewById(R.id.tv_n));
        textViews.add(aux = findViewById(R.id.tv_o));
        textViews.add(aux = findViewById(R.id.tv_p));
        textViews.add(aux = findViewById(R.id.tv_q));
        textViews.add(aux = findViewById(R.id.tv_r));
        textViews.add(aux = findViewById(R.id.tv_s));
        textViews.add(aux = findViewById(R.id.tv_t));
        textViews.add(aux = findViewById(R.id.tv_u));
        textViews.add(aux = findViewById(R.id.tv_v));
        textViews.add(aux = findViewById(R.id.tv_w));
        textViews.add(aux = findViewById(R.id.tv_x));
        textViews.add(aux = findViewById(R.id.tv_y));
        textViews.add(aux = findViewById(R.id.tv_z));
        textViews.add(tvEnter = findViewById(R.id.tv_enter));
        textViews.add(tvApagar = findViewById(R.id.tv_apagar));
        textViews.add(tvEspaco = findViewById(R.id.tv_espaco));
        textViews.add(tvPalavra1 = findViewById(R.id.tv_palavra1));
        textViews.add(tvPalavra2 = findViewById(R.id.tv_palavra2));
        textViews.add(tvPalavra3 = findViewById(R.id.tv_palavra3));
        textViews.add(tvPalavra4 = findViewById(R.id.tv_palavra4));

        this.tvSelecionado = tvA;
    }
}
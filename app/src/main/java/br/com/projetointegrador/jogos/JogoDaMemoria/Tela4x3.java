package br.com.projetointegrador.jogos.JogoDaMemoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import br.com.projetointegrador.jogos.R;

public class Tela4x3 extends AppCompatActivity implements View.OnClickListener {

    private static final String dadosApp = "DadosJogo";
    private TextView txtPontos, txtTempo;
    private ImageView L1xC1, L1xC2, L1xC3;
    private ImageView L2xC1, L2xC2, L2xC3;
    private ImageView L3xC1, L3xC2, L3xC3;
    private ImageView L4xC1, L4xC2, L4xC3;
    private Button btnSair, btnRestart;

    private Timer tempo;
    private int contaTempo = 0;
    private int clickBomba = 0;
    private int duasImagens1 = 0, duasImagens2 = 0;
    private int duasImagens3 = 0, duasImagens4 = 0;
    private int duasImagens5 = 0, duasImagens6 = 0;


    Integer[] posicaoImg = {101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206};

    int imgJogo1, imgJogo2, imgJogo3, imgJogo4, imgJogo5, imgJogo6;
    int imgJogo7, imgJogo8, imgJogo9, imgJogo10, imgJogo11, imgJogo12;

    int imgEscolha1, imgEscolha2;

    int selImg1, selImg2;
    int img = 1;
    int pontos = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela4x3);

        iniciar();
    }

    private void salvarPontos() {
        //Salva os dados na memoria do telefone do usuario.
        SharedPreferences arquivos = getSharedPreferences(dadosApp, 0);

        if (arquivos.contains("pontos")) {
            SharedPreferences.Editor editor = arquivos.edit();
            int qtdPontos = arquivos.getInt("pontos", 0);
            int pontos = Integer.parseInt(txtPontos.getText().toString());

            if (pontos > qtdPontos) {
                qtdPontos = pontos;

                editor.putInt("pontos", qtdPontos);
                editor.apply();
            }
            editor.putInt("pontos", qtdPontos);
            editor.apply();
        }
    }

    private void iniciar() {
        txtPontos = findViewById(R.id.txtPontos);
        txtPontos.setText(String.valueOf(pontos));
        txtTempo = findViewById(R.id.txtTempo);

        btnSair = findViewById(R.id.btnSair);
        btnSair.setOnClickListener(this);

        btnRestart = findViewById(R.id.btnRestart);
        btnRestart.setOnClickListener(this);

        //Linha 1
        L1xC1 = findViewById(R.id.imgBt4x3_L1xC1);
        L1xC1.setOnClickListener(this);

        L1xC2 = findViewById(R.id.imgBt4x3_L1xC2);
        L1xC2.setOnClickListener(this);

        L1xC3 = findViewById(R.id.imgBt4x3_L1xC3);
        L1xC3.setOnClickListener(this);

        //Linha 2
        L2xC1 = findViewById(R.id.imgBt4x3_L2xC1);
        L2xC1.setOnClickListener(this);

        L2xC2 = findViewById(R.id.imgBt4x3_L2xC2);
        L2xC2.setOnClickListener(this);

        L2xC3 = findViewById(R.id.imgBt4x3_L2xC3);
        L2xC3.setOnClickListener(this);

        //Linha 3
        L3xC1 = findViewById(R.id.imgBt4x3_L3xC1);
        L3xC1.setOnClickListener(this);

        L3xC2 = findViewById(R.id.imgBt4x3_L3xC2);
        L3xC2.setOnClickListener(this);

        L3xC3 = findViewById(R.id.imgBt4x3_L3xC3);
        L3xC3.setOnClickListener(this);

        //Linha 4
        L4xC1 = findViewById(R.id.imgBt4x3_L4xC1);
        L4xC1.setOnClickListener(this);

        L4xC2 = findViewById(R.id.imgBt4x3_L4xC2);
        L4xC2.setOnClickListener(this);

        L4xC3 = findViewById(R.id.imgBt4x3_L4xC3);
        L4xC3.setOnClickListener(this);


        contaTempo = 90;

        iniciaCronometro();

        //Definindo ordem das imagens
        L1xC1.setTag("0");
        L1xC2.setTag("1");
        L1xC3.setTag("2");

        L2xC1.setTag("3");
        L2xC2.setTag("4");
        L2xC3.setTag("5");

        L3xC1.setTag("6");
        L3xC2.setTag("7");
        L3xC3.setTag("8");

        L4xC1.setTag("9");
        L4xC2.setTag("10");
        L4xC3.setTag("11");


        imagensJogo();

        //Criando colecao de linhas
        //Suffle embaralha as imgs
        Collections.shuffle(Arrays.asList(posicaoImg));

        //Deixando as imagens visiveis
        L1xC1.setVisibility(View.VISIBLE);
        L1xC2.setVisibility(View.VISIBLE);
        L1xC3.setVisibility(View.VISIBLE);

        L2xC1.setVisibility(View.VISIBLE);
        L2xC2.setVisibility(View.VISIBLE);
        L2xC3.setVisibility(View.VISIBLE);

        L3xC1.setVisibility(View.VISIBLE);
        L3xC2.setVisibility(View.VISIBLE);
        L3xC3.setVisibility(View.VISIBLE);

        L4xC1.setVisibility(View.VISIBLE);
        L4xC2.setVisibility(View.VISIBLE);
        L4xC3.setVisibility(View.VISIBLE);


        //Alterar as imagens para a imagem padrao
        L1xC1.setImageResource(R.drawable.star);
        L1xC2.setImageResource(R.drawable.star);
        L1xC3.setImageResource(R.drawable.star);

        L2xC1.setImageResource(R.drawable.star);
        L2xC2.setImageResource(R.drawable.star);
        L2xC3.setImageResource(R.drawable.star);

        L3xC1.setImageResource(R.drawable.star);
        L3xC2.setImageResource(R.drawable.star);
        L3xC3.setImageResource(R.drawable.star);

        L4xC1.setImageResource(R.drawable.star);
        L4xC2.setImageResource(R.drawable.star);
        L4xC3.setImageResource(R.drawable.star);

    }

    private void imagensJogo() {

        imgJogo1 = R.drawable.eagle;
        imgJogo2 = R.drawable.bomb;
        imgJogo3 = R.drawable.giraffe;
        imgJogo4 = R.drawable.hamster;
        imgJogo5 = R.drawable.kangaroo;
        imgJogo6 = R.drawable.pigeon;

        imgJogo7 = R.drawable.eagle;
        imgJogo8 = R.drawable.bomb;
        imgJogo9 = R.drawable.giraffe;
        imgJogo10 = R.drawable.hamster;
        imgJogo11 = R.drawable.kangaroo;
        imgJogo12 = R.drawable.pigeon;
    }

    private void trocaImagem(ImageView imagem, int posicao) {
        if (posicaoImg[posicao] == 101) {
            imagem.setImageResource(imgJogo1);
            clickBomba = 0;
            duasImagens1++;

        } else if (posicaoImg[posicao] == 102) {
            imagem.setImageResource(imgJogo2);
            clickBomba++;

            if (clickBomba == 2) {
                Intent gameOver = new Intent(getApplication(), TelaBomba.class);
                startActivity(gameOver);
                finish();
            }
        } else if (posicaoImg[posicao] == 103) {
            imagem.setImageResource(imgJogo3);
            clickBomba = 0;
            duasImagens3++;

        } else if (posicaoImg[posicao] == 104) {
            imagem.setImageResource(imgJogo4);
            clickBomba = 0;
            duasImagens4++;

        } else if (posicaoImg[posicao] == 105) {
            imagem.setImageResource(imgJogo5);
            clickBomba = 0;
            duasImagens5++;

        } else if (posicaoImg[posicao] == 106) {
            imagem.setImageResource(imgJogo6);
            clickBomba = 0;
            duasImagens6++;

        } else if (posicaoImg[posicao] == 201) {
            imagem.setImageResource(imgJogo7);
            clickBomba = 0;
            duasImagens1++;

        } else if (posicaoImg[posicao] == 202) {
            imagem.setImageResource(imgJogo8);
            clickBomba++;

            if (clickBomba == 2) {
                Intent gameOver = new Intent(getApplication(), TelaBomba.class);
                startActivity(gameOver);
                finish();
            }
        } else if (posicaoImg[posicao] == 203) {
            imagem.setImageResource(imgJogo9);
            clickBomba = 0;
            duasImagens3++;
        } else if (posicaoImg[posicao] == 204) {
            imagem.setImageResource(imgJogo10);
            clickBomba = 0;
            duasImagens4++;
        } else if (posicaoImg[posicao] == 205) {
            imagem.setImageResource(imgJogo11);
            clickBomba = 0;
            duasImagens5++;
        } else if (posicaoImg[posicao] == 206) {
            imagem.setImageResource(imgJogo12);
            clickBomba = 0;
            duasImagens6++;
        }

        if (img == 1) {
            //seleciona a posição do array das imagens
            imgEscolha1 = posicaoImg[posicao];

            //verifica se o numero do array foi passado
            if (imgEscolha1 > 200) {

                imgEscolha1 = imgEscolha1 - 100;
            }

            //troca o numero da imagem
            img = 2;
            //adiciona a posicao da img clicada
            selImg1 = posicao;
            //desabilita a imagem para nao ser clicada varias vezes
            imagem.setEnabled(false);

        } else if (img == 2) {
            //seleciona a posição do array das imagens
            imgEscolha2 = posicaoImg[posicao];

            //verifica se o numero do array foi passado
            if (imgEscolha2 > 200) {

                imgEscolha2 = imgEscolha2 - 100;
            }

            //troca o numero da imagem
            img = 1;
            //adiciona a posicao da img clicada
            selImg2 = posicao;
            //desabilitar todas as imagens
            L1xC1.setEnabled(false);
            L1xC2.setEnabled(false);
            L1xC3.setEnabled(false);

            L2xC1.setEnabled(false);
            L2xC2.setEnabled(false);
            L2xC3.setEnabled(false);

            L3xC1.setEnabled(false);
            L3xC2.setEnabled(false);
            L3xC3.setEnabled(false);

            L4xC1.setEnabled(false);
            L4xC2.setEnabled(false);
            L4xC3.setEnabled(false);

            //Desabilita os clicks por 1 segundo
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    verificaAcerto();
                }
            }, 1000);
        }
    }

    private void verificaAcerto() {
        // Faz a validacao se as imagens sao iguais
        if (imgEscolha1 == imgEscolha2) {

            //bloco de validaçao da primeira imagem selecionada
            if (selImg1 == 0) {
                L1xC1.setVisibility(View.INVISIBLE);

            } else if (selImg1 == 1) {
                L1xC2.setVisibility(View.INVISIBLE);

            } else if (selImg1 == 2) {
                L1xC3.setVisibility(View.INVISIBLE);

            } else if (selImg1 == 3) {
                L2xC1.setVisibility(View.INVISIBLE);

            } else if (selImg1 == 4) {
                L2xC2.setVisibility(View.INVISIBLE);

            } else if (selImg1 == 5) {
                L2xC3.setVisibility(View.INVISIBLE);

            } else if (selImg1 == 6) {
                L3xC1.setVisibility(View.INVISIBLE);

            } else if (selImg1 == 7) {
                L3xC2.setVisibility(View.INVISIBLE);

            } else if (selImg1 == 8) {
                L3xC3.setVisibility(View.INVISIBLE);

            } else if (selImg1 == 9) {
                L4xC1.setVisibility(View.INVISIBLE);

            } else if (selImg1 == 10) {
                L4xC2.setVisibility(View.INVISIBLE);

            } else if (selImg1 == 11) {
                L4xC3.setVisibility(View.INVISIBLE);

            }

            //bloco de validaçao da segunda imagen selecionada
            if (selImg2 == 0) {
                L1xC1.setVisibility(View.INVISIBLE);

            } else if (selImg2 == 1) {
                L1xC2.setVisibility(View.INVISIBLE);

            } else if (selImg2 == 2) {
                L1xC3.setVisibility(View.INVISIBLE);

            } else if (selImg2 == 3) {
                L2xC1.setVisibility(View.INVISIBLE);

            } else if (selImg2 == 4) {
                L2xC2.setVisibility(View.INVISIBLE);

            } else if (selImg2 == 5) {
                L2xC3.setVisibility(View.INVISIBLE);

            } else if (selImg2 == 6) {
                L3xC1.setVisibility(View.INVISIBLE);

            } else if (selImg2 == 7) {
                L3xC2.setVisibility(View.INVISIBLE);

            } else if (selImg2 == 8) {
                L3xC3.setVisibility(View.INVISIBLE);

            } else if (selImg2 == 9) {
                L4xC1.setVisibility(View.INVISIBLE);

            } else if (selImg2 == 10) {
                L4xC2.setVisibility(View.INVISIBLE);

            } else if (selImg2 == 11) {
                L4xC3.setVisibility(View.INVISIBLE);

            }

            pontos++;
            txtPontos.setText(String.valueOf(pontos));
            salvarPontos();

        } else {

            zeraClick();

            L1xC1.setImageResource(R.drawable.star);
            L1xC2.setImageResource(R.drawable.star);
            L1xC3.setImageResource(R.drawable.star);

            L2xC1.setImageResource(R.drawable.star);
            L2xC2.setImageResource(R.drawable.star);
            L2xC3.setImageResource(R.drawable.star);

            L3xC1.setImageResource(R.drawable.star);
            L3xC2.setImageResource(R.drawable.star);
            L3xC3.setImageResource(R.drawable.star);

            L4xC1.setImageResource(R.drawable.star);
            L4xC2.setImageResource(R.drawable.star);
            L4xC3.setImageResource(R.drawable.star);

        }

        L1xC1.setEnabled(true);
        L1xC2.setEnabled(true);
        L1xC3.setEnabled(true);

        L2xC1.setEnabled(true);
        L2xC2.setEnabled(true);
        L2xC3.setEnabled(true);

        L3xC1.setEnabled(true);
        L3xC2.setEnabled(true);
        L3xC3.setEnabled(true);

        L4xC1.setEnabled(true);
        L4xC2.setEnabled(true);
        L4xC3.setEnabled(true);

        validaFimDeJogo();
    }

    private void zeraClick() {
        if (duasImagens1 < 2)
            duasImagens1 = 0;

        if (duasImagens2 < 2)
            duasImagens2 = 0;

        if (duasImagens3 < 2)
            duasImagens3 = 0;

        if (duasImagens4 < 2)
            duasImagens4 = 0;

        if (duasImagens5 < 2)
            duasImagens5 = 0;

        if (duasImagens6 < 2)
            duasImagens6 = 0;

        clickBomba = 0;
    }

    private void validaFimDeJogo() {
        if (duasImagens1 == 2 && duasImagens3 == 2 && duasImagens4 == 2
                && duasImagens5 == 2 && duasImagens6 == 2) {

            contaTempo = 0;

            tempo.cancel();

            //Se acertar todas as imagens troca de fase
            Intent passaFase = new Intent(getApplication(), Tela4x4.class);
            startActivity(passaFase);
            finish();
        }
    }

    public void iniciaCronometro() {
        tempo = new Timer();
        tempo.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (contaTempo > 0) {
                            contaTempo--;
                            txtTempo.setText(String.valueOf(contaTempo));
                        } else {
                            tempo.cancel();
                            Toast.makeText(getApplication(), "SEU TEMPO ACABOU! TENTE NOVAMENTE", Toast.LENGTH_LONG).show();
                            finish();
                        }
                    }
                });
            }
        }, 1000, 1000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        tempo.cancel();
    }

    @Override
    public void onClick(View view) {
        if (view == L1xC1) {
            int posicao = Integer.parseInt((String) view.getTag());
            trocaImagem(L1xC1, posicao);

        } else if (view == L1xC2) {
            int posicao = Integer.parseInt((String) view.getTag());
            trocaImagem(L1xC2, posicao);

        } else if (view == L1xC3) {
            int posicao = Integer.parseInt((String) view.getTag());
            trocaImagem(L1xC3, posicao);

        } else if (view == L2xC1) {
            int posicao = Integer.parseInt((String) view.getTag());
            trocaImagem(L2xC1, posicao);

        } else if (view == L2xC2) {
            int posicao = Integer.parseInt((String) view.getTag());
            trocaImagem(L2xC2, posicao);

        } else if (view == L2xC3) {
            int posicao = Integer.parseInt((String) view.getTag());
            trocaImagem(L2xC3, posicao);

        } else if (view == L3xC1) {
            int posicao = Integer.parseInt((String) view.getTag());
            trocaImagem(L3xC1, posicao);

        } else if (view == L3xC2) {
            int posicao = Integer.parseInt((String) view.getTag());
            trocaImagem(L3xC2, posicao);

        } else if (view == L3xC3) {
            int posicao = Integer.parseInt((String) view.getTag());
            trocaImagem(L3xC3, posicao);

        } else if (view == L4xC1) {
            int posicao = Integer.parseInt((String) view.getTag());
            trocaImagem(L4xC1, posicao);

        } else if (view == L4xC2) {
            int posicao = Integer.parseInt((String) view.getTag());
            trocaImagem(L4xC2, posicao);

        } else if (view == L4xC3) {
            int posicao = Integer.parseInt((String) view.getTag());
            trocaImagem(L4xC3, posicao);

        } else if (view == btnSair) {
            Intent telaInicial = new Intent(this, JogoDaMemoria.class);
            startActivity(telaInicial);

        } else if (view == btnRestart) {
            contaTempo = 0;
            tempo.cancel();
            pontos = 0;
            clickBomba = 0;
            duasImagens1 = 0;
            duasImagens2 = 0;
            txtPontos.setText(String.valueOf(pontos));
            iniciar();
        }

    }
}
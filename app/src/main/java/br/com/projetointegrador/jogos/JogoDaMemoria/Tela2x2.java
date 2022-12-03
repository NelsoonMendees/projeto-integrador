package br.com.projetointegrador.jogos.JogoDaMemoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Arrays;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import br.com.projetointegrador.jogos.R;

public class Tela2x2 extends AppCompatActivity implements View.OnClickListener {
    TextView txtPontos, txtTempo;
    ImageView L1xC1, L1xC2;
    ImageView L2xC1, L2xC2;
    Button btnSair, btnRestart;

    private Timer tempo;
    private int contaTempo = 0;

    Integer[] posicaoImg = {101, 102, 201, 202};

    int imgJogo1, imgJogo2, imgJogo3, imgJogo4;

    int imgEscolha1, imgEscolha2;

    int selImg1, selImg2;
    int img = 1;
    int pontos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2x2);

        iniciar();
    }

    private void iniciar() {
        txtPontos = findViewById(R.id.txtPontos);
        txtTempo = findViewById(R.id.txtTempo);

        btnSair = findViewById(R.id.btnSair);
        btnSair.setOnClickListener(this);

        btnRestart = findViewById(R.id.btnRestart);

        //Linha 1
        L1xC1 = findViewById(R.id.imgBt2x2_L1xC1);
        L1xC1.setOnClickListener(this);
        L1xC2 = findViewById(R.id.imgBt2x2_L1xC2);
        L1xC2.setOnClickListener(this);

        //Linha 2
        L2xC1 = findViewById(R.id.imgBt2x2_L2xC1);
        L2xC1.setOnClickListener(this);
        L2xC2 = findViewById(R.id.imgBt2x2_L2xC2);
        L2xC2.setOnClickListener(this);

        contaTempo = 30;

        iniciaCronometro();

        //Definindo ordem das imagens
        L1xC1.setTag("0");
        L1xC2.setTag("1");
        L2xC1.setTag("2");
        L2xC2.setTag("3");

        imagensJogo();

        //Criando colecao de linhas
        //Suffle embaralha as imgs
        Collections.shuffle(Arrays.asList(posicaoImg));

        //Deixando as imagens visiveis
        L1xC1.setVisibility(View.VISIBLE);
        L1xC2.setVisibility(View.VISIBLE);
        L2xC1.setVisibility(View.VISIBLE);
        L2xC2.setVisibility(View.VISIBLE);


        //Alterar as imagens para a img padrao
        L1xC1.setImageResource(R.drawable.star);
        L1xC2.setImageResource(R.drawable.star);
        L2xC1.setImageResource(R.drawable.star);
        L2xC2.setImageResource(R.drawable.star);
    }

    private void imagensJogo() {
        imgJogo1 = R.drawable.cat;
        imgJogo2 = R.drawable.alpaca;
        imgJogo3 = R.drawable.cat;
        imgJogo4 = R.drawable.alpaca;
    }

    private void trocaImagem(ImageView imagem, int posicao) {
        if (posicaoImg[posicao] == 101) {
            imagem.setImageResource(imgJogo1);

        } else if (posicaoImg[posicao] == 102) {
            imagem.setImageResource(imgJogo2);

        } else if (posicaoImg[posicao] == 201) {
            imagem.setImageResource(imgJogo3);

        } else if (posicaoImg[posicao] == 202) {
            imagem.setImageResource(imgJogo4);
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
            L2xC1.setEnabled(false);
            L2xC2.setEnabled(false);

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
        // Faz a validacao se as imagens sao iguais e
        if (imgEscolha1 == imgEscolha2) {

            if (selImg1 == 0) {
                L1xC1.setVisibility(View.INVISIBLE);
            } else if (selImg1 == 1) {
                L1xC2.setVisibility(View.INVISIBLE);
            } else if (selImg1 == 2) {
                L2xC1.setVisibility(View.INVISIBLE);
            } else if (selImg1 == 3) {
                L2xC2.setVisibility(View.INVISIBLE);
            }

            if (selImg2 == 0) {
                L1xC1.setVisibility(View.INVISIBLE);
            } else if (selImg2 == 1) {
                L1xC2.setVisibility(View.INVISIBLE);
            } else if (selImg2 == 2) {
                L2xC1.setVisibility(View.INVISIBLE);
            } else if (selImg2 == 3) {
                L2xC2.setVisibility(View.INVISIBLE);
            }

            pontos = pontos + 10;
            txtPontos.setText(String.valueOf(pontos));
        } else {
            L1xC1.setImageResource(R.drawable.star);
            L1xC2.setImageResource(R.drawable.star);
            L2xC1.setImageResource(R.drawable.star);
            L2xC2.setImageResource(R.drawable.star);
        }

        L1xC1.setEnabled(true);
        L1xC2.setEnabled(true);
        L2xC1.setEnabled(true);
        L2xC2.setEnabled(true);

        validaFimDeJogo();
    }

    private void validaFimDeJogo() {
        if (L1xC1.getVisibility() == View.INVISIBLE && L1xC2.getVisibility() == View.INVISIBLE &&
                L2xC1.getVisibility() == View.INVISIBLE && L2xC2.getVisibility() == View.INVISIBLE) {


            //Se acertar todas as imagens troca de fase
            Intent passaFase = new Intent(getApplication(), Tela3x2.class);
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
                            Toast.makeText(Tela2x2.this, "SEU TEMPO ACABOU! TENTE NOVAMENTE", Toast.LENGTH_LONG).show();
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
        } else if (view == L2xC1) {
            int posicao = Integer.parseInt((String) view.getTag());
            trocaImagem(L2xC1, posicao);
        } else if (view == L2xC2) {
            int posicao = Integer.parseInt((String) view.getTag());
            trocaImagem(L2xC2, posicao);
        } else if (view == btnSair) {
            Intent telaInicial = new Intent(this, JogoDaMemoria.class);
            startActivity(telaInicial);
        }

    }

}
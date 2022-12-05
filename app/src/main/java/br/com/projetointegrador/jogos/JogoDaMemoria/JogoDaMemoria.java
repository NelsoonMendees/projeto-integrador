package br.com.projetointegrador.jogos.JogoDaMemoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.projetointegrador.jogos.MainActivity;
import br.com.projetointegrador.jogos.R;

public class JogoDaMemoria extends AppCompatActivity implements View.OnClickListener {

    private Button btnVoltarMemory;
    private Button btnJogarMemory;
    private TextView txtQtdPts;

    private static final String dadosApp = "DadosJogo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_da_memoria);

        btnVoltarMemory = findViewById(R.id.btnVoltarMemory);
        btnVoltarMemory.setOnClickListener(this);
        btnJogarMemory = findViewById(R.id.btnJogarMemory);
        btnJogarMemory.setOnClickListener(this);
        txtQtdPts = findViewById(R.id.txtPts);
    }

    @Override
    public void onClick(View view) {
        if (view == btnJogarMemory) {
            Intent jogar = new Intent(this, Tela2x2.class);
            startActivity(jogar);
        } else if (view == btnVoltarMemory) {
            Intent telaPrincipal = new Intent(this, MainActivity.class);
            startActivity(telaPrincipal);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Salva os dados na memoria do usuario.
        SharedPreferences arquivos = getSharedPreferences(dadosApp, 0);

        if (arquivos.contains("pontos")) {
            int recuperaPontos = arquivos.getInt("pontos", 0);
            txtQtdPts.setText("Maior Pontuação: " + recuperaPontos);

        } else {
            SharedPreferences.Editor editor = arquivos.edit();
            editor.putInt("pontos", 0);
            editor.apply();
        }

    }


}
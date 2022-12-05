package br.com.projetointegrador.jogos.JogoDaMemoria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.projetointegrador.jogos.R;

public class TelaWin extends AppCompatActivity implements View.OnClickListener {

    Button sair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_win);

        sair = findViewById(R.id.btnVoltarWin);
        sair.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == sair) {
            finish();
        }
    }
}
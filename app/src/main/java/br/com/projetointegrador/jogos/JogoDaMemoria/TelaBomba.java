package br.com.projetointegrador.jogos.JogoDaMemoria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import br.com.projetointegrador.jogos.R;

public class TelaBomba extends AppCompatActivity implements View.OnClickListener {

  private Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_bomba);

        voltar = findViewById(R.id.btnVoltarGameOver);
        voltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == voltar){
            finish();
        }
    }
}
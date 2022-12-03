package br.com.projetointegrador.jogos.JogoDaMemoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.projetointegrador.jogos.MainActivity;
import br.com.projetointegrador.jogos.R;

public class JogoDaMemoria extends AppCompatActivity implements View.OnClickListener {
    Button btnVoltarMemory;
    Button btnJogarMemory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_da_memoria);

        btnVoltarMemory = findViewById(R.id.btnVoltarMemory);
        btnVoltarMemory.setOnClickListener(this);
        btnJogarMemory = findViewById(R.id.btnJogarMemory);
        btnJogarMemory.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btnJogarMemory){
            Intent jogar = new Intent(this, Tela2x2.class);
            startActivity(jogar);
        }
        else if(view == btnVoltarMemory){
            Intent telaPrincipal = new Intent(this, MainActivity.class);
            startActivity(telaPrincipal);
        }
    }
}
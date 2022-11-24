package br.com.projetointegrador.jogos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.projetointegrador.jogos.Anagrama.Anagrama;
import br.com.projetointegrador.jogos.JogoDaMemoria.JogoDaMemoria;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnJogarAnagrama;
    Button btnJogoMemoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJogarAnagrama = findViewById(R.id.btnJogarAnagrama);
        btnJogarAnagrama.setOnClickListener(this);
        btnJogoMemoria = findViewById(R.id.btnJogoMemoria);
        btnJogoMemoria.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnJogarAnagrama) {
            Intent playAnagrama = new Intent(this, Anagrama.class);
            startActivity(playAnagrama);
        } else if (view == btnJogoMemoria) {
            Intent playMemory = new Intent(this, JogoDaMemoria.class);
            startActivity(playMemory);
        }
    }
}
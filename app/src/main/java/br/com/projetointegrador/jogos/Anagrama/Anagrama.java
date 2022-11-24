package br.com.projetointegrador.jogos.Anagrama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.projetointegrador.jogos.MainActivity;
import br.com.projetointegrador.jogos.R;

public class Anagrama extends AppCompatActivity implements View.OnClickListener {
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anagrama);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == btnVoltar){
            Intent telaPrincipal = new Intent(this, MainActivity.class);
            startActivity(telaPrincipal);
        }
    }
}
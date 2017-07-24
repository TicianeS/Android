package com.example.ti_ti.guess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton rdoFacil, rdoMedio, rdoDificil;
    Button btnJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdoFacil = (RadioButton) findViewById(R.id.rdoFacil);
        rdoMedio = (RadioButton) findViewById(R.id.rdoMedio);
        rdoDificil = (RadioButton) findViewById(R.id.rdoDificil);
        btnJogar = (Button) findViewById(R.id.btnJogar);
    }

    public void btnJogarClick(View view) {
        int dif=0;
        if (rdoFacil.isChecked()){
            dif = 1;
        }else{
            if(rdoMedio.isChecked()){
                dif = 2;
            }else {
                    dif = 3;
            }
        }

        Intent intent = new Intent(MainActivity.this, JogoActivity.class); //onde esta e onde quer ir
        intent.putExtra("Dificuldade", dif); // passa a informação pra outra tela, nome e parametro
        startActivity(intent);
    }
}

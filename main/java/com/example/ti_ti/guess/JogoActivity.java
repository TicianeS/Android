package com.example.ti_ti.guess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class JogoActivity extends AppCompatActivity {

    Button btnVerificar;
    TextView txtSorteado, txtStatus;
    EditText edtPalpite;
    int numSorteado;
    Random r = new Random(); // cria um número aleatório

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        btnVerificar = (Button) findViewById(R.id.btnVerificar);
        txtSorteado = (TextView) findViewById(R.id.txtSorteado);
        txtStatus = (TextView) findViewById(R.id.txtStatus);
        edtPalpite = (EditText) findViewById(R.id.edtPalpite);

        int dif = getIntent().getIntExtra("Dificuldade", 0); // nome do parametro, pra valores numéricos atribuir o valor 0 caso se esqueça de passar o parâmetro


        if (dif == 1){
            numSorteado = r.nextInt(11); // 0 a 10
        } else{
            if( dif == 2){
                numSorteado = r.nextInt(101);
            } else {
                numSorteado = r.nextInt(1001);
            }
        }

    }

    public void btnVerificarClick(View view) {
        int palpite = Integer.parseInt(edtPalpite.getText().toString());

        if (palpite< numSorteado) {
            txtStatus.setText("O número informado é menor do que o sorteado");
        }else{
            if (palpite> numSorteado) {
                txtStatus.setText("O número informado é maior do que o sorteado");
            } else {
                txtStatus.setText("Parabéns, você acertou!!");
                txtSorteado.setText(numSorteado+"");
            }
        }

    }
}


// escolher um tema sem action bar

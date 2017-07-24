package com.example.ti_ti.bhaskara;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bhaskara extends AppCompatActivity {
    Button btnCalcular, btnReiniciar;
    EditText edtA, edtB, edtC;
    float delta, x1, x2, a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhaskara);

        edtA = (EditText) findViewById(R.id.edtA);
        edtB = (EditText) findViewById(R.id.edtB);
        edtC = (EditText) findViewById(R.id.edtC);


    }

    public void btnCalcularClick(View view) {
        a = Float.parseFloat(edtA.getText().toString());
        b = Float.parseFloat(edtB.getText().toString());
        c = Float.parseFloat(edtC.getText().toString());

        delta = (b*b)-4*a*c;

        x1 = (float) ((-b + (Math.sqrt(delta)))/ 2*a);
        x2 = (float) ((-b - (Math.sqrt(delta)))/ 2*a);

        Toast.makeText(Bhaskara.this, "x1 = " + x1 + "  ,  x2 = " + x2, Toast.LENGTH_LONG).show();
    }

    public void btnReiniciarClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Bhaskara.this);

        builder.setTitle("Bhaskara"); //título
        builder.setMessage("Deseja reiniciar?"); // mensagem
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Bhaskara.this, "Novo Cálculo", Toast.LENGTH_LONG).show();
                //zerar o jogo
                delta=0; x1=0; x2=0; a=0; b=0; c=0;
                edtA.setText("");
                edtB.setText("");
                edtC.setText("");
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // não se usa código para sair da aplicação
            }
        });

        // criar a caixa de diálogo
        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false); // não deixa clicar fora da caixa de diálogo

        //mostrar na tela
        alertDialog.show();
    }
}

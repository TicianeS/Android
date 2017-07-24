package com.example.ti_ti.imobiliaria.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.ti_ti.imobiliaria.R;

public class MainActivity extends AppCompatActivity {
    Button btnAdmin, btnPesquisar;
    RadioButton rdoAlugar, rdoComprar, rdo1, rdo2, rdo3, rdo4;
    EditText edtBairro, edtCidade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdmin = (Button) findViewById(R.id.btnAdmin);
        btnPesquisar = (Button) findViewById(R.id.btnPesquisar);
        rdoAlugar = (RadioButton) findViewById(R.id.rdoAlugar);
        rdoComprar = (RadioButton) findViewById(R.id.rdoComprar);
        rdo1 = (RadioButton) findViewById(R.id.rdo1);
        rdo2 = (RadioButton) findViewById(R.id.rdo2);
        rdo3 = (RadioButton) findViewById(R.id.rdo3);
        rdo4 = (RadioButton) findViewById(R.id.rdo4);
        edtBairro = (EditText) findViewById(R.id.edtBairro);
        edtCidade = (EditText) findViewById(R.id.edtCidade);
    }

    public void btnAdminClick(View view) {

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);

    }

    public void btnPesquisarClick(View view) {
        int qt = 0;
        String op= null;
        String tipo = "U";

        if (rdo1.isChecked()){
            qt = 1;
        }else {
            if (rdo2.isChecked()){
                qt = 2;
            } else {
                if (rdo3.isChecked()){
                    qt = 3;
                } else {
                    qt = 4;
                }
            }
        }

        if(rdoAlugar.isChecked()){
            op = "Locaçao";
        } else {
            op = "Venda";
        }


        Intent intent = new Intent(MainActivity.this, PesquisaActivity.class); //onde esta e onde quer ir
        intent.putExtra("Quartos", qt);
        intent.putExtra("Opcao", op);
        intent.putExtra("Tipo", "U");
        intent.putExtra("Bairro", edtBairro.getText().toString());
        intent.putExtra("Cidade", edtCidade.getText().toString());
        startActivity(intent);
    }
}

package com.example.ti_ti.imobiliaria.view;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ti_ti.imobiliaria.R;

public class OpcoesAdminActivity extends AppCompatActivity {

    EditText edtPesqAdmin;
    Button btnPesqAdmin, btnCadastrar, btnListar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes_admin);

        edtPesqAdmin = (EditText) findViewById(R.id.edtPesqAdmin);
        btnPesqAdmin = (Button) findViewById(R.id.btnPesqAdmin);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnListar = (Button) findViewById(R.id.btnListar);
    }

    public void btnPesqAdminClick(View view) {
        String tipo = "A";
        Intent intent = new Intent(OpcoesAdminActivity.this, PesquisaActivity.class); //onde esta e onde quer ir
        intent.putExtra("Tipo", tipo);
        intent.putExtra("Bairro", edtPesqAdmin.getText().toString());
        startActivity(intent);
    }

    public void btnCadastrarClick(View view) {
        Intent intent = new Intent(OpcoesAdminActivity.this, GravarImovelActivity.class); //onde esta e onde quer ir
        startActivity(intent);
    }

    public void btnListarClick(View view) {
        Intent intent = new Intent(OpcoesAdminActivity.this, ListaActivity.class); //onde esta e onde quer ir
        startActivity(intent);
    }
}

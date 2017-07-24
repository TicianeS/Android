package com.example.ti_ti.imobiliaria.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ti_ti.imobiliaria.R;

public class LoginActivity extends AppCompatActivity {

    EditText edtLogin, edtSenha;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtLogin = (EditText) findViewById(R.id.edtLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
    }

    public void btnEntrarClick(View view) {
        if (edtLogin.getText().toString().equals("admin") && edtSenha.getText().toString().equals("123")){
            Intent intent = new Intent(LoginActivity.this, OpcoesAdminActivity.class);
            startActivity(intent);
        } else{
            Toast.makeText(this,"Usuário ou senha inválida", Toast.LENGTH_LONG).show();
        }
    }


}

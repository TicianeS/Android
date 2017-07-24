package com.example.ti_ti.imobiliaria.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ti_ti.imobiliaria.R;
import com.example.ti_ti.imobiliaria.dal.ImovelDAO;
import com.example.ti_ti.imobiliaria.model.Imovel;

public class GravarImovelActivity extends AppCompatActivity {

    EditText edtFinalidade, edtValor, edtEndereco, edtBairro, edtCidade, edtNumero, edtComplemento, edtQuartos, edtDescricao, edtFoto, edtTelefone;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravar_imovel);

        edtFinalidade = (EditText) findViewById(R.id.edtFinalidade);
        edtValor = (EditText) findViewById(R.id.edtValor);
        edtEndereco = (EditText) findViewById(R.id.edtEndereco);
        edtBairro = (EditText) findViewById(R.id.edtBairro);
        edtCidade = (EditText) findViewById(R.id.edtCidade);
        edtNumero = (EditText) findViewById(R.id.edtNumero);
        edtComplemento = (EditText) findViewById(R.id.edtComplemento);
        edtQuartos = (EditText) findViewById(R.id.edtQuartos);
        edtDescricao = (EditText) findViewById(R.id.edtDescricao);
        edtFoto = (EditText) findViewById(R.id.edtFoto);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        edtTelefone = (EditText) findViewById(R.id.edtTelefone);
    }

    public void btnSalvarClick(View view) {
            if (edtFinalidade.getText().toString().equals("Locaçao") || edtFinalidade.getText().toString().equals("Venda")){
                Imovel imovel = new Imovel();
                imovel.setFinalidade(edtFinalidade.getText().toString());
                imovel.setValor(edtValor.getText().toString());
                imovel.setEndereco(edtEndereco.getText().toString());
                imovel.setBairro(edtBairro.getText().toString());
                imovel.setCidade(edtCidade.getText().toString());
                imovel.setNumero(edtNumero.getText().toString());
                imovel.setComplemento(edtComplemento.getText().toString());
                imovel.setQuartos(Integer.parseInt(edtQuartos.getText().toString()));
                imovel.setDescricao(edtDescricao.getText().toString());
                imovel.setTelefone(edtTelefone.getText().toString());
                imovel.setFoto(edtFoto.getText().toString());

                ImovelDAO.adicionarImovel(this, imovel);
                Toast.makeText(this, "Imóvel cadastrado com sucesso", Toast.LENGTH_SHORT).show();

                edtFinalidade.setText("");
                edtValor.setText("");
                edtEndereco.setText("");
                edtBairro.setText("");
                edtCidade.setText("");
                edtNumero.setText("");
                edtComplemento.setText("");
                edtQuartos.setText("");
                edtDescricao.setText("");
                edtTelefone.setText("");
                edtFoto.setText("");


            } else{
                Toast.makeText(this, "O campo finalidade deve ser preenchido somente como Locaçao ou Venda", Toast.LENGTH_SHORT).show();
            }
    }

}

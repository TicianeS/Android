package com.example.ti_ti.imobiliaria.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ti_ti.imobiliaria.R;
import com.example.ti_ti.imobiliaria.dal.Banco;
import com.example.ti_ti.imobiliaria.dal.ImovelDAO;
import com.example.ti_ti.imobiliaria.model.Imovel;
import com.squareup.picasso.Picasso;

public class AdminImovelActivity extends AppCompatActivity {

    EditText edtFinalidade, edtValor, edtEndereco, edtNumero, edtComplemento, edtQuartos, edtBairro, edtCidade, edtDescricao, edtFoto, edtTelefone;
    Button btnAlterar, btnExcluir;
    ImageView imgFoto;
    TextView txtId;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_imovel);

        String foto = "";

        id = Integer.parseInt(getIntent().getStringExtra("Id"));

       txtId = (TextView) findViewById(R.id.txtId);

        edtFinalidade = (EditText) findViewById(R.id.edtFinalidade);
        edtValor = (EditText) findViewById(R.id.edtValor);
        edtEndereco = (EditText) findViewById(R.id.edtEndereco);
        edtNumero = (EditText) findViewById(R.id.edtNumero);
        edtComplemento = (EditText) findViewById(R.id.edtComplemento);
        edtQuartos = (EditText) findViewById(R.id.edtQuartos);
        edtBairro = (EditText) findViewById(R.id.edtBairro);
        edtCidade = (EditText) findViewById(R.id.edtCidade);
        edtDescricao = (EditText) findViewById(R.id.edtDescricao);
        edtFoto = (EditText) findViewById(R.id.edtFoto);
        btnAlterar = (Button) findViewById(R.id.btnAlterar);
        btnExcluir = (Button) findViewById(R.id.btnExcluir);
        imgFoto = (ImageView) findViewById(R.id.imgFoto);
        edtTelefone = (EditText) findViewById(R.id.edtTelefone);

        foto = getIntent().getStringExtra("Foto");
        txtId.setText(getIntent().getStringExtra("Id"));
        edtFoto.setText(foto);
        edtValor.setText(getIntent().getStringExtra("Valor"));
        edtFinalidade.setText(getIntent().getStringExtra("Finalidade"));
        edtEndereco.setText(getIntent().getStringExtra("Endereco"));
        edtNumero.setText(getIntent().getStringExtra("Numero"));
        edtComplemento.setText(getIntent().getStringExtra("Complemento"));
        edtQuartos.setText(getIntent().getStringExtra("Quartos"));
        edtDescricao.setText(getIntent().getStringExtra("Descricao"));
        edtBairro.setText(getIntent().getStringExtra("Bairro"));
        edtCidade.setText(getIntent().getStringExtra("Cidade"));
        edtTelefone.setText(getIntent().getStringExtra("Telefone"));


        if (!foto.equals("")) {

            Picasso.with(this)
                    .load(foto)
                    .placeholder(R.drawable.carregando)
                    .into(imgFoto);

        }
    }

    public void btnAlterarClick(View view) {
        if (edtFinalidade.getText().toString().equals("Locaçao") || edtFinalidade.getText().toString().equals("Venda")) {
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

            ImovelDAO.atualizarImovel(this, imovel, Integer.parseInt(txtId.getText().toString()));
            Toast.makeText(this, "Imóvel atualizado com sucesso", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, ListaActivity.class);
            startActivity(intent);
        } else{
            Toast.makeText(this, "O campo finalidade deve ser preenchido somente como Locaçao ou Venda", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnExcluir(View view) {
        Banco banco = new Banco(this);
        Toast.makeText(this, "Imóvel: " + id + " excluído com sucesso.", Toast.LENGTH_SHORT).show();
        banco.excluirImovel(id);
        Intent intent = new Intent(this, ListaActivity.class);
        startActivity(intent);
    }
}

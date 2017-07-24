package com.example.ti_ti.imobiliaria.view;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.ti_ti.imobiliaria.R;
import com.squareup.picasso.Picasso;

public class UsuImovelActivity extends AppCompatActivity {

    TextView txtId, txtFinalidade, txtValor, txtEndereco, txtNumero, txtComplemento, txtQuartos, txtBairro, txtCidade, txtDescricao, txtTelefone;
    Button btnMapa, btnEmail;
    ImageView imgFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usu_imovel);

        txtId = (TextView) findViewById(R.id.txtId);
        txtFinalidade = (TextView) findViewById(R.id.txtFinalidade);
        txtValor = (TextView) findViewById(R.id.txtValor);
        txtEndereco = (TextView) findViewById(R.id.txtEndereco);
        txtNumero = (TextView) findViewById(R.id.txtNumero);
        txtComplemento = (TextView) findViewById(R.id.txtComplemento);
        txtQuartos = (TextView) findViewById(R.id.txtQuartos);
        txtBairro = (TextView) findViewById(R.id.txtBairro);
        txtCidade = (TextView) findViewById(R.id.txtCidade);
        txtDescricao = (TextView) findViewById(R.id.txtDescricao);
        btnMapa = (Button) findViewById(R.id.btnMapa);
        btnEmail = (Button) findViewById(R.id.btnEnviarEmail);
        imgFoto = (ImageView) findViewById(R.id.imgFoto);
        txtTelefone = (TextView) findViewById(R.id.txtTelefone);

        txtId.setText(getIntent().getStringExtra("Id"));
        String foto = getIntent().getStringExtra("Foto");
        txtValor.setText(getIntent().getStringExtra("Valor"));
        txtFinalidade.setText(getIntent().getStringExtra("Finalidade"));
        txtEndereco.setText(getIntent().getStringExtra("Endereco"));
        txtNumero.setText(getIntent().getStringExtra("Numero"));
        txtComplemento.setText(getIntent().getStringExtra("Complemento"));
        txtQuartos.setText(getIntent().getStringExtra("Quartos"));
        txtDescricao.setText(getIntent().getStringExtra("Descricao"));
        txtBairro.setText(getIntent().getStringExtra("Bairro"));
        txtCidade.setText(getIntent().getStringExtra("Cidade"));
        txtTelefone.setText(getIntent().getStringExtra("Telefone"));

        if (!foto.equals("")) {
            Picasso.with(this)
                    .load(foto)
                    .placeholder(R.drawable.carregando)
                    .into(imgFoto);
        }
    }

    public void btnMapaClick(View view) {
        String cidade = txtCidade.getText().toString();
        String bairro = txtBairro.getText().toString();
        String endereco = txtEndereco.getText().toString();
        String numero = txtNumero.getText().toString();
        cidade.replace(" ", "+");
        bairro.replace(" ", "+");
        endereco.replace(" ", "+");
        Uri uri = Uri.parse("geo:0,0?q="+endereco+numero+bairro+cidade+"?z=20");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        startActivity(intent);

    }

    public void btnEnviarEmailClick(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("txt/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String []{"ti_tici@hotmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Código do imóvel: " + txtId.getText().toString() +
                "  " + txtFinalidade.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, "Dados do imóvel: \nValor: "+txtValor.getText().toString()+"" +
                "\nEndereço: "+txtEndereco.getText().toString()+", "+txtBairro.getText().toString()+", "+txtCidade.getText().toString()+ "\n\n" +
                "Por favor, preencha seus dados para contato: \nNome: \nTelefone: \n");
        startActivity(Intent.createChooser(intent, "Selecione o aplicativo"));


        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.casinha);
        builder.setContentTitle("Portal dos Imóveis - mensagem");
        builder.setContentText("Ao recebermos sua mensagem entraremos em contato o mais breve possível");

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
       builder.setContentIntent(pendingIntent);

        builder.setColor(Color.RED);

        builder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);

        final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    notificationManager.notify(0, builder.build());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }



}

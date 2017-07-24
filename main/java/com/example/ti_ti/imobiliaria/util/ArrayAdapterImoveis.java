package com.example.ti_ti.imobiliaria.util;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ti_ti.imobiliaria.R;
import com.example.ti_ti.imobiliaria.model.Imovel;
import com.example.ti_ti.imobiliaria.view.AdminImovelActivity;
import com.example.ti_ti.imobiliaria.view.MainActivity;
import com.example.ti_ti.imobiliaria.view.UsuImovelActivity;

import java.util.List;

/**
 * Created by ti_ti on 04/12/2016.
 */

public class ArrayAdapterImoveis extends ArrayAdapter{
    Handler handler = new Handler();
    private Context context;
    private List<Imovel> lista;
    private TextView txtId, txtFinalidade, txtEndereco, txtNumero, txtComplemento, txtBairro, txtCidade,
            txtQuartos, txtValor, txtDescricao, txtTelefone;
    private ImageView imgFoto;

    String tipo;

    public ArrayAdapterImoveis(Context context, List<Imovel> lista, String tp) {
        super(context, 0, lista);
        this.context = context;
        this.lista = lista;
        tipo = tp;
    }


    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {//cria cada item da lista

        Imovel i = lista.get(position);


        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
        }

        txtId = (TextView) convertView.findViewById(R.id.txtId);
        txtFinalidade = (TextView) convertView.findViewById(R.id.txtFinalidade);
        txtValor = (TextView) convertView.findViewById(R.id.txtValor);
        txtBairro = (TextView) convertView.findViewById(R.id.txtBairro);
        txtCidade = (TextView) convertView.findViewById(R.id.txtCidade);
        txtEndereco = (TextView) convertView.findViewById(R.id.txtEndereco);
        txtNumero = (TextView) convertView.findViewById(R.id.txtNumero);
        txtComplemento = (TextView) convertView.findViewById(R.id.txtComplemento);
        txtQuartos = (TextView) convertView.findViewById(R.id.txtQuartos);
        txtDescricao = (TextView) convertView.findViewById(R.id.txtDescricao);
        txtTelefone = (TextView) convertView.findViewById(R.id.txtTelefone);
        imgFoto = (ImageView) convertView.findViewById(R.id.imgFoto);

        txtId.setText(""+i.getId());
        txtFinalidade.setText(i.getFinalidade());
        txtValor.setText(i.getValor());
        txtBairro.setText(i.getBairro());
        txtCidade.setText(i.getCidade());
        txtEndereco.setText(i.getEndereco());
        txtNumero.setText(i.getNumero());
        txtComplemento.setText(i.getComplemento());
        txtQuartos.setText(""+i.getQuartos());
        txtDescricao.setText(i.getDescricao());
        txtTelefone.setText(i.getTelefone());
      //  final String foto = i.getFoto();


        convertView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Imovel i = lista.get(position);

                Toast.makeText(context, "Posição: " + position, Toast.LENGTH_SHORT).show();

                if (tipo.equals("U")){
                    Intent intent = new Intent(context, UsuImovelActivity.class);

                    intent.putExtra("Id", ""+i.getId());
                    intent.putExtra("Finalidade", i.getFinalidade());
                    intent.putExtra("Valor", i.getValor());
                    intent.putExtra("Endereco", i.getEndereco());
                    intent.putExtra("Numero", i.getNumero());
                    intent.putExtra("Complemento", i.getComplemento());
                    intent.putExtra("Quartos", ""+i.getQuartos());
                    intent.putExtra("Bairro", i.getBairro());
                    intent.putExtra("Cidade", i.getCidade());
                    intent.putExtra("Descricao", i.getDescricao());
                    intent.putExtra("Telefone", i.getTelefone());
                    intent.putExtra("Foto", i.getFoto());

                    context.startActivity(intent);
                } else{
                    if(tipo.equals("A")){
                        Intent intent = new Intent(context, AdminImovelActivity.class);
                        intent.putExtra("Id", ""+i.getId());
                        intent.putExtra("Finalidade", i.getFinalidade());
                        intent.putExtra("Valor", i.getValor());
                        intent.putExtra("Endereco", i.getEndereco());
                        intent.putExtra("Numero", i.getNumero());
                        intent.putExtra("Complemento", i.getComplemento());
                        intent.putExtra("Quartos", ""+i.getQuartos());
                        intent.putExtra("Bairro", i.getBairro());
                        intent.putExtra("Cidade", i.getCidade());
                        intent.putExtra("Descricao", i.getDescricao());
                        intent.putExtra("Telefone", i.getTelefone());
                        intent.putExtra("Foto", i.getFoto());

                        context.startActivity(intent);
                    }
                }


            }
        });

        return convertView;
    }


}

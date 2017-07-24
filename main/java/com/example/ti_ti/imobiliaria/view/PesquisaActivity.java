package com.example.ti_ti.imobiliaria.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ti_ti.imobiliaria.R;
import com.example.ti_ti.imobiliaria.dal.ImovelDAO;
import com.example.ti_ti.imobiliaria.util.ArrayAdapterImoveis;

public class PesquisaActivity extends AppCompatActivity {

    ListView lstImoveis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lstImoveis = (ListView) findViewById(R.id.lstImoveis);

        int qt = getIntent().getIntExtra("Quartos", 0);
        String op = getIntent().getStringExtra("Opcao");
        String bairro = getIntent().getStringExtra("Bairro");
        String cidade = getIntent().getStringExtra("Cidade");
        String tipo = getIntent().getStringExtra("Tipo");

        if (tipo.equals("U")){
            ArrayAdapterImoveis adapterImoveis = new ArrayAdapterImoveis(this, ImovelDAO.listarImoveisPesqUsu(this, bairro, cidade, qt, op), "U");
            lstImoveis.setAdapter(adapterImoveis);
           if (adapterImoveis.isEmpty()) {
                Toast.makeText(this, "Não possuímos imóveis com estas especificações", Toast.LENGTH_LONG).show();
            }
        }
            if (tipo.equals("A")){
                ArrayAdapterImoveis adapterImoveis = new ArrayAdapterImoveis(this, ImovelDAO.listarImoveisPesqAdmin(this, bairro), "A");
                lstImoveis.setAdapter(adapterImoveis);
                if (adapterImoveis.isEmpty()){
                    Toast.makeText(this, "Não possuímos imóveis no bairro pesquisado", Toast.LENGTH_LONG).show();
                }
            }


    }
}

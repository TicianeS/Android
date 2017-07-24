package com.example.ti_ti.imobiliaria.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.ti_ti.imobiliaria.R;
import com.example.ti_ti.imobiliaria.dal.ImovelDAO;
import com.example.ti_ti.imobiliaria.util.ArrayAdapterImoveis;

/**
 * Created by ti_ti on 04/12/2016.
 */

public class ListaActivity extends AppCompatActivity {

    ListView lstImoveis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lstImoveis = (ListView) findViewById(R.id.lstImoveis);

       final  ArrayAdapterImoveis adapterImoveis = new ArrayAdapterImoveis(this, ImovelDAO.listarImoveis(this), "A");
        lstImoveis.setAdapter(adapterImoveis);


    }
}

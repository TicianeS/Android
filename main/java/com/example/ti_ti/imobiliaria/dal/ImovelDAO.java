package com.example.ti_ti.imobiliaria.dal;

import android.content.Context;
import android.widget.Toast;

import com.example.ti_ti.imobiliaria.model.Imovel;

import java.util.List;

/**
 * Created by ti_ti on 04/12/2016.
 */

public class ImovelDAO {
    private static Banco banco;


    public static void adicionarImovel(Context context, Imovel imovel){
        banco = new Banco(context);
        long id = banco.inserirImovel(imovel);
        Toast.makeText(context, "ID: " + id, Toast.LENGTH_LONG).show();
    }

    public static void atualizarImovel(Context context, Imovel imovel, int id){
        banco = new Banco(context);
        long id2 = banco.atualizarImovel(imovel, id);
    }


    public static List<Imovel> listarImoveis (Context context){
        banco = new Banco(context);
        return banco.retornarImoveis();
    }

    public static List<Imovel> listarImoveisPesqUsu (Context context, String bairro, String cidade, int qt, String op){
        banco = new Banco(context);
        return banco.retornarImoveisPesqUsu(bairro, cidade, qt, op);
    }

    public static List<Imovel> listarImoveisPesqAdmin (Context context, String bairro){
        banco = new Banco(context);
        return banco.retornarImoveisPesqAdmin(bairro);
    }


}

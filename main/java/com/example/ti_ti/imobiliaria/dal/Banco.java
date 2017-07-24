package com.example.ti_ti.imobiliaria.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.ti_ti.imobiliaria.model.Imovel;
import com.example.ti_ti.imobiliaria.view.MainActivity;


import java.util.ArrayList;
import java.util.List;

import static com.example.ti_ti.imobiliaria.R.id.title;

/**
 * Created by ti_ti on 04/12/2016.
 */

public class Banco extends SQLiteOpenHelper {


    private static final String NOME_DO_BANCO = "Imoveis.db";
    private static final int VERSAO_DO_BANCO = 2;

    private static final String TIPO_TEXTO = " TEXT";
    private static final String TIPO_INTEIRO = " INTEGER";
    private static final String VIRGULA = ",";

    public static final String SQL_CRIAR_TABELA_IMOVEL =
            "CREATE TABLE " + Contrato.TabelaImovel.NOME_DA_TABELA + "( " +
                    Contrato.TabelaImovel.COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY" + VIRGULA +
                    Contrato.TabelaImovel.COLUNA_FINALIDADE + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaImovel.COLUNA_ENDERECO + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaImovel.COLUNA_NUMERO + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaImovel.COLUNA_COMPLEMENTO + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaImovel.COLUNA_BAIRRO + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaImovel.COLUNA_CIDADE + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaImovel.COLUNA_QUARTOS + TIPO_INTEIRO + VIRGULA +
                    Contrato.TabelaImovel.COLUNA_VALOR + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaImovel.COLUNA_DESCRICAO + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaImovel.COLUNA_FOTO + TIPO_TEXTO + " )";

    public Banco(Context context) {
        super(context, NOME_DO_BANCO, null, VERSAO_DO_BANCO);
    }



    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CRIAR_TABELA_IMOVEL);

    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            db.execSQL("ALTER TABLE "+Contrato.TabelaImovel.NOME_DA_TABELA+" ADD COLUMN "+Contrato.TabelaImovel.COLUNA_TELEFONE+" TEXT DEFAULT 0");
        }
    }



    public long inserirImovel(Imovel i){
        SQLiteDatabase banco = getWritableDatabase();//ALTERAR, INSERIR OU REMOVER

        ContentValues registro = new ContentValues();//PRA PODER ESPECIFICAR A COLUNA E A INFORMAÇÃO
        registro.put(Contrato.TabelaImovel.COLUNA_FINALIDADE, i.getFinalidade());
        registro.put(Contrato.TabelaImovel.COLUNA_ENDERECO, i.getEndereco());
        registro.put(Contrato.TabelaImovel.COLUNA_NUMERO, i.getNumero());
        registro.put(Contrato.TabelaImovel.COLUNA_COMPLEMENTO, i.getComplemento());
        registro.put(Contrato.TabelaImovel.COLUNA_BAIRRO, i.getBairro());
        registro.put(Contrato.TabelaImovel.COLUNA_CIDADE, i.getCidade());
        registro.put(Contrato.TabelaImovel.COLUNA_QUARTOS, i.getQuartos());
        registro.put(Contrato.TabelaImovel.COLUNA_VALOR, i.getValor());
        registro.put(Contrato.TabelaImovel.COLUNA_DESCRICAO, i.getDescricao());
        registro.put(Contrato.TabelaImovel.COLUNA_FOTO, i.getFoto());
        registro.put(Contrato.TabelaImovel.COLUNA_TELEFONE,i.getTelefone());

        return banco.insert(Contrato.TabelaImovel.NOME_DA_TABELA, null, registro);// SEMPRE RETORNA O ID DO REGISTRO INSERIDO, SE FOR = A -1 DEU PROBLEMA
    }

    //******************************************************************************************************


    public long atualizarImovel(Imovel i, int id){
        SQLiteDatabase banco = getReadableDatabase();

        ContentValues registro = new ContentValues();

        registro.put(Contrato.TabelaImovel.COLUNA_FINALIDADE, i.getFinalidade());
        registro.put(Contrato.TabelaImovel.COLUNA_ENDERECO, i.getEndereco());
        registro.put(Contrato.TabelaImovel.COLUNA_NUMERO, i.getNumero());
        registro.put(Contrato.TabelaImovel.COLUNA_COMPLEMENTO, i.getComplemento());
        registro.put(Contrato.TabelaImovel.COLUNA_BAIRRO, i.getBairro());
        registro.put(Contrato.TabelaImovel.COLUNA_CIDADE, i.getCidade());
        registro.put(Contrato.TabelaImovel.COLUNA_QUARTOS, i.getQuartos());
        registro.put(Contrato.TabelaImovel.COLUNA_VALOR, i.getValor());
        registro.put(Contrato.TabelaImovel.COLUNA_DESCRICAO, i.getDescricao());
        registro.put(Contrato.TabelaImovel.COLUNA_FOTO, i.getFoto());
        registro.put(Contrato.TabelaImovel.COLUNA_TELEFONE,i.getTelefone());

        String selection = Contrato.TabelaImovel.COLUNA_ID + " LIKE ?";
        String[] selectionArgs = { ""+id};

        return banco.update(Contrato.TabelaImovel.NOME_DA_TABELA, registro, selection, selectionArgs);
    }

//********************************************************************************************************************

    //EXCLUIR
    public long excluirImovel(int id) {
        SQLiteDatabase banco = getWritableDatabase();//ALTERAR, INSERIR OU REMOVER
        String selecaoExcluir = Contrato.TabelaImovel.COLUNA_ID + " LIKE ?";
        String[] parametrosExcluir = {""+id};
        return banco.delete(Contrato.TabelaImovel.NOME_DA_TABELA, selecaoExcluir, parametrosExcluir);
    }

//********************************************************************************************************************


    public List<Imovel> retornarImoveis(){
        SQLiteDatabase banco = getReadableDatabase();
        List<Imovel> imoveis = new ArrayList<Imovel>();
        Imovel i;

        String[] colunas = {
                Contrato.TabelaImovel.COLUNA_ID,
                Contrato.TabelaImovel.COLUNA_FINALIDADE,
                Contrato.TabelaImovel.COLUNA_ENDERECO,
                Contrato.TabelaImovel.COLUNA_NUMERO,
                Contrato.TabelaImovel.COLUNA_COMPLEMENTO,
                Contrato.TabelaImovel.COLUNA_BAIRRO,
                Contrato.TabelaImovel.COLUNA_CIDADE,
                Contrato.TabelaImovel.COLUNA_QUARTOS,
                Contrato.TabelaImovel.COLUNA_VALOR,
                Contrato.TabelaImovel.COLUNA_DESCRICAO,
                Contrato.TabelaImovel.COLUNA_TELEFONE,
                Contrato.TabelaImovel.COLUNA_FOTO
        };

        Cursor cursor = banco.query(
                Contrato.TabelaImovel.NOME_DA_TABELA,
                colunas, null, null, null, null, null //para listar tudo
        );

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                i = new Imovel();
                int indexId = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_ID);
                int indexFinalidade = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_FINALIDADE);
                int indexEndereco = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_ENDERECO);
                int indexNumero = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_NUMERO);
                int indexComplemento = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_COMPLEMENTO);
                int indexBairro = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_BAIRRO);
                int indexCidade = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_CIDADE);
                int indexQuartos = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_QUARTOS);
                int indexValor = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_VALOR);
                int indexDescricao = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_DESCRICAO);
                int indexTelefone = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_TELEFONE);
                int indexFoto = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_FOTO);
                i.setId(cursor.getInt(indexId));
                i.setFinalidade(cursor.getString(indexFinalidade));
                i.setEndereco(cursor.getString(indexEndereco));
                i.setNumero(cursor.getString(indexNumero));
                i.setComplemento(cursor.getString(indexComplemento));
                i.setBairro(cursor.getString(indexBairro));
                i.setCidade(cursor.getString(indexCidade));
                i.setQuartos(cursor.getInt(indexQuartos));
                i.setValor(cursor.getString(indexValor));
                i.setDescricao(cursor.getString(indexDescricao));
                i.setTelefone(cursor.getString(indexTelefone));
                i.setFoto(cursor.getString(indexFoto));

                imoveis.add(i);
            }while (cursor.moveToNext());
        }
        return imoveis;
    }

    //********************************************************************************************************************

    public List<Imovel> retornarImoveisPesqUsu(String bairro, String cidade, int qt, String op){
        SQLiteDatabase banco = getReadableDatabase();
        List<Imovel> imoveis = new ArrayList<Imovel>();
        Imovel i;
        String quartos = String.valueOf(qt);


        String[] colunas = {
                Contrato.TabelaImovel.COLUNA_ID,
                Contrato.TabelaImovel.COLUNA_FINALIDADE,
                Contrato.TabelaImovel.COLUNA_ENDERECO,
                Contrato.TabelaImovel.COLUNA_NUMERO,
                Contrato.TabelaImovel.COLUNA_COMPLEMENTO,
                Contrato.TabelaImovel.COLUNA_BAIRRO,
                Contrato.TabelaImovel.COLUNA_CIDADE,
                Contrato.TabelaImovel.COLUNA_QUARTOS,
                Contrato.TabelaImovel.COLUNA_VALOR,
                Contrato.TabelaImovel.COLUNA_DESCRICAO,
                Contrato.TabelaImovel.COLUNA_TELEFONE,
                Contrato.TabelaImovel.COLUNA_FOTO
        };


   String selecao = Contrato.TabelaImovel.COLUNA_FINALIDADE + " = ? AND "
                + Contrato.TabelaImovel.COLUNA_QUARTOS + " = ? AND "
           + Contrato.TabelaImovel.COLUNA_BAIRRO + " = ? AND "
           + Contrato.TabelaImovel.COLUNA_CIDADE + " = ?";
        String[] parametros = {op, quartos, bairro, cidade};



        Cursor cursor = banco.query(
                Contrato.TabelaImovel.NOME_DA_TABELA,
                colunas, selecao, parametros, null, null, null
        );

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                i = new Imovel();
                int indexId = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_ID);
                int indexFinalidade = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_FINALIDADE);
                int indexEndereco = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_ENDERECO);
                int indexNumero = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_NUMERO);
                int indexComplemento = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_COMPLEMENTO);
                int indexBairro = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_BAIRRO);
                int indexCidade = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_CIDADE);
                int indexQuartos = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_QUARTOS);
                int indexValor = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_VALOR);
                int indexDescricao = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_DESCRICAO);
                int indexTelefone = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_TELEFONE);
                int indexFoto = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_FOTO);
                i.setId(cursor.getInt(indexId));
                i.setFinalidade(cursor.getString(indexFinalidade));
                i.setEndereco(cursor.getString(indexEndereco));
                i.setNumero(cursor.getString(indexNumero));
                i.setComplemento(cursor.getString(indexComplemento));
                i.setBairro(cursor.getString(indexBairro));
                i.setCidade(cursor.getString(indexCidade));
                i.setQuartos(cursor.getInt(indexQuartos));
                i.setValor(cursor.getString(indexValor));
                i.setDescricao(cursor.getString(indexDescricao));
                i.setTelefone(cursor.getString(indexTelefone));
                i.setFoto(cursor.getString(indexFoto));

                imoveis.add(i);
            }while (cursor.moveToNext());
        }
        return imoveis;
    }


//********************************************************************************************************************


    public List<Imovel> retornarImoveisPesqAdmin(String bairro){
        SQLiteDatabase banco = getReadableDatabase();
        List<Imovel> imoveis = new ArrayList<Imovel>();
        Imovel i;

        String[] colunas = {
                Contrato.TabelaImovel.COLUNA_ID,
                Contrato.TabelaImovel.COLUNA_FINALIDADE,
                Contrato.TabelaImovel.COLUNA_ENDERECO,
                Contrato.TabelaImovel.COLUNA_NUMERO,
                Contrato.TabelaImovel.COLUNA_COMPLEMENTO,
                Contrato.TabelaImovel.COLUNA_BAIRRO,
                Contrato.TabelaImovel.COLUNA_CIDADE,
                Contrato.TabelaImovel.COLUNA_QUARTOS,
                Contrato.TabelaImovel.COLUNA_VALOR,
                Contrato.TabelaImovel.COLUNA_DESCRICAO,
                Contrato.TabelaImovel.COLUNA_TELEFONE,
                Contrato.TabelaImovel.COLUNA_FOTO
        };

        String selecao = Contrato.TabelaImovel.COLUNA_BAIRRO + " = ?";

        String[] parametros = {bairro};


        Cursor cursor = banco.query(
                Contrato.TabelaImovel.NOME_DA_TABELA,
                colunas, selecao, parametros, null, null, null
        );

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                i = new Imovel();
                int indexId = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_ID);
                int indexFinalidade = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_FINALIDADE);
                int indexEndereco = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_ENDERECO);
                int indexNumero = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_NUMERO);
                int indexComplemento = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_COMPLEMENTO);
                int indexBairro = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_BAIRRO);
                int indexCidade = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_CIDADE);
                int indexQuartos = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_QUARTOS);
                int indexValor = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_VALOR);
                int indexDescricao = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_DESCRICAO);
                int indexTelefone = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_TELEFONE);
                int indexFoto = cursor.getColumnIndexOrThrow(Contrato.TabelaImovel.COLUNA_FOTO);
                i.setId(cursor.getInt(indexId));
                i.setFinalidade(cursor.getString(indexFinalidade));
                i.setEndereco(cursor.getString(indexEndereco));
                i.setNumero(cursor.getString(indexNumero));
                i.setComplemento(cursor.getString(indexComplemento));
                i.setBairro(cursor.getString(indexBairro));
                i.setCidade(cursor.getString(indexCidade));
                i.setQuartos(cursor.getInt(indexQuartos));
                i.setValor(cursor.getString(indexValor));
                i.setDescricao(cursor.getString(indexDescricao));
                i.setTelefone(cursor.getString(indexTelefone));
                i.setFoto(cursor.getString(indexFoto));

                imoveis.add(i);
            }while (cursor.moveToNext());
        }
        return imoveis;
    }

}

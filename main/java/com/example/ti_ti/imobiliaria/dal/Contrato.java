package com.example.ti_ti.imobiliaria.dal;

import android.provider.BaseColumns;

/**
 * Created by ti_ti on 04/12/2016.
 */

public final class Contrato {

    public static class TabelaImovel implements BaseColumns {

        public final static String NOME_DA_TABELA = "TabelaImovel";
        public final static String COLUNA_ID = "Id";
        public final static String COLUNA_FINALIDADE ="Finalidade";
        public final static String COLUNA_ENDERECO = "Endereco";
        public final static String COLUNA_NUMERO ="Numero";
        public final static String COLUNA_COMPLEMENTO = "Complemento";
        public final static String COLUNA_BAIRRO = "Bairro";
        public final static String COLUNA_CIDADE ="Cidade";
        public final static String COLUNA_QUARTOS= "Quartos";
        public final static String COLUNA_VALOR = "Valor";
        public final static String COLUNA_DESCRICAO = "Descricao";
        public final static String COLUNA_TELEFONE = "Telefone";
        public final static String COLUNA_FOTO = "Foto";
        // o nome da coluna é do tipo string
    }
}

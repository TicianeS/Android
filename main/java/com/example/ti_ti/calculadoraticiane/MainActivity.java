package com.example.ti_ti.calculadoraticiane;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt_dados, txt_valor;
    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_ponto,
            btn_mais, btn_menos, btn_vezes, btn_divi, btn_igual, btn_limpar, btn_corrigir;
    String valor, op;
    Double result=0; Double numero= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_dados = (TextView) findViewById(R.id.txtDados);
        txt_valor = (TextView) findViewById(R.id.txtValor);
        btn_0 = (Button) findViewById(R.id.btn0);
        btn_1 = (Button) findViewById(R.id.btn1);
        btn_2 = (Button) findViewById(R.id.btn2);
        btn_3 = (Button) findViewById(R.id.btn3);
        btn_4 = (Button) findViewById(R.id.btn4);
        btn_5 = (Button) findViewById(R.id.btn5);
        btn_6 = (Button) findViewById(R.id.btn6);
        btn_7 = (Button) findViewById(R.id.btn7);
        btn_8 = (Button) findViewById(R.id.btn8);
        btn_9 = (Button) findViewById(R.id.btn9);
        btn_ponto = (Button) findViewById(R.id.btnPonto);
        btn_mais = (Button) findViewById(R.id.btnAdicao);
        btn_menos = (Button) findViewById(R.id.btnSubtracao);
        btn_vezes = (Button) findViewById(R.id.btnMultiplicacao);
        btn_divi = (Button) findViewById(R.id.btnDivisao);
        btn_igual = (Button) findViewById(R.id.btnIgual);
        btn_limpar = (Button) findViewById(R.id.btnLimpar);
        btn_corrigir = (Button) findViewById(R.id.btnCorrigir);
    }


    public void preencherDados() {
        txt_dados.setText(txt_dados.getText()+""+txt_valor.getText()+op);
    }

    public void preencherValor(String num) {
        txt_valor.setText(txt_valor.getText()+num);
    }

    public void btnLimparClick(View view) {
        txt_valor.setText("");
        txt_dados.setText("");
        valor = "";
        op = "";
    }

    public void btnCorrigirClick(View view) {
        valor = (String) txt_valor.getText();
        if (!valor.isEmpty()){
            valor = valor.substring (0, valor.length() - 1);
        }
        txt_valor.setText(valor);
    }

    public void btn7Click(View view) {
        preencherValor("7");
    }

    public void btn8Click(View view) {
        preencherValor("8");
    }

    public void btn9Click(View view) {
        preencherValor("9");
    }

    public void btnMultiplicacaoClick(View view) {
        op = "*";
        preencherDados();
        operacao();
    }

    public void btn4Click(View view) {
        preencherValor("4");
    }

    public void btn5Click(View view) {
        preencherValor("5");
    }

    public void btn6Click(View view) {
        preencherValor("6");
    }

    public void btnDivisaoClick(View view) {
        op = "/";
        preencherDados();
        operacao();
    }

    public void btn1Click(View view) {
        preencherValor("1");
    }

    public void btn2Click(View view) {
        preencherValor("2");
    }

    public void btn3Click(View view) {
        preencherValor("3");
    }

    public void btnSubtracaoClick(View view) {
        op = "-";
        preencherDados();
        operacao();
    }

    public void btnIgualClick(View view) {
    }

    public void btn0Click(View view) {
        preencherValor("0");
    }

    public void btnPontoClick(View view) {
        if(!txt_valor.getText().toString().contains(".")){
            txt_valor.setText(txt_valor.getText()+".");
        }
    }

    public void btnAdicaoClick(View view) {
        op = "+";
        preencherDados();
        operacao();
    }

    public void operacao(){
        numero = Double.parseDouble(txt_valor.getText().toString());
        switch (op){
            case "+":
                result = result + numero;
                break;
            case "-":
                result = result - numero;
                break;
            case "*":
                result = result * numero;
                break;
            case "/":
                result = result / numero;
                break;
            default:
                break;
        }

        txt_valor.setText(result+"");
    }
}

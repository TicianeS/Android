package com.example.ti_ti.jogodavelha;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView txtMsg;
    Button btnPos1, btnPos2, btnPos3, btnPos4, btnPos5, btnPos6, btnPos7, btnPos8, btnPos9;

    int jogador=1, fim=0, jogadas=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPos1 = (Button) findViewById(R.id.btnPos1);
        btnPos2 = (Button) findViewById(R.id.btnPos2);
        btnPos3 = (Button) findViewById(R.id.btnPos3);
        btnPos4 = (Button) findViewById(R.id.btnPos4);
        btnPos5 = (Button) findViewById(R.id.btnPos5);
        btnPos6 = (Button) findViewById(R.id.btnPos6);
        btnPos7 = (Button) findViewById(R.id.btnPos7);
        btnPos8 = (Button) findViewById(R.id.btnPos8);
        btnPos9 = (Button) findViewById(R.id.btnPos9);
        txtMsg = (TextView) findViewById(R.id.txtMsg);

        txtMsg.setText("Jogador " + jogador);

        //gerar click do botao 9 pelo código
       /* btnPos9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

    }

    public void preencherBotao (View view){
        Button btn = (Button) view; // converte a view em botão
            if(btn.getText().toString().equals("")){
                if (jogador == 1){
                    btn.setText("X");
                    jogador = 2;
                }else {
                    btn.setText("O");
                    jogador = 1;
                }
                verificar();
            }
    }

    public void ganhou() {
        //personalizar a mensagem
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("TicTacToe"); //título
        builder.setMessage("Deseja reiniciar?"); // mensagem
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Novo Jogo", Toast.LENGTH_LONG).show();
                //zerar o jogo
                jogador=1; fim=0; jogadas=0;
                txtMsg.setText("Jogador " + jogador);
                btnPos1.setText("");
                btnPos2.setText("");
                btnPos3.setText("");
                btnPos4.setText("");
                btnPos5.setText("");
                btnPos6.setText("");
                btnPos7.setText("");
                btnPos8.setText("");
                btnPos9.setText("");
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // não se usa código para sair da aplicação
            }
        });

        // criar a caixa de diálogo
        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false); // não deixa clicar fora da caixa de diálogo

        //mostrar na tela
        alertDialog.show();
    }

    /*public void btnPos2(View view) {
        btnPos2.setText(jogar(btnPos2.getText().toString()));
        verificar();
    }

    public void btnPos3(View view) {
        btnPos3.setText(jogar(btnPos3.getText().toString()));
        verificar();
    }

    public void btnPos4(View view) {
        btnPos4.setText(jogar(btnPos4.getText().toString()));
        verificar();
    }

    public void btnPos5(View view) {
        btnPos5.setText(jogar(btnPos5.getText().toString()));
        verificar();
    }

    public void btnPos6(View view) {
        btnPos6.setText(jogar(btnPos6.getText().toString()));
        verificar();
    }

    public void btnPos7(View view) {
        btnPos7.setText(jogar(btnPos7.getText().toString()));
        verificar();
    }

    public void btnPos9(View view) {
        btnPos9.setText(jogar(btnPos9.getText().toString()));
        verificar();
    }

    public void btnPos8(View view) {
        btnPos8.setText(jogar(btnPos8.getText().toString()));
        verificar();
    }*/

    public void verificar (){
        jogadas++;
        if (btnPos2.getText().toString()!="" && btnPos1.getText().toString()==btnPos2.getText().toString() && btnPos1.getText().toString()==btnPos3.getText().toString()){
            jogadores(btnPos2.getText().toString());
        } else{
            if (btnPos4.getText().toString()!="" && btnPos1.getText().toString()==btnPos4.getText().toString() && btnPos1.getText().toString()==btnPos7.getText().toString()){
                jogadores(btnPos4.getText().toString());
            } else {
                if (btnPos5.getText().toString()!="" && btnPos1.getText().toString()==btnPos5.getText().toString() && btnPos1.getText().toString()==btnPos9.getText().toString()){
                    jogadores(btnPos5.getText().toString());
                } else {
                    if (btnPos5.getText().toString()!="" && btnPos4.getText().toString()==btnPos5.getText().toString() && btnPos4.getText().toString()==btnPos6.getText().toString()){
                        jogadores(btnPos5.getText().toString());
                    } else {
                        if (btnPos8.getText().toString()!="" && btnPos7.getText().toString()==btnPos8.getText().toString() && btnPos7.getText().toString()==btnPos9.getText().toString()){
                            jogadores(btnPos8.getText().toString());
                        } else {
                            if (btnPos5.getText().toString()!="" && btnPos2.getText().toString()==btnPos5.getText().toString() && btnPos2.getText().toString()==btnPos8.getText().toString()){
                                jogadores(btnPos5.getText().toString());
                            } else {
                                if (btnPos5.getText().toString()!="" && btnPos3.getText().toString()==btnPos5.getText().toString() && btnPos3.getText().toString()==btnPos7.getText().toString()){
                                    jogadores(btnPos5.getText().toString());
                                } else {
                                    if (btnPos6.getText().toString()!="" && btnPos3.getText().toString()==btnPos6.getText().toString() && btnPos3.getText().toString()==btnPos9.getText().toString()){
                                        jogadores(btnPos6.getText().toString());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (fim == 0 && jogadas < 9) {
            txtMsg.setText("Jogador " + jogador);
        }else {
            if (fim == 0 && jogadas == 9){
                txtMsg.setText("*** EMPATE ***");
                ganhou();
            }
        }

    }

    public void jogadores(String a){
        if (a =="X"){
            txtMsg.setText("O jogador 1 venceu!!");
            ganhou();
        }else {
            txtMsg.setText("O jogador 2 venceu!!");
            ganhou();
        }
        fim =1;

    }

   /* public String jogar(String a){
        if (a=="" && fim==0) {
            if (jogador == 1) {
                jogador = 2;
                return "X";
            } else {
                jogador = 1;
                return "O";
            }
        }else {
            return a;
        }
    }*/
}


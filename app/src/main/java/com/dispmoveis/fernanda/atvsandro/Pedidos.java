package com.dispmoveis.fernanda.atvsandro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Pedidos extends AppCompatActivity {


    private EditText nomepedido;
    private CheckBox creme;
    private CheckBox chocolate;
    private TextView quantidade;
    private TextView pedidos;
    private Button mais;
    private Button menos;
    private Button fazerPedido;
    private int quant =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        fazerPedido =  findViewById(R.id.btnPedido);

       final Pedido p = new Pedido();


        fazerPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Salvar(p);
            }
        });


    }




   public void Mais(View view){

        quantidade = findViewById(R.id.txtQuantidade);

        quant = quant +1;
        quantidade.setText(""+quant);

   }

    public void Menos(View view){

        quantidade = findViewById(R.id.txtQuantidade);
        quant = quant -1;
        quantidade.setText(""+ quant);

    }

    public void Salvar(Pedido p){
        pedidos = findViewById(R.id.txtPedido);
        creme = findViewById(R.id.checkBox);
        chocolate = findViewById(R.id.checkBox2);

        nomepedido = findViewById(R.id.idPedido);
        p.setNome(nomepedido.getText().toString());
        p.setQuantidade(quant);

        if(chocolate.isChecked()){
            p.setChocolate("Chocolate");
        }
        if(creme.isChecked()){
            p.setCreme("Creme");
        }

        pedidos.setText(p.getNome()+" , "+p.getCreme()+" , "+p.getChocolate()+" , "+p.getQuantidade());

    }


 public void Ovo(View view){
        startActivity(new Intent(Pedidos.this, MainActivity.class));
    }
}

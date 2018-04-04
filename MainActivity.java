package com.dispmoveis.fernanda.atvsandro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   private Button btn;
   private TextView quilo;
   private TextView mensagem;
   private ImageView img;
   private int Calcular;
   private Button btnAtv2;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quilo = findViewById(R.id.idQuilo);


        quilo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() ==   MotionEvent.ACTION_DOWN){
                    quilo.setText("");
                }

                return false;
            }
        });
    }


    public void Mensagem(View view){
        quilo = findViewById(R.id.idQuilo);
        mensagem = findViewById(R.id.txtMensagem);
        img = findViewById(R.id.img);

        int quilon = Integer.parseInt(quilo.getText().toString());
        int valor = (quilon * 1000) /500;

        img.setVisibility(View.VISIBLE);

        mensagem.setText("Com "+ quilon+ "kg pode se fazer "+valor+" ovos de 500g.");

    }

    public void Pedido(View view){
        startActivity(new Intent(MainActivity.this, Pedidos.class));
    }




}

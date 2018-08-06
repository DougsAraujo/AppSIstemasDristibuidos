package com.example.douglas.trabsd;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ActivityCompras extends AppCompatActivity {

    private ListView lista2;
    private TextView produto,valor;
    private Button adicionar,finalizar;
    private EditText quantidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        finalizar = (Button) findViewById(R.id.finalizar);

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastFinalizado();
            }
        });

        lista2 = (ListView) findViewById(R.id.lista_produtos);

        final ActionBar abar = getSupportActionBar();
        abar.setDisplayHomeAsUpEnabled(true);


        final List<produtos_compras> local2 = new ArrayList<produtos_compras>();

        local2.add(new produtos_compras("Óleo liza","R$3.25"));
        local2.add(new produtos_compras("Colgate Luminous White","R$4.00"));
        local2.add(new produtos_compras("Pilha Energizer","R$5.00"));
        local2.add(new produtos_compras("Chocolate Baton","R$2.50"));

         class AdapterCompras extends BaseAdapter {

            int[] IMAGES2 = {R.drawable.oleo,R.drawable.creme,R.drawable.pilha,R.drawable.baton};

            @Override
            public int getCount(){
                return IMAGES2.length;

            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {

                view = getLayoutInflater().inflate(R.layout.compra_produtos, null);

                ImageView imagem2 = (ImageView) view.findViewById(R.id.imagemproduto);
                produto = (TextView) view.findViewById(R.id.produto);
                valor = (TextView) view.findViewById(R.id.preco);
                adicionar = (Button) view.findViewById(R.id.adicionar);
                quantidade = (EditText) view.findViewById(R.id.quantidade);
                adicionar = (Button)view.findViewById(R.id.adicionar);

                imagem2.setImageResource(IMAGES2[i]);

                produto.setText(local2.get(i).getProduto());
                valor.setText(local2.get(i).getPreco());

                adicionar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toastadicionar();
                    }
                });

                return view;

            }


        }

        AdapterCompras customAdapter = new AdapterCompras();
        lista2.setAdapter(customAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu) {

        Intent i = new Intent(getApplicationContext(), Activity_mercados.class);
        finish();
        return true;

    }

    public void Toastadicionar(){

        Toast.makeText(this, "Adicionado com sucesso", Toast.LENGTH_SHORT).show();
    }

    public void ToastFinalizado(){

        Toast.makeText(this, "Compra registrada", Toast.LENGTH_SHORT).show();
    }



}




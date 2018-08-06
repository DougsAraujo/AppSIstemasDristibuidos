package com.example.douglas.trabsd;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Activity_mercados extends AppCompatActivity {

    private ListView lista;
    private TextView referencia;
    int[] IMAGES = {R.drawable.img1,R.drawable.img2,R.drawable.img3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercados);

        final ActionBar abar = getSupportActionBar();
        abar.setDisplayHomeAsUpEnabled(true);


        lista = (ListView) findViewById(R.id.lista);

        final List<mercado> local = new ArrayList<mercado>();

        local.add(new mercado("Ao lado do Lavras Shooping"));
        local.add(new mercado(("Próximo a Selt")));
        local.add(new mercado(("Próximo ao Expolavras")));

        class CustomAdapter extends BaseAdapter {

            @Override
            public int getCount(){
                return IMAGES.length;

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

                view = getLayoutInflater().inflate(R.layout.custom, null);

                ImageView imagem = (ImageView)view.findViewById(R.id.imagem);
                TextView referencia = (TextView)view.findViewById(R.id.ref);


                String ref = local.get(i).getReferencia();


                imagem.setImageResource(IMAGES[i]);
                referencia.setText(ref);

                return view;

            }

        }
        CustomAdapter customAdapter = new CustomAdapter();
        lista.setAdapter(customAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent x = getIntent();
                Bundle bundle = x.getExtras();
                Intent i = new Intent(Activity_mercados.this, ActivityCompras.class);
                i.putExtras(bundle);
                Log.d("AQUIIIIIIIIIIIIII", String.valueOf(bundle.getInt("id")));
                startActivity(i);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menu) {

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        finish();
        return true;

    }

}

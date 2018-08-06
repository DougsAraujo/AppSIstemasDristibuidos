package com.example.douglas.trabsd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AdminAcitivy extends AppCompatActivity {

    private Retrofit retrofit;
    private Services services;
    private ListView lista_compras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_acitivy);

        lista_compras = (ListView) findViewById(R.id.lista_admin);

        RetrofitInicializador conexao = new  RetrofitInicializador();
        retrofit = conexao.getInitiator();
        services = retrofit.create(Services.class);


        Call call = services.comprasusuarios();
        call.enqueue(new Callback<List<ComprasUsuario>>(){
            @Override
            public void onResponse(Call<List<ComprasUsuario>> call, Response<List<ComprasUsuario>> response) {

                List<ComprasUsuario> listaCompras;
                listaCompras = response.body();
                final AdapterAdmin adapterAdmin = new AdapterAdmin(listaCompras, getApplicationContext());
                lista_compras.setAdapter(adapterAdmin);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
            Log.d("ERROOOOOOOO", t.getMessage());
            }
        });

    }
}

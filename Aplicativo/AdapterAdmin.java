package com.example.douglas.trabsd;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Douglas on 16/08/2017.
 */

public class AdapterAdmin extends BaseAdapter {

    private List<ComprasUsuario> comprasUsuarios;
    private LayoutInflater layoutInflater;
    private Context context;


    public AdapterAdmin(List<ComprasUsuario> empresas, Context context){
        this.context = context;
        this.layoutInflater = (LayoutInflater.from(context));
        this.comprasUsuarios = empresas;
    }

    @Override
    public int getCount() {
        return comprasUsuarios.size();
    }

    @Override
    public Object getItem(int position) {
        return comprasUsuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = layoutInflater.inflate(R.layout.admin,null);

        ComprasUsuario ComprasUsuario = comprasUsuarios.get(position);


        TextView nome;
        nome = (TextView) view.findViewById(R.id.usuario_compra);
        nome.setText(ComprasUsuario.getUsuario());


        TextView data;
        data = (TextView) view.findViewById(R.id.data_compra);
        data.setText(ComprasUsuario.getData());

        TextView produtos;
        produtos = (TextView) view.findViewById(R.id.produtos_compra);
        produtos.setText(ComprasUsuario.getProduto());

        TextView preco;
        preco = (TextView) view.findViewById(R.id.total_compra);
        String total = String.valueOf(ComprasUsuario.getTotal());
        preco.setText("R$"+total);

        TextView endereco;
        endereco = (TextView) view.findViewById(R.id.endereco_compra);
        endereco.setText(ComprasUsuario.getEndereco());

        Button btnadmin;
        btnadmin = (Button) view.findViewById(R.id.finalizar);

        final TextView status;
        status = (TextView) view.findViewById(R.id.status);

        btnadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status.setText("Compra iniciada");
               status.setTextColor(Color.parseColor("#3F51B5"));
            }
        });
        return view;
    }
}

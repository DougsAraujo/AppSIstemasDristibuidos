package com.example.douglas.trabsd;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Douglas on 16/08/2017.
 */

public class ComprasUsuario implements Serializable {

    private String usuario,produto,data_compra, endereco;
    private Double preco;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ComprasUsuario(String usuario, String produto, String data, Double total, String endereco) {
        this.usuario = usuario;
        this.produto = produto;
        this.data_compra = data;
        this.preco = total;
        this.endereco = endereco;

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getData() {
        return data_compra;
    }

    public void setData(String data) {
        this.data_compra = data;
    }

    public Double getTotal() {
        return preco;
    }

    public void setTotal(Double total) {
        this.preco = total;
    }
}

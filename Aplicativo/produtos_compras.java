package com.example.douglas.trabsd;

/**
 * Created by Douglas on 16/08/2017.
 */

public class produtos_compras {

    private String produto;
    private String preco;

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public produtos_compras(String produto, String preco) {

        this.produto = produto;
        this.preco = preco;
    }
}

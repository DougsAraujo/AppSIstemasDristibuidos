/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

/**
 *
 * @author T-Gamer
 */
public class Compras {
    
    private String produto;
    private Integer quantidade;
    private String endereco;
    private double preco;
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
   

    Compras(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Compras{" + "produto=" + produto + ", quantidade=" + quantidade + ", preco=" + preco + '}';
    }

    public Compras(String produto, Integer quantidade, double preco, String endereco) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.endereco = endereco;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

/**
 *
 * @author Douglas
 */
public class Compra_usuario {
    
    private int id_usuario;
    private String usuario;
    private String produto;
    private String data_compra;
    private Double preco;
    private String endereco;
    
    @Override
    public String toString() {
        return "Compra_usuario{" + "id_usuario=" + id_usuario + ", usuario=" + usuario + ", produto=" + produto + ", data_compra=" + data_compra + '}';
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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

    public String getData_compra() {
        return data_compra;
    }

    public void setData_compra(String data_compra) {
        this.data_compra = data_compra;
    }

    public Compra_usuario(int id_usuario, String usuario, String produto, String data_compra, Double preco, String endereco) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.produto = produto;
        this.data_compra = data_compra;
        this.preco = preco;
        this.endereco = endereco;
    }
    
}

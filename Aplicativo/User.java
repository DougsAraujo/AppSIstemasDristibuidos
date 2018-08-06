package com.example.douglas.trabsd;

import java.io.Serializable;

/**
 * Created by Douglas on 16/08/2017.
 */

public class User implements Serializable {

    private String user;
    private String senha;
    private String endereco;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "usuario='" + user + '\'' +
                ", senha='" + senha + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    public String getUsuario() {
        return user;
    }

    public void setUsuario(String usuario) {
        this.user = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public User(Integer id, String usuario, String senha, String endereco) {
        this.id = id;
        this.user = usuario;
        this.senha = senha;
        this.endereco = endereco;
    }
}

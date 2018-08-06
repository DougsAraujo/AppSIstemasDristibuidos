package com.example.douglas.trabsd;

import java.io.Serializable;

/**
 * Created by Douglas on 16/08/2017.
 */

public class UserLogin implements Serializable {

    private String user;
    private String senha;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UserLogin(String user, String senha) {

        this.user = user;
        this.senha = senha;
    }
}

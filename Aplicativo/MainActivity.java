package com.example.douglas.trabsd;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private EditText user;
    private EditText senha;
    private Button entrar;
    private TextView cadastro;
    private String nome,senha2;
    private TextView recu_senha;
    private Retrofit retrofit;
    private  Services services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.user);
        senha = (EditText) findViewById(R.id.senha);
        entrar = (Button) findViewById(R.id.entrar);
        recu_senha = (TextView) findViewById(R.id.senha);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RetrofitInicializador conexao = new  RetrofitInicializador();
                retrofit = conexao.getInitiator();
                services = retrofit.create(Services.class);

                final UserLogin userlogin = new UserLogin(user.getText().toString(), senha.getText().toString());
                Call call = services.verificalogin(userlogin.getUser().toString(),userlogin.getSenha().toString());
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {

                        User user;
                        user = response.body();
                        String admin = "Admin";
                        if(user != null){
                            if(admin.equals(userlogin.getUser())){
                                Intent x = new Intent(MainActivity.this, AdminAcitivy.class);
                                startActivity(x);
                            }else{
                                Intent i = new Intent(MainActivity.this, Activity_mercados.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("id", user.getId());
                                i.putExtras(bundle);
                                ToastSucesso();
                                startActivity(i);
                            }
                        }else{
                            ToastFalha();
                        }


                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Log.d("ERROOOO", t.getMessage());
                    }
                });
            }
        });


    }

    public void ToastSucesso(){

        Toast.makeText(this, "Logado com Sucesso!", Toast.LENGTH_SHORT).show();
    }
    public void ToastFalha(){

        Toast.makeText(this, "Usuário ou Senha Incorretos!", Toast.LENGTH_SHORT).show();
    }


}

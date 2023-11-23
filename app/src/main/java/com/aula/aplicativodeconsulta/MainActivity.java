package com.aula.aplicativodeconsulta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.aula.aplicativodeconsulta.activity.CadastroActivity;
import com.aula.aplicativodeconsulta.activity.LoginActivity;
import com.aula.aplicativodeconsulta.activity.PrimeiraActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageLogo;
    Button buttonLogin,buttonCadastro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregarXml();
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //toast("Button Login");
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        buttonCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //toast("Button Cadastro");

                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);

            }
        });
    }

    private void carregarXml() {
        imageLogo = findViewById(R.id.imageLogo);
        buttonCadastro = findViewById(R.id.buttonCadastro);
        buttonLogin = findViewById(R.id.buttonLogin);
    }
    private void toast(String msg){
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
        toast.show();
    }
}
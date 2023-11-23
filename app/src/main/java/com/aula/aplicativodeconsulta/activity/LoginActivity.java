package com.aula.aplicativodeconsulta.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aula.aplicativodeconsulta.MainActivity;
import com.aula.aplicativodeconsulta.R;

public class LoginActivity extends AppCompatActivity {

    EditText editText_email,editText_senha;
    Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        associarXml();
        findBtn();
    }

    private void associarXml(){
        editText_email = findViewById(R.id.editText_email);
        editText_senha = findViewById(R.id.editText_senha);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setEnabled(false); // Desativar o botão inicialmente
    }

    private void findBtn(){
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificarCampo()){
                    Intent intent = new Intent(LoginActivity.this, PrimeiraActivity.class);
                    startActivity(intent);
                }
            }
        });
        // Adicionando um TextWatcher para monitorar alterações nos campos
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Verificar os campos sempre que houver uma alteração
                verificarCampo();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        };

        editText_email.addTextChangedListener(textWatcher);
        editText_senha.addTextChangedListener(textWatcher);
    }

    private boolean verificarCampo() {
        String email = editText_email.getText().toString().trim();
        String senha = editText_senha.getText().toString().trim();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editText_email.setError("Insira um e-mail válido");
            return false;
        }

        if (senha.isEmpty() || senha.length() < 6) {
            editText_senha.setError("A senha deve ter pelo menos 6 caracteres");
            return false;
        }
        buttonLogin.setEnabled(true); // Habilitar o botão
        return true;
    }

    private void toast(String msg){
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
        toast.show();
    }
}
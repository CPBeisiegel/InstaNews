package com.example.instanews.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.instanews.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroActivity extends AppCompatActivity {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;
    private TextInputLayout editTextNome;
    private TextInputLayout editTextEmail;
    private TextInputLayout editTextSenha;
    private TextInputLayout editTextConfirmarSenha;
    private Button btnRegistrar;
    private Button btnCancelar;
    private String nome, email, senha, confirmarsenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        initViews();


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextEmail.setError(null);
                editTextSenha.setError(null);
                editTextConfirmarSenha.setError(null);

                validaCampos();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                irParaLogin();

            }
        });

    }

    public void irParaHome() {
        Intent intent = new Intent(CadastroActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void irParaLogin() {
        Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void initViews() {
        editTextNome = findViewById(R.id.textYourEntryNome);
        editTextEmail = findViewById(R.id.textYourEntryEmail);
        editTextSenha = findViewById(R.id.textYourEntrySenha);
        editTextConfirmarSenha = findViewById(R.id.textYourEntryConfirmarSenha);
        btnCancelar = findViewById(R.id.buttonCancelar);
        btnRegistrar = findViewById(R.id.buttonRegistrar);

    }

    public void validaCampos() {
        email = editTextEmail.getEditText().getText().toString().trim();
        nome = editTextNome.getEditText().getText().toString().trim();
        senha = editTextSenha.getEditText().getText().toString().trim();
        confirmarsenha = editTextConfirmarSenha.getEditText().getText().toString().trim();

        editTextNome.setError(null);
        editTextEmail.setError(null);
        editTextSenha.setError(null);
        editTextConfirmarSenha.setError(null);

        if (editTextNome.getEditText().toString().equals("")) {
            editTextNome.setError("Informe seu nome.");
        } else if (editTextEmail.getEditText().toString().equals("")) {
            editTextEmail.setError("Informe seu e-mail.");
        } else if (!validateEmail(editTextEmail.getEditText().toString())) {
            editTextEmail.setError("E-mail digitado incorretamente.");
        } else if (editTextSenha.getEditText().toString().equals("")) {
            editTextConfirmarSenha.setError("Informe sua senha.");
        } else if (!validatePassword(editTextSenha.getEditText().toString())) {
            editTextSenha.setError("Senha deve ter entre 6 e 14 caracteres");
        } else {
            irParaHome();
        }
    }

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        return password.length() > 5;

    }


}

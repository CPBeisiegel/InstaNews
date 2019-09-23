package com.example.instanews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cadastro extends AppCompatActivity {

    public final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
    private EditText editTextNome;
    private EditText editTextEmail;
    private EditText editTextSenha;
    private EditText editTextConfirmarSenha;
    private Button btnRegistrar;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        editTextConfirmarSenha = findViewById(R.id.editTextConfirmarSenha);
        btnCancelar = findViewById(R.id.buttonCancelar);
        btnRegistrar = findViewById(R.id.buttonRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextNome.setError(null);
                editTextEmail.setError(null);
                editTextSenha.setError(null);
                editTextConfirmarSenha.setError(null);

                if (editTextNome.getEditableText().toString().equals("")) {
                    editTextNome.setError("Informe seu nome.");
                } else if (editTextEmail.getEditableText().toString().equals("")) {
                    editTextEmail.setError("Informe seu e-mail.");
                } else if (!emailInvalido(editTextEmail.getEditableText().toString())) {
                    editTextEmail.setError("E-mail digitado incorretamente.");
                } else if (editTextSenha.getEditableText().toString().equals("")) {
                    editTextConfirmarSenha.setError("Informe sua senha.");
                } else if (!senhaValida(editTextSenha.getEditableText().toString())) {
                    editTextSenha.setError("Senha deve ter entre 6 e 14 caracteres");
                } else {
                    irParaHome();
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    irParaLogin();
            }
        });
    }

    // conferir se o formato da senha é valido
    private boolean senhaValida(String senha) {
        senha = senha.trim();
        return senha.length() >= 6 && senha.length() < 14 && textPattern.matcher(senha).matches();
    }

    // conferir se o email é invalido
    public static boolean emailInvalido(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

    //***Confirmar o nome da tela de Home e concluir metodo
    public void irParaHome(){
        // Intent intent = new Intent(this,Home.class);
        // startActivity(intent);
    }

    public void irParaLogin(){
        // Intent intent = new Intent(this,Home.class);
        // startActivity(intent);
    }


}

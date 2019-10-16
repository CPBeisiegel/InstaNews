package com.example.instanews.views.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.instanews.R;
import com.google.android.material.textfield.TextInputLayout;

public class CadastroActivity extends AppCompatActivity {

   // public final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
    private TextInputLayout editTextNome;
    private TextInputLayout editTextEmail;
    private TextInputLayout editTextSenha;
    private TextInputLayout editTextConfirmarSenha;
    private Button btnRegistrar;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editTextNome = findViewById(R.id.textYourEntryNome);
        editTextEmail = findViewById(R.id.textYourEntryEmail);
        editTextSenha = findViewById(R.id.textYourEntrySenha);
        editTextConfirmarSenha = findViewById(R.id.textYourEntryConfirmarSenha);
        btnCancelar = findViewById(R.id.buttonCancelar);
        btnRegistrar = findViewById(R.id.buttonRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextNome.setError(null);
                editTextEmail.setError(null);
                editTextSenha.setError(null);
                editTextConfirmarSenha.setError(null);

                if (editTextNome.getEditText().toString().equals("")) {
                    editTextNome.setError("Informe seu nome.");
                } else if (editTextEmail.getEditText().toString().equals("")) {
                    editTextEmail.setError("Informe seu e-mail.");
                } else if (editTextSenha.getEditText().toString().equals("")) {
                    editTextConfirmarSenha.setError("Informe sua senha.");
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
//    private boolean senhaValida(String senha) {
//        senha = senha.trim();
//        return senha.length() >= 6 && senha.length() < 14 ;
//    }

    // conferir se o email é invalido
//    public static boolean emailInvalido(String email) {
//        boolean isEmailIdValid = false;
//        if (email != null && email.length() > 0) {
//            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
//            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
//            Matcher matcher = pattern.matcher(email);
//            if (matcher.matches()) {
//                isEmailIdValid = true;
//            }
//        }
//        return isEmailIdValid;
//    }

    //***Confirmar o nome da tela de Home e concluir metodo
    public void irParaHome(){
         Intent intent = new Intent(this,HomeActivity.class);
         startActivity(intent);
    }

    public void irParaLogin(){
         Intent intent = new Intent(this, LoginActivity.class);
         startActivity(intent);
    }


}

package com.example.instanews.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.instanews.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    public final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
    private EditText usernameEditText;
    private EditText passwordEditText;
    private TextView registro;
    private TextView esqueceuSenha;
    private Button logIn;
    private Button loginFace;
    private Button loginGoogle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.textInputEditTextUsernameDigitado);
        passwordEditText = findViewById(R.id.textInputEditTextPassswordDigitado);
        registro = findViewById(R.id.textViewRegistro);
        esqueceuSenha = findViewById(R.id.textViewEsqueceuSenha);
        logIn = findViewById(R.id.botaoLogin);
        loginFace = findViewById(R.id.botaoLoginFace);
        loginGoogle = findViewById(R.id.botaoLoginGoogle);


        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernameEditText.setError(null);
                passwordEditText.setError(null);

                if (usernameEditText.getEditableText().toString().equals("")){
                    usernameEditText.setError("Informe seu e-mail.");
                }else if (!emailInvalido(usernameEditText.getEditableText().toString())){
                    usernameEditText.setError("E-mail digitado incorretamente.");
                }else if(passwordEditText.getEditableText().toString().equals("")){
                    passwordEditText.setError("Informe sua senha.");
                }else if (!senhaValida(passwordEditText.getEditableText().toString())){
                    passwordEditText.setError("Senha deve ter entre 6 e 14 caracteres");
                }else {
                    // irParaHome();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, CadastroActivity.class));
            }
        });

        esqueceuSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esqueceuSenha();
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

        startActivity(new Intent(LoginActivity.this, MainActivity.class));

    }



    //***Confirmar o nome da tela de CadastroActivity e concluir metodo
    public void irParaRegistro(){
        startActivity(new Intent(this, CadastroActivity.class));
    }



    //***Confirmar o nome da tela de Esqueceu Senha e concluir metodo
    public void esqueceuSenha(){
        //Intent intent = new Intent(this,EsqueceuSenha.class);
        //startActivity(intent);
    }


}
//*Verificar barra titulo "LoginActivity to your app".
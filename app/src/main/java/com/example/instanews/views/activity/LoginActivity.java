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

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;
    //public final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
    private EditText usernameEditText;
    private EditText passwordEditText;
    private TextView registro;
    private TextView esqueceuSenha;
    private Button logIn;
    private Button loginFace;
    private Button loginGoogle;
    private String email, senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernameEditText.setError(null);
                passwordEditText.setError(null);

                validarCampos();
            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaRegistro();
            }
        });

        esqueceuSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaRegistro();
            }
        });
    }


    public void validarCampos() {
        usernameEditText.setError(null);
        passwordEditText.setError(null);

        email = usernameEditText.getText().toString().trim();
        senha = passwordEditText.getText().toString().trim();

        if (usernameEditText.getEditableText().toString().equals("")) {
            usernameEditText.setError("Informe seu e-mail.");
        } else if (!validateEmail(usernameEditText.getEditableText().toString())) {
            usernameEditText.setError("E-mail digitado incorretamente.");
        } else if (passwordEditText.getEditableText().toString().equals("")) {
            passwordEditText.setError("Informe sua senha.");
        } else if (!validatePassword(passwordEditText.getEditableText().toString())) {
            passwordEditText.setError("Senha deve ter entre 6 e 14 caracteres");
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

    public void irParaHome() {

        startActivity(new Intent(LoginActivity.this, HomeActivity.class));

    }


    public void irParaRegistro() {
        startActivity(new Intent(this, CadastroActivity.class));
    }

    public void initViews() {
        usernameEditText = findViewById(R.id.textInputEditTextUsernameDigitado);
        passwordEditText = findViewById(R.id.textInputEditTextPassswordDigitado);
        registro = findViewById(R.id.textViewRegistro);
        esqueceuSenha = findViewById(R.id.textViewEsqueceuSenha);
        logIn = findViewById(R.id.botaoLogin);
        loginFace = findViewById(R.id.botaoLoginFace);
        loginGoogle = findViewById(R.id.botaoLoginGoogle);
    }
}

package com.example.instanews.views.activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.instanews.R;
import com.example.instanews.util.AppUtil;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
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
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        initViews();
        btnRegistrar.setOnClickListener(v -> {
            String email = editTextEmail.getEditText().getText().toString();
            String password = editTextSenha.getEditText().getText().toString();
            // Se email e senha são validos tentamos o registro no firebase
            if (validar(email, password)){
                registrarUsuario(email, password);
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaLogin();
            }
        });
    }
    private void registrarUsuario(String email, String password) {
        // TODO: cadastro co firebase via email e senha
        FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        AppUtil.salvarIdUsuario(CadastroActivity.this, FirebaseAuth.getInstance().getCurrentUser().getUid());
                        startActivity(new Intent(CadastroActivity.this, HomeActivity.class));
                        finish();
                    } else {
                        Snackbar.make(btnRegistrar, task.getException().getMessage(), Snackbar.LENGTH_LONG).show();
                        Log.i("TAG", "ERROR: " + task.getException().getMessage());
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
    private boolean validar(String email, String password) {
        if (email.isEmpty()) {
            editTextEmail.setError("Email não pode ser vazio");
            editTextEmail.requestFocus();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Email inválido");
            editTextEmail.requestFocus();
            return false;
        }
        if (password.isEmpty()) {
            editTextSenha.setError("Senha não pode ser vazio");
            editTextSenha.requestFocus();
            return false;
        }
        if (password.length() < 6) {
            editTextSenha.setError("Senha deve ser maior qeu 6 caracters");
            editTextSenha.requestFocus();
            return false;
        }
        return true;
    }
    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public boolean validatePassword(String password) {
        return password.length() > 5;
    }
}
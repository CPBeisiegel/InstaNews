package com.example.instanews.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.instanews.R;
import com.example.instanews.util.AppUtil;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;
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
    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        callbackManager = CallbackManager.Factory.create();

        logIn.setOnClickListener(v -> loginEmail());

        loginFace.setOnClickListener(v -> loginFacebook());

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

    public void loginEmail() {

        String email = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Campos não podem ser vazios :(", Toast.LENGTH_SHORT).show();
            return;
        }

        // tentamos fazer o login com o email e senha no firebase
        FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        irParaHome(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    } else {
                        Snackbar.make(logIn, task.getException().getMessage(), Snackbar.LENGTH_LONG).show();
                    }
                });
    }

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        return password.length() > 5;
    }

    public void loginFacebook() {
        // TODO: Login facebook
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                //
                AuthCredential credential = FacebookAuthProvider
                        .getCredential(loginResult.getAccessToken().getToken());

                FirebaseAuth.getInstance().signInWithCredential(credential)
                        .addOnCompleteListener(task -> {
                            irParaHome(loginResult.getAccessToken().getUserId());
                        });
            }

            @Override
            public void onCancel() {
                Toast.makeText(LoginActivity.this, "Cancelado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO: activeresult para callback facebook
        callbackManager.onActivityResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);

    }

    private void irParaHome(String uiid) {
        AppUtil.salvarIdUsuario(getApplication().getApplicationContext(), uiid);
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        finish();
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

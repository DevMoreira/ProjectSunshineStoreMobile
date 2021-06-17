package br.com.devgus.sunshinestore.authentication_pages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

import br.com.devgus.sunshinestore.MainActivity;
import br.com.devgus.sunshinestore.presentation_page.Presentation;
import br.com.devgus.sunshinestore.R;

public class FormLogin extends AppCompatActivity implements View.OnClickListener {

    private AppCompatButton bt_back_login, bt_login, bt_register_login;

    private AppCompatImageView ic_eye_pass_login, ic_eye_pass_login_required;

    private AppCompatEditText login_password_field, login_email_field;

    private ProgressBar progressBar;

    private AppCompatTextView text_progress;

    String[] mensagens = {" Preencha  TODOS  os  campos"," Login Efetuado com Sucesso ! "};

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        loadingComponents();
        applyingContext();
        applyingVisibility();
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    public void loadingComponents(){
        bt_login = findViewById(R.id.button_login);
        bt_back_login = findViewById(R.id.button_back_login);
        ic_eye_pass_login = findViewById(R.id.ic_eye_password_login);
        ic_eye_pass_login_required = findViewById(R.id.ic_eye_password_selected_login);
        bt_register_login = findViewById(R.id.button_register_login);
        login_password_field = findViewById(R.id.edit_text_login_password);
        login_email_field = findViewById(R.id.edit_text_login_email);
        progressBar = findViewById(R.id.progress);
        text_progress = findViewById(R.id.text_alert_progress);
    }

    public void applyingContext(){
        bt_login.setOnClickListener(this);
        bt_back_login.setOnClickListener(this);
        ic_eye_pass_login.setOnClickListener(this);
        ic_eye_pass_login_required.setOnClickListener(this);
        bt_register_login.setOnClickListener(this);
    }

    public void applyingVisibility(){
        ic_eye_pass_login.setVisibility(View.VISIBLE);
        ic_eye_pass_login_required.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        text_progress.setVisibility(View.INVISIBLE);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        String valueButton;

        switch (view.getId()){
            case R.id.button_login:
                String email = login_email_field.getText().toString();
                String password = login_password_field.getText().toString();
                    if(email.isEmpty() || password.isEmpty()){
                        Snackbar snack = Snackbar.make(view, mensagens[0], Snackbar.LENGTH_LONG);
                        snack.setBackgroundTint(Color.BLACK);
                        snack.setTextColor(Color.WHITE);
                        snack.show();
                    }else{
                        AuthenticateUser(view);
                    }
                    break;
            case R.id.button_back_login:
            case R.id.button_register_login:
                valueButton = ((AppCompatButton)view).getText().toString();
                changingScreen(valueButton.toLowerCase());
                break;
            case R.id.ic_eye_password_login:
                ic_eye_pass_login.setVisibility(View.INVISIBLE);
                ic_eye_pass_login_required.setVisibility(View.VISIBLE);
                login_password_field.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL);
                break;
            case R.id.ic_eye_password_selected_login:
                ic_eye_pass_login.setVisibility(View.VISIBLE);
                ic_eye_pass_login_required.setVisibility(View.INVISIBLE);
                login_password_field.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
                break;
        }
    }


    private void AuthenticateUser(View view){
        String email = login_email_field.getText().toString();
        String password = login_password_field.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressBar.setVisibility(View.VISIBLE);
                    text_progress.setVisibility(View.VISIBLE);
                    bt_login.setVisibility(View.INVISIBLE);
                    bt_register_login.setVisibility(View.INVISIBLE);
                    bt_back_login.setVisibility(View.INVISIBLE);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            changingScreen("entrar");
                        }
                    },3000);

                }else{
                    String erro;

                    try {
                        throw task.getException();
                    }catch (Exception e) {
                        erro = " Email ou Senha inválido ! ";
                    }

                    Snackbar snack = Snackbar.make(view, erro, Snackbar.LENGTH_LONG);
                    snack.setBackgroundTint(Color.BLACK);
                    snack.setTextColor(Color.WHITE);
                    snack.show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if(currentUser != null){
            changingScreen("entrar");
        }
    }

    public void changingScreen(String str){
        switch (str){
            case "entrar":
                Intent screenPresentation = new Intent(this, Presentation.class);
                startActivity(screenPresentation);
                break;
            case "voltar":
                Intent screenHome = new Intent(this, MainActivity.class);
                startActivity(screenHome);
                break;
            case "cadastrar":
                Intent screenRegister = new Intent(this, FormRegister.class);
                startActivity(screenRegister);
                break;
        }
    }
}
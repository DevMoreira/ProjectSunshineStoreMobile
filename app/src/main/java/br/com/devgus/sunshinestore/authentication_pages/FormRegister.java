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
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;

import br.com.devgus.sunshinestore.MainActivity;
import br.com.devgus.sunshinestore.R;

public class FormRegister extends AppCompatActivity implements View.OnClickListener{

    private AppCompatButton bt_register, bt_back_register, bt_login_register;

    private AppCompatImageView ic_eye_pass_register, ic_eye_pass_register_required;

    private AppCompatEditText register_password_field, register_email_field, register_name_field;

    private ProgressBar progressBar;

    private AppCompatTextView text_progress;

    String[] mensagens = {" Preencha  TODOS  os  campos","Cadastro Realizado com Sucesso !"};

    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_register);

        loadingComponents();
        applyingContext();
        applyingVisibility();
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    public void loadingComponents(){
        bt_register = findViewById(R.id.button_register);
        bt_back_register = findViewById(R.id.button_back_register);
        ic_eye_pass_register = findViewById(R.id.ic_eye_password_register);
        ic_eye_pass_register_required = findViewById(R.id.ic_eye_password_selected_register);
        register_password_field = findViewById(R.id.edit_text_register_password);
        register_name_field = findViewById(R.id.edit_text_register_name);
        register_email_field = findViewById(R.id.edit_text_register_email);
        bt_login_register = findViewById(R.id.button_login_register);
        progressBar = findViewById(R.id.progress);
        text_progress = findViewById(R.id.text_alert_progress);
    }

    public void applyingContext(){
        bt_register.setOnClickListener(this);
        bt_back_register.setOnClickListener(this);
        ic_eye_pass_register.setOnClickListener(this);
        ic_eye_pass_register_required.setOnClickListener(this);
        bt_login_register.setOnClickListener(this);
    }

    public void applyingVisibility(){
        ic_eye_pass_register.setVisibility(View.VISIBLE);
        ic_eye_pass_register_required.setVisibility(View.INVISIBLE);
    }

    @SuppressLint({"NonConstantResourceId", "ResourceType"})
    @Override
    public void onClick(View view) {

        String valueButton, name, email, password;

        switch (view.getId()){
            case R.id.button_back_register:
            case R.id.button_login_register:
                valueButton = ((AppCompatButton) view).getText().toString();
                changingScreen(valueButton.toLowerCase());
                break;
            case R.id.button_register:
                name = register_name_field.getText().toString();
                email = register_email_field.getText().toString();
                password = register_password_field.getText().toString();
                if(name.isEmpty() || email.isEmpty() || password.isEmpty()){
                    Snackbar snack = Snackbar.make(view, mensagens[0],Snackbar.LENGTH_LONG);
                    snack.setBackgroundTint(Color.BLACK);
                    snack.setTextColor(Color.WHITE);
                    snack.show();
                }else{
                    RegisterUser(view);
                }
                break;
            case R.id.ic_eye_password_register:
                ic_eye_pass_register.setVisibility(View.INVISIBLE);
                ic_eye_pass_register_required.setVisibility(View.VISIBLE);
                register_password_field.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL);
                break;
            case R.id.ic_eye_password_selected_register:
                ic_eye_pass_register.setVisibility(View.VISIBLE);
                ic_eye_pass_register_required.setVisibility(View.INVISIBLE);
                register_password_field.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
                break;
        }
    }

    private void RegisterUser(View view){
        String email = register_email_field.getText().toString();
        String password = register_password_field.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    saveUserData();

                    progressBar.setVisibility(View.VISIBLE);
                    text_progress.setVisibility(View.VISIBLE);
                    bt_register.setVisibility(View.INVISIBLE);
                    bt_back_register.setVisibility(View.INVISIBLE);
                    bt_login_register.setVisibility(View.INVISIBLE);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            changingScreen("cadastrar");
                        }
                    },3000);

                }else{
                    String erro;
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e) {
                        erro = " Digite uma senha com no minimo 6 caracteres ";
                    }catch (FirebaseAuthUserCollisionException e){
                        erro = " Esta conta já foi cadastrada ";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        erro = " Email Invalido ! ";
                    } catch (Exception e) {
                        erro = " Erro ao cadastrar usuário ! ";
                    }

                    Snackbar snack = Snackbar.make(view, erro, Snackbar.LENGTH_LONG);
                    snack.setBackgroundTint(Color.BLACK);
                    snack.setTextColor(Color.WHITE);
                    snack.show();
                }
            }
        });
    }

    private void saveUserData(){
        String name = register_name_field.getText().toString();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String,Object> users = new HashMap<>();
        users.put("name",name);

        userID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuários").document(userID);

        documentReference.set(users).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("db"," Sucesso ao salvar os dados ");
            }
        })
         .addOnFailureListener(new OnFailureListener() {
             @Override
             public void onFailure(@NonNull Exception e) {
                 Log.d("db_error"," Erro ao salvar os dados " + e.toString());
             }
         });
    }

    private void changingScreen(String str){
        switch (str){
            case "voltar":
                Intent screenHome = new Intent(this, MainActivity.class);
                startActivity(screenHome);
                break;
            case "entrar":
            case "cadastrar":
                Intent screenLogin = new Intent(this, FormLogin.class);
                startActivity(screenLogin);
                break;
        }
    }
}
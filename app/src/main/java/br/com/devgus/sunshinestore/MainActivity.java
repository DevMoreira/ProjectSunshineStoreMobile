package br.com.devgus.sunshinestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

import br.com.devgus.sunshinestore.authentication_pages.FormLogin;
import br.com.devgus.sunshinestore.authentication_pages.FormRegister;
import br.com.devgus.sunshinestore.presentation_page.Presentation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatButton bt_login_home, bt_register_home, bt_collections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingComponents();
        applyingContext();
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    public void loadingComponents(){
        bt_login_home = findViewById(R.id.button_login_home);
        bt_register_home = findViewById(R.id.button_register_home);
        bt_collections = findViewById(R.id.button_collections);
    }

    public void applyingContext(){
        bt_login_home.setOnClickListener(this);
        bt_register_home.setOnClickListener(this);
        bt_collections.setOnClickListener(this);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        String valueButton;

        switch (view.getId()){
            case R.id.button_login_home:
            case R.id.button_register_home:
            case R.id.button_collections:
                valueButton = ((AppCompatButton)view).getText().toString();
                changingScreen(valueButton.toLowerCase());
                break;
        }
    }

    public void changingScreen(String str){
        switch (str){
            case "entrar":
                Intent screenLogin = new Intent(this, FormLogin.class);
                startActivity(screenLogin);
                break;
            case "cadastrar":
                Intent screenRegister = new Intent(this, FormRegister.class);
                startActivity(screenRegister);
                break;
            case "coleções":
                Intent screenPresentation = new Intent(this, Presentation.class);
                startActivity(screenPresentation);
                break;
        }
    }
}
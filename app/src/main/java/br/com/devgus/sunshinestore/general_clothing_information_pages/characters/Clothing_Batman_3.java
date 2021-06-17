package br.com.devgus.sunshinestore.general_clothing_information_pages.characters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import java.util.Objects;

import br.com.devgus.sunshinestore.R;
import br.com.devgus.sunshinestore.clothing_pages.characters.AmericaPage;
import br.com.devgus.sunshinestore.clothing_pages.characters.BatmanPage;

public class Clothing_Batman_3 extends AppCompatActivity implements View.OnClickListener{

    private AppCompatImageView ic_back;

    private AppCompatButton bt_size_p, bt_size_m, bt_size_g, bt_size_gg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing_batman_3);

        loadingComponents();
        applyingContext();
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    @SuppressLint("CutPasteId")
    public void loadingComponents(){
        ic_back = findViewById(R.id.ic_back_page_clothing_batman_3);
        bt_size_p = findViewById(R.id.size_p);
        bt_size_m = findViewById(R.id.size_m);
        bt_size_g = findViewById(R.id.size_g);
        bt_size_gg = findViewById(R.id.size_gg);
    }

    @SuppressLint("CutPasteId")
    public void applyingContext(){
        ic_back.setOnClickListener(this);
        bt_size_p.setOnClickListener(this);
        bt_size_m.setOnClickListener(this);
        bt_size_g.setOnClickListener(this);
        bt_size_gg.setOnClickListener(this);
    }

    public void changingScreen(String str){
        switch (str){
            case "back":
                Intent screenBatmanPage = new Intent(this, BatmanPage.class);
                startActivity(screenBatmanPage);
                break;
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        String valueButton;

        switch (view.getId()){
            case R.id.ic_back_page_clothing_batman_3:
                valueButton = "back";
                changingScreen(valueButton);
                break;
            case R.id.size_p:
                bt_size_p.setBackgroundColor(getResources().getColor(android.R.color.white));
                bt_size_p.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                bt_size_m.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                bt_size_m.setTextColor(getResources().getColor(android.R.color.black));
                bt_size_g.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                bt_size_g.setTextColor(getResources().getColor(android.R.color.black));
                bt_size_gg.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                bt_size_gg.setTextColor(getResources().getColor(android.R.color.black));
                break;
            case R.id.size_m:
                bt_size_m.setBackgroundColor(getResources().getColor(android.R.color.white));
                bt_size_m.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                bt_size_p.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                bt_size_p.setTextColor(getResources().getColor(android.R.color.black));
                bt_size_g.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                bt_size_g.setTextColor(getResources().getColor(android.R.color.black));
                bt_size_gg.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                bt_size_gg.setTextColor(getResources().getColor(android.R.color.black));
                break;
            case R.id.size_g:
                bt_size_g.setBackgroundColor(getResources().getColor(android.R.color.white));
                bt_size_g.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                bt_size_p.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                bt_size_p.setTextColor(getResources().getColor(android.R.color.black));
                bt_size_m.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                bt_size_m.setTextColor(getResources().getColor(android.R.color.black));
                bt_size_gg.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                bt_size_gg.setTextColor(getResources().getColor(android.R.color.black));
                break;
            case R.id.size_gg:
                bt_size_gg.setBackgroundColor(getResources().getColor(android.R.color.white));
                bt_size_gg.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                bt_size_p.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                bt_size_p.setTextColor(getResources().getColor(android.R.color.black));
                bt_size_m.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                bt_size_m.setTextColor(getResources().getColor(android.R.color.black));
                bt_size_g.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                bt_size_g.setTextColor(getResources().getColor(android.R.color.black));
                break;
        }
    }
}
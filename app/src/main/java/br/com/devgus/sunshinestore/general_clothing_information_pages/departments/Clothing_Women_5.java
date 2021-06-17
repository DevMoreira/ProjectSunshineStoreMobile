package br.com.devgus.sunshinestore.general_clothing_information_pages.departments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

import br.com.devgus.sunshinestore.R;
import br.com.devgus.sunshinestore.clothing_pages.departments.ChildishPage;
import br.com.devgus.sunshinestore.clothing_pages.departments.WomenPage;

public class Clothing_Women_5 extends AppCompatActivity implements View.OnClickListener{

    private AppCompatImageView ic_back;

    private AppCompatButton bt_size_p, bt_size_m, bt_size_g, bt_size_gg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing_women_5);

        loadingComponents();
        applyingContext();
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    @SuppressLint("CutPasteId")
    public void loadingComponents(){
        ic_back = findViewById(R.id.ic_back_page_clothing_women_5);
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
                Intent screenWomenPage = new Intent(this, WomenPage.class);
                startActivity(screenWomenPage);
                break;
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        String valueButton;

        switch (view.getId()){
            case R.id.ic_back_page_clothing_women_5:
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
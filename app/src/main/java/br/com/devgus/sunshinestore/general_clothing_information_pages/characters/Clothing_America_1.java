package br.com.devgus.sunshinestore.general_clothing_information_pages.characters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

import br.com.devgus.sunshinestore.R;
import br.com.devgus.sunshinestore.clothing_pages.characters.AmericaPage;
import br.com.devgus.sunshinestore.clothing_pages.departments.ChildishPage;

public class Clothing_America_1 extends AppCompatActivity implements View.OnClickListener{

    private AppCompatImageView ic_back;

    private AppCompatButton bt_size_p, bt_size_m, bt_size_g, bt_size_gg, bt_decrement,
                            bt_increment;

    private AppCompatTextView quantity_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing_america_1);

        loadingComponents();
        applyingContext();
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    @SuppressLint("CutPasteId")
    public void loadingComponents(){
        ic_back = findViewById(R.id.ic_back_page_clothing_america_1);
        bt_size_p = findViewById(R.id.size_p);
        bt_size_m = findViewById(R.id.size_m);
        bt_size_g = findViewById(R.id.size_g);
        bt_size_gg = findViewById(R.id.size_gg);
        bt_decrement = findViewById(R.id.button_decreasing_amount);
        bt_increment = findViewById(R.id.button_increasing_amount);
        quantity_field = findViewById(R.id.the_amount);
    }

    @SuppressLint("CutPasteId")
    public void applyingContext(){
        ic_back.setOnClickListener(this);
        bt_size_p.setOnClickListener(this);
        bt_size_m.setOnClickListener(this);
        bt_size_g.setOnClickListener(this);
        bt_size_gg.setOnClickListener(this);
        bt_decrement.setOnClickListener(this);
        bt_increment.setOnClickListener(this);
        quantity_field.setOnClickListener(this);
    }

    public void changingScreen(String str){
        switch (str){
            case "back":
                Intent screenAmericaPage = new Intent(this, AmericaPage.class);
                startActivity(screenAmericaPage);
                break;
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        String valueButton;
        int quantity;

        switch (view.getId()){
            case R.id.ic_back_page_clothing_america_1:
                valueButton = "back";
                changingScreen(valueButton);
                break;
            case R.id.button_increasing_amount:
                quantity = Integer.parseInt(quantity_field.getText().toString());
                quantity += 1;
                quantity_field.setText(String.valueOf(quantity));
                break;
            case R.id.button_decreasing_amount:
                quantity = Integer.parseInt(quantity_field.getText().toString());
                if(quantity > 0){
                    quantity -= 1;
                }
                quantity_field.setText(String.valueOf(quantity));
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
package br.com.devgus.sunshinestore.clothing_pages.teams;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import java.util.Objects;

import br.com.devgus.sunshinestore.R;
import br.com.devgus.sunshinestore.general_clothing_information_pages.departments.Clothing_Childish_1;
import br.com.devgus.sunshinestore.general_clothing_information_pages.departments.Clothing_Childish_2;
import br.com.devgus.sunshinestore.general_clothing_information_pages.departments.Clothing_Childish_3;
import br.com.devgus.sunshinestore.general_clothing_information_pages.departments.Clothing_Childish_4;
import br.com.devgus.sunshinestore.general_clothing_information_pages.departments.Clothing_Childish_5;
import br.com.devgus.sunshinestore.general_clothing_information_pages.departments.Clothing_Childish_6;
import br.com.devgus.sunshinestore.general_clothing_information_pages.teams.Clothing_Sport_1;
import br.com.devgus.sunshinestore.general_clothing_information_pages.teams.Clothing_Sport_2;
import br.com.devgus.sunshinestore.general_clothing_information_pages.teams.Clothing_Sport_3;
import br.com.devgus.sunshinestore.general_clothing_information_pages.teams.Clothing_Sport_4;
import br.com.devgus.sunshinestore.general_clothing_information_pages.teams.Clothing_Sport_5;
import br.com.devgus.sunshinestore.general_clothing_information_pages.teams.Clothing_Sport_6;
import br.com.devgus.sunshinestore.presentation_page.Presentation;

public class SportPage extends AppCompatActivity implements View.OnClickListener{

    private AppCompatImageView ic_back,
            ic_favorite_unchecked_1, ic_favorite_unchecked_2,ic_favorite_unchecked_3,
            ic_favorite_unchecked_4, ic_favorite_unchecked_5, ic_favorite_unchecked_6,
            ic_favorite_marked_1, ic_favorite_marked_2,ic_favorite_marked_3, ic_favorite_marked_4,
            ic_favorite_marked_5, ic_favorite_marked_6,
            img_clothing_1, img_clothing_2, img_clothing_3, img_clothing_4, img_clothing_5,
            img_clothing_6;

    private View container_sport_clothing_1, container_sport_clothing_2, container_sport_clothing_3,
            container_sport_clothing_4, container_sport_clothing_5, container_sport_clothing_6;

    private AppCompatTextView info_clothing_1, info_clothing_2, info_clothing_3, info_clothing_4,
            info_clothing_5, info_clothing_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_page);

        loadingComponents();
        applyingContext();
        applyingVisibility();
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    public void loadingComponents(){
        ic_back = findViewById(R.id.ic_back_page_sport);
        ic_favorite_unchecked_1 = findViewById(R.id.ic_favorite_not_selected_1);
        ic_favorite_unchecked_2 = findViewById(R.id.ic_favorite_not_selected_2);
        ic_favorite_unchecked_3 = findViewById(R.id.ic_favorite_not_selected_3);
        ic_favorite_unchecked_4 = findViewById(R.id.ic_favorite_not_selected_4);
        ic_favorite_unchecked_5 = findViewById(R.id.ic_favorite_not_selected_5);
        ic_favorite_unchecked_6 = findViewById(R.id.ic_favorite_not_selected_6);
        ic_favorite_marked_1 = findViewById(R.id.ic_favorite_selected_1);
        ic_favorite_marked_2 = findViewById(R.id.ic_favorite_selected_2);
        ic_favorite_marked_3 = findViewById(R.id.ic_favorite_selected_3);
        ic_favorite_marked_4 = findViewById(R.id.ic_favorite_selected_4);
        ic_favorite_marked_5 = findViewById(R.id.ic_favorite_selected_5);
        ic_favorite_marked_6 = findViewById(R.id.ic_favorite_selected_6);
        img_clothing_1 = findViewById(R.id.img_clothing_1);
        img_clothing_2 = findViewById(R.id.img_clothing_2);
        img_clothing_3 = findViewById(R.id.img_clothing_3);
        img_clothing_4 = findViewById(R.id.img_clothing_4);
        img_clothing_5 = findViewById(R.id.img_clothing_5);
        img_clothing_6 = findViewById(R.id.img_clothing_6);
        container_sport_clothing_1 = findViewById(R.id.sport_clothing_1);
        container_sport_clothing_2 = findViewById(R.id.sport_clothing_2);
        container_sport_clothing_3 = findViewById(R.id.sport_clothing_3);
        container_sport_clothing_4 = findViewById(R.id.sport_clothing_4);
        container_sport_clothing_5 = findViewById(R.id.sport_clothing_5);
        container_sport_clothing_6 = findViewById(R.id.sport_clothing_6);
        info_clothing_1 = findViewById(R.id.info_clothing_1);
        info_clothing_2 = findViewById(R.id.info_clothing_2);
        info_clothing_3 = findViewById(R.id.info_clothing_3);
        info_clothing_4 = findViewById(R.id.info_clothing_4);
        info_clothing_5 = findViewById(R.id.info_clothing_5);
        info_clothing_6 = findViewById(R.id.info_clothing_6);
    }

    public void applyingContext(){
        ic_back.setOnClickListener(this);
        ic_favorite_unchecked_1.setOnClickListener(this);
        ic_favorite_unchecked_2.setOnClickListener(this);
        ic_favorite_unchecked_3.setOnClickListener(this);
        ic_favorite_unchecked_4.setOnClickListener(this);
        ic_favorite_unchecked_5.setOnClickListener(this);
        ic_favorite_unchecked_6.setOnClickListener(this);
        ic_favorite_marked_1.setOnClickListener(this);
        ic_favorite_marked_2.setOnClickListener(this);
        ic_favorite_marked_3.setOnClickListener(this);
        ic_favorite_marked_4.setOnClickListener(this);
        ic_favorite_marked_5.setOnClickListener(this);
        ic_favorite_marked_6.setOnClickListener(this);
        img_clothing_1.setOnClickListener(this);
        img_clothing_2.setOnClickListener(this);
        img_clothing_3.setOnClickListener(this);
        img_clothing_4.setOnClickListener(this);
        img_clothing_5.setOnClickListener(this);
        img_clothing_6.setOnClickListener(this);
        container_sport_clothing_1.setOnClickListener(this);
        container_sport_clothing_2.setOnClickListener(this);
        container_sport_clothing_3.setOnClickListener(this);
        container_sport_clothing_4.setOnClickListener(this);
        container_sport_clothing_5.setOnClickListener(this);
        container_sport_clothing_6.setOnClickListener(this);
        info_clothing_1.setOnClickListener(this);
        info_clothing_2.setOnClickListener(this);
        info_clothing_3.setOnClickListener(this);
        info_clothing_4.setOnClickListener(this);
        info_clothing_5.setOnClickListener(this);
        info_clothing_6.setOnClickListener(this);
    }

    public void applyingVisibility(){
        ic_favorite_marked_1.setVisibility(View.INVISIBLE);
        ic_favorite_marked_2.setVisibility(View.INVISIBLE);
        ic_favorite_marked_3.setVisibility(View.INVISIBLE);
        ic_favorite_marked_4.setVisibility(View.INVISIBLE);
        ic_favorite_marked_5.setVisibility(View.INVISIBLE);
        ic_favorite_marked_6.setVisibility(View.INVISIBLE);
        ic_favorite_unchecked_1.setVisibility(View.VISIBLE);
        ic_favorite_unchecked_2.setVisibility(View.VISIBLE);
        ic_favorite_unchecked_3.setVisibility(View.VISIBLE);
        ic_favorite_unchecked_4.setVisibility(View.VISIBLE);
        ic_favorite_unchecked_5.setVisibility(View.VISIBLE);
        ic_favorite_unchecked_6.setVisibility(View.VISIBLE);
    }

    public void changingScreen(String valueButton){
        switch (valueButton){
            case "back":
                Intent screenPresentation = new Intent(this, Presentation.class);
                startActivity(screenPresentation);
                break;
            case "clothing_sport_1":
                Intent screenClothingSport1 = new Intent(this, Clothing_Sport_1.class);
                startActivity(screenClothingSport1);
                break;
            case "clothing_sport_2":
                Intent screenClothingSport2 = new Intent(this, Clothing_Sport_2.class);
                startActivity(screenClothingSport2);
                break;
            case "clothing_sport_3":
                Intent screenClothingSport3 = new Intent(this, Clothing_Sport_3.class);
                startActivity(screenClothingSport3);
                break;
            case "clothing_sport_4":
                Intent screenClothingSport4 = new Intent(this, Clothing_Sport_4.class);
                startActivity(screenClothingSport4);
                break;
            case "clothing_sport_5":
                Intent screenClothingSport5 = new Intent(this, Clothing_Sport_5.class);
                startActivity(screenClothingSport5);
                break;
            case "clothing_sport_6":
                Intent screenClothingSport6 = new Intent(this, Clothing_Sport_6.class);
                startActivity(screenClothingSport6);
                break;
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        String valueButton;

        switch (view.getId()){
            case R.id.ic_back_page_sport:
                valueButton = "back";
                changingScreen(valueButton);
                break;
            case R.id.ic_favorite_selected_1:
                ic_favorite_unchecked_1.setVisibility(View.VISIBLE);
                ic_favorite_marked_1.setVisibility(View.INVISIBLE);
                break;
            case R.id.ic_favorite_selected_2:
                ic_favorite_unchecked_2.setVisibility(View.VISIBLE);
                ic_favorite_marked_2.setVisibility(View.INVISIBLE);
                break;
            case R.id.ic_favorite_selected_3:
                ic_favorite_unchecked_3.setVisibility(View.VISIBLE);
                ic_favorite_marked_3.setVisibility(View.INVISIBLE);
                break;
            case R.id.ic_favorite_selected_4:
                ic_favorite_unchecked_4.setVisibility(View.VISIBLE);
                ic_favorite_marked_4.setVisibility(View.INVISIBLE);
                break;
            case R.id.ic_favorite_selected_5:
                ic_favorite_unchecked_5.setVisibility(View.VISIBLE);
                ic_favorite_marked_5.setVisibility(View.INVISIBLE);
                break;
            case R.id.ic_favorite_selected_6:
                ic_favorite_unchecked_6.setVisibility(View.VISIBLE);
                ic_favorite_marked_6.setVisibility(View.INVISIBLE);
                break;
            case R.id.ic_favorite_not_selected_1:
                ic_favorite_unchecked_1.setVisibility(View.INVISIBLE);
                ic_favorite_marked_1.setVisibility(View.VISIBLE);
                break;
            case R.id.ic_favorite_not_selected_2:
                ic_favorite_unchecked_2.setVisibility(View.INVISIBLE);
                ic_favorite_marked_2.setVisibility(View.VISIBLE);
                break;
            case R.id.ic_favorite_not_selected_3:
                ic_favorite_unchecked_3.setVisibility(View.INVISIBLE);
                ic_favorite_marked_3.setVisibility(View.VISIBLE);
                break;
            case R.id.ic_favorite_not_selected_4:
                ic_favorite_unchecked_4.setVisibility(View.INVISIBLE);
                ic_favorite_marked_4.setVisibility(View.VISIBLE);
                break;
            case R.id.ic_favorite_not_selected_5:
                ic_favorite_unchecked_5.setVisibility(View.INVISIBLE);
                ic_favorite_marked_5.setVisibility(View.VISIBLE);
                break;
            case R.id.ic_favorite_not_selected_6:
                ic_favorite_unchecked_6.setVisibility(View.INVISIBLE);
                ic_favorite_marked_6.setVisibility(View.VISIBLE);
                break;
            case R.id.img_clothing_1:
            case R.id.sport_clothing_1:
            case R.id.info_clothing_1:
                valueButton = "clothing_sport_1";
                changingScreen(valueButton);
                break;
            case R.id.img_clothing_2:
            case R.id.sport_clothing_2:
            case R.id.info_clothing_2:
                valueButton = "clothing_sport_2";
                changingScreen(valueButton);
                break;
            case R.id.img_clothing_3:
            case R.id.sport_clothing_3:
            case R.id.info_clothing_3:
                valueButton = "clothing_sport_3";
                changingScreen(valueButton);
                break;
            case R.id.img_clothing_4:
            case R.id.sport_clothing_4:
            case R.id.info_clothing_4:
                valueButton = "clothing_sport_4";
                changingScreen(valueButton);
                break;
            case R.id.img_clothing_5:
            case R.id.sport_clothing_5:
            case R.id.info_clothing_5:
                valueButton = "clothing_sport_5";
                changingScreen(valueButton);
                break;
            case R.id.img_clothing_6:
            case R.id.sport_clothing_6:
            case R.id.info_clothing_6:
                valueButton = "clothing_sport_6";
                changingScreen(valueButton);
                break;
        }
    }
}
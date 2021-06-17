package br.com.devgus.sunshinestore.presentation_page;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

import br.com.devgus.sunshinestore.R;
import br.com.devgus.sunshinestore.authentication_pages.FormLogin;
import br.com.devgus.sunshinestore.authentication_pages.FormRegister;
import br.com.devgus.sunshinestore.clothing_pages.departments.*;
import br.com.devgus.sunshinestore.clothing_pages.characters.*;
import br.com.devgus.sunshinestore.clothing_pages.teams.*;
import br.com.devgus.sunshinestore.user_page.AccountUser;

public class Presentation extends AppCompatActivity implements View.OnClickListener {

    private AppCompatImageView ic_info_accout, options_feminine, options_masculine, options_childish,
                               options_shoes, options_sporty, options_pajamas,
                               options_nasa, options_batman, options_america, options_simpsons,
                               options_spider, options_avengers,
                               options_ceara, options_goias, options_icasa, options_bahia,
                               options_sport, options_vasco;

    private AppCompatTextView bt_login_presentation, bt_register_presentation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

        loadingComponents();
        applyingContext();
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if(currentUser != null){
            bt_login_presentation.setVisibility(View.INVISIBLE);
            bt_register_presentation.setVisibility(View.INVISIBLE);
            ic_info_accout.setVisibility(View.VISIBLE);
        }else{
            bt_login_presentation.setVisibility(View.VISIBLE);
            bt_register_presentation.setVisibility(View.VISIBLE);
            ic_info_accout.setVisibility(View.INVISIBLE);
        }
    }

    public void loadingComponents(){
        ic_info_accout = findViewById(R.id.ic_info_account_presentation);
        options_feminine = findViewById(R.id.options_feminine_clothes);
        options_masculine = findViewById(R.id.options_masculine_clothes);
        options_childish = findViewById(R.id.options_childish_clothes);
        options_shoes = findViewById(R.id.options_shoes_clothes);
        options_sporty = findViewById(R.id.options_sporty_clothes);
        options_pajamas = findViewById(R.id.options_pajamas_clothes);
        options_nasa = findViewById(R.id.options_nasa_clothes);
        options_batman = findViewById(R.id.options_batman_clothes);
        options_america = findViewById(R.id.options_america_clothes);
        options_simpsons = findViewById(R.id.options_simpsons_clothes);
        options_spider = findViewById(R.id.options_spider_clothes);
        options_avengers = findViewById(R.id.options_avengers_clothes);
        options_ceara = findViewById(R.id.options_ceara_clothes);
        options_goias = findViewById(R.id.options_goias_clothes);
        options_icasa = findViewById(R.id.options_icasa_clothes);
        options_bahia = findViewById(R.id.options_bahia_clothes);
        options_sport = findViewById(R.id.options_sport_clothes);
        options_vasco = findViewById(R.id.options_vasco_clothes);
        bt_login_presentation = findViewById(R.id.button_login_presentation);
        bt_register_presentation = findViewById(R.id.button_register_presentation);
    }

    public void applyingContext(){
        ic_info_accout.setOnClickListener(this);
        options_feminine.setOnClickListener(this);
        options_masculine.setOnClickListener(this);
        options_childish.setOnClickListener(this);
        options_shoes.setOnClickListener(this);
        options_sporty.setOnClickListener(this);
        options_pajamas.setOnClickListener(this);
        options_nasa.setOnClickListener(this);
        options_batman.setOnClickListener(this);
        options_america.setOnClickListener(this);
        options_simpsons.setOnClickListener(this);
        options_spider.setOnClickListener(this);
        options_avengers.setOnClickListener(this);
        options_ceara.setOnClickListener(this);
        options_goias.setOnClickListener(this);
        options_icasa.setOnClickListener(this);
        options_bahia.setOnClickListener(this);
        options_sport.setOnClickListener(this);
        options_vasco.setOnClickListener(this);
        bt_login_presentation.setOnClickListener(this);
        bt_register_presentation.setOnClickListener(this);
    }

    public void changingScreen(String str){
        switch (str){
            case "account_user":
                Intent screenAccountUser = new Intent(this, AccountUser.class);
                startActivity(screenAccountUser);
                break;
            case "login_presentation":
                Intent screenLogin = new Intent(this, FormLogin.class);
                startActivity(screenLogin);
                break;
            case "register_presentation":
                Intent screenRegister = new Intent(this, FormRegister.class);
                startActivity(screenRegister);
                break;
            case "women_page":
                Intent screenWomenPage = new Intent(this, WomenPage.class);
                startActivity(screenWomenPage);
                break;
            case "masculine_page":
                Intent screenMasculinePage = new Intent(this, MasculinePage.class);
                startActivity(screenMasculinePage);
                break;
            case "childish_page":
                Intent screenChildishPage = new Intent(this, ChildishPage.class);
                startActivity(screenChildishPage);
                break;
            case "shoes_page":
                Intent screenShoesPage = new Intent(this, ShoesPage.class);
                startActivity(screenShoesPage);
                break;
            case "sporty_page":
                Intent screenSportyPage = new Intent(this, SportyPage.class);
                startActivity(screenSportyPage);
                break;
            case "pajamas_page":
                Intent screenPajamasPage = new Intent(this, PajamasPage.class);
                startActivity(screenPajamasPage);
                break;
            case "nasa_page":
                Intent screenNasaPage = new Intent(this, NasaPage.class);
                startActivity(screenNasaPage);
                break;
            case "batman_page":
                Intent screenBatmanPage = new Intent(this, BatmanPage.class);
                startActivity(screenBatmanPage);
                break;
            case "america_page":
                Intent screenAmericaPage = new Intent(this, AmericaPage.class);
                startActivity(screenAmericaPage);
                break;
            case "simpsons_page":
                Intent screenSimpsonsPage = new Intent(this, SimpsonsPage.class);
                startActivity(screenSimpsonsPage);
                break;
            case "spider_page":
                Intent screenSpiderPage = new Intent(this, SpiderPage.class);
                startActivity(screenSpiderPage);
                break;
            case "avengers_page":
                Intent screenAvengersPage = new Intent(this, AvengersPage.class);
                startActivity(screenAvengersPage);
                break;
            case "ceara_page":
                Intent screenCearaPage = new Intent(this, CearaPage.class);
                startActivity(screenCearaPage);
                break;
            case "goias_page":
                Intent screenGoiasPage = new Intent(this, GoiasPage.class);
                startActivity(screenGoiasPage);
                break;
            case "icasa_page":
                Intent screenIcasaPage = new Intent(this, IcasaPage.class);
                startActivity(screenIcasaPage);
                break;
            case "bahia_page":
                Intent screenBahiaPage = new Intent(this, BahiaPage.class);
                startActivity(screenBahiaPage);
                break;
            case "sport_page":
                Intent screenSportPage = new Intent(this, SportPage.class);
                startActivity(screenSportPage);
                break;
            case "vasco_page":
                Intent screenVascoPage = new Intent(this, VascoPage.class);
                startActivity(screenVascoPage);
                break;
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        String valueButton;

        switch (view.getId()){
            case R.id.ic_info_account_presentation:
                valueButton = "account_user";
                changingScreen(valueButton);
                break;
            case R.id.button_login_presentation:
                valueButton = "login_presentation";
                changingScreen(valueButton);
                break;
            case R.id.button_register_presentation:
                valueButton = "register_presentation";
                changingScreen(valueButton);
                break;
            case R.id.options_feminine_clothes:
                valueButton = "women_page";
                changingScreen(valueButton);
                break;
            case R.id.options_masculine_clothes:
                valueButton = "masculine_page";
                changingScreen(valueButton);
                break;
            case R.id.options_childish_clothes:
                valueButton = "childish_page";
                changingScreen(valueButton);
                break;
            case R.id.options_shoes_clothes:
                valueButton = "shoes_page";
                changingScreen(valueButton);
                break;
            case R.id.options_sporty_clothes:
                valueButton = "sporty_page";
                changingScreen(valueButton);
                break;
            case R.id.options_pajamas_clothes:
                valueButton = "pajamas_page";
                changingScreen(valueButton);
                break;
            case R.id.options_nasa_clothes:
                valueButton = "nasa_page";
                changingScreen(valueButton);
                break;
            case R.id.options_batman_clothes:
                valueButton = "batman_page";
                changingScreen(valueButton);
                break;
            case R.id.options_america_clothes:
                valueButton = "america_page";
                changingScreen(valueButton);
                break;
            case R.id.options_simpsons_clothes:
                valueButton = "simpsons_page";
                changingScreen(valueButton);
                break;
            case R.id.options_spider_clothes:
                valueButton = "spider_page";
                changingScreen(valueButton);
                break;
            case R.id.options_avengers_clothes:
                valueButton = "avengers_page";
                changingScreen(valueButton);
                break;
            case R.id.options_ceara_clothes:
                valueButton = "ceara_page";
                changingScreen(valueButton);
                break;
            case R.id.options_goias_clothes:
                valueButton = "goias_page";
                changingScreen(valueButton);
                break;
            case R.id.options_icasa_clothes:
                valueButton = "icasa_page";
                changingScreen(valueButton);
                break;
            case R.id.options_bahia_clothes:
                valueButton = "bahia_page";
                changingScreen(valueButton);
                break;
            case R.id.options_sport_clothes:
                valueButton = "sport_page";
                changingScreen(valueButton);
                break;
            case R.id.options_vasco_clothes:
                valueButton = "vasco_page";
                changingScreen(valueButton);
                break;
        }
    }
}
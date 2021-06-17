package br.com.devgus.sunshinestore.user_page;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import br.com.devgus.sunshinestore.MainActivity;
import br.com.devgus.sunshinestore.R;
import br.com.devgus.sunshinestore.presentation_page.Presentation;

import static br.com.devgus.sunshinestore.R.id.ic_back_account;
import static br.com.devgus.sunshinestore.R.id.ic_logout_inside_container;

public class AccountUser extends AppCompatActivity implements View.OnClickListener {

    private AppCompatImageView ic_back, ic_logout;

    private AppCompatTextView nameUser, emailUser;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_user);

        loadingComponents();
        applyingContext();
        getSupportActionBar().hide();
    }

    @Override
    protected void onStart() {
        super.onStart();

        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();

        userID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuários").document(userID);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if(documentSnapshot != null){
                    nameUser.setText(documentSnapshot.getString("name"));
                    emailUser.setText(email);
                }
            }
        });
    }

    public void loadingComponents(){
        ic_back = findViewById(ic_back_account);
        ic_logout = findViewById(ic_logout_inside_container);
        nameUser = findViewById(R.id.text_info_user);
        emailUser = findViewById(R.id.text_info_email);
    }

    public void applyingContext(){
        ic_back.setOnClickListener(this);
        ic_logout.setOnClickListener(this);
    }

    public void changingScreen(String valueButton){
        switch (valueButton){
            case "back":
                Intent screenPresentation = new Intent(this, Presentation.class);
                startActivity(screenPresentation);
                break;
            case "logout":
                FirebaseAuth.getInstance().signOut();
                Intent screenHome = new Intent(this, MainActivity.class);
                startActivity(screenHome);
                break;
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        String valueButton;

        switch (view.getId()){
            case ic_back_account:
                valueButton = "back";
                changingScreen(valueButton);
                break;
            case ic_logout_inside_container:
                valueButton = "logout";
                changingScreen(valueButton);
                break;
        }
    }
}
package com.example.quizz20.controller;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.quizz20.R;
import com.example.quizz20.modele.Bdd;

public class MainActivity extends AppCompatActivity {
    private Bdd bdd;
    private TextView titre;
    private EditText nomJoueurEditText;
    private Button boutonStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bdd = new Bdd();
        Log.d("bdd", "onCreate: bdd intancier");
        titre = findViewById(R.id.nomAppTextView);
        nomJoueurEditText = findViewById(R.id.nomJoueurEditText);
        boutonStart = findViewById(R.id.StartButton);
        boutonStart.setEnabled(false);
        nomJoueurEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // This is where we'll check the user input
                boutonStart.setEnabled(!s.toString().isEmpty());
            }
        });

        boutonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new QuestionFragment());
                titre.setVisibility(View.GONE);
                boutonStart.setVisibility(View.GONE);
                nomJoueurEditText.setVisibility(View.GONE);
            }
            private void replaceFragment(QuestionFragment questionFragment){
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, questionFragment);
                fragmentTransaction.commit();
            }
        });
    }
}
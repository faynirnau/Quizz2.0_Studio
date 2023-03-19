package com.example.quizz20.controller;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.quizz20.R;


public class QuestionFragment extends Fragment {
    View view;
    TextView textViewQuestion;
    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_question, container, false);
        return view;
    }

}
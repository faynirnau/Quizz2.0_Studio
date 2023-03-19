package com.example.quizz20.modele;

public class Question {
    private String question;
    private String reponse;

    public Question(String question, String reponse) {
        this.question = setQuestion(question);
        this.reponse = setReponse(reponse);
    }

    public String setQuestion(String question) {
        return this.question = question;
    }

    public String setReponse(String reponse) {
        return this.reponse = reponse;
    }

    public String getQuestion() {
        return question;
    }

    public String getReponse() {
        return reponse;
    }
}

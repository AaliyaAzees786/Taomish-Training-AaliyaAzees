package org.example;

import java.util.ArrayList;

public class Questions {

    //Using ArrayList to define questions
    private ArrayList<String> questions;
    public Questions(){
        questions = new ArrayList<>();
        questions.add("What is the capital of Kerala?");
        questions.add("Which planet is known as the Red Planet?");
        questions.add("Which is the largest ocean in the world?");
        questions.add("What is the capital of France?");
        questions.add("Who painted the Mona Lisa?");
    }

    //To display questions to the user
    public String getQuestion(int number) {
        return questions.get(number - 1);
    }
}

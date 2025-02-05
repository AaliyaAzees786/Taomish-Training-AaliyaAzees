package org.example;

import java.util.HashMap;

public class Answers {

    //Using Hashmap to provide the answers corresponding to each question
    private HashMap<Integer, String> answers;
    public Answers() {
        answers = new HashMap<>();
        answers.put(1, "A");  // TVM
        answers.put(2, "B");  // Mars
        answers.put(3, "A");  // Pacific Ocean
        answers.put(4, "A");  // Paris
        answers.put(5, "C");  // Leonardo da Vinci
    }

    //Get answers from user
    public String getAnswer(int number) {
        return answers.get(number);
    }
}

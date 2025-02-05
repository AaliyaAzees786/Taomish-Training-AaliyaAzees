package org.example;

public interface QuizOperations {
    void showQuestions(Integer number);
    void showOptions(Integer number);
    int fetchScore();
    boolean checkAnswer(Integer number, String option);
}

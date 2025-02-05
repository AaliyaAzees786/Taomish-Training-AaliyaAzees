package org.example;

import java.util.List;
import java.util.Scanner;

public class Quiz implements QuizOperations{
    //Declaration of all the variables
    private String userName;
    private Questions questions;
    private Answers answers;
    private Options options;
    private Score score;
    private Scanner scanner;

    //Constructor creation
    public Quiz(){
        this.scanner = new Scanner(System.in);
        this.questions = new Questions();
        this.answers = new Answers();
        this.options = new Options();
        this.score = new Score();
    }

    //Start function which starts the quiz.
    public void start(){
        System.out.println("Enter your name: ");
        this.userName = scanner.nextLine();
        System.out.println("Hi " + userName + ", Let's begin with the quiz!");

        //Loop to display questions with options
        for (int i = 1; i <= 5; i++) {
            showQuestions(i);
            showOptions(i);
            System.out.print("Your answer (A/B/C/D): ");
            String userAnswer = scanner.nextLine().toUpperCase();
            boolean isCorrect = checkAnswer(i, userAnswer);
            if (isCorrect) {
                System.out.println("Correct!");
                score.incrementScore();
            } else {
                System.out.println("Incorrect. The correct answer was: " + answers.getAnswer(i));
            }
            System.out.println();
        }
        System.out.println("Quiz completed! Your final score: " + fetchScore() + "/5");
    }

    //Overriding all methods
    @Override
    public void showQuestions(Integer number) {
        System.out.println("\nQuestion " + number + ": " + questions.getQuestion(number));
    }

    @Override
    public void showOptions(Integer number) {
        List<String> questionOptions = options.getOptions(number);
        System.out.println("A) " + questionOptions.get(0));
        System.out.println("B) " + questionOptions.get(1));
        System.out.println("C) " + questionOptions.get(2));
        System.out.println("D) " + questionOptions.get(3));
    }

    @Override
    public int fetchScore() {
        return score.getScore();
    }

    @Override
    public boolean checkAnswer(Integer number, String option) {
        return answers.getAnswer(number).equals(option);
    }
}

package org.example;

public class Score {
    private int score;

    //Initialize the score
    public Score() {
        this.score = 0;
    }

    //Increment score for each correct answers
    public void incrementScore() {
        this.score++;
    }

    //Display the score earned by the user at last
    public int getScore() {
        return score;
    }
}

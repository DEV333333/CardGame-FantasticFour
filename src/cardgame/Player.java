/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package softwareproject;

/**
 *
 * @author Hriday Juneja
 * @author Lovepreet Kaur
 * @author Nikhil Chaudhary
 * @author Harsh Patel
 */

public class Player {
    private String name;
    private int score;
    private boolean isWinner;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.isWinner = false;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

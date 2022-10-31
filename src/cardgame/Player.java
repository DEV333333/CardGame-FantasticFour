package cardgame;

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
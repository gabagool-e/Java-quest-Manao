package main.java.model;

public class Reward {
    private String title;
    private int xpAmount;

    public Reward(String title, int xpAmount) {
        this.title = title;
        this.xpAmount = xpAmount;
    }

    public String getTitle() {
        return title;
    }

    public int getXpAmount() {
        return xpAmount;
    }
}

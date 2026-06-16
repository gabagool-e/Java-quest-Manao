package main.java.model;

public class Player {
    private String name;
    private int level;
    private int currentXP;
    private int totalXP;
    private String title;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.currentXP = 0;
        this.totalXP = 0;
        this.title = "Novice";
    }

    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getCurrentXP() { return currentXP; }
    public int getTotalXP() { return totalXP; }
    public String getTitle() { return title; }
}

package main.java.model;

import java.io.Serializable;

public class Player implements Serializable {
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

public void addXP(int amount) {
    currentXP += amount;
    totalXP += amount;
    int xpNeeded = level * 100;
    if (currentXP >= xpNeeded) {
        currentXP -= xpNeeded;
        level++;
        updateTitle();
    }
}

private void updateTitle() {
    switch (level) {
        case 2: title = "Apprenti"; break;
        case 3: title = "Développeur"; break;
        case 4: title = "Vétéran"; break;
        case 5: title = "Architecte"; break;
        case 6: title = "Légende"; break;
    }
}
}
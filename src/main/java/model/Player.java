package main.java.model;

import java.io.Serializable;

/**
 * Représente le joueur de TaskQuest.
 * Le joueur accumule de l'XP en complétant des quêtes et monte de niveau.
 */
public class Player implements Serializable {
    private String name;
    private int level;
    private int currentXP;
    private int totalXP;
    private String title;

    /**
     * Crée un nouveau joueur au niveau 1 avec le titre "Novice".
     * @param name le nom du joueur
     */
    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.currentXP = 0;
        this.totalXP = 0;
        this.title = "Novice";
    }

    /** @return le nom du joueur */
    public String getName() { return name; }

    /** @return le niveau actuel du joueur */
    public int getLevel() { return level; }

    /** @return l'XP actuelle dans le niveau en cours */
    public int getCurrentXP() { return currentXP; }

    /** @return le total d'XP accumulé depuis le début */
    public int getTotalXP() { return totalXP; }

    /** @return le titre RPG actuel du joueur */
    public String getTitle() { return title; }

    /**
     * Ajoute de l'XP au joueur et déclenche une montée de niveau si le seuil est atteint.
     * @param amount la quantité d'XP à ajouter
     */
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

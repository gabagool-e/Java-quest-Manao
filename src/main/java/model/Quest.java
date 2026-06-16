package main.java.model;

import java.io.Serializable;

/**
 * Classe abstraite représentant une quête RPG.
 * Une quête possède un titre, une description, une récompense en XP et un statut.
 */
public abstract class Quest implements Serializable {
    private String title;
    private String description;
    private int xpReward;
    private QuestStatus status;

    /**
     * Crée une nouvelle quête.
     * @param title le titre de la quête
     * @param description la description de la quête
     * @param xpReward la récompense en XP
     */
    public Quest(String title, String description, int xpReward) {
        this.title = title;
        this.description = description;
        this.xpReward = xpReward;
        this.status = QuestStatus.TODO;
    }

    /**
     * Retourne le type de la quête (DAILY ou ONETIME).
     * @return le type sous forme de chaîne
     */
    public abstract String getType();

    /** @return le titre de la quête */
    public String getTitle() { return title; }

    /** @return la description de la quête */
    public String getDescription() { return description; }

    /** @return la récompense XP de la quête */
    public int getXpReward() { return xpReward; }

    /** @return le statut actuel de la quête */
    public QuestStatus getStatus() { return status; }

    /**
     * Modifie le statut de la quête.
     * @param status le nouveau statut
     */
    public void setStatus(QuestStatus status) { this.status = status; }
}

package main.java.controller;

import main.java.model.*;
import main.java.exception.InvalidQuestException;
import java.util.ArrayList;
import java.util.List;

/**
 * Contrôleur principal de TaskQuest.
 * Coordonne les actions entre la vue et le modèle : création, completion et suppression de quêtes.
 */
public class QuestController {
    private List<Quest> quests;
    private Player player;

    /**
     * Crée un contrôleur avec un joueur donné.
     * @param player le joueur associé à cette session
     */
    public QuestController(Player player) {
        this.quests = new ArrayList<>();
        this.player = player;
    }

    /**
     * Crée et ajoute une nouvelle quête à la liste.
     * @param title le titre de la quête
     * @param description la description de la quête
     * @param xpReward la récompense en XP
     * @param type le type de quête ("DAILY" ou "ONETIME")
     * @throws InvalidQuestException si le titre est vide ou l'XP invalide
     */
    public void createQuest(String title, String description, int xpReward, String type) throws InvalidQuestException {
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidQuestException("Le titre ne peut pas être vide.");
        }
        if (xpReward <= 0 || xpReward > 1000) {
            throw new InvalidQuestException("L'XP doit être entre 1 et 1000.");
        }
        Quest quest;
        if (type.equals("DAILY")) {
            quest = new DailyQuest(title, description, xpReward);
        } else {
            quest = new OneTimeQuest(title, description, xpReward);
        }
        quests.add(quest);
    }

    /** @return la liste de toutes les quêtes */
    public List<Quest> getQuests() { return quests; }

    /** @return le joueur actuel */
    public Player getPlayer() { return player; }

    /**
     * Remplace la liste de quêtes (utilisé au chargement des données).
     * @param quests la liste chargée depuis le repository
     */
    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    /**
     * Marque une quête comme terminée et attribue l'XP au joueur.
     * @param quest la quête à terminer
     */
    public void markAsDone(Quest quest) {
        quest.setStatus(QuestStatus.DONE);
        player.addXP(quest.getXpReward());
    }

    /**
     * Supprime une quête de la liste.
     * @param quest la quête à supprimer
     */
    public void deleteQuest(Quest quest) {
        quests.remove(quest);
    }
}

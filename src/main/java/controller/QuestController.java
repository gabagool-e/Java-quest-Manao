package main.java.controller;

import main.java.model.*;
import main.java.exception.InvalidQuestException;
import java.util.ArrayList;
import java.util.List;

public class QuestController {
    private List<Quest> quests;
    private Player player;

    public QuestController(Player player) {
        this.quests = new ArrayList<>();
        this.player = player;
    }

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

    public List<Quest> getQuests() { return quests; }
    public Player getPlayer() { return player; }

    public void markAsDone(Quest quest) {
        quest.setStatus(QuestStatus.DONE);
        player.addXP(quest.getXpReward());
    }

    public void deleteQuest(Quest quest) {
        quests.remove(quest);
    }
    public void setQuests(java.util.List<Quest> quests) {
    this.quests = quests;
}

}

package main.java.model;

public class DailyQuest extends Quest {

    public DailyQuest(String title, String description, int xpReward) {
        super(title, description, xpReward);
    }

    @Override
    public String getType() {
        return "DAILY";
    }

    public void reset() {
        setStatus(QuestStatus.TODO);
    }
}

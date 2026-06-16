package main.java.model;

public abstract class Quest {
    private String title;
    private String description;
    private int xpReward;
    private QuestStatus status;

    public Quest(String title, String description, int xpReward) {
        this.title = title;
        this.description = description;
        this.xpReward = xpReward;
        this.status = QuestStatus.TODO;
    }

    public abstract String getType();

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getXpReward() { return xpReward; }
    public QuestStatus getStatus() { return status; }
    public void setStatus(QuestStatus status) { this.status = status; }
}

package main.java;

import main.java.controller.QuestController;
import main.java.model.Player;
import main.java.view.MainView;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Aventurier");
        QuestController controller = new QuestController(player);
        new MainView(controller);
    }
}

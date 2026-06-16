package main.java;

import main.java.controller.QuestController;
import main.java.exception.DataCorruptedException;
import main.java.model.Player;
import main.java.repository.QuestRepository;
import main.java.view.MainView;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        QuestRepository repo = new QuestRepository();
        Player player = new Player("Aventurier");
        QuestController controller = new QuestController(player);
        try {
            controller.setQuests(repo.load());
        } catch (DataCorruptedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        MainView view = new MainView(controller);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> repo.save(controller.getQuests())));
    }
}

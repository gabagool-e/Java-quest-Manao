package main.java.view;

import main.java.controller.QuestController;
import main.java.model.Quest;
import main.java.exception.InvalidQuestException;
import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private QuestController controller;
    private DefaultListModel<String> questListModel;
    private JList<String> questList;
    private JLabel playerInfoLabel;
    private JProgressBar xpBar;

    public MainView(QuestController controller) {
        this.controller = controller;
        setTitle("TaskQuest");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        buildUI();
        refresh();
        setVisible(true);
    }

    private void buildUI() {
        playerInfoLabel = new JLabel();
        xpBar = new JProgressBar(0, 100);
        xpBar.setStringPainted(true);
        JPanel playerPanel = new JPanel(new BorderLayout());
        playerPanel.add(playerInfoLabel, BorderLayout.CENTER);
        playerPanel.add(xpBar, BorderLayout.SOUTH);
        playerPanel.setBorder(BorderFactory.createTitledBorder("Joueur"));
        add(playerPanel, BorderLayout.NORTH);

        questListModel = new DefaultListModel<>();
        questList = new JList<>(questListModel);
        add(new JScrollPane(questList), BorderLayout.CENTER);

        JButton btnAdd = new JButton("Nouvelle Quête");
        JButton btnDone = new JButton("Terminer");
        JButton btnDelete = new JButton("Supprimer");
        JPanel btnPanel = new JPanel();
        btnPanel.add(btnAdd);
        btnPanel.add(btnDone);
        btnPanel.add(btnDelete);
        add(btnPanel, BorderLayout.SOUTH);

        btnAdd.addActionListener(e -> showAddDialog());
        btnDone.addActionListener(e -> markSelectedDone());
        btnDelete.addActionListener(e -> deleteSelected());
    }

    private void refresh() {
        questListModel.clear();
        for (Quest q : controller.getQuests()) {
            questListModel.addElement("[" + q.getStatus() + "] " + q.getTitle() + " (+" + q.getXpReward() + " XP)");
        }
        playerInfoLabel.setText(controller.getPlayer().getName() + " — Niveau " +
            controller.getPlayer().getLevel() + " — " + controller.getPlayer().getTitle());
        int xpNeeded = controller.getPlayer().getLevel() * 100;
        xpBar.setMaximum(xpNeeded);
        xpBar.setValue(controller.getPlayer().getCurrentXP());
        xpBar.setString(controller.getPlayer().getCurrentXP() + " / " + xpNeeded + " XP");
    }

    private void showAddDialog() {
        JTextField titleField = new JTextField(20);
        JTextField descField = new JTextField(20);
        JTextField xpField = new JTextField("50", 5);
        String[] types = {"DAILY", "ONETIME"};
        JComboBox<String> typeBox = new JComboBox<>(types);
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.add(new JLabel("Titre:")); panel.add(titleField);
        panel.add(new JLabel("Description:")); panel.add(descField);
        panel.add(new JLabel("XP:")); panel.add(xpField);
        panel.add(new JLabel("Type:")); panel.add(typeBox);
        int result = JOptionPane.showConfirmDialog(this, panel, "Nouvelle Quête", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                int xp = Integer.parseInt(xpField.getText());
                controller.createQuest(titleField.getText(), descField.getText(), xp, (String) typeBox.getSelectedItem());
                refresh();
            } catch (InvalidQuestException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "XP doit être un nombre.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void markSelectedDone() {
        int index = questList.getSelectedIndex();
        if (index >= 0) {
            controller.markAsDone(controller.getQuests().get(index));
            refresh();
        }
    }

    private void deleteSelected() {
        int index = questList.getSelectedIndex();
        if (index >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "Supprimer cette quête ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                controller.deleteQuest(controller.getQuests().get(index));
                refresh();
            }
        }
    }
}

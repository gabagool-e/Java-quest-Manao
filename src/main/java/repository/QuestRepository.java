package main.java.repository;

import main.java.exception.DataCorruptedException;
import main.java.model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuestRepository {
    private static final String FILE_PATH = "quests.dat";

    public void save(List<Quest> quests) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(new ArrayList<>(quests));
        } catch (IOException e) {
            System.err.println("Erreur sauvegarde: " + e.getMessage());
        }
    }

    public List<Quest> load() throws DataCorruptedException {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Quest>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new DataCorruptedException("Fichier de données corrompu.");
        }
    }
}

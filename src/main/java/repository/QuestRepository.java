package main.java.repository;

import main.java.exception.DataCorruptedException;
import main.java.model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository gérant la persistance des quêtes via sérialisation Java.
 * Sauvegarde et charge les données depuis un fichier binaire.
 */
public class QuestRepository {
    private static final String FILE_PATH = "quests.dat";

    /**
     * Sauvegarde la liste des quêtes dans le fichier de données.
     * @param quests la liste des quêtes à persister
     */
    public void save(List<Quest> quests) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(new ArrayList<>(quests));
        } catch (IOException e) {
            System.err.println("Erreur sauvegarde: " + e.getMessage());
        }
    }

    /**
     * Charge la liste des quêtes depuis le fichier de données.
     * @return la liste des quêtes chargées, ou une liste vide si aucun fichier n'existe
     * @throws DataCorruptedException si le fichier est illisible ou corrompu
     */
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

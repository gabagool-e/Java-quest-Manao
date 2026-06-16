# TaskQuest

Gestionnaire de tâches gamifié — Projet Java B1 S2 2025-2026

## Description

TaskQuest est une application de bureau Java qui transforme vos tâches du quotidien en quêtes RPG. Chaque quête complétée rapporte de l'XP à votre personnage, qui monte de niveau et débloque de nouveaux titres (Novice → Apprenti → Développeur → Vétéran → Architecte → Légende).

## Fonctionnalités

- Créer des quêtes (Daily ou OneTime) avec titre, description et récompense XP
- Afficher la liste des quêtes avec leur statut (TODO / IN_PROGRESS / DONE)
- Marquer une quête comme terminée (XP attribuée automatiquement)
- Supprimer une quête
- Profil joueur avec barre de progression XP
- Sauvegarde automatique des données à la fermeture

## Architecture

Le projet suit une architecture MVC stricte :

```
src/main/java/
├── model/        → Classes métier (Quest, Player, Reward, QuestStatus)
├── view/         → Interface graphique Swing (MainView)
├── controller/   → Logique applicative (QuestController)
├── repository/   → Persistance des données (QuestRepository)
└── exception/    → Exceptions personnalisées
```

## Lancement

### Prérequis
- Java 11 ou supérieur

### Compilation et exécution (depuis la racine du projet)
```bash
javac -d out src/main/java/**/*.java src/main/java/*.java
java -cp out main.java.Main
```

## Choix techniques

- **Interface graphique** : Java Swing (intégré au JDK, aucune dépendance externe)
- **Persistance** : Sérialisation Java (fichier `quests.dat`)
- **Architecture** : MVC avec packages séparés par responsabilité

## Auteur

Manao BRUNETTI — Ynov Campus Rennes — Bachelor Informatique B1 — 2025-2026

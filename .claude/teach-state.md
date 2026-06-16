# Teach session state

## Meta
- date_started: 2026-05-19
- date_updated: 2026-05-19
- level: Beginner

## Project
- name: TaskQuest
- description: Application de bureau Java gamifiée où les tâches sont des quêtes RPG qui rapportent de l'XP à un joueur qui monte de niveau.

## Choices
- UI: Swing
- Persistence: JSON (Gson)
- IDE: VS Code
- Availability: 3 jours/semaine, ~2h/séance
- Deadline: 2026-06-07

## KANBAN
### Tâche 1 : Les fondations Java — Classes, objets et packages
**Objectif :** Comprendre ce qu'est une classe, un objet et un package. Créer les premières briques : Reward, QuestStatus, Player.
- [ ] Sous-étape 1.1 : Créer la structure de dossiers MVC + Git init + .gitignore + premier commit
- [ ] Sous-étape 1.2 : Apprendre classe/objet → créer la classe Reward dans model
- [ ] Sous-étape 1.3 : Apprendre enum → créer QuestStatus (TODO, IN_PROGRESS, DONE)
- [ ] Sous-étape 1.4 : Créer Player avec addXP(int) + commit

### Tâche 2 : L'héritage — La classe abstraite Quest et ses sous-classes
**Objectif :** Comprendre abstract et extends. Créer la hiérarchie Quest → DailyQuest / OneTimeQuest.
- [ ] Sous-étape 2.1 : Apprendre héritage + classe abstraite (analogie Animal/Dog/Cat)
- [ ] Sous-étape 2.2 : Créer la classe abstraite Quest avec ses champs et méthode abstraite getType()
- [ ] Sous-étape 2.3 : Créer OneTimeQuest extends Quest
- [ ] Sous-étape 2.4 : Créer DailyQuest extends Quest
- [ ] Sous-étape 2.5 : Logique de level-up + titres dans Player.addXP() + commit

### Tâche 3 : Les exceptions et le repository
**Objectif :** Créer des exceptions personnalisées. Implémenter la persistance JSON avec Gson.
- [ ] Sous-étape 3.1 : Apprendre exceptions → créer InvalidQuestException + DataCorruptedException
- [ ] Sous-étape 3.2 : Validation dans Quest (titre vide = InvalidQuestException)
- [ ] Sous-étape 3.3 : Ajouter Gson + créer QuestRepository.saveQuests()
- [ ] Sous-étape 3.4 : QuestRepository.loadQuests() avec gestion d'erreurs
- [ ] Sous-étape 3.5 : PlayerRepository + commit

### Tâche 4 : Le controller et la vue console
**Objectif :** Comprendre le MVC. Implémenter les 6 fonctionnalités en mode console pour valider la logique.
- [ ] Sous-étape 4.1 : Apprendre MVC → créer QuestController avec injection des repositories
- [ ] Sous-étape 4.2 : createQuest(), listQuests(), deleteQuest()
- [ ] Sous-étape 4.3 : markAsDone() avec attribution XP au joueur
- [ ] Sous-étape 4.4 : ConsoleView pour tester les 6 fonctionnalités bout-en-bout + commit

### Tâche 5 : Interface Swing et finitions
**Objectif :** Remplacer la console par une interface Swing. Ajouter Javadoc et README.
- [ ] Sous-étape 5.1 : Apprendre Swing → créer MainView (JFrame, JPanel, JTable, JProgressBar)
- [ ] Sous-étape 5.2 : Connecter les boutons au QuestController
- [ ] Sous-étape 5.3 : Formulaire de création de quête (JDialog)
- [ ] Sous-étape 5.4 : Javadoc sur toutes les classes/méthodes publiques
- [ ] Sous-étape 5.5 : README.md + nettoyage + commit final

## Progress
- current_task: Tâche 1 — Les fondations Java
- current_substep: 1.1
- attempt_count: 0

## Recap
(vide pour l'instant — mis à jour après chaque sous-étape validée)

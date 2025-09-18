# ECF CCP-1 SPARADRAP 2025 AFPA

## Description

La pharmacie Sparadrap souhaite mettre en place un outil desktop interne de gestion et suivi des achats de leurs clients.
Elle vous présente le fonctionnement souhaité de sa future application :
• Le client se présente au guichet de la pharmacie pour un achat dit direct ou sous ordonnance prescrite par un médecin.

•La pharmacie effectuera donc un enregistrement de cet achat en fonction du client en enregistrant toutes les informations nécessaires au bon suivi.
Afin de vous aider dans la démarche de conception, la pharmacie vous fournit quelques informations qui lui sont nécessaires dans le S.I :

•Un client est représenté par son nom, prénom, adresse, code postal, ville, téléphone, email et son numéro de sécurité social, sa date de naissance et sa mutelle. Il a également un médecin traitant référent.

•Un médecin est representé par son nom, prénom, adresse, code postal, ville, téléphone, email et son numéro d’agréement. Il peut avoir un ou plusieurs patients.

•Un médicament est représenté par son nom, sa catégorie, son prix et sa date de mise en service et une quantité.

•Une mutuelle est représentée par son nom, adresse, code postal, ville, son télephone, son email, son département et le taux de prise en charge du remboursement des médicaments.

•Une ordonnance est représenté par une date, le nom du médecin traitant, le nom du patient, la liste des médicaments.


Ce projet Java permet de gérer les commandes, les patients, les médecins et les mutuelles.

## Structure du projet

- `src/` : code source Java
- `sparadrap.afpa` : Dossier qui contient Controller, exception, image, model, test, utility et view.swing
- `README.md` : fichier README.md

## Prérequis

- Java 21+

## Compilation et exécution

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="sparadrap.afpa.Main"

# Projet de Système de Gestion de Bibliothèque en Console Java

## Aperçu
Dans ce projet, vous allez créer un système de gestion de bibliothèque en console où les utilisateurs pourront gérer les livres, les adhérents, ainsi que les processus d’emprunt et de retour. Le système devra être implémenté sous forme d’application console en Java, en utilisant les concepts de programmation orientée objet et des patrons de conception.

## Exigences

### Fonctionnalités du Système
1. **Gestion des livres** (ajouter, supprimer, rechercher, afficher)
2. **Gestion des adhérents** (inscrire, mettre à jour, supprimer)
3. **Emprunt et retour de livres**
4. **Système de réservation** pour les livres déjà empruntés
5. **Calcul des amendes** pour les livres en retard
6. **Catégories de livres** avec des règles de prêt spécifiques
7. **Fonctionnalités de reporting** (livres en retard, livres les plus empruntés, etc.)
8. **Persistance de l’état du système** (fonctionnalité de sauvegarde/chargement)

### Exigences Techniques

#### Concepts POO
1. **Agrégation** : Implémenter des relations où des objets contiennent d’autres objets (par exemple, une bibliothèque contenant des livres et des adhérents, des adhérents ayant des livres empruntés)
2. **Cohésion** : S’assurer que les classes ont des responsabilités bien définies et des méthodes cohérentes
3. **Héritage** : Créer des hiérarchies de classes (par exemple, différents types de livres, d’utilisateurs)
4. **Encapsulation** : Utiliser les modificateurs d’accès appropriés et les méthodes getter/setter
5. **Polymorphisme** : Implémenter la redéfinition de méthodes pour des comportements spécifiques

#### Patrons de Conception
1. **Patron Factory** : Pour créer différents types de livres, d’utilisateurs ou de rapports
2. **Patron Observer** : Pour les notifications (par exemple, lorsqu’un livre réservé devient disponible, lorsqu’un livre est en retard)
3. **Patron State** : Pour gérer les états des livres (disponible, emprunté, réservé, en réparation)
4. **Patron Strategy** : Pour différentes stratégies de calcul d’amendes ou d’algorithmes de recherche
5. **Patron Singleton** : Pour un accès global à la base de données de la bibliothèque ou à la configuration
6. **Patron Facade** : Pour fournir une interface simplifiée aux sous-systèmes complexes de la bibliothèque

### Interface Utilisateur
- Interface textuelle dans la console
- Instructions claires pour les utilisateurs
- Système de commandes intuitif (par exemple : `ajouter livre`, `emprunter livre`, `rechercher auteur`)

## Livrables
1. Le code source du système de gestion de bibliothèque
2. Un bref document expliquant :
    - Comment chaque concept POO a été implémenté
    - Comment chaque patron de conception a été utilisé
    - Les instructions pour utiliser le système

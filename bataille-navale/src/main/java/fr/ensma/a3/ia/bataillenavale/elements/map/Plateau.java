package fr.ensma.a3.ia.bataillenavale.elements.map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import fr.ensma.a3.ia.bataillenavale.elements.bateaux.Bateau;
import fr.ensma.a3.ia.bataillenavale.elements.bateaux.militaires.Torpilleur;


public class Plateau {
    private Integer taille; // Taille du plateau (10x10 dans notre cas)
    public Case[][] grille; // Grille du plateau contenant les cases
    protected BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


    public Plateau() {
        Boolean error = true;
        while (error) {
            error = demanderTaillePlateau(error);
        }
        this.grille = new Case[taille][taille];
        for (Integer i = 0; i < taille; i++) {
            for (Integer j = 0; j < taille; j++) {
            this.grille[i][j] = new Case(i, j);
            }
        }
        System.out.println("Grille créée");
    }

    private Boolean demanderTaillePlateau(Boolean error) {
        String input = "";
        System.out.print("Quelle taille de plateau désirez-vous : ");
        try {
            input = this.in.readLine();
        } catch (java.io.IOException e) {
            System.out.println("Une erreur est survenue : " + e);
        }
        try {
            Integer t = Integer.valueOf(input);
            if (t < 7 || t > 15) {
                System.out.println("Veuillez entrer un entier entre 7 et 15");
            } else {
                this.taille = t;
                error = false;
            } 
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un entier" + e);
        }
        return error;
    }

    // Getters et setters pour la taille du plateau
    public Integer getTaille() {
        return taille;
    }

    public void setTaille(Integer taille) {
        this.taille = taille;
    }

    // // Méthode pour vérifier si un emplacement est valide pour placer un élément
    // private boolean emplacementValide(ElementJeu element, Integer colonne, Integer ligne) {
    //     List<Case> casesElement = element.getCases();
    //     for (Case c : casesElement) {
    //         Integer col = colonne + c.getColonne();
    //         Integer lin = ligne + c.getLigne();
    //         // Vérifier si la case est dans les limites du plateau
    //         if (col < 0 || col >= taille || lin < 0 || lin >= taille) {
    //             return false;
    //         }
    //         // Vérifier si la case est déjà occupée
    //         if (grille[col][lin] != null) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }


    // Méthode pour afficher l'état actuel du plateau (débogage)
    public void afficherPlateau() {
        for (Integer i = 0; i < taille; i++) {
            for (Integer j = 0; j < taille; j++) {
                if (grille[i][j] != null) {
                    System.out.print(" X "); // Case occupée par un élément de jeu
                } else {
                    System.out.print(" . "); // Eau
                }
            }
            System.out.println(); // Nouvelle ligne pour chaque ligne du plateau
        }
    }
}

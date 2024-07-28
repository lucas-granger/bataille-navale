package fr.ensma.a3.ia.bataillenavale;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import fr.ensma.a3.ia.bataillenavale.elements.bateaux.Bateau;
import fr.ensma.a3.ia.bataillenavale.elements.bateaux.militaires.BateauMilitaire;
import fr.ensma.a3.ia.bataillenavale.elements.map.Case;
import fr.ensma.a3.ia.bataillenavale.elements.objets.Bombe;
import fr.ensma.a3.ia.bataillenavale.outils.Config;
import fr.ensma.a3.ia.bataillenavale.outils.CoordinateHelper;
import fr.ensma.a3.ia.bataillenavale.outils.MortPersonnageException;

/**
 * Represents a human player
 */
public class JoueurHumain extends Joueur {

    public JoueurHumain() {
        setPlayerName();
    }

    public List<String> getLabels() {
        Integer n = this.boats.length;
        String[] labels = new String[n];
        for (Integer i = 0; i < n; i++) {
            labels[i] = this.boats[i].name;
        }
        return Arrays.asList(labels);
    }

    public BateauMilitaire getBoatByLabel(String nomBateau) {
        Integer i = 0;
        while (i < this.boats.length) {
            if (this.boats[i].name.equals(nomBateau)) {
                return this.boats[i];
            }
            i ++;
        }
        return this.boats[i];
    }

    /**
     * Asks the player to place his ships.
     * A check is made to ensure that the placement of the boats respects the rules of the game.
     * 
     * @return void
     */
    protected void placeBoats() {
        for (Integer i = 0; i < this.boats.length; i++) {
            Boolean error = true;
            String input = "";
            // ConsoleHelper.eraseConsole();
            // System.out.println("╔══════════════════════════════════════════════════════════════════════════════╗");
            // System.out.println("║                            Placement des bateaux                             ║");
            // System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝");
            // System.out.println();
            // System.out.println(pseudo + ", vous devez placer vos navires sur la grille de jeu.");
            // System.out.println("Vous devez pour cela indiquer l'orientation de votre bateau ainsi que son point d'application.");
            // System.out.println("Si vous indiquez \"" + TextHelper.ANSI_GREEN + "V" + TextHelper.ANSI_RESET + ""+ TextHelper.ANSI_PURPLE + "C6" + TextHelper.ANSI_RESET+ "\" pour un bateau de 3 cases, le bateau sera orienté " + TextHelper.ANSI_GREEN + "verticalement"+ TextHelper.ANSI_RESET + ", débutera en " + TextHelper.ANSI_PURPLE + "C6" + TextHelper.ANSI_RESET+ " et se terminera en F6.");
            // System.out.println("Si vous indiquez \"" + TextHelper.ANSI_GREEN + "H" + TextHelper.ANSI_RESET + ""+ TextHelper.ANSI_PURPLE + "I3" + TextHelper.ANSI_RESET+ "\" pour un bateau de 3 cases, le bateau sera orienté " + TextHelper.ANSI_GREEN+ "horizontalement" + TextHelper.ANSI_RESET + ", débutera en " + TextHelper.ANSI_PURPLE + "I3"+ TextHelper.ANSI_RESET + " et se terminera en I6.");
            // System.out.println("Faites attention à ne pas sortir du plateau de jeu, à ne pas faire chevaucher deux bateaux et à ne pas coller deux bateaux ensembles, auquel cas vous devrez recommencer le placement de votre bateau.");
            // System.out.println("Soyez stratégique ! Préparez-vous, la bataille va bientôt commencer ;)");
            // System.out.println();
            // System.out.println("════════════════════════════════════════════════════════════════════════════════");
            // System.out.println();
            Integer boatSize = this.boats[i].taille;
            // plateau.showPersonnalBoard();
            System.out.println(pseudo + ", vous devez placer votre " + this.boats[i].name + " (" + boatSize + " cases).");
            while (error) {
                System.out.print("Veuillez choisir une direction et un point d'application (ex : VC6) : ");
                try {
                    input = in.readLine();
                } catch (java.io.IOException e) {
                    System.out.println("Une erreur est survenue : " + e);
                }
                if (Pattern.matches("^[HVhv][abcdefghijABCDEFGHIJ][1-9][0]{0,1}", input)) {
                    String direction = input.substring(0, 1).toUpperCase();
                    Integer x = Integer.valueOf(input.substring(2)) - 1;
                    Integer y = Integer.valueOf(CoordinateHelper.letterCoordinateToNumber(input.substring(1, 2).toUpperCase()));
                    System.out.println();
                    if (x < 0 || x > 9) {
                        System.out.println("La composante X de votre bateau est invalide.");
                    } else if (y < 0 || y > 9) {
                        System.out.println("La composante Y de votre bateau est invalide.");
                    } 
                    //TODO: Gestion des collisions
                    else {
                        error = false;
                        initCases(this.boats[i], direction, x, y);
                    }
                }
            }
        }
        placerBombeAléatoirement();
        System.out.println("Placement terminé");
    }

    private void placerBombeAléatoirement() {
        Random random = new Random();
        Integer ligne, colonne;
        Bombe bombe = new Bombe();

        ligne = random.nextInt(this.plateau.getTaille());
        colonne = random.nextInt(this.plateau.getTaille());

        // Placer la bombe
        plateau.grille[ligne][colonne].rejoindreCase(bombe, bombe.resistance);
        System.out.println("Bombe placée à la position : (" + ligne + ", " + colonne + ")");
    }

    private void initCases(Bateau bateau, String direction, Integer x, Integer y) {
        System.out.println(direction);
        if (direction.equals("H")) {
            for (Integer i = 0; i < bateau.taille; i++) {
                this.plateau.grille[x][y+i].rejoindreCase(bateau, bateau.taille);
            }
        } else {
            for (Integer i = 0; i < bateau.taille; i++) {
                this.plateau.grille[x+i][y].rejoindreCase(bateau, bateau.taille);
            }
        }
    }

    /**
     * Asks the player to choose his pseudo
     * 
     * @return void
     */
    protected void setPlayerName() {
        String input = "";
        boolean error = true;
        do {
            System.out.print("Comment souhaitez-vous que l'on vous appelle (3-12 caractères) ? ");
            try {
                input = in.readLine().replaceAll("\\s", "-");
            } catch (java.io.IOException e) {
                System.out.println("Une erreur est survenue : " + e);
            }
            if (Pattern.matches("[A-Za-z-éèï]+", input) && (input.length() >= 3) && (input.length() <= 12)) {
                error = false;
            }
        } while (error);
        this.pseudo = input;
    }


    protected void attaquer(Joueur enemy) {
        boolean error = true;
        Integer x = 0;
        Integer y = 0;
        String nomBateau = "";

        while (error) {
            System.out.print(this.pseudo + ", quel bateau voulez-vous utiliser ? ");
            try {
                nomBateau = in.readLine();
            } catch (java.io.IOException e) {
                System.out.println("Une erreur est survenue : " + e);
            }
            if (getLabels().contains(nomBateau)) {
                System.out.println("Vous avez choisi le " + nomBateau);
                error = false;
            }
        }
        error = true;
        while (error) {
            String input = "";
            System.out.print(this.pseudo + ", sur quelle case souhaitez-vous tirer ? ");
            try {
                input = in.readLine();
            } catch (java.io.IOException e) {
                System.out.println("Une erreur est survenue : " + e);
            }
            if (Pattern.matches("[A-Ja-j][1-9]{1}[0]{0,1}", input)) {
                x = Integer.valueOf(input.substring(1)) - 1;
                y = Integer.valueOf(CoordinateHelper.letterCoordinateToNumber(input.substring(0, 1).toUpperCase()));
                if (CoordinateHelper.isValid(x, y)) {
                    error = false;
                } else {
                    System.out.println("Cette coordonnée est invalide.");
                }
            }
        }

        Case cible = enemy.getPlateau().grille[x][y];

        try {
            getBoatByLabel(nomBateau).attaque(cible);
        } catch (MortPersonnageException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }

    @Override
    protected void choisirAction() {
        System.out.println(this.pseudo + ", que voulez vous faire entre (1)Attaquer et (2)Déplacer un bateau ?");
    }
    }
package fr.ensma.a3.ia.bataillenavale;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import fr.ensma.a3.ia.bataillenavale.elements.bateaux.militaires.BateauMilitaire;
import fr.ensma.a3.ia.bataillenavale.elements.bateaux.militaires.ContreTorpilleur;
import fr.ensma.a3.ia.bataillenavale.elements.bateaux.militaires.Croiseur;
import fr.ensma.a3.ia.bataillenavale.elements.bateaux.militaires.SousMarin;
import fr.ensma.a3.ia.bataillenavale.elements.bateaux.militaires.Torpilleur;
import fr.ensma.a3.ia.bataillenavale.elements.map.Case;
import fr.ensma.a3.ia.bataillenavale.elements.map.Plateau;

/**
 * Represents a player
 */
public abstract class Joueur {

    protected String pseudo;
    public Plateau plateau = new Plateau();
    protected BateauMilitaire[] boats = {
        // new PorteAvion(),
        new Croiseur(),
        new ContreTorpilleur(),
        new SousMarin(),
        new Torpilleur()
    };
    protected BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private Integer statNbTotalShot;
    private Integer statNbSuccessfullShot;
    private Integer statNbBoatShot;
    private Case lastCellShot = new Case(-1, -1);

    protected abstract void placeBoats();
    protected abstract void attaquer(Joueur enemy);
    protected abstract void setPlayerName();

    /**
     * Increases the number of shots fired by the player
     * 
     * @return void
     */
    protected void incrementStatNbTotalShot() {
        statNbTotalShot++;
    }

    /**
     * Increases the number of successfull shots fired by the player
     * 
     * @return void
     */
    protected void incrementStatNbSuccessfullShot() {
        statNbSuccessfullShot++;
    }

    /**
     * Increases the number of ships sunk by the player
     * 
     * @return void
     */
    protected void incrementStatNbBoatShot() {
        statNbBoatShot++;
    }

    /**
     * Gets the plateau of the player
     * 
     * @return Plateau
     */
    protected Plateau getPlateau() {
        return this.plateau;
    }

    /**
     * Gets the name of the player
     * 
     * @return String
     */
    protected String getPlayerName() {
        return this.pseudo;
    }

    /**
     * Show player stats
     * 
     * @return void
     */
    protected void printStats() {
        System.out.println();
        System.out.println("║");
        System.out.println("║ Statistiques de jeu de " + pseudo + " :");
        System.out.println("║");
        System.out.println("║ Nombre de tirs réalisés : " + statNbTotalShot);
        System.out.println("║ Nombre de tirs réussis : " + statNbSuccessfullShot);
        System.out.println("║ Précision : " + (double) Math.round(((double) (statNbSuccessfullShot) / (double) (statNbTotalShot)) * 100.0) + "%");
        // System.out.println("║ Nombre de bateaux adverses détruis : " + statNbBoatShot + "/" + Config.getNbBoats());
        System.out.println("║");
    }

    /**
     * Gets the last shot made by the player
     * 
     * @return Case
     */
    protected Case getLastCellShot() {
        return lastCellShot;
    }

    /**
     * Saves the last shot made by the player
     * 
     * @param Integer x
     * @param Integer y
     * 
     * @return void
     */
    protected void setLastCellShot(Integer x, Integer y) {
        lastCellShot = new Case(x, y);
    }
    protected abstract void choisirAction();
}

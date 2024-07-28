package fr.ensma.a3.ia.bataillenavale.outils;

import java.util.ArrayList;

import fr.ensma.a3.ia.bataillenavale.elements.bateaux.Bateau;
import fr.ensma.a3.ia.bataillenavale.elements.bateaux.militaires.BateauMilitaire;
import fr.ensma.a3.ia.bataillenavale.elements.bateaux.militaires.ContreTorpilleur;
import fr.ensma.a3.ia.bataillenavale.elements.bateaux.militaires.Croiseur;
import fr.ensma.a3.ia.bataillenavale.elements.bateaux.militaires.SousMarin;
import fr.ensma.a3.ia.bataillenavale.elements.bateaux.militaires.Torpilleur;

/**
 * Config : game configuration file
 */
public abstract class Config {

    /**
     * The boats and their configuration
     * {:id, :name, :size}
     */
    private static final BateauMilitaire[] boats = {
        // new PorteAvion(),
        new Croiseur(),
        new ContreTorpilleur(),
        new SousMarin(),
        new Torpilleur()
    };
    
    /**
     * Returns a given boat's configuration
     * 
     * @param int boatId
     *
     * @return String[]
     */
    public static BateauMilitaire getBoatsConfig(Integer index) {
        if (index < 0 || index >= boats.length) {
            System.err.println("Index out of range");;
        }
        return boats[index];
    }

    /**
     * Returns the number of boats
     *
     * @return int
     */
    public static Integer getNbBoats() {
        return boats.length;
    }
}
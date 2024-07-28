package fr.ensma.a3.ia.bataillenavale;

import fr.ensma.a3.ia.bataillenavale.elements.bateaux.militaires.Croiseur;
import fr.ensma.a3.ia.bataillenavale.elements.bateaux.militaires.Torpilleur;
import fr.ensma.a3.ia.bataillenavale.elements.comportement.deplacements.EnAvancant;
import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ValParamException
    {
        Croiseur croiseur = new Croiseur();
        EnAvancant avancer = new EnAvancant();
        croiseur.setCompDepl(avancer);
        croiseur.deplacer();
        Jeu jeu = new Jeu();
        jeu.joueur1.plateau.grille[0][0].stringify();
    }
}

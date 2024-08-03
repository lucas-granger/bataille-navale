package fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques;

import fr.ensma.a3.ia.bataillenavale.elements.map.Case;
import fr.ensma.a3.ia.bataillenavale.elements.map.Plateau;
import fr.ensma.a3.ia.bataillenavale.outils.MortPersonnageException;

public class EnCroix implements ICompoAttaque{

    @Override
    public void attaquer(IAttaquant att, Case cible) throws MortPersonnageException {
        System.out.println("J'attaque en croix");

        // Attaque au centre
        cible.estAttaque(att.getPuissAttaque());

        // Récupération des informations
        Plateau plateau = cible.getPlateau();
        Integer x = cible.getLigne();
        Integer y = cible.getColonne();

        //Attaque sur les cases adjacentes
        for (int i = 0; i < 2; i++) {
            plateau.grille[x + (2 * i - 1)][y].estAttaque(att.getPuissAttaque());
            plateau.grille[x][y + (2 * i - 1)].estAttaque(att.getPuissAttaque());
        }
    }
    
}

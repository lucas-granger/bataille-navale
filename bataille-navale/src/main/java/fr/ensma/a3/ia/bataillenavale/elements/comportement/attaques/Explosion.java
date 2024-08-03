package fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques;

import fr.ensma.a3.ia.bataillenavale.elements.map.Case;
import fr.ensma.a3.ia.bataillenavale.elements.map.Plateau;
import fr.ensma.a3.ia.bataillenavale.outils.MortPersonnageException;

public class Explosion implements ICompoAttaque{

    @Override
    public void attaquer(IAttaquant att, Case cible) throws MortPersonnageException {
        System.out.println("J'explose");

        // Attaque au centre
        cible.estAttaque(att.getPuissAttaque());

        // Récupération des informations
        Plateau plateau = cible.getPlateau();
        Integer x = cible.getLigne();
        Integer y = cible.getColonne();

        //Attaque sur la première couronne
        for (int i = 0; i < 2; i++) {
            plateau.grille[x + (2 * i - 1)][y].estAttaque(att.getPuissAttaque() - 1);
            plateau.grille[x][y + (2 * i - 1)].estAttaque(att.getPuissAttaque() - 1);
            plateau.grille[x + (2 * i - 1)][y + (2 * i - 1)].estAttaque(att.getPuissAttaque() - 1);
            plateau.grille[x + (2 * i - 1)][y + (-2 * i + 1)].estAttaque(att.getPuissAttaque() - 1);
        }

        //Attaque sur la deuxième couronne
        for (int i = 2; i <= 2; i++) { // Pour la deuxième couronne
            plateau.grille[x + (2 * i - 1)][y].estAttaque(att.getPuissAttaque() - 2);
            plateau.grille[x][y + (2 * i - 1)].estAttaque(att.getPuissAttaque() - 2);
            plateau.grille[x + (2 * i - 1)][y + (2 * i - 1)].estAttaque(att.getPuissAttaque() - 2);
            plateau.grille[x + (2 * i - 1)][y + (-2 * i + 1)].estAttaque(att.getPuissAttaque() - 2);
            
            plateau.grille[x + (2 * i - 1)][y + (-2 * i + 3)].estAttaque(att.getPuissAttaque() - 2);
            plateau.grille[x + (-2 * i + 3)][y + (2 * i - 1)].estAttaque(att.getPuissAttaque() - 2);
            plateau.grille[x + (2 * i - 3)][y + (2 * i - 1)].estAttaque(att.getPuissAttaque() - 2);
            plateau.grille[x + (2 * i - 1)][y + (-2 * i + 1)].estAttaque(att.getPuissAttaque() - 2);
        }

    }    
}

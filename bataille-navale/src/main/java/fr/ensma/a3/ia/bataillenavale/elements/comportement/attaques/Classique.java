package fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques;

import fr.ensma.a3.ia.bataillenavale.elements.map.Case;
import fr.ensma.a3.ia.bataillenavale.outils.MortPersonnageException;

public class Classique implements ICompoAttaque{

    @Override
    public void attaquer(IAttaquant att, Case cible) throws MortPersonnageException {
        System.out.println("Attaque classique");
        cible.estAttaque(att.getPuissAttaque());
    }
    
}

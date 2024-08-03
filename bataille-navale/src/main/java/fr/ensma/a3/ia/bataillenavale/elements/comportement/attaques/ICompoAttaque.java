package fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques;

import fr.ensma.a3.ia.bataillenavale.elements.map.Case;
import fr.ensma.a3.ia.bataillenavale.outils.MortPersonnageException;

public interface ICompoAttaque {
    void attaquer (IAttaquant att, final Case cible) throws MortPersonnageException;
}

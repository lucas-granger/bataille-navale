package fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques;

import fr.ensma.a3.ia.bataillenavale.outils.MortPersonnageException;

/**
 * Peut attaquer n'importe qui...
 */
public interface IAttaquant {

    public void attaque(final IAttaquable cible)
        throws MortPersonnageException;
        
    public Integer getPuissAttaque();
}

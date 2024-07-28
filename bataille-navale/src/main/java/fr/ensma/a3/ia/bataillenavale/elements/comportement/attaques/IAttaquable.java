package fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques;

import fr.ensma.a3.ia.bataillenavale.outils.MortPersonnageException;

/**
 * Peut-être attaqué par n'importe qui...
 */
public interface IAttaquable {
    
    public void estAttaque(final Integer puissance)
    throws MortPersonnageException;

}

package fr.ensma.a3.ia.bataillenavale.elements.map;

import fr.ensma.a3.ia.bataillenavale.elements.ElementJeu;
import fr.ensma.a3.ia.bataillenavale.outils.MortPersonnageException;

/**
 * Typage pour Observable
 * Pattern Observateur pour la case
 * @author L. Granger
 * @since 1.0
 * @version 1.0
 */
public interface ICase {

    /**
     * Permet de rejoindre une case
     * @param obs l'élément qui rejoint la case
     */
    void rejoindreCase(final ElementJeu obs, Integer pointsDeVie);

    /**
     * Permet de quitter la case
     * @param obs l'élément quittant la case
     */
    void quitterCase(final ElementJeu obs);

    /**
     * Provoque le déplacement de la case
     */
    void estAttaque(Integer puissAtk) throws MortPersonnageException;
}

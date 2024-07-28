package fr.ensma.a3.ia.bataillenavale.elements.comportement.etats;

import fr.ensma.a3.ia.bataillenavale.outils.AutomateTransitionException;

public interface IEtat {
    void deplacer() throws AutomateTransitionException;

    void attaquer() throws AutomateTransitionException;

    void arret() throws AutomateTransitionException;

    void subirAttaque() throws AutomateTransitionException;

    void finAttaque() throws AutomateTransitionException;
}


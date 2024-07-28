package fr.ensma.a3.ia.bataillenavale.outils;

import fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques.IAttaquable;

public class MortPersonnageException extends Exception {

    private IAttaquable elem;

    public MortPersonnageException(IAttaquable pers) {
        elem = pers;
    }

    public IAttaquable getElem() {
        return elem;
    }

}

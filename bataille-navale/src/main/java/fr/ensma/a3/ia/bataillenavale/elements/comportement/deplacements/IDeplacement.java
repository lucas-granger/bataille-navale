package fr.ensma.a3.ia.bataillenavale.elements.comportement.deplacements;

import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

public interface IDeplacement {
    void deplacer(final IDeplacable elem) throws ValParamException;
}

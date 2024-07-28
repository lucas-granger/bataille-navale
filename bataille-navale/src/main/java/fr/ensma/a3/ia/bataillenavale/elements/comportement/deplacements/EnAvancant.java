package fr.ensma.a3.ia.bataillenavale.elements.comportement.deplacements;

import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

public class EnAvancant implements IDeplacement{

    @Override
    public void deplacer(IDeplacable elem) throws ValParamException {
        if (elem == null) {
            throw new ValParamException("Param elem null...");        
        }
        System.out.println("Je me déplace et j'avance");
    }
}

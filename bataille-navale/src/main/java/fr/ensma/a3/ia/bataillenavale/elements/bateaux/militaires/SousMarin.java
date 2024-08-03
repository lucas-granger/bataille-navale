package fr.ensma.a3.ia.bataillenavale.elements.bateaux.militaires;

import fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques.IAttaquable;
import fr.ensma.a3.ia.bataillenavale.elements.map.Case;
import fr.ensma.a3.ia.bataillenavale.outils.MortPersonnageException;

public class SousMarin extends BateauMilitaire {

    public SousMarin() {
        super("Sous-Marin", 3, 3, 3);
        System.out.println(this.name +" créé : Puissance de feu = "+this.puissanceDAttaque+", Taille = "+this.taille);
    }

    @Override
    public void attaque(Case cible) throws MortPersonnageException {
        compAtt.attaquer(this, cible);
    }

    @Override
    public void attaque(IAttaquable cible) throws MortPersonnageException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attaque'");
    }

    @Override
    public Integer getPuissAttaque() {
        return this.puissanceDAttaque;
    }

}

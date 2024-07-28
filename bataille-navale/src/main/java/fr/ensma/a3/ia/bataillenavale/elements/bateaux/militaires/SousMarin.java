package fr.ensma.a3.ia.bataillenavale.elements.bateaux.militaires;

import fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques.IAttaquable;
import fr.ensma.a3.ia.bataillenavale.outils.MortPersonnageException;

public class SousMarin extends BateauMilitaire {

    public SousMarin() {
        super("Sous-Marin", 3, 3, 3);
        System.out.println(this.name +" créé : Puissance de feu = "+this.puissanceDAttaque+", Taille = "+this.taille);
    }

    @Override
    public void attaque(IAttaquable cible) throws MortPersonnageException {
        System.out.println("Attaque du "+this.name);
        cible.estAttaque(this.puissanceDAttaque);
    }

    @Override
    public Integer getPuissAttaque() {
        return this.puissanceDAttaque;
    }
}

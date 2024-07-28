package fr.ensma.a3.ia.bataillenavale.elements.bateaux.militaires;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.bataillenavale.elements.bateaux.Bateau;
import fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques.IAttaquable;
import fr.ensma.a3.ia.bataillenavale.elements.map.Case;
import fr.ensma.a3.ia.bataillenavale.outils.MortPersonnageException;

public class Torpilleur extends BateauMilitaire {

    public Torpilleur() {
        super("Torpilleur", 2, 2, 2);
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

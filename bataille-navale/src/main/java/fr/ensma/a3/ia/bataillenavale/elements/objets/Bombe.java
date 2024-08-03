package fr.ensma.a3.ia.bataillenavale.elements.objets;

import fr.ensma.a3.ia.bataillenavale.elements.ElementJeu;
import fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques.Explosion;
import fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques.IAttaquable;
import fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques.IAttaquant;
import fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques.ICompoAttaque;
import fr.ensma.a3.ia.bataillenavale.elements.map.Case;
import fr.ensma.a3.ia.bataillenavale.outils.MortPersonnageException;

public class Bombe extends ElementJeu implements IAttaquant {
    protected Integer puissanceDAttaque = 3;
    protected ICompoAttaque compAtt;

    public Bombe() {
        super(3);
        compAtt = new Explosion();
    }

    @Override
    public void estAttaque(Integer puissance) throws MortPersonnageException {
        if (this.estCoule()) {
            compAtt.attaquer(this, this.getCases().get(0));
        }
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

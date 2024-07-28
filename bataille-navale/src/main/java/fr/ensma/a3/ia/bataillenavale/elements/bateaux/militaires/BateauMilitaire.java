package fr.ensma.a3.ia.bataillenavale.elements.bateaux.militaires;


import java.util.Objects;

import fr.ensma.a3.ia.bataillenavale.elements.bateaux.Bateau;
import fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques.Classique;
import fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques.IAttaquant;
import fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques.ICompoAttaque;
import fr.ensma.a3.ia.bataillenavale.elements.comportement.deplacements.IDeplacable;
import fr.ensma.a3.ia.bataillenavale.elements.comportement.deplacements.IDeplacement;
import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

public abstract class BateauMilitaire extends Bateau implements IAttaquant, IDeplacable{
    protected Integer puissanceDAttaque;
    protected ICompoAttaque compAtt;

    public BateauMilitaire(String label, Integer taille, Integer res, Integer atk) {
        super(label, taille, res); // Appel au constructeur de la classe Bateau
        this.puissanceDAttaque = Objects.requireNonNull(atk);
        compAtt = new Classique();
    }

    public final void setCompAtt(final ICompoAttaque att) throws ValParamException {
        try {
            compAtt = Objects.requireNonNull(att);
        } catch (NullPointerException ex) {
            throw new ValParamException("Param att null...");
        }
    }

    @Override
    public void deplacer() {
        try {
            compDepl.deplacer(this);
        } catch (ValParamException ex) {
            ex.printStackTrace();
        }
    }
}

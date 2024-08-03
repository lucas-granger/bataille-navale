package fr.ensma.a3.ia.bataillenavale.elements.bateaux;

import java.util.Objects;

import fr.ensma.a3.ia.bataillenavale.elements.ElementJeu;
import fr.ensma.a3.ia.bataillenavale.elements.comportement.deplacements.IDeplacement;
import fr.ensma.a3.ia.bataillenavale.elements.comportement.deplacements.Immobile;
import fr.ensma.a3.ia.bataillenavale.outils.MortPersonnageException;
import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

public abstract class Bateau extends ElementJeu {
    public String name;
    public Integer taille;
    // Comportement de deplacement (Strategy)
    protected IDeplacement compDepl;

    // Constructeur de la classe Bateau
    public Bateau(String label, Integer taille, Integer res) {
        super(res); // Appel au constructeur de la classe ElementJeu
        this.name = Objects.requireNonNull(label);
        this.taille = Objects.requireNonNull(taille);
        compDepl = new Immobile();
    }


    public final void setCompDepl(final IDeplacement dep) throws ValParamException {
        try {
            compDepl = Objects.requireNonNull(dep);
        } catch (NullPointerException ex) {
            throw new ValParamException("Param dep null...");
        }
    }

    @Override
    public void estAttaque(Integer puissance) throws MortPersonnageException {
    }
}

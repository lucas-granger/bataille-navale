package fr.ensma.a3.ia.bataillenavale.elements.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import fr.ensma.a3.ia.bataillenavale.elements.ElementJeu;
import fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques.IAttaquable;
import fr.ensma.a3.ia.bataillenavale.outils.MortPersonnageException;


public class Case implements ICase, IAttaquable{
    private Plateau plateau;
    private Integer colonne;
    private Integer ligne;
    public Map<ElementJeu, Integer> pointsDeVieParElement;

    public Case(Plateau plateau, Integer colonne, Integer ligne) {
        this.plateau = plateau;
        this.colonne = colonne;
        this.ligne = ligne;
        this.pointsDeVieParElement = new HashMap<>();
    }

    public Plateau getPlateau() {
        return this.plateau;
    }

    public Integer getColonne() {
        return this.colonne;
    }

    public Integer getLigne() {
        return this.ligne;
    }

    public boolean contientElement(ElementJeu element) {
        return this.pointsDeVieParElement.containsKey(element);
    }

    @Override
    public void rejoindreCase(ElementJeu obs, Integer pointsDeVie) {
        this.pointsDeVieParElement.put(obs, pointsDeVie);
        obs.ajouterCase(this);
    }

    @Override
    public void quitterCase(ElementJeu obs) {
        this.pointsDeVieParElement.remove(obs);
        obs.supprimerCase(this);

    }

    @Override
    public void estAttaque(Integer puissAtk) throws MortPersonnageException {
        Set<ElementJeu> elements = this.pointsDeVieParElement.keySet();
        for (ElementJeu element : elements) {
            Integer pointsDeVieActuels = this.pointsDeVieParElement.get(element);
            this.pointsDeVieParElement.put(element, pointsDeVieActuels - puissAtk);
            element.estAttaque(puissAtk);
            System.out.println(element + " : Oh non ma vie!!!" + pointsDeVieActuels + "-->" + this.pointsDeVieParElement.get(element));
            if (element.estCoule()) {
                System.out.println(element + " : Argh je meurs...");
                throw new MortPersonnageException(element);
            }
        }
    }
    public void stringify() {
        System.out.println(this.pointsDeVieParElement);
    }


    // @Override
    // public void estAttaque(Integer puissance) throws MortPersonnageException {
    //     Integer pointsDeVieAvant = pointsDeVie;
    //     pointsDeVie = pointsDeVie - puissance;
    //     logger.info("Aiieee !! ça fait mal quand même !! " + pointsDeVieAvant + " --> " + pointsDeVie);
    //     if (pointsDeVie <= 0) {
    //         logger.warn("Ahhh ... je meurs .... ");
    //         throw new MortPersonnageException(this);
    //     }
    // }

    // @Override
    // public String getIdentPerso() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getIdentPerso'");
    // }
}


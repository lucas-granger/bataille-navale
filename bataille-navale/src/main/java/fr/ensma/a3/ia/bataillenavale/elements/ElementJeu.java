package fr.ensma.a3.ia.bataillenavale.elements;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.bataillenavale.elements.comportement.ISuperposable;
import fr.ensma.a3.ia.bataillenavale.elements.comportement.attaques.IAttaquable;
import fr.ensma.a3.ia.bataillenavale.elements.map.Case;

/**
 * Modélisation d'un élément de jeu.
 *
 * @author L. Granger
 * @since 1.0
 * @version 1.0
 * @see ISuperposable
 */

public abstract class ElementJeu implements ISuperposable, IAttaquable {
    public Integer resistance;
    protected List<Case> cases; // Liste des cases composant l'élément

    public ElementJeu(Integer res) {
        this.resistance = res;
        this.cases = new ArrayList<>();
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    public Boolean estDetruit() {
        for (Case c : this.cases) {
            if (c.pointsDeVieParElement.get(this) <= 0) {
                return false;
            }
        }
        return true;
    }

    // Méthode pour ajouter une case à l'élément
    public void ajouterCase(Case nouvelleCase) {
        this.cases.add(nouvelleCase);
    }
    
    public void supprimerCase(Case ancienneCase) {
        this.cases.remove(ancienneCase);
    }

    @Override
    public boolean peutEtreSuperposeAvec(ISuperposable autre) {
        // Par défaut, un élément ne peut pas être superposé avec un autre
        return false;
    }

    public boolean estCoule() {
        for (Case cell : cases) {
            if (cell.pointsDeVieParElement.get(this) > 0) {
                return false; // The boat is not sunk if any case still has life
            }
        }
        return true; // All cases are at 0 or below
    }

    // /**
    //  * Redéfinition de toString.
    //  */
    // @Override
    // public String toString() {
    //     return " ----> " + laBase.toString();
    // }

    /**
     * Redéfinition de equals.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        //ElementJeu other = (ElementJeu) obj;
        return true;
    }

    // /**
    //  * Redéfinition de hashCode pour conformité à equals
    //  *
    //  * @see equals
    //  */
    // @Override
    // public Integer hashCode() {
    //     final Integer prime = 31;
    //     Integer result = 1;
    //     result = prime * result + nivVie.hashCode();
    //     result = prime * result + laBase.hashCode();
    //     return result;
    // }

    // private static Logger logger = LogManager.getLogger(ElementJeu.class);
}

package fr.ensma.a3.ia.bataillenavale;

public class Jeu {
    public Boolean jeuTermine = false;
    public Joueur joueur1;
    public Joueur joueur2;

    public Jeu() {

        this.joueur1 = new JoueurHumain();
        System.out.println("Jeu créé");
        joueur1.placeBoats();
        while(!this.jeuTermine) {
            joueur1.choisirAction();
            joueur1.attaquer(joueur1);
        }
    }
}

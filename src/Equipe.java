/**
 * Created by Aline on 25/10/2016.
 */
public class Equipe {
    private String nom;
    private Joueur[] gardien;
    private Joueur[] defenseur;
    private Joueur[] milieu;
    private Joueur[] attaquant;
    private int score;
    private Equipe adversaire;

    public Equipe(String nom) {
        this.nom = nom;
        this.score = 0; //at the begining of a game a team have no points
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Joueur[] getGardien() {
        return gardien;
    }

    public void setGardien(Joueur[] gardien) {
        this.gardien = gardien;
    }

    public Joueur[] getDefenseur() {
        return defenseur;
    }

    public void setDefenseur(Joueur[] defenseur) {
        this.defenseur = defenseur;
    }

    public Joueur[] getMilieu() {
        return milieu;
    }

    public void setMilieu(Joueur[] milieu) {
        this.milieu = milieu;
    }

    public Joueur[] getAttaquant() {
        return attaquant;
    }

    public void setAttaquant(Joueur[] attaquant) {
        this.attaquant = attaquant;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Equipe getAdversaire() {
        return adversaire;
    }

    public void setAdversaire(Equipe adversaire) {
        this.adversaire = adversaire;
    }

    public Joueur choixJoueurEngagement() {
        int aleatoire = (int) (Math.random() * 4);
        return this.getMilieu()[aleatoire];
    }
}

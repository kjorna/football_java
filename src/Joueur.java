/**
 * Created by Aline on 25/10/2016.
 */
public class Joueur {
    private int numero;
    private String nom;
    private String prenom;
    private String poste;
    private int[] caracteristique;
    private Equipe equipe;
    private Joueur adversaire;

    public Joueur(int numero, String nom, String prenom, String poste, int[] caracteristique, Equipe equipe) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.caracteristique = caracteristique;
        this.equipe = equipe;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int[] getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(int[] caracteristique) {
        this.caracteristique = caracteristique;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Joueur getAdversaire() {
        return adversaire;
    }

    public void setAdversaire(Joueur adversaire) {
        this.adversaire = adversaire;
    }

    /**
     * choixActionJoueur
     * Choisi une action pour le joueur qui a la balle
     *
     * @return une action au format String
     */
    public String choixActionJoueur() {
        String poste = this.getPoste();
        String[] choix;
        int aleatoire;
        switch (poste) {
            case "gardien":
                choix = new String[]{"passeCourte", "passeLongue"};
                aleatoire = (int) (Math.random() * 2); //nombre aléatoire entre 0 et 1
                return choix[aleatoire];
            case "defenseur":
                choix = new String[]{"passeCourte", "passeLongue", "tirLointain"};
                aleatoire = (int) (Math.random() * 3); //nombre aléatoire entre 0 et 2
                return choix[aleatoire];
            case "milieu":
                choix = new String[]{"passeCourte", "tirLointain"};
                aleatoire = (int) (Math.random() * 2); //nombre aléatoire entre 0 et 1
                return choix[aleatoire];
            case "attaquant":
                return "tirCourt";
            default:
                return "error";
        }
    }

    /**
     * choixJoueurPasseCourte
     * Choisi un joueur pour faire une passe courte
     *
     * @return un Joueur
     */
    public Joueur choixJoueurPasseCourte() {
        String poste = this.getPoste();
        Joueur[] choix;
        int aleatoire;
        switch (poste) {
            case "gardien":
                choix = this.equipe.getDefenseur();
                aleatoire = (int) (Math.random() * 4); //nombre aléatoire entre 0 et 3
                return choix[aleatoire];
            case "defenseur":
                choix = this.equipe.getMilieu();
                aleatoire = (int) (Math.random() * 4); //nombre aléatoire entre 0 et 3
                return choix[aleatoire];
            case "milieu":
                choix = this.equipe.getAttaquant();
                aleatoire = (int) (Math.random() * 2); //nombre aléatoire entre 0 et 1
                return choix[aleatoire];
            case "attaquant":
                return this; //Au cas où l'attanquant fait une passe courte (même si c'est carrément impossible)
            default:
                return this;
        }
    }

    /**
     * choixJoueurPasseLongue
     * Choisi un joueur pour faire une passe longue
     *
     * @return un Joueur
     */
    public Joueur choixJoueurPasseLongue() {
        String poste = this.getPoste();
        Joueur[] choix;
        int aleatoire;
        switch (poste) {
            case "gardien":
                choix = this.equipe.getMilieu();
                aleatoire = (int) (Math.random() * 4); //nombre aléatoire entre 0 et 3
                return choix[aleatoire];
            case "defenseur":
                choix = this.equipe.getAttaquant();
                aleatoire = (int) (Math.random() * 2); //nombre aléatoire entre 0 et 1
                return choix[aleatoire];
            case "milieu":
                return this; //Au cas où le milieu fait une passe longue (même si c'est carrément impossible)
            case "attaquant":
                return this; //Au cas où l'attanquant fait une passe longue (même si c'est carrément impossible)
            default:
                return this;
        }
    }

    public Joueur testReussitePasse(Joueur allie, String typePasse) {
        if (allie.getAdversaire() == null) { // l'allié n'a pas d'aversaire
            return allie;
        } else { // on fait les calculs

            int caracteristiquePasse;

            if (typePasse == "passeCourte") {
                caracteristiquePasse = this.getCaracteristique()[1];
            } else {
                caracteristiquePasse = this.getCaracteristique()[2];
            }

            Joueur adversaire = allie.getAdversaire();
            int caracteristiqueDefenseAdversaire = adversaire.getCaracteristique()[0];
            double probabilite;

            if (caracteristiquePasse > caracteristiqueDefenseAdversaire) {
                probabilite = caracteristiquePasse / 100.0; //la probabilité de réussite à comparer avec le nombre aléatoire
            } else { // caractéristique de la passe inférieur à la défense de l'adversaire
                probabilite = 0.2; //la probabilité de réussite à comparer avec le nombre aléatoire
            }

            double aleatoire = Math.random();

            if (aleatoire < probabilite) {
                // le joueur a réussi sa passe
                return allie;
            } else {
                // le joueur a loupé sa passe
                return adversaire;
            }
        }
    }

    public Joueur testReussiteTir(String typeTir) {

        int caracteristiqueTir;

        if (typeTir == "tirCourt") {
            caracteristiqueTir = this.getCaracteristique()[3]; // réccupère la caractéristique du tir court
        } else {
            caracteristiqueTir = this.getCaracteristique()[4]; // celui du tir long
        }
        Joueur adversaire = this.getEquipe().getAdversaire().getGardien()[0];
        int caracteristiqueDefenseAdversaire = adversaire.getCaracteristique()[0];
        double probabilite;

        if (caracteristiqueTir > caracteristiqueDefenseAdversaire) {
            probabilite = (double) caracteristiqueTir / 100.0; //la probabilité de réussite à comparer avec le nombre aléatoire
        } else { // caractéristique du tir inférieur à la défense du gardien
            probabilite = 0.2; //la probabilité de réussite à comparer avec le nombre aléatoire
        }

        double aleatoire = Math.random();

        if (aleatoire < probabilite) {
            System.out.println("buuuuuuuut");
            // le joueur a réussi son tir et a marqué un but GOOOAAAAAAL !!
            this.getEquipe().setScore(this.getEquipe().getScore() + 1); // incrémentation du score de l'équipe
            return adversaire.getEquipe().choixJoueurEngagement();
        } else {
            // le joueur a loupé son tir
            System.out.println("tir loupé");
            return adversaire;
        }
    }
}



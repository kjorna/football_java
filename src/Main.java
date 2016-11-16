/**
 * Created by Aline on 25/10/2016.
 */
public class Main {

    public static Joueur choixJoueurDebut(Equipe e1, Equipe e2) {
        double aleatoire = Math.random();
        Joueur joueur;
        if (aleatoire < 0.5) {
            //equipe 1 commence
            System.out.println("l'équipe " + e1.getNom() + " commence !");
            joueur = e1.choixJoueurEngagement();
        } else {
            //equipe 2 commence
            System.out.println("l'équipe " + e2.getNom() + " commence !");
            joueur = e2.choixJoueurEngagement();
        }
        System.out.println("c'est le joueur " + joueur.getNom() + " " + joueur.getPrenom() + " n°" + joueur.getNumero() + " qui engage la partie");
        return joueur;
    }


    public static void main(String[] args) {
        Equipe equipe1 = new Equipe("France");
        Equipe equipe2 = new Equipe("Japon");

        // Joueur de l'équipe 1
        Joueur dylan1 = new Joueur(1, "Freismuth", "Dylan", "gardien", new int[]{20, 80, 80, 80, 80}, equipe1);
        Joueur dylan2 = new Joueur(2, "Freismuth", "Dylan", "defenseur", new int[]{20, 80, 80, 80, 80}, equipe1);
        Joueur dylan3 = new Joueur(3, "Freismuth", "Dylan", "defenseur", new int[]{20, 80, 80, 80, 80}, equipe1);
        Joueur dylan4 = new Joueur(4, "Freismuth", "Dylan", "defenseur", new int[]{20, 80, 80, 80, 80}, equipe1);
        Joueur dylan5 = new Joueur(5, "Freismuth", "Dylan", "defenseur", new int[]{20, 80, 80, 80, 80}, equipe1);
        Joueur dylan6 = new Joueur(6, "Freismuth", "Dylan", "milieu", new int[]{20, 80, 80, 80, 80}, equipe1);
        Joueur dylan7 = new Joueur(7, "Freismuth", "Dylan", "milieu", new int[]{20, 80, 80, 80, 80}, equipe1);
        Joueur dylan8 = new Joueur(8, "Freismuth", "Dylan", "milieu", new int[]{20, 80, 80, 80, 80}, equipe1);
        Joueur dylan9 = new Joueur(9, "Freismuth", "Dylan", "milieu", new int[]{20, 80, 80, 80, 80}, equipe1);
        Joueur dylan10 = new Joueur(10, "Freismuth", "Dylan", "attaquant", new int[]{20, 80, 80, 80, 80}, equipe1);
        Joueur dylan11 = new Joueur(11, "Freismuth", "Dylan", "attaquant", new int[]{20, 80, 80, 80, 80}, equipe1);

        // Joueur de l'équipe 2
        Joueur aline1 = new Joueur(1, "Freismuth", "Aline", "gardien", new int[]{20, 80, 80, 80, 80}, equipe2);
        Joueur aline2 = new Joueur(2, "Freismuth", "Aline", "defenseur", new int[]{20, 80, 80, 80, 80}, equipe2);
        Joueur aline3 = new Joueur(3, "Freismuth", "Aline", "defenseur", new int[]{20, 80, 80, 80, 80}, equipe2);
        Joueur aline4 = new Joueur(4, "Freismuth", "Aline", "defenseur", new int[]{20, 80, 80, 80, 80}, equipe2);
        Joueur aline5 = new Joueur(5, "Freismuth", "Aline", "defenseur", new int[]{20, 80, 80, 80, 80}, equipe2);
        Joueur aline6 = new Joueur(6, "Freismuth", "Aline", "milieu", new int[]{20, 80, 80, 80, 80}, equipe2);
        Joueur aline7 = new Joueur(7, "Freismuth", "Aline", "milieu", new int[]{20, 80, 80, 80, 80}, equipe2);
        Joueur aline8 = new Joueur(8, "Freismuth", "Aline", "milieu", new int[]{20, 80, 80, 80, 80}, equipe2);
        Joueur aline9 = new Joueur(9, "Freismuth", "Aline", "milieu", new int[]{20, 80, 80, 80, 80}, equipe2);
        Joueur aline10 = new Joueur(10, "Freismuth", "Aline", "attaquant", new int[]{20, 80, 80, 80, 80}, equipe2);
        Joueur aline11 = new Joueur(11, "Freismuth", "Aline", "attaquant", new int[]{20, 80, 80, 80, 80}, equipe2);

        //adversaires
        dylan3.setAdversaire(aline11);
        aline3.setAdversaire(dylan11);

        dylan4.setAdversaire(aline10);
        aline4.setAdversaire(dylan10);

        dylan6.setAdversaire(aline9);
        aline6.setAdversaire(dylan9);

        dylan7.setAdversaire(aline8);
        aline7.setAdversaire(dylan8);

        dylan8.setAdversaire(aline7);
        aline8.setAdversaire(dylan7);

        dylan9.setAdversaire(aline6);
        aline9.setAdversaire(dylan6);

        dylan10.setAdversaire(aline4);
        aline10.setAdversaire(dylan4);

        dylan11.setAdversaire(aline3);
        aline11.setAdversaire(dylan3);

        // Composition de l'équipe1
        Joueur[] gardien1 = new Joueur[]{dylan1};
        Joueur[] defenseur1 = new Joueur[]{dylan2, dylan3, dylan4, dylan5};
        Joueur[] milieu1 = new Joueur[]{dylan6, dylan7, dylan8, dylan9};
        Joueur[] attaquant1 = new Joueur[]{dylan10, dylan11};

        equipe1.setGardien(gardien1);
        equipe1.setDefenseur(defenseur1);
        equipe1.setMilieu(milieu1);
        equipe1.setAttaquant(attaquant1);

        // Composition de l'équipe2
        Joueur[] gardien2 = new Joueur[]{aline1};
        Joueur[] defenseur2 = new Joueur[]{aline2, aline3, aline4, aline5};
        Joueur[] milieu2 = new Joueur[]{aline6, aline7, aline8, aline9};
        Joueur[] attaquant2 = new Joueur[]{aline10, aline11};

        equipe2.setGardien(gardien2);
        equipe2.setDefenseur(defenseur2);
        equipe2.setMilieu(milieu2);
        equipe2.setAttaquant(attaquant2);

        equipe1.setAdversaire(equipe2);
        equipe2.setAdversaire(equipe1);

        Joueur balle = choixJoueurDebut(equipe1, equipe2);

        for (int temps = 0; temps < 90; temps++) {
            System.out.println(balle.getNom() + " " + balle.getPrenom() + " n°" + balle.getNumero() + " a la balle.");
            String action = balle.choixActionJoueur();
            Joueur allie;
            switch (action) {
                case "passeCourte":
                    allie = balle.choixJoueurPasseCourte();
                    System.out.println(balle.getNom() + " " + balle.getPrenom() + " n°" + balle.getNumero() + " choisi de faire une passe courte à " + allie.getNom() + " " + allie.getPrenom() + " n°" + allie.getNumero() + "");
                    balle = balle.testReussitePasse(allie, action);
                    break;
                case "passeLongue":
                    allie = balle.choixJoueurPasseLongue();
                    System.out.println(balle.getNom() + " " + balle.getPrenom() + " n°" + balle.getNumero() + " choisi de faire une passe longue à " + allie.getNom() + " " + allie.getPrenom() + " n°" + allie.getNumero() + "");
                    balle = balle.testReussitePasse(allie, action);
                    break;
                case "tirCourt":
                    System.out.println("essai");
                    balle = balle.testReussiteTir(action);
                    break;
                case "tirLointain":
                    System.out.println("essai");
                    balle = balle.testReussiteTir(action);
                    break;
            }
        }

        System.out.println("score : " + equipe1.getNom() + " " + equipe1.getScore() + "-" + equipe2.getScore() + " " + equipe2.getNom());


    }
}

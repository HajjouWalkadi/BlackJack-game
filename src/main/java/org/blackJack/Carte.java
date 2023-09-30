package org.blackJack;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class Carte {

   // method using ArrayList
    /*public static ArrayList<ArrayList<Integer>> getALLCartes() {
        ArrayList<ArrayList<Integer>> Cartes = new ArrayList<>();
        for (int form = 1; form <= 4; form++) {
            for (int i = 1; i <= 13; i++) {
                ArrayList<Integer> card = new ArrayList<>();
                card.add(i);
                card.add(form);
                Cartes.add(card);
            }
        }
        return Cartes;
    }*/



        public static int[][] getALLCartes() {
            int[][] Cartes = new int[52][2];
            int index = 0;
            for (int form = 1; form <= 4; form++) {
                for (int i = 1; i <= 13; i++) {
                    Cartes[index][0] = i;
                    Cartes[index][1] = form;
                    index++;
                }
            }
            return Cartes;
        }


    //methodes pour mélanger les cartes
    public static Object[] extraire_ieme_carte(int[][] cartes, int indice) {
        int[][] carteExtraite = {cartes[indice]};
        int[][] cartesRestantes = new int[cartes.length - 1][2];
        int index = 0;

        for (int i = 0; i < cartes.length; i++) {
            if (i != indice) {
                cartesRestantes[index] = cartes[i];
                index++;
            }
        }

        return new Object[]{carteExtraite, cartesRestantes};
    }

    public static Object[] tirer_une_carte(int[][] cartes) {
        int indice = (int) (Math.random() * cartes.length);
        return extraire_ieme_carte(cartes, indice);
    }

    public static int[][] melanger_jeu_cartes(int[][] cartes) {
        int[][] jeuMelange = new int[cartes.length][2];

        for (int i = 0; i < cartes.length; i++) {
            Object[] result = tirer_une_carte(cartes);
            int[][] carteTiree = (int[][]) result[0];
            cartes = (int[][]) result[1];
            jeuMelange[i] = carteTiree[0];
        }

        return jeuMelange;
    }

    public static int[][][] piocher_n_cartes(int[][] cartes, int n) {
        if (n <= 0 || n > cartes.length) {
            System.out.println("Nombre invalide de cartes à piocher.");
            return null;
        }

        int[][] cartesPiochees = new int[n][2];
        int[][] cartesRestantes = new int[cartes.length - n][2];

        // Copier les n premières cartes dans cartesPiochees
        for (int i = 0; i < n; i++) {
            cartesPiochees[i] = cartes[i];
        }

        // Copier les cartes restantes dans cartesRestantes
        for (int i = n; i < cartes.length; i++) {
            cartesRestantes[i - n] = cartes[i];
        }

        return new int[][][] { cartesPiochees, cartesRestantes };
    }



    public static int[][] defausser_cartes(int[][] pioche, int[][] cartesADefaucher) {
        int taillePioche = pioche.length;
        int tailleCartesADefaucher = cartesADefaucher.length;
        int[][] nouvellePioche = new int[taillePioche + tailleCartesADefaucher][2];

        // Copier les cartes de la pioche d'origine dans la nouvelle pioche
        for (int i = 0; i < taillePioche; i++) {
            nouvellePioche[i] = pioche[i];
        }

        // Copier les cartes à défausser à la fin de la nouvelle pioche
        for (int i = 0; i < tailleCartesADefaucher; i++) {
            nouvellePioche[taillePioche + i] = cartesADefaucher[i];
        }

        return nouvellePioche;
    }


}




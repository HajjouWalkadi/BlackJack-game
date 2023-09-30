package org.blackJack;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!!");

        int[][] allCartes = Carte.getALLCartes();

        // Now you can do something with the allCartes array, like printing its contents
        for (int i = 0; i < allCartes.length; i++) {
            int value = allCartes[i][0];
            int form = allCartes[i][1];
            System.out.println("Card: " + value + " of Form: " + form);
        }

        // Call the piocher_n_cartes method
        int indice = 2;
        int[][][] piocheResult = Carte.piocher_n_cartes(allCartes, indice);
        int[][] cartesPiochees = piocheResult[0];
        int[][] cartesRestantes = piocheResult[1];

        System.out.println("Cartes piochées: " + java.util.Arrays.deepToString(cartesPiochees));
        System.out.println("Cartes restantes: " + java.util.Arrays.deepToString(cartesRestantes));

        // Call the extraire_ieme_carte method
        int[][] carteExtraite = (int[][]) Carte.extraire_ieme_carte(allCartes, indice)[0];
        System.out.println("Carte extraite: [" + carteExtraite[0][0] + " " + carteExtraite[0][1] + "]");

        // Call the tirer_une_carte method
        int[][] carteTiree = (int[][]) Carte.tirer_une_carte(allCartes)[0];
        System.out.println("Carte tirée: [" + carteTiree[0][0] + " " + carteTiree[0][1] + "]");

        // Call the melanger_jeu_cartes method
        int[][] jeuMelange = Carte.melanger_jeu_cartes(allCartes);
        System.out.println("Jeu mélangé: " + java.util.Arrays.deepToString(jeuMelange));
    }
}



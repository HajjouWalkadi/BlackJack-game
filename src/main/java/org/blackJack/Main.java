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

        // Call the extraire_ieme_carte method
        int indice = 2;
        Object[] extractionResult = Carte.extraire_ieme_carte(allCartes, indice);
        int[][] carteExtraite = (int[][]) extractionResult[0];
        int[][] cartesRestantes = (int[][]) extractionResult[1];
        System.out.println("Carte extraite: [" + carteExtraite[0][0] + " " + carteExtraite[0][1] + "]");
        System.out.println("Cartes restantes: " + java.util.Arrays.deepToString(cartesRestantes));

        // Call the tirer_une_carte method
        Object[] tirageResult = Carte.tirer_une_carte(allCartes);
        int[][] carteTiree = (int[][]) tirageResult[0];
        int[][] cartesApresTirage = (int[][]) tirageResult[1];
        System.out.println("Carte tirée: [" + carteTiree[0][0] + " " + carteTiree[0][1] + "]");
        System.out.println("Cartes après tirage: " + java.util.Arrays.deepToString(cartesApresTirage));


    }
}


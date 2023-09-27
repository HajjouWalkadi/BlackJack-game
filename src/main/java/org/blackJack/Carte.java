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





}




package org.blackJack;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to BlackJack!!");

        ArrayList<ArrayList<Integer>> allCartes = Carte.getALLCartes();

        for (ArrayList<Integer> card : allCartes) {
            System.out.println("Card: " + card.get(0) + " of Form: " + card.get(1));
        }
    }
}


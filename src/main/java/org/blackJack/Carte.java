package org.blackJack;
import java.util.ArrayList;

public class Carte {
    public static ArrayList<ArrayList<Integer>> getALLCartes() {
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
    }
}

package org.blackJack;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;


        System.out.println("************************************************************************************************************************************************");
        System.out.println("\n" +
                " __    __    ___  _        __   ___   ___ ___    ___      ______   ___       ____   _       ____    __  __  _   ____   ____    __  __  _ \n" +
                "|  |__|  |  /  _]| |      /  ] /   \\ |   |   |  /  _]    |      | /   \\     |    \\ | |     /    |  /  ]|  |/ ] |    | /    |  /  ]|  |/ ]\n" +
                "|  |  |  | /  [_ | |     /  / |     || _   _ | /  [_     |      ||     |    |  o  )| |    |  o  | /  / |  ' /  |__  ||  o  | /  / |  ' / \n" +
                "|  |  |  ||    _]| |___ /  /  |  O  ||  \\_/  ||    _]    |_|  |_||  O  |    |     || |___ |     |/  /  |    \\  __|  ||     |/  /  |    \\ \n" +
                "|  `  '  ||   [_ |     /   \\_ |     ||   |   ||   [_       |  |  |     |    |  O  ||     ||  _  /   \\_ |     \\/  |  ||  _  /   \\_ |     \\\n" +
                " \\      / |     ||     \\     ||     ||   |   ||     |      |  |  |     |    |     ||     ||  |  \\     ||  .  |\\  `  ||  |  \\     ||  .  |\n" +
                "  \\_/\\_/  |_____||_____|\\____| \\___/ |___|___||_____|      |__|   \\___/     |_____||_____||__|__|\\____||__|\\_| \\____||__|__|\\____||__|\\_|\n" +
                "                                                                                                                                         \n");
        System.out.println("************************************************************************************************************************************************");


        int[][] deck = Carte.getALLCartes();
        int[][] playerHand = new int[0][2];
        int[][] dealerHand = new int[0][2];
        int playerScore = 0;
        int dealerScore = 0;
        boolean gameOver = false;
        boolean playerTurn = true;

        // Shuffle the deck
        deck = Carte.melanger_jeu_cartes(deck);

    }
}




package org.blackJack;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
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

            while (!gameOver) {
                if (playerTurn) {
                    System.out.println("\nPlayer's turn:");
                    System.out.println("Your hand: ");
                    playerHand = Carte.defausser_cartes(playerHand, playerHand);
                    playerHand = Carte.defausser_cartes(playerHand, Carte.piocher_n_cartes(deck, 2)[0]);
                    playerScore = calculateHandValue(playerHand);
                    printHand(playerHand, playerScore);
                    if (playerScore == 21) {
                        System.out.println("Blackjack! Player wins!");
                        gameOver = true;
                    } else if (playerScore > 21) {
                        System.out.println("Player busts! Dealer wins!");
                        gameOver = true;
                    } else {
                        System.out.print("Do you want to hit (h) or stand (s): ");
                        String choice = scanner.nextLine().toLowerCase();
                        if (choice.equals("s")) {
                            playerTurn = false;
                        } else if (choice.equals("h")) {
                            int[][] newCard = Carte.piocher_n_cartes(deck, 1)[0];
                            playerHand = Carte.defausser_cartes(playerHand, newCard);
                        }
                    }
                }else {
                    System.out.println("\nDealer's turn:");
                    System.out.println("Dealer's hand: ");
                    dealerHand = Carte.defausser_cartes(dealerHand, dealerHand);
                    dealerHand = Carte.defausser_cartes(dealerHand, Carte.piocher_n_cartes(deck, 2)[0]);
                    dealerScore = calculateHandValue(dealerHand);
                    printHand(dealerHand, dealerScore);

                    while (dealerScore < 17) {
                        dealerHand = Carte.defausser_cartes(dealerHand, Carte.piocher_n_cartes(deck, 1)[0]);
                        dealerScore = calculateHandValue(dealerHand);
                        printHand(dealerHand, dealerScore);
                    }
                    if (dealerScore > 21) {
                        System.out.println("Dealer busts! Player wins!");
                    } else if (playerScore > dealerScore) {
                        System.out.println("Player wins!");
                    } else if (dealerScore > playerScore) {
                        System.out.println("Dealer wins!");
                    } else {
                        System.out.println("It's a push! ");
                    }

                    gameOver = true;
                }
                }
            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = scanner.nextLine().toLowerCase();
        } while (playAgain.equals("yes"));

        System.out.println("\nThanks for playing!");
    }

    public static int calculateHandValue(int[][] hand) {
        int value = 0;
        int numAces = 0;

        for (int i = 0; i < hand.length; i++) {
            int cardValue = hand[i][0];
            if (cardValue == 1) {
                numAces++;
                value += 11;
            } else if (cardValue >= 10) {
                value += 10;
            } else {
                value += cardValue;
            }
        }

        while (value > 21 && numAces > 0) {
            value -= 10;
            numAces--;
        }

        return value;
    }

    public static void printHand(int[][] hand, int score) {
        for (int i = 0; i < hand.length; i++) {
            int value = hand[i][0];
            String form = getForm(hand[i][1]);
            System.out.println(value + " of " + form);
        }
        System.out.println("Hand value: " + score);
    }

    public static String getForm(int form) {
        switch (form) {
            case 1:
                return "Hearts";
            case 2:
                return "Diamonds";
            case 3:
                return "Clubs";
            case 4:
                return "Spades";
            default:
                return "Unknown";
        }
    }
}




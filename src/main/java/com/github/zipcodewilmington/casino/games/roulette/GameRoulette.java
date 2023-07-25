package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class GameRoulette implements GameInterface {
        public static void main(String[] args) {
        GameRoulette game = new GameRoulette();
        game.run();
    }
    Scanner console = new Scanner(System.in);
    Random rand = new Random();
    PlayerRoulette player;
    int bank = 100;
//    int max = bank;
//    int spins = 0;

    public void run() {
        play();
        int bet = getBet();
        int choice = getChoice("What would you like to bet on?", "1. odd", "2. even");
        int spin = getSpin();
        compareResults(bet, choice, spin);
//        spins++;
        try {
            broke();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        quit();
    }

    public void play() {
        System.out.println("Welcome to Roulette!");

//        int bet = getChoice("You have $" + bank + " in your bank.", "The maximum amount you can bet is $" + max + ".", "How much would you like to bet?");
//        if (bet > max) {
//            System.out.println("You cannot bet more than $" + max + ".");
//            System.out.println("How much would you like to bet?");
//            bet = console.nextInt();
//        }


    }


    public void compareResults(int bet, int choice, int spin) {
        if (choice == 1) {
            if (spin % 2 == 1) {
//            if (spin == 1 || spin == 3 || spin == 5 || spin == 7 || spin == 9 || spin == 11 || spin == 13 || spin == 15 ||
//                    spin == 17 || spin == 19 || spin == 21 || spin == 23 || spin == 25 || spin == 27 || spin == 29 ||
//                    spin == 31 || spin == 33 || spin == 35 || spin == 37) {
                System.out.println("You win!");
                System.out.println("the spin was " + spin);
                bank += bet;
                System.out.println("You now have $" + bank + " in your bank.");
            } else {
                System.out.println("You lose!");
                System.out.println("the spin was " + spin);
                bank = bank - bet;
                System.out.println("You now have $" + bank + " in your bank.");
            }
        } else if (choice == 2) {
            if (spin % 2 == 0) {
//            if (spin == 0 ||spin == 2 || spin == 4 || spin == 6 || spin == 8 || spin == 10 || spin == 12 || spin == 14 ||
//                    spin == 16 || spin == 18 || spin == 20|| spin == 22 || spin == 24|| spin == 26 || spin == 28
//                    || spin == 30 || spin == 32 || spin == 34 || spin == 36) {
                System.out.println("You win!");
                System.out.println("the spin was " + spin);
                bank = bank + bet;
                System.out.println("You now have $" + bank + " in your bank.");
            } else {
                System.out.println("You lose!");
                System.out.println("the spin was " + spin);
                bank = bank - bet;
                System.out.println("You now have $" + bank + " in your bank.");
            }
        }
    }

    int getSpin() {
        int spin = rand.nextInt(38);
        return spin;
    }

     int getChoice(String x, String x1, String x2) {
        System.out.println(x);
        System.out.println(x1);
        System.out.println(x2);

        int choice = console.nextInt();
        if (choice != 2 && choice != 1) {
            System.out.println("Please enter a valid choice. 1 or 2.");
            choice = console.nextInt();
        }
        return choice;
    }

//    int bet = getChoice("You have $" + bank + " in your bank.", "The maximum amount you can bet is $" + max + ".", "How much would you like to bet?");
//        if (bet > max) {
//            System.out.println("You cannot bet more than $" + max + ".");
//            System.out.println("How much would you like to bet?");
//            bet = console.nextInt();

    int getBet() {
        System.out.println("You have $" + bank + " in your bank.\n" +
                "The maximum amount you can bet is $" + bank + ".\n" +
                " How much would you like to bet?");
        int bet = console.nextInt();
        if (bet > bank) {
            System.out.println("You cannot bet more than $" + bank + ".");
            System.out.println("How much would you like to bet?");
            bet = console.nextInt();
        }
        return bet;
    }

    @Override
    public void add(Player player) {

    }

    @Override
    public void remove(Player player) {

    }

    @Override
    public void displayInstructions() {

    }

    @Override
    public Boolean checkWinner() {
        return null;
    }

    public void quit() {
        System.out.println("Thank you for playing! Press 1 to replay or 2 to return to the casino lobby.");

        int choice = console.nextInt();
        if (choice == 1) {
            run();
        } else if (choice == 2) {
            //Casino casino = new Casino();
            //casino.run();
        }
    }
    public void broke() throws IOException {
        if (bank <= 0){
            System.out.println("You are out of money. Please return to the casino lobby.");

            Casino casino = new Casino();
            casino.run();
        }
    }
}
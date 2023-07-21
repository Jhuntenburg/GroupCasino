package com.github.zipcodewilmington.casino.games.rockpaperscissors;

import com.fasterxml.jackson.databind.util.ISO8601Utils;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;

public class RpsGame implements GameInterface {

    RpsPlayer player;
    String userChoice;
    String computerChoice;
    String playAgain;
    String[] choices = {"ROCK", "PAPER", "SCISSOR"};

    private final IOConsole console = new IOConsole(AnsiColor.CYAN);
    @Override
    public void run() {

        displayInstructions();

        boolean play = true;
        while(play==true) {

            getUserChoice();

            getComputerChoice();

            displayResults(userChoice, computerChoice);

            playAgain();
            if(playAgain.equalsIgnoreCase("yes")) {
                play = true;
            } else if(playAgain.equalsIgnoreCase("no")) {
                play = false;
            }

        }

    }

    @Override
    public void displayInstructions() {
        console.println("Welcome to Trillium's Rock Paper Scissor Game!");
    }

    public String getUserChoice() {
        userChoice = console.getStringInput("Enter your choice: Rock  Paper  Scissor");
       return userChoice.toUpperCase();
    }

    public String getComputerChoice() {
        Random random = new Random();
        int number = random.nextInt(3);
        computerChoice = choices[number];
        return computerChoice;
    }


    public Boolean isWinner(String userChoice, String computerChoice) {
        return (userChoice.equalsIgnoreCase("ROCK") && computerChoice.equals("SCISSOR")) ||
                (userChoice.equalsIgnoreCase("PAPER") && computerChoice.equals("ROCK")) ||
                (userChoice.equalsIgnoreCase("SCISSOR") && computerChoice.equals("PAPER"));

    }

    public void displayResults(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            console.println("It's a tie!");
        } else if (isWinner(userChoice, computerChoice)) {
            console.println("You won!");
        } else {
            console.println("You lost...");
        }
        console.println("You chose: " + userChoice + " and we chose: " + computerChoice);
    }

    public String playAgain() {
        playAgain = console.getStringInput("Would you like to play again? Enter \"yes\" or \"no\".");
        return playAgain;
    }

    @Override
    public void add(Player player) {

    }

    @Override
    public void remove(Player player) {

    }
    @Override
    public Boolean checkWinner() {
        return null;
    }
    @Override
    public void quit() {

    }

}

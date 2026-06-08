/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hangmangame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author willy
 */
public class HangmanGame {

    public static void main(String[] args) {

        //Init Scanner
        Scanner sc = new Scanner(System.in);
        
        //We add a boolean for the play again feature.
        boolean playAgain = true;

        do {

            //Word to be guessed (selects a random word from RandomWords class)
            String word = RandomWords.getRandomWord(sc);

            //Gets the selected theme
            String selectedTheme = RandomWords.getSelectedTheme();

            //Words to play with
            ArrayList<Character> wordState = new ArrayList<>();

            //List of all guessed letters
            ArrayList<Character> guessedLetters = new ArrayList<>();

            //Varibale to count wrong guesses
            int wrongGuesses = 0;

            for (int i = 0; i < word.length(); i++) {
                wordState.add('_');
            }

            //Welcome message
            System.out.println("************************");
            System.out.println("Welcome to Hangman GAME!");
            System.out.println("************************");

            //As long as the player does not run out of guesses, we will continue the game
            while (wrongGuesses < 6) {

                //We print the art correspinding to the amount of wrong guesses
                System.out.print(getHangmanArt(wrongGuesses));

                //Game start
                System.out.print("Word: ");

                //Cycles trough array of characters
                for (char c : wordState) {
                    System.out.print(c + " ");
                }
                System.out.println();// new line spacing

                //Prints out the selected theme
                System.out.println("Theme selected: " + selectedTheme);

                //Print out list of all used letters
                System.out.print("Guessed letters: ");

                for (char letter : guessedLetters) {
                    System.out.print(letter + " ");
                }

                //New line spacing
                System.out.println();

                //We ask user to guess a letter
                System.out.print("Guess a letter: ");

                //Gets the first letter from user and converts it to char
                char guess = sc.next().toLowerCase().charAt(0);

                //We insert the guessed letter into the guessedLetters ArrayList
                //if the letter has already been guessed we will output a messsage
                if (guessedLetters.contains(guess)) {
                    System.out.println("You already guessed that letter!");
                    continue;
                }

                //Adds guessed letter to the ArrayList<>
                guessedLetters.add(guess);

                //for every correct guess we show the corresponding letter in the word
                if (word.indexOf(guess) >= 0) {
                    System.out.println("Correct guess!");

                    for (int i = 0; i < word.length(); i++) {
                        //If the guessed letter matches the letter in the secret word
                        if (word.charAt(i) == guess) {
                            wordState.set(i, guess);
                        }
                    }

                    //If the player wins
                    /*We check to see if there are no more blank spaces
                    left in the word ('_'), and show the winning message*/
                    if (!wordState.contains('_')) {
                        System.out.print(getHangmanArt(wrongGuesses));
                        System.out.println("YOU WIN!");
                        System.out.println("The word was: " + word);

                        //If the user wins with 0 wrong guesses, we congratualte them well
                        if (wrongGuesses == 0) {
                            System.out.print(getHangmanArt(wrongGuesses));
                            System.out.println("FLAWLESS WIN! AMAZING!");
                            System.out.println("The word was: " + word);
                        }

                        break;//EXITS the while loop
                    }

                } else {
                    System.out.println("Wrong guess!");
                    wrongGuesses++;//For each wrong guess, we add 1 to (int wrongGuesses).
                }
            }

            //Whenever the player loses we show the full hanged man
            if (wrongGuesses >= 6) {
                System.out.print(getHangmanArt(wrongGuesses));
                System.out.println("GAME OVER");
                System.out.println("YOU LOSE!");
                System.out.println("The word was: " + word);
            }

            //Play again option
            System.out.print("Play again? (y/n): ");
            playAgain = sc.next().equalsIgnoreCase("y");

        } while (playAgain);

        System.out.println("Thanks for playing!");

        sc.close();
    }
    //Method to print out HangMan ART
    static String getHangmanArt(int wrongGuesses) {
    switch (wrongGuesses) {
        case 0:
            return """
               +----+
               |    |
               |
               |
               |
             -----
               """;

        case 1:
            return """
               +----+
               |    |
               |    0
               |
               |
             -----
               """;

        case 2:
            return """
               +----+
               |    |
               |    0
               |    |
               |
             -----
               """;

        case 3:
            return """
               +----+
               |    |
               |    0
               |   /|
               |
             -----
               """;

        case 4:
            return """
               +----+
               |    |
               |    0
               |   /|\\
               |
             -----
               """;

        case 5:
            return """
               +----+
               |    |
               |    0
               |   /|\\
               |   /
             -----
               """;

        case 6:
            return """
               +----+
               |    |
               |    0
               |   /|\\
               |   / \\
             -----
               """;

        default:
            return "";
        }
    }
}
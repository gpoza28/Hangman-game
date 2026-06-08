/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hangmangame;

/**
 *
 * @author willy
 */
import java.util.Random;
import java.util.Scanner;

public class RandomWords {

    //Theme selector
    private static String selectedTheme;

    public static String getSelectedTheme() {
        return selectedTheme;
    }
    
    //Get random word method
    public static String getRandomWord(Scanner sc) {

        Random rand = new Random();

        while (true) {

            System.out.println("Choose a theme [input the #]:");
            System.out.println("1. Animals");
            System.out.println("2. Sports");
            System.out.println("3. Countries");
            System.out.println("4. Foods");
            System.out.println("5. Jobs");
            System.out.println("6. Colours");
            System.out.print("Option: ");

            int choice = sc.nextInt();

            String[] words;

            switch (choice) {

                case 1:
                    selectedTheme = "Animals";
                    words = new String[]{
                        "dog", "cat", "horse", "giraffe", "snake",
                        "rabbit", "fish", "bear", "chicken", "monkey"
                    };
                    break;

                case 2:
                    selectedTheme = "Sports";
                    words = new String[]{
                        "football", "tennis", "basketball", "golf", "swimming",
                        "volleyball", "hockey", "baseball", "badminton", "ping pong"
                    };
                    break;

                case 3:
                    selectedTheme = "Countries";
                    words = new String[]{
                        "spain", "france", "canada", "japan", "brazil",
                        "russia", "china", "ukraine", "egypt", "mexico"
                    };
                    break;

                case 4:
                    selectedTheme = "Foods";
                    words = new String[]{
                        "bread", "icecream", "pasta", "hamburger", "rice",
                        "cake", "steak", "taco", "hotdog", "lobster"
                    };
                    break;
                
                case 5:
                    selectedTheme = "Jobs";
                    words = new String[]{
                        "doctor", "lawyer", "firefighter", "pilot", "teacher",
                        "president", "architect", "detective", "scientist", "zookeeper"
                    };
                    break;
                
                case 6:
                    selectedTheme = "Colours";
                    words = new String[]{
                        "red", "white", "blue", "yellow", "green",
                        "orange", "black", "purple", "gray", "pink"
                    };
                    break;

                default:
                    System.out.println("Invalid option. You must choose a number between [1-6].\n");
                    continue;
            }

            return words[rand.nextInt(words.length)];
        }
    }
}


/* Whats great about this having the words in a separate class, is that
we can edit the words at any given moment, and it won't affect the main code! */
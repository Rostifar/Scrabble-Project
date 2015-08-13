package com.rostifar.scrabbleproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ross on 7/25/15.
 */
public class LetterSelection {

    private char[] letters_list = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}; // This and the array below both hold letters and their respective quantity. ex: letters_list[1] -> integer_list[1]
    private int[] integer_list = {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1};
    private static final int MAX_LETTERS = 7; //FIXME - what should this value be?



    public void setupLetter() { // Method which allows for the setup of Letters and their values and quantities


        List<Character> adding_characters = new ArrayList<>();

        for (int j = 0; j < integer_list.length; j++) { // Function which allows to print the correct amount of letters within the scrabble bag
            for (int f = 0; f < integer_list[j]; f++)
                adding_characters.add(letters_list[j]);
        }
        
         int list_factorial = adding_characters.size();
        if (MAX_LETTERS < 7) {
            Random rand = new Random();
            int randomNum = rand.nextInt((100 - 0) + 1) + 0;
            char selected_letter = adding_characters.get(randomNum);
            System.out.println(selected_letter);


        }



    }



}














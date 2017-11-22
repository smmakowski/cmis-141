/* File: Guitar.java
 * Author: Stephen
 * Date: November 22, 2017
 * Purpose: Demonstrate understanding of arrays and array length though a
 * command line implementation of the 'Guessing' phase of 'Mastermind'.
 */

import java.util.Scanner;
import java.util.Random;

public class StoreDataInArray {
  private char[] code;
  final String validChars = "ABCDEFG";

  public static main(String[] args) {
      Random rand = new Random();

      System.out.println("Welcome to ___! This program is a command line version of the boardgame 'MASTERMIND'.");
      System.out.println("In this game, the computer will come up with a '4 Letter Code' for you to guess.");
      System.out.println("Each letter in the code can be on of the following letters: A, B, C, D, E , or F.");
      System.out.println("With each guess you make, the computer respond with 4 symbols.");
      System.out.println("An 'X' means that one of the letters you chose is not in the sequence");
      System.out.println("A '-' means that one of the letters you chose a letter that is in the sequence but not in the right order.");
      System.out.println("An 'O' means one of the letters you chose was both in the sequence and in the correct position");

      System.out.println("The code was: ");

  }
  // generate random code for user to guess
  public char[] generateCode() {
    Random rand = new Random();
    char[] code = new char[4];
    char randChar = '';
    int randomIdx = 0;
    for (int i = 0; i < code.length; i++) {
      randIdx = rand.nextInt();
      randChar = validChars.charAt(randIdx)
    }
  }

  public static char[] makeGuess() {
    Scanner scan = new Scanner(System.in);
    char[] guess = new char[4];
    char choice = '';
    int i = 0;

    // prompt user for choices to populate guess array
    while (i < 4) {
      System.out.println("Please enter your choice for 'SLOT" + (i + 1) + "'.");
      choice = scan.next().toUpperCase();
      // if choice is valid chacter, move to mext index
      if (validChars.indexOf(choice) != -1) {
        i++;
      } else {
        System.out.println("You have entered an invalid character! Please enter A, B, C, D, E, or F.");
      }
    }

    // return guess
    return guess;
  }


}

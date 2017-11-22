/* File: Guitar.java
 * Author: Stephen
 * Date: November 22, 2017
 * Purpose: Demonstrate understanding of arrays and array length though a
 * command line implementation of the 'Guessing' phase of 'Mastermind'.
 */

import java.util.Scanner;
import java.util.Random;

public class StoreDataInArray {
  private static final String VALIDCHARS = "ABCDEFG";
  private static char[] code;
  private static int currentTurn;
  private static int maxTurns = 0;
  private static boolean solved = false;
  private static char[][] guesses;
  private static char[][] responses;

  public static void main(String[] args) {
      System.out.println("Welcome to ___! This program is a command line version of the boardgame 'MASTERMIND'.");
      System.out.println("In this game, the computer will come up with a '4 Letter Code' for you to guess.");
      System.out.println("Each letter in the code can be on of the following letters: A, B, C, D, E , or F.");
      System.out.println("With each guess you make, the computer respond with 4 symbols.");
      System.out.println("An 'X' means that one of the letters you chose is not in the sequence");
      System.out.println("A '-' means that one of the letters you chose a letter that is in the sequence but not in the right order.");
      System.out.println("An 'O' means one of the letters you chose was both in the sequence and in the correct position");

      setDifficulty();
      generateCode();
      // main game loop
      while (!solved  && currentTurn < maxTurns) {
        promptGuess();
        rateGuess();
      }
  }
  // generate random code for user to guess
  public static void generateCode() {
    Random rand = new Random();
    char[] code = new char[4];
    char randChar;
    int randIdx = 0;
    for (int i = 0; i < code.length; i++) {
      randIdx = rand.nextInt(VALIDCHARS.length());
      randChar = VALIDCHARS.charAt(randIdx);
      System.out.println(randChar);
      code[i] = randChar;
    }
  }
  // set difficulty
  public static void setDifficulty() {
    Scanner scan = new Scanner(System.in);
    String selection = "";
    // prompt user for difficulty while not set
    while (maxTurns == 0) {
      //print prompt
      System.out.println("Please select a difficulty (ex. MEDIUM, not case-sensitive):");
      System.out.println("\tEASY (12 turns)");
      System.out.println("\tMEDIUM (10 turns)");
      System.out.println("\tHARD (8 turns)");
      System.out.println("\tMASTERMIND (6 turns)");

      selection = scan.next().toUpperCase();
      // switch to set difficulty/detect invalid input
      switch (selection) {
        case "EASY" : // if the selection is easy
          maxTurns = 12; // max turns
          System.out.println("You have Selected EASY difficulty!"); //print selection notification
          break;
        case "MEDIUM" :
          maxTurns = 10;
          System.out.println("You have Selected MEDIUM difficulty!");
          break;
        case "HARD" :
          maxTurns = 8;
          System.out.println("You have Selected HARD difficulty!");
          break;
        case "MASTERMIND" :
          maxTurns = 6;
          System.out.println("You have Selected MASTERMIND difficulty!");
          break;
        default :
          System.out.println("Invalid choice! Please chose a valid difficulty level!");
      }
    }
    guesses = new char[4][maxTurns];
    responses = new char[4][maxTurns];
  }

  public static char[] promptGuess() {
    Scanner scan = new Scanner(System.in);
    char[] guess = new char[4];
    char choice;
    int i = 0;

    // prompt user for choices to populate guess array
    while (i < 4) {
      System.out.println("Please enter your choice for 'SLOT" + (i + 1) + "' (Not case-sensitive): ");
      System.out.println("(If you enter more than one character at a time, it will only use the first one)");
      choice = scan.nextLine().toUpperCase().charAt(0);
      // if choice is valid chacter, move to mext index
      if (VALIDCHARS.indexOf(choice) != -1) {
        guess[i] = choice;
        i++;
      } else {
        System.out.println("You have entered an invalid input! Please enter A, B, C, D, E, or F (or at least something that starts with one of those letters).");
      }
    }
    System.out.println("GUESS IS >>>>");
    for  (i = 0; i < guess.length; i++) {
      System.out.println(guess[i]);
    }
    // return guess
    return guess;
  }

  public static void rateGuess() {

  }
}

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
  private static char[] code = new char[4];
  private static int currentTurn = 0;
  private static int maxTurns = 0;
  private static boolean solved = false;
  private static char[][] guesses;
  private static char[][] responses;

  public static void main(String[] args) throws InterruptedException {
      System.out.println("Welcome to ___! This program is a command line version of the boardgame 'MASTERMIND'.");
      System.out.println("********** INSTRUCTIONS **********");
      System.out.println("- In this game, the computer will come up with a '4 Letter Code' for you to guess.");
      System.out.println("- Each letter in the code can be on of the following letters: A, B, C, D, E , or F.");
      System.out.println(" - With each guess you make, the computer respond with 4 symbols.");
      System.out.println("\t An 'X' means that one of the letters you chose is not in the sequence");
      System.out.println("\tA '-' means that one of the letters you chose a letter that is in the sequence but not in the right order.");
      System.out.println("\tAn 'O' means one of the letters you chose was both in the sequence and in the correct position");

      setDifficulty();
      generateCode();
      // main game loop
      while (!solved  && currentTurn < maxTurns) {
        promptGuess();
        rateGuess();
        printTurnResults(currentTurn);
        checkIfSolved();
        printAll();
        currentTurn++;
      }

      endGame();
  }
  // generate random code for user to guess
  public static void generateCode() throws InterruptedException {
    Random rand = new Random();
    char randChar;
    int randIdx = 0;

    for (int i = 0; i < code.length; i++) {
      randIdx = rand.nextInt(VALIDCHARS.length());
      randChar = VALIDCHARS.charAt(randIdx);
      System.out.println(randChar);
      code[i] = randChar;
    }

    System.out.println("Please wait... computer generating code...");
    for (int j = 0; j < 3; j++) {
      System.out.print(". ");
      Thread.sleep(1000);
    }
    System.out.println("");
    System.out.println("Code Generated!");
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
    guesses = new char[maxTurns][4];
    responses = new char[maxTurns][4];
  }

  public static void promptGuess() {
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
        guesses[currentTurn][i] = choice;
        i++;
      } else {
        System.out.println("You have entered an invalid input! Please enter A, B, C, D, E, or F (or at least something that starts with one of those letters).");
      }
    }
    // return guess
  }

  public static void printTurnResults(int turn) {
    System.out.println("<<< Results for turn " + (turn + 1) + " >>>");
    System.out.print("Your Guess: ");
    for (int i = 0; i < guesses[turn].length; i++) {
      System.out.print(Character.toString(guesses[turn][i]) + ' ');
    }
    System.out.print('\n');

    System.out.print("Computer's Response: ");
    for (int j = 0; j < responses[turn].length; j++) {
      System.out.print(Character.toString(responses[turn][j]) + ' ');
    }
    System.out.print('\n');
  }

  public static void printAll() {

    for (int i = 0; i <= currentTurn; i++) {
        printTurnResults(i);
    }
  }

  public static void rateGuess() {
    // iterate through current guesses
    int correctPlacements = 0;
    int correctColors = 0;
    int incorrect = 0;

    for (int i = 0; i < guesses[currentTurn].length; i++) {
      // if correct color and placement
      if (guesses[currentTurn][i] == code[i]) {
        correctPlacements++;
        responses[currentTurn][i] = 'O';
      } else if (indexOfCharArray(guesses[currentTurn][i], code) == -1) { // if not present at all in code
        responses[currentTurn][i] = 'X';
      } else { // if right color but wrong placement

      }
    }
  }

  public static int indexOfCharArray(char target, char[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i;
      }
    }
    return -1;
  }

  public static void checkIfSolved() {
    // change solved to true for check
    solved = true;
    for (int i = 0; i < responses[currentTurn].length; i++) {
      // if response peg is not a 'correct' peg revert solved to false
      if (!(responses[currentTurn][i] == 'O')) {
        System.out.println("NOPE");
        solved = false;
      }
    }
  }

  public static void endGame() {
    if (solved) {
      System.out.println("Congratulations! You solved the code in " + currentTurn + "turns!");
    } else {
      System.out.println("Sorry, you were unable to solve the code... Better luck next time!");
    }
    System.out.println("");
    System.out.println("Thanks for playing!");
    System.out.println("");
    System.out.println("~~~~~ END ~~~~~");
  }
}

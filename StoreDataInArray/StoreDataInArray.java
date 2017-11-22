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
      Scanner scan = new Scanner(System.in);
      String resp = "";

      // print opening lines, and instructions
      System.out.println("Welcome! This program is a command-line version of the boardgame 'MASTERMIND'.");
      System.out.println("");
      System.out.println("********** INSTRUCTIONS **********");
      System.out.println("- In this game, the computer will come up with a '4 Letter Code' for you to guess.");
      System.out.println("- The cod will be comprised of a combination of the letters A, B, C, D, E , and F.");
      System.out.println("- With each guess you make, the computer respond with a combination of 4 digits. Each digit have the following meaning:");
      System.out.println("\t(0) One of the letters you chose is not in the sequence");
      System.out.println("\t(1) One of the letters is in the sequence but in the wrong slot");
      System.out.println("\t(2) One of the letters is both in the sequence and in the correct slot");
      System.out.println("NOTE: The order of the digits may not be the same as the way you ordered the letters in your guess.");
      System.out.println("Example: The code is 'ABDD', and you guess 'ADCB'. Responses of '2101', '1210', or '2110' are all valid.");
      System.out.println("");

      // set difficulty
      setDifficulty();
      generateCode();

      // Enter main game loop
      while (!solved  && currentTurn < maxTurns) {
        System.out.println("********** TURN " + (currentTurn + 1) + " **********");
        System.out.println("");
        promptGuess();
        rateGuess();
        printTurnResults(currentTurn);
        checkIfSolved();
        currentTurn++; // increment turn number;
      }
      // run method that handles game ending
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
      System.out.println("Please enter a difficulty level(ex. MEDIUM, not case-sensitive):");
      System.out.println("\tEASY (12 turns)");
      System.out.println("\tMEDIUM (10 turns)");
      System.out.println("\tHARD (8 turns)");
      System.out.println("\tMASTERMIND (6 turns)");

      selection = scan.next().toUpperCase();
      System.out.println("");
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
      System.out.println("");
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

  // method that rates user guess
  public static void rateGuess() {
    boolean[] confirmed = new boolean[]{false, false, false, false};
    char c;

    // check for
    for (int i = 0; i < guesses[currentTurn].length; i++) {
      // if correct color and placement
      if (guesses[currentTurn][i] == code[i]) {
        confirmed[i] = true;
        responses[currentTurn][i] = '2';
      }
      // else if (indexOfCharArray(guesses[currentTurn][i], code, 0) == -1) { // if not present at all in code
      //   confirmed[i] = true;
      //   responses[currentTurn][i] = '0';
      // }
    }
    // check for middle ground pegs

    for (int j = 0; j < confirmed.length; j++) {
      if (confirmed[j] == false) {
        c = guesses[currentTurn][j];
        // iterate through code?
        for (int k = 0; k < code.length; k++) {
          // if the slot hasnt been confirmed and the slot is equal to
          if (confirmed[k] == false && code[k] == c) {
            // checked[j] = true;
            responses[currentTurn][j] = '1';
          }
        }
      }
    }

    for (int l = 0; l < guesses[currentTurn].length; l++) {
      if (responses[currentTurn][l] != '2' && responses[currentTurn][l] != '1') {
        responses[currentTurn][l] = '0';
      }
    }
    // shuffle the array to confuse people

  }

  // deprecated method due to lack of use; searches for target character in array from user defined start
  public static int indexOfCharArray(char target, char[] arr, int startIdx) {
    for (int i = startIdx; i < arr.length; i++) {
      if (arr[i] == target) {
        return i;
      }
    }
    return -1;
  }

  // method to check responses for complete solution
  public static void checkIfSolved() {
    // change solved to true for check
    solved = true;
    for (int i = 0; i < responses[currentTurn].length; i++) {
      // if response peg is not a 'correct' peg revert solved to false
      if (!(responses[currentTurn][i] == '2')) {
        solved = false;
      }
    }
  }

  public static void printCode() {
    String codeString = new String(code);
    System.out.println("The Code was: " + codeString);
  }

  public static void endGame() {
    System.out.println("");
    System.out.println("You have finished the game!");
    printCode();
    System.out.println("");

    if (solved) {
      System.out.println("Congratulations! You solved the code in " + currentTurn + "turn(s)!");
    } else {
      System.out.println("Sorry, you were unable to solve the code... Better luck next time!");
    }
    System.out.println("");
    System.out.println("Thanks for playing!");
    System.out.println("");
    System.out.println("~~~~~ END ~~~~~");
  }
}

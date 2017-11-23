/* File: Guitar.java
 * Author: Stephen Makowski
 * Date: November 22, 2017
 * Purpose: Demonstrate understanding of Arrays and array length though a
 * command line implementation of the 'Guessing' phase of 'Mastermind'.
 */

import java.util.Scanner;
import java.util.Random;

public class StoreDataInArray {
  // add field for game states for multimethod sharing
  private static final String VALIDCHARS = "ABCDEFG";
  private static char[] code = new char[4];
  private static int currentTurn = 0;
  private static int maxTurns = 0;
  private static boolean solved = false;
  private static char[][] guesses;
  private static char[][] responses;

  public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      String resp = "";

      // print opening lines, and instructions
      System.out.println("Welcome! This program is a command-line version of the boardgame 'MASTERMIND'.");
      printInstructions();

      // ask the user if they want to continue using 'while' loop to validate proper input
      while (true) {
        System.out.println("Would you like to play the game (enter 'Y' or 'YES' to continue, 'N' for 'NO' to leave; Not case-sensitive)?");
        resp = scan.next().toUpperCase();
        if (resp.equals("Y") || resp.equals("YES")) {
          System.out.println("");
          break;
        } else if (resp.equals("N") || resp.equals("NO")){
          System.out.println("");
          System.out.println("OKAY! Maybe next time!");
          System.out.println("");
          System.out.println("~~~~~ END ~~~~~");
          System.exit(0);
        } else {
          System.out.println("");
          System.out.println("You have entered and INVALID INPUT! Please try again!");
          System.out.println("");
        }
      }
      // set difficulty and generate random code using methods
      setDifficulty();
      generateCode();

      // Enter main game loop
      while (!solved  && currentTurn < maxTurns) {
        System.out.println("********** TURN " + (currentTurn + 1) + " **********");
        takeTurn();
      }
      // run method that handles game ending
      endGame();
  }
  // generate random code for user to guess
  public static void generateCode() {
    Random rand = new Random();
    char randChar;
    int randIdx = 0;
    // for each slot in code
    for (int i = 0; i < code.length; i++) {
      //generate random characters using random numbers and indexs
      randIdx = rand.nextInt(VALIDCHARS.length());
      randChar = VALIDCHARS.charAt(randIdx);
      code[i] = randChar; // assign index in code array
    }

    System.out.println("");
    System.out.println("The Computer has generated a RANDOM CODE!");
    System.out.println("");
    System.out.println("LET'S PLAY!");
    System.out.println("");

  }
  // set difficulty

  public static void setDifficulty() {
    Scanner scan = new Scanner(System.in);
    String selection = "";
    // prompt user for difficulty while not set
    while (maxTurns == 0) {
      //print prompt
      System.out.println("Please enter a DIFFICULTY LEVEL (ex. MEDIUM, not case-sensitive):");
      System.out.println("\t- EASY (12 turns)");
      System.out.println("\t- MEDIUM (10 turns)");
      System.out.println("\t- HARD (8 turns)");
      System.out.println("\t- MASTERMIND (6 turns)");

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
    }
    // depending on difficulty create guesses and responses array based on maxTurns
    guesses = new char[maxTurns][4];
    responses = new char[maxTurns][4];
  }

  public static void takeTurn() {
    Scanner scan = new Scanner(System.in);
    boolean nowSelecting = true;
    String resp = "";
    // prompt user for an option using loop to ensure proper input
    while (nowSelecting) {
      System.out.println("What would you like to do? Please SELECT and action for the options below (Ex. Enter '1' to 'MAKE A GUESS'):");
      System.out.println("\t(1) Make a Guess");
      System.out.println("\t(2) Print all guesses and results up to present");
      System.out.println("\t(3) Print instructions again");

      resp = scan.next();
      switch (resp) {
        case "1" : // logic for taking a turn
          nowSelecting = false;
          promptGuess();
          rateGuess();
          printTurnResults(currentTurn);
          System.out.println("");
          checkIfSolved();
          currentTurn++; // increment turn number (this only occurs if turn is taken via switch)
          break;
        case "2" : // print all turns method
          printAll();
          nowSelecting = false;
          break;
        case "3" : // repreint directions
          printInstructions();
          nowSelecting = false;
          break;
        default :
          System.out.print("Input is INVALID! Please enter valid input");
      }
    }
  }
  // prompt user for a guess and fill guesses array
  public static void promptGuess() {
    Scanner scan = new Scanner(System.in);
    char[] guess = new char[4];
    char choice;
    int i = 0;
    String place = "";

    // swtich to determine which slot for string
    while (i < 4) {
      switch (i) {
        case 0 :
          place = "FIRST";
          break;
        case 1:
          place = "SECOND";
          break;
        case 2 :
          place = "THIRD";
          break;
        case 3 :
          place = "FOURTH";
          break;
        default:
          // do nothing because we will never hit the default
      }
      System.out.println("");
      System.out.println("Please enter your choice for '" + place + " SLOT' (Not case-sensitive): ");
      System.out.println("(If you enter more than one character at a time, only the FIRST character will be considered)");
      choice = scan.next().toUpperCase().charAt(0);
      // if choice is valid chacter, move to mext index
      if (VALIDCHARS.indexOf(choice) != -1) {
        guesses[currentTurn][i] = choice;
        i++;
      } else {
        System.out.println("");
        System.out.println("You have entered an INVALID INPUT! Please enter A, B, C, D, E, or F (or at least something that starts with one of those letters).");
      }
    }
    // return guess
  }
  // method to print results of an individual turns
  public static void printTurnResults(int turn) {
    System.out.println("");
    System.out.println("<<<<< RESULTS FOR TURN " + (turn + 1) + " >>>>>");
    System.out.print("Your Guess: ");
    //iterate throgh array and print guess charactes
    for (int i = 0; i < guesses[turn].length; i++) {
      System.out.print(Character.toString(guesses[turn][i]) + ' ');
    }
    System.out.print('\n');
    // iteratethrogh response array and proint repsnse characters
    System.out.print("Computer's Response: ");
    for (int j = 0; j < responses[turn].length; j++) {
      System.out.print(Character.toString(responses[turn][j]) + ' ');
    }
    System.out.print('\n');
  }
  // method to print all repsonses up to current
  public static void printAll() {
    // handle printign for first turn (since no guesses have been made)
    if (currentTurn == 0) {
      System.out.println("");
      System.out.println("You haven't made any guesses yet! Please wait until TURN 2.");
      System.out.println("");
      return;
    }
    // iterate through rray until current turn and call printTrurn
    for (int i = 0; i < currentTurn; i++) {
        printTurnResults(i);
    }
    System.out.println("");
  }
  //method that prints insturctiosn
  public static void printInstructions() {
    System.out.println("");
    System.out.println("********** INSTRUCTIONS **********");
    System.out.println("- In this game, the computer will come up with a '4 Letter Code' for you to guess.");
    System.out.println("- The code will be comprised of a combination of the letters A, B, C, D, E , and F.");
    System.out.println("- With each guess you make, the computer respond with a combination of 4 digits. Each digit have the following meaning:");
    System.out.println("\t(0) One of the letters you chose is not in the sequence");
    System.out.println("\t(1) One of the letters is in the sequence but in the wrong slot");
    System.out.println("\t(2) One of the letters is both in the sequence and in the correct slot");
    System.out.println("NOTE: The order of the digits may not be the same as the way you ordered the letters in your guess." +
    "Example: The code is 'ABDD', and you guess 'ADCB'. Responses of '2101', '1210', or '2110' are all valid.");
    System.out.println("");
  }

  // method that rates user guess
  public static void rateGuess() {
    // variavels to hold confirmed characteres and current character
    boolean[] confirmed = new boolean[]{false, false, false, false};
    char c;

    // iterate through guess and compare to code
    for (int i = 0; i < guesses[currentTurn].length; i++) {
      // if correct color and placement confirm in array and add notation to responses
      if (guesses[currentTurn][i] == code[i]) {
        confirmed[i] = true;
        responses[currentTurn][i] = '2';
      }
    }
    // check for middle ground pegs
    // iterate through guesses and assess if right letter wrong slot
    for (int j = 0; j < confirmed.length; j++) {
      // it the particular spot has not yet been confirmed
      if (confirmed[j] == false) {
        c = guesses[currentTurn][j];
        // iterate through 'code array'
        for (int k = 0; k < code.length; k++) {
          // if the slot hasnt been confirmed and the slot is
          if (confirmed[k] == false && code[k] == c) {
            // checked[j] = true;
            responses[currentTurn][j] = '1';
          }
        }
      }
    }
    // fill the rest of of the slots with 'fail characters'
    for (int l = 0; l < guesses[currentTurn].length; l++) {
      if (responses[currentTurn][l] != '2' && responses[currentTurn][l] != '1') {
        responses[currentTurn][l] = '0';
      }
    }
    // shuffle the array to avoid making it too obvious
    shuffleResponse(currentTurn);
    // print out 'computing message'
  }
  // method to shuffle response using swaps
  public static void shuffleResponse(int turn) {
    Random rand = new Random();
    char temp;
    int randIdx;
    // iterate through array once
    for (int i = 0; i < responses[turn].length; i++) {
      //generate a random index numebr
      randIdx = rand.nextInt(4);
      // hold current value in temp
      temp = responses[turn][i];
      //swap the current index value with the randomly selected one
      responses[turn][i] = responses[turn][randIdx];
      responses[turn][randIdx] = temp;
    }
  }

  // deprecated method due to lack of use; searches for target character in array from user defined start
  public static int indexOfCharArray(char target, char[] arr, int startIdx) {
    //iterate through array from start

    for (int i = startIdx; i < arr.length; i++) {
      // if target found return index
      if (arr[i] == target) {
        return i;
      }
    }
    // return -1 for not found
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
  // method to print hidden code
  public static void printCode() {
    // convert array to sting and rint
    String codeString = new String(code);
    System.out.println("");
    System.out.println("THE CODE YOUR WERE TRYING TO GUESS WAS: " + codeString);
  }
  // end game phase method
  public static void endGame() {
    System.out.println("");
    System.out.println("You have FINISHED the game!");
    printCode();
    System.out.println("");
    // print win depending string
    if (solved) {
      System.out.println("CONGRATULATIONS! You solved the code in " + currentTurn + "turn(s)!");
    } else {
      System.out.println("SORRY, you were unable to solve the code... Better luck next time!");
    }
    System.out.println("");
    System.out.println("Thanks for playing!");
    System.out.println("");
    System.out.println("~~~~~ END ~~~~~");
  }
}

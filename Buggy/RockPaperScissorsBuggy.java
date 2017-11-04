/*
* File: RockPaperScissorsBuggy.java
* Author: Stephen Makowski
* Date: November 5, 2017
* Purpose: This program is a command line Rock Paper Scissors game that uses
  loops, conditionals, and switch statements. This is the buggy version.
  There are
*/
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsBuggy {
  public static void main(String[] args) {
    // declare/assign choice constants
    final String ROCK = "R";
    final String PAPER = "P";
    final String SCISSORS = "S";
    final String QUIT = "Q";
    final String[] OPTIONS = {ROCK, PAPER, SCISSORS};
    // declare and assign game states
    String result = "";
    int wins = 0, losses = 0, ties = 0;
    int gamesCount, randomIdx;
    boolean stillPlaying = true;
    String compChoice;
    String userChoice;
    // create random, and scanner objects to use methods
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    // print opening information
    System.out.println("ROCK PAPER SCISSORS");
    System.out.println("*******************");
    System.out.println("You will play Rock Paper Scissors (best out of 5 with the computer).");
    System.out.println("There will be up to 5 rounds that can be won or lost");
    System.out.println("The game will end when a total of 3 rounds have been won by either player.");
    //
    while (stillPlaying) {
      //prompt user for choice
      System.out.println("*******************");
      if (wins == 2 & losses == 2) {
        System.out.println("You both have 2 wins! This is the TIE-BREAKER!!!");
      }
      System.out.println("What is your choice for this round (Enter 'R' for Rock, 'P' for Paper, 'S' for Scissors, or 'Q' to forfeit and quit the game')?");
      userChoice = scan.next().toUpperCase();
      // randomly generate computer choice
      randomIdx = rand.nextInt(3);
      compChoice = OPTIONS[randomIdx];
      // use switch to determine winner and increment score
      switch () {
        case ROCK: // handle possibilities for each option
          if (compChoice == SCISSORS) { // increment wins if won
            System.out.println("You chose ROCK and Computer chose SCISSORS. You Wins!");
            wins++;
          } else if (compChoice == PAPER) { // increment losses if loses
            System.out.println("You chose ROCK and Computer chose PAPER. Computer Wins!");
            losses++;
          } else { // do nothing if tie
            System.out.println("You both chose ROCK. This round is a tie!");
            ties++;
          }
          break;
        case SCISSORS:
          if (compChoice == PAPER { // increment wins if won
            System.out.println("You chose SCISSORS and Computer chose PAPER. You Wins!");
            wins++;
          } else if (compChoice ==  ROCK) { // increment losses if loses
            System.out.println("You chose SCISSORS and Computer chose ROCK. Computer Wins!");
            losses++;
          } else { // do nothing if tie
            System.out.println("You both chose SCISSORS. This round is a tie!");
            ties++;
          }
          break;
        case PAPER:
          if (compChoice = ROCK) { // increment wins if won
            System.out.println("You chose PAPER and Computer chose ROCK. You win!");
            wins++;
          } else if (compChoice == SCISSORS) { // increment losses if loses
            System.out.println("You chose PAPER and Computer chose SCISSORS. Computer wins!");
            losses++;
          } else { // do nothing if tie
            System.out.println("You both chose PAPER. This round is a tie!");
            ties++;
          }
          break;
        case QUIT: // print final strings and exit if user wants to quit
          result = " have forefeited against ";
          break;
          // no break statement here because program is done
        default: // handle invalid input and re-itera
          System.out.println("Invalid input, please try again!");
          break;
      }
      // check conditions for victory (either player gets 3 wins or forfeit)
      if (result == " have forefeited against ") {
        stillPlaying = false;
      } else if (wins == 3) {
        result = " are victorious against ";
        stillPlaying = false;
      } else if (losses == 3) {
        result = " have been defeated by";
        stillPlaying = false;
      }
    }
    System.out.println("*******************");
    System.out.println("You" + result + "the computer!");
    System.out.println("Final results... You: " + wins + ", Computer: " + losses + ", Ties:" + ties + ".");
    System.out.println("Thanks for playing! See you next time!")
  }
}

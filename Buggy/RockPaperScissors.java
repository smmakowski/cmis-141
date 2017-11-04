import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
  public static void main(String[] args) {
    // declare/assign choice constants
    final char ROCK = 'R';
    final char PAPER = 'P';
    final char SCISSORS = 'S';
    // declare and assign game states
    int wins = 0, losses = 0;
    int gamesCount;
    boolean stillPlaying;
    char continuePlaying;
    char compChoice;
    char userChoice;

    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    System.out.println("Let's play Rock Paper Scissors with the computer!");
    System.out.println("You can play up to 5 rounds against the computer");

    while (stillPlaying && wins < 3 && losses < 3) {
      System.out.println("What is your choice for this round (Enter 'R' for Rock,\
      'P' for Paper, or 'S' for Scissors)?");
      Scanner s = new Scanner(System.in);
      userChoice = s.next();

      if () {

      }
    }

    if ()
    System.out.println("");
    System.out.println("Thanks for playing! See you next time!");
  }
}

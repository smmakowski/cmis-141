/**
  * File: Loops.java
  * Author: Stephen Makowski
  * Date: November 9, 2017
  * Purpose: A game of tic tc toe that uses loops to deterimine if game is
  * being played and to check the grid for a winner
*/
import java.util.Random;
import java.util.Scanner;

public class Loops {
  public static void main(String[] args) {
    // intialize grid
    String[][] grid = {{" ", " ", " "}, {" ", " ", " "}, {" ",
       " ", " "}};
    final String[] coin = {"Heads", "Tails"};
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    // initialize players and tracker variales
    String players[] = {"Computer", "Player", "No one"};
    String winner = "";
    int coinToss = rand.nextInt(2);
    int playerCoinChoice = 0;
    boolean playerFirst = false;
    int result = 3;

    System.out.println("Let's play Tic Tac Toe with the computer!");
    // prompt user for name
    System.out.println("What is your name?");
    players[1] = scan.nextLine();

    // flip a coin using random to select who goes fist
    System.out.println("Let's flip a coin to see who goes first.");
    // prompt user for coin
    while (true) {
      System.out.println("Which side would you like to be (1 for heads, 2 for tails)?");
      playerCoinChoice = scan.nextInt();
      if (playerCoinChoice == 1 || playerCoinChoice == 2) {
        break;
      } else {
        System.out.println("Invalid choice! Please select one of the correct options.");
      }
    }

    // compare coint toss and decide winner
    System.out.println("You have selected " + coin[playerCoinChoice - 1] + ".");
    System.out.println("The coin is " + coin[coinToss]);
    if (coinToss == playerCoinChoice - 1) {
      System.out.println("You have won the toss! You will go first.");
      playerFirst = true;
    } else {
      System.out.println("You have lost the toss! The Computer will go first.");
    }
    //print empty grid to start
    printGrid(grid);
    // enter main game loop
    while (true) {
      // let computer go
      if (playerFirst) {
        movePlayer(grid);
      } else {
        moveComputer(grid);
      }


      result = checkWinner(grid);
      // if there is an endgame outcome
      if (result < 3) {
        // assign winner string and end main game loop
        winner = players[result];
        break;
      }

      // player takes turn
      if (playerFirst) {
        moveComputer(grid);
      } else {
        movePlayer(grid);
      }

      // check to see outcome of round
      result = checkWinner(grid);
      // if there is an endgame outcome
      if (result < 3) {
        // assign winner string and end main game loop
        winner = players[result];
        break;
      }
      // if no victory continue main loop
    }
    // print post game strings and exit
    System.out.println(winner + " has won the game!");
    System.out.println("Thanks for playing! Bye!");
  }

  public static void movePlayer(String[][] grid) {
    Scanner scan = new Scanner(System.in);
    boolean lookingForSpot = true;
    int row = 0;
    int col = 0;
    // allow player to look for spot
    while (lookingForSpot) {
      // prompt user for spot while proper input has not been achieved
      while (row < 1 || row > 3) {
        System.out.println("Please enter the row you like to select (1, 2, or 3):");
        row = scan.nextInt();
        if (row < 1 || row > 3) {
          System.out.println("Row number out of range!");
        }
      }
      // prompt user for
      while (col < 1 || col > 3) {
        System.out.println("Please enter the column you like to select (1, 2, or 3):");
        col = scan.nextInt();
        if (col < 1 && col > 3) {
          System.out.println("Column number out of range!");
        }
      }
      // check to see if slot on grid has been taken
      if ((grid[row - 1][col - 1]).equals(" ")) {
        grid[row - 1][col - 1] = "O";
        System.out.println("You have moved to row " +  (row + 1) + " column " + (col + 1) + ".");
        printGrid(grid);
        lookingForSpot = false;
      } else {
        System.out.println("The spot you attempted to select has already been taken! Please try again!");
        row = 0;
        col = 0;
      }
    }
  }
  public static void moveComputer(String[][]grid) {
    // setup required object instances and tracker variabels
    Random rand = new Random();
    boolean lookingForSpot = true;
    int row;
    int col;
    // while looking for spot
    System.out.println("It is now the computers turn!");
    while (lookingForSpot){
      //generate reandom row and column
      row = rand.nextInt(3);
      col = rand.nextInt(3);

      // if spot is emtpy assign and end loop
      if ((grid[row][col]).equals(" ")) {
        grid[row][col] = "X";
        System.out.println("The computer has moved to row " +  (row + 1) + " column " + (col + 1) + ".");
        printGrid(grid);
        lookingForSpot = false;
      }
      //otherqise continue
    }
  }

  public static int checkWinner(String[][] grid) {
    // iterate through all the rows to check for an X or O victory
    final String[] players = {"X", "O"};

    // iterate through both players
    for (int i = 0; i < players.length; i++) {
      // iterate through each row to check horizontal vicory for playr[i]
      for (int j = 0; j < grid.length; j++) {
        // if all in row are equal return i (index of player in player array)
        if ((grid[j][0]).equals(players[i]) && (grid[j][1]).equals(players[i]) && (grid[j][2]).equals(players[i])) {
          return i;
        }
      }
      // iterate through each column to check vertical victory
      for (int k = 0; k < grid.length; k++) {
        if ((grid[0][k]).equals(players[i]) && (grid[1][k]).equals(players[i]) && (grid[2][k]).equals(players[i])) {
          return i;
        }
      }

      // check diagonal victories
      if ((grid[0][0]).equals(players[i]) && (grid[1][1]).equals(players[i]) && (grid[2][2]).equals(players[i])) {
        return i;
      }
      if ((grid[0][2]).equals(players[i]) && (grid[1][1]).equals(players[i]) && (grid[2][0]).equals(players[i])) {
        return i;
      }
    }
    // iterate through all rows to see if all slots filled
    for (int l = 0; l < grid.length; l++) {
      for (int m = 0; m < grid.length; m++) {
        // if current spot is empty return outcome 3 (no victory or tie)
        if ((grid[l][m]).equals(" ")) {
          return 3;
        }
      }
    }
    // if all slots are filled return outcome 2 (tie)
    return 2;
  }

  public static void printGrid(String[][] grid) {
    // print column header
    System.out.println("  1 2 3");
    // iterate throuhg first 2 rows
    for (int i = 0; i < grid.length - 1; i++) {
      // print row header
      System.out.print((i + 1) + " ");
      // iterate through first two columns in row and print grid spaces
      for (int j = 0; j < grid.length - 1; j++) {
        System.out.print(grid[i][j] + '|');
      }
      // print last value in row
      System.out.print(grid[i][2]+ "\n");
      System.out.println("  _____");
    }
    // print final row
    System.out.print("3 ");
    for (int k = 0; k < grid.length - 1; k++) {
      System.out.print(grid[grid.length - 1][k] + '|');
    }
    System.out.println(grid[grid.length - 1][grid.length - 1]);
  }
}

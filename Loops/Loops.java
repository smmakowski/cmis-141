/**
  * File: Loops.java
  * Author: Stephen Makowski
  * Date: November 9, 2017
  * Purpose: A game of tic tc toe that uses loops to deterimine if game is
  * being played and to check the grid for a winner
*/
import java.util.Random;

public class Loops {
  public static void main(String[] args) {
    // tic tac toe
    String[][] grid = {{" ", " ", " "}, {" ", " ", " "}, {" ",
       " ", " "}};
    String players[] = {"", "Computer"};
    boolean gameInProgress = true;
    String winner;
    System.out.println("Let's play Tic Tac Toe with the computer!");
    System.out.println("This computer isn't very smart, it'll just choose any open space at random.");
    System.out.println("So to be nice, we'll allow it to go first. Good luck!");

    printGrid(grid);
    movecomputer(grid);
    printGrid(grid);


    // while (gameInProgress) {
    //   // let computer go
    //
    //   // player takes turn h
    //
    //   // if victory is achieved
    //   if (checkWinner() < 3) {
    //
    //     gameInProgress = false;
    //   }
    //     // assign winner String
    //     // end game
    //   // reset player and computer ability to play
    // }
  }

  public static void movecomputer(String[][]grid) {
    Random rand = new Random();
    boolean lookingForSpot = true;
    int row;
    int col;
    // while looking for spot
    while (lookingForSpot){
      //generate reandom row and column
      row = rand.nextInt(3);
      col = rand.nextInt(3);

      // if spot is emtpy assign and end loop
      if ((grid[row][col]).equals(" ")) {
        grid[row][col] = "X";
        lookingForSpot = false;
      }
    }
  }

  public static int checkWinner(String[][] grid) {
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

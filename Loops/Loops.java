/**
  * File: Loops.java
  * Author: Stephen Makowski
  * Date: November 9, 2017
  * Purpose: A game of tic tc toe that uses loops to deterimine if game is
  * being played and to check the grid for a winner
*/
public class Loops {
  public static void main(String[] args) {
    // tic tac toe
    String[][] grid = {{" ", " ", " "}, {" ", " ", " "}, {" ",
       " ", " "}};
    printGrid(grid);
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

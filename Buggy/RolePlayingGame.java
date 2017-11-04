/*
* File: RolePlayingGame.java
* Author: Sean Mooneyham
* Date: 11/1/2017
* Purpose: Class exercise
* Classes: BufferedReader and Scanner
* */


import java.io.IOException;
import java.util.Scanner;

public class RolePlayingGame {
    public static void main(String[] args) throws IOException {
        int[] coordinates = {0, 0}; /** added postion tuple {x, y} */
        Scanner scanner = new Scanner(System.in); // i might move this elsewhere
        printDirections();
        boolean flag = true;
        while(flag) {
            System.out.println("Which direction do you want to move your character?");

            // method Character.toUpperCase(argument) will change a lower case character to an upper case character
            char move = Character.toUpperCase(scanner.next().charAt(0));

            /** if (move != 'Q') { (since Q is an option for input no need for outer conditonal) */
                switch (move) { // added (value) to switch statement to indicate what is value is being checked
                    case 'N': /** (i.e: if (move) == 'N') */
                        System.out.println("You move 10 meters North");
                        break; /** added 'break' statement to avoid falling through */
                    case 'S':
                        System.out.println("You move 10 meters South");
                        break; /** added 'break' statement to avoid falling through */
                    case 'E':
                        System.out.println("You move 10 meters East");
                        break; /** added 'break' statement to avoid falling through */
                    case 'W':
                        System.out.println("You move 10 meters West");
                        break; /** added 'break' statement to avoid falling through */
                    case 'P':
                        printDirections();
                        break; /** added 'break' statement to avoid falling through */
                    case 'Q':
                        flag = false;
                        break; /** added 'break' statement to avoid falling through */
                    default:
                        System.out.println("Invalid entry!  If you don't remember the instructions, press 'P'!");
                        break; // added 'break' statement to avoid falling through

                }
            /**} else {
                flag = false;
            }
            the above else was removed and added to the swtich statement, since else
            is essentially an
            */
        }
        scanner.close()/** close scanner to */
        /**
        moved below println outside of while since a true value of 'flag' means one is playing game,
        and game is over
        */
        printFinalLocation(coordinates); /** Calculate and print how far you traveled*/
        System.out.println("Thank you for playing!");
    }
    public static void printDirections() {
        System.out.println("Type 'N' to move North\nType 'S' to move South\n" +
                "Type 'E' to move East\nType 'W' to move West");
        System.out.println("Type 'Q' to quit\nType 'P' to re-print directions");
    }

    public static void printFinalLocation(int[] coordinates) {
      String direction = "";
      int distance;
      // assess north/south
      if (coordinates[0] > 1) {
        direction += "North";
      } else {
        direction += "South";
      }

      //assess east/west
      if (coordinate[1] > 1) {
        direction += "East";
      } else {
        direction += "West";
      }
      // calculate hypotenuse
      if (coordinates[0] == 0 ) { // if no triangle
        distance = coordinates[1];
      } else if (coordinates[1] == 0) { // if no traingle
        distance = coordinates[0];
      } else { // calculate hypotenuse a^2 + b^2 = c^2
        distance = Math.sqrt(Math.pow((double)coordinates[0], 2.0) + Math.pow((double), 2.0));
      }


      System.out.println("You are " + distance + " meters " +  direction +
      " from your original location");
    }
}

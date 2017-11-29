/*
* File: RockPaperScissors.java
* Author: Stephen Makowski
* Date: November 5, 2017
* Purpose:
*/
import java.util.Scanner;

public class Homework1 {
  public static void main(String[] args) {
    // declare constant for degree symbol
    final char DEGREE = '\u00b0';
    // declare necessary values to store input and caluclations
    int emplId, months, years, quiz, j;
    double score, average, degreesC, degreesF;
    double[] scores = new double[3];

    // create scanner object instance
    Scanner sc = new Scanner(System.in);

    // while awaiting proper input prompt user for emplId
    while (true) {
      System.out.print("Enter your Student EMPLID (0 - 999999): ");
      emplId = sc.nextInt();
      // if user input is within range exit loop and rseumt
      if (emplId >= 0 && emplId <= 999999) {
        break;
      } else { // prints message requesting valid input and reiterates
        System.out.println("Incorrect input. Value not between 0 and 999999");
      }
    }

    System.out.print("Enter your Student EMPLID (0 - 999999): ");
    emplId = sc.nextInt();

    // Fill scores array with user input
    for (int i = 0; i < scores.length; i++) {
      quiz = i + 1;
      // nest while loop to collect user input
      while (true) {
        System.out.print("\nEnter your quiz" + quiz + " percentage score (0.0 - 100.0): ");
        score = sc.nextDouble();
        if (score >= 0.0 && score <= 100.0) {
          scores[i] = score;
          break;
        } else {
          System.out.println("Invalid Input. Value not between 0.0 and 100.0.");
        }
      }
    }
    // calculate and store average using helper function
    average = averageScores(scores);

    // prompt user for age in months; calculate and store conversion to years
    while (true) {
      System.out.print("\nEnter your age in months (0 - 1440): ");
      months = sc.nextInt();
      if (months >= 0 && months <= 1440) {
        break;
      } else {
        System.out.println("Invalid input. Please enter integer from 0 to 1440.");
      }

    }

    years = convertToYears(months);
    //prompt user for temperatute in C; calculate and save conversion to Farenheit
    System.out.print("\nEnter the current Temperature in degrees Celsius (ex. 19.0): ");
    degreesC = sc.nextDouble();
    degreesF = convertToF(degreesC);

    // close scanner
    sc.close();
    // print inputted information
    j = 0;
    System.out.println("***Thank You**");
    System.out.println("Your student EMPLID: " + emplId);

    while (j < scores.length) {
      quiz = j + 1;
      System.out.println("Quiz " + quiz + " Score: " + scores[j]);
      j++;
    }

    System.out.println("Average quiz score: " + String.format("%.1f", average));
    System.out.println("Age in months: " + months);
    System.out.println("Age in years: " + years);
    System.out.println("Temperature in Celsius: " + degreesC + DEGREE);
    System.out.println("Temperature in Fahrenheit: " + String.format("%.1f", degreesF) + DEGREE);
  }
  // helper method to convert F to C

  public static double convertToF(double c) {
    // return converted value
    return c * (9.0 / 5.0) + 32;
  }
  // helper method that averages inputted scores
  public static double averageScores(double[] scores) {
    double sum = 0.0;
    // iterate through array and add scores to sum
    for (int i = 0; i < scores.length; i++) {
      sum += scores[i];
    }
    // return average (length (INT) is converted to double implicitly)
    return sum / (double)scores.length;
  }
  // helper method to convert months to years
  public static int convertToYears(int months) {
    return months / 12;
  }
}

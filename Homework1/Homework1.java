/*
  CMIS 141 - Introductory Programming
  Homework1.java
  November 5, 2017
  Stephen Makowski
  ------------------------------------
  The below program...
*/
import java.util.Scanner;

public class Homework1 {
  public static void main(String[] args) {
    int emplId, months, quiz;
    double score, temp, average;
    double[] scores = new double[3];

    // Get user input EmplID using scanner
    System.out.print("Enter your Student EMPLID (0 - 999999): ");
    Scanner sc = new Scanner(System.in);
    emplId = sc.nextInt();

    // Fill scores array with user input
    for (int i = 0; i < scores.length; i++) {
      quiz = i + 1;
      System.out.println("\nEnter your quiz" + quiz + " percentage score (0.0 - 100.0): ");
      score = sc.nextDouble();
      scores[i] = score;
    }

    System.out.print("\nEnter your age in months (0 - 1440): ");
    months = sc.nextInt();

    System.out.print("\nEnter the current Temperature in degrees Celsius (ex. 19.0): ");
    temp = sc.nextDouble();

  }
  // helper method to convert F to C
  public static double convertToCelsius(double f) {
    // return converted value
    return (f - 32) * (5.0 / 9.0);
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

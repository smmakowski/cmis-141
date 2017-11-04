public class Hw1Helpers {
  //
  public static double convertToCelsius(double f) {
    // return converted value
    return (f - 32.0) * (5.0 / 9.0);
  }
  // helper method that averages inputted scores
  public static double averageScores(Double[] scores) {
    double sum = 0.0;
    // iterate through array and add scores to sum
    for (int i = 0; i < scores.length; i++) {
      sum += scores[i];
    }
    // return average (length (INT) is converted to double implicitly)
    return sum / scores.length;
  }
  // helper method to convert months to years
  public static int convertToYears(int months) {
    return months / 12;
  }
}

import java.util.Random;
import java.util.Arrays;

public class GenerateRandomNumbers {
  public static void main(String[] args) {
    Random rand = new Random();
    int numOfRand = 0;
    int maxRand = 0;
    // handle diffrent amounts of aruguments
    if (args.length >= 2) { // if enough args to run program
      try { // try to parse first two arguments
        // parse arguments to integers
        numOfRand = Integer.parseInt(args[0]);
        maxRand = Integer.parseInt(args[1]);

        if (args.length > 2) { // if more than two, notify user that other arguments have been ignored
          System.out.println("You have entered more than the required arguments. The following arguments were accepted: [" +
          args[0] + ", " + args[1] + "]. The folowing arguments have been ignored: [");
          // iterate through extra args
          for (int i = 2; i < args.length; i++) {
            System.out.print(args[i] + ", "); // print arg with separator
          }

          System.out.println("\b\b]."); // print double backspace (to erase final sepator) and close bracket
        }
      } catch (NumberFormatException e) { // handle execptions re: parsing integers
        System.out.println("ERROR: One or both of your arguments: {" + args[0] + ", " + args[1] + "} could not be parsed." +
        " Please run program with two valid integers as arguments in command-line (e.g, java GenerateRandomNumbers 10 20).");
        System.exit(1); // exit
      }
    } else { // else not enogh args, notify and exit
      System.out.println("ERROR: This Random Integer Generator requires 2 command-line arguments." +
      " Please run program with two valid integers as arguments in command-line (e.g, java GenerateRandomNumbers 5 10).");
      System.exit(0);
    }

    // init empty array len numRand
    int[] randArr = new int[numOfRand];

    for (int j = 0; j < numOfRand; j++) { // populate array
      randArr[j] = rand.nextInt(maxRand + 1);
    }
    // print out random number array
    System.out.println("The following " + numOfRand + " random numbers between 0 (inclusive) and " +
    maxRand + " (inclusive) have been generated: " + Arrays.toString(randArr) + ".");
  }

  public static int sumIntArr(int[] arr){
    int sum = 0;

    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }

    return sum;
  }

  public static double averageArray(int[] arr) {
    return (double)sumIntArr(arr) / (double)arr.length;
  }

}

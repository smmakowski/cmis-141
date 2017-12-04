public class GenerateRandomNumbers {
  public void main(String[] args) {
    Random rand = new Random();
    int numOfRand;
    int maxRand;
    if (args.length >= 2) {
      try {
        // parse arguments to integers
        numOfRand = Integer.parseInt(args[0]);
        maxRand = Integer.parseInt(args[1]);
        if (args.length > 2) { // if more than two, notify user that other arguments have been ignored
          System.out.println("")
        }
      } catch (NumberFormatException e){
        System.out.println("One or both of your arguments: [" + args[0] + ", " + args[1] + "] could not be parsed.");
        System.out.println("Please run program valid integers as arguments in command-line (e.g, java GenerateRandomNumbers 10 20)");
        System.out.exit(1); // exit
      }
    } else {
      System.out.println("This Random Integer Generator requires 2 command-line arguments.");
      System.out.println("Please restart this program with ")
      System.exit(0);
    }

    // Repeat numOfRand

  }
}

import java.util.HashMap;

public class SentimentAnalysis {
    private String fileString = "";
    private int linesRead = 0;
    private HashMap<String, int> wordScores = new HashMap<String, int>();

    public static main(String[] args) {

    }
    // method to print file;
    public printFile() {
      System.outprintln("~~~~~~~~~~ START FILE ~~~~~~~~~~");
      System.out.print(fileString);
      System.outprintln("~~~~~~~~~~ END FILE ~~~~~~~~~~");

    }
}

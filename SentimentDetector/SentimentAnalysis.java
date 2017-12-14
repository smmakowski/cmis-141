import java.util.HashMap;
import java.io.*;
import java.util.Scanner;

public class SentimentAnalysis {
    private static String fileString = "";
    private static int linesRead = 0;
    private static HashMap<String, Integer> wordScores = new HashMap<String, Integer>();

    public static  void main(String[] args) {
      Scanner scan = null;
  		int lineNum = 0;
  		String lineText = "";

  		try {
  			// create fileScanner
  			scan = new Scanner(new File("subjclueslen1-HLTEMNLP05.txt"));
  			// while there are more lines to parse
  			while (scan.hasNext()) {
          linesRead++; // increment line
  				lineText = scan.nextLine(); // scan

          parseLine(lineText); // parse score with method
  			}
        System.out.println("Lines read" + lineNum);
  		} catch (FileNotFoundException e) { // if exception thrown then exit
  			System.err.println("Unable to find file. Please make sure that your file path is correct.");
  		} finally { // after scan is done, close scanner, if created
  			if (scan != null) {
  				scan.close();
  			}
        promptUser();
  		}
  	}

    // method to print file;
    public static void printFile() {
      System.out.println("The file has " + linesRead + "lines. Now printing file contents...");
      System.out.println("~~~~~~~~~~ START FILE ~~~~~~~~~~");
      System.out.print(fileString);
      System.out.println("~~~~~~~~~~ END FILE ~~~~~~~~~~");
    }

    public static void parseLine(String line) {
      int score;
      fileString = fileString.concat(line); // concat line to fieString;
      // split the line into A=B pairs
      String[]pairs = line.split(" ");
      String word = pairs[2].split("=")[1]; // get word

      String polarity = pairs[5].split("=")[1]; // get polarity

      // score based on popularity
      if (polarity.equals("positive")) {
        score = 1;
      } else if (polarity.equals("negative")) {
        score = -1;
      } else { // for netural (not else if since only 3 options)
        score = 0;
      }
      System.out.println("WORD: " + word);
      System.out.println("SCORE: " + score);
      wordScores.put(word, score); // add to hashmap
    }

    public static void printSentenceScore(String sentence) {

    }

    public static void promptUser() {
      Scanner scan = new Scanner(System.in);
      String response = "";
      while (true) {
        // prompt user for menu choice
        System.out.println("Please enter the number of the option you wish to choose.");
        System.out.println("1. Analyze Sentence");
        System.out.println("2. View File Contents and Size.");
        System.out.println("3. Quit");
        System.out.println("");

        System.out.print("What is your choice? ");
        response = scan.nextLine();
        // depending on response, call appropriate method or exit loop
        if (response.equals("1")) {

        } else if (response.equals("2")) {
          printFile();
        } else if (response.equals("3")) {
          break;
        } else {
          System.out.println("Option not available! Please choose one of the available options.");
        }
      }
      scan.close();
    }
}

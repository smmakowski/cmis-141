/*
  Filename: SentimentAnalysis.java
  Author: Stephen Makowski
  Date: December 14, 2017
  Purpose: Program reads two files, a test file with integer values, and a sentiment lexicon.
  On the main menu the user can view the data read and how much data/how many lines were read,
  or type in some text and have it basically analyzed for tone to determine if its a negative
  positive or neutral test. Uses Arrayslists, Hashmaps, File I/O and the scanner.
*/

import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class SentimentAnalysis {
    // sentiment file test
    private static String fileString = "";
    private static int linesRead = 0;
    // test file data holder
    private static ArrayList<Integer> testIntsRead = new ArrayList<Integer>();
    // hashmap to hold scores from sentiment file
    private static HashMap<String, Integer> wordScores = new HashMap<String, Integer>();

    public static  void main(String[] args) {
      Scanner scan = null;
  		String lineText = "";
      System.out.println("");
      System.out.println("Now attempting to read files. Please wait...");
  		try {
  			// create fileScanner
  			scan = new Scanner(new File("subjclueslen1-HLTEMNLP05.txt"));
  			// while there are more lines to parse
  			while (scan.hasNext()) {
          linesRead++; // increment line
  				lineText = scan.nextLine(); // scan

          parseLine(lineText); // parse score with method
  			}
        scan.close(); // close and nullify
        scan = null;
        // assign new scanner for test file
        scan = new Scanner(new File("test.txt"));
        while (scan.hasNext()) {
          int currInt = Integer.parseInt(scan.next());
          testIntsRead.add(currInt);
        }
  		} catch (FileNotFoundException e) { // if exception thrown then exit
  			System.err.println("Unable to find one or more files. Please make sure" +
        "that files are in same directory, or change file path(s) in SentimentAnalysis.java.");
        System.exit(1);
  		}
        System.out.println("");
        System.out.println("Files have been read succesfully! Opening Main Menu!");

        if (scan != null) {
  				scan.close();
  			}
        promptUser(); // start menu
  	}

    // method to print file;
    public static void printFile() {
      System.out.println("");
      System.out.println("The program has read " + linesRead + " lines from the Sentiment Lexicon. Now printing file contents...");
      System.out.println("");
      System.out.println("~~~~~~~~~~ START FILE CONTENTS ~~~~~~~~~~");
      System.out.print(fileString);
      System.out.println("~~~~~~~~~~ END FILE CONTENTS ~~~~~~~~~~");
    }
    // prints tes tfiles values and number of data read
    public static void printTestFile() {
      System.out.println("");
      System.out.println("The program read " + testIntsRead.size() + " data from the test file. Now printing data values...");
      System.out.println("");
      System.out.println("~~~~~~~~~~ START DATA VALUES ~~~~~~~~~~");
      for (int i = 0; i < testIntsRead.size(); i++) {
        System.out.print(testIntsRead.get(i) + " ");
      }
      System.out.print("\n");
      System.out.println("~~~~~~~~~~ END  DATA VALUES ~~~~~~~~~~");
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
      wordScores.put(word, score); // add to hashmap
    }

    public static void printSentenceScore(String sentence) {
      System.out.println("");
      System.out.println("~~~~~~~~~~ START ANALYSIS ~~~~~~~~~~");
      int totalScore = 0; // start score at 0
      // replaces all non letters with " "s just in case
      // and then split on empty spaces
      String[] words = sentence.replaceAll("[^a-zA-Z]" , " ").split(" ");
      HashMap<String, Integer> scoredWords = new HashMap<String, Integer>();
      // trim all wordScores
      for (int i = 0; i < words.length; i++) {
        words[i] = words[i].trim();
      }

      // iterate through words and assess score
      for (int j = 0; j < words.length; j++) {
        if (wordScores.get(words[j].toLowerCase()) != null) { // if the word is found in the hash map
          scoredWords.put(words[j], wordScores.get(words[j]));
          totalScore += wordScores.get(words[j].toLowerCase());
        } else {
          // do nothing since not in HashMap
        }
      }
      String tone = ""; // generate tone string based on polarity

      if (totalScore > 0) {
        tone = "positive";
      } else if (totalScore < 0) {
        tone = "negative";
      } else {
        tone = "neutral";
      }

      System.out.println("The text you entered has a score of " + totalScore + ".");
      System.out.println("This text has an overall " + tone + " tone.");
      System.out.println("");
      System.out.println("Here are the words that were found in the lexicon and their scores:");
       System.out.println("KEY : (1 = postive, -1 = negative, 0 = neutral)");

      for (String key : scoredWords.keySet()) {
        System.out.println(key + " : " + scoredWords.get(key));
      }

      System.out.println("~~~~~~~~~~ END ANALYSIS ~~~~~~~~~~");
    }

    public static void promptUser() {
      Scanner scan = new Scanner(System.in);
      String response = "";
      while (true) {
        // prompt user for menu choice
        System.out.println("");
        System.out.println("Please enter the number of the option you wish to choose.");
        System.out.println("1. Analyze Sentence");
        System.out.println("2. View sentiment exicon file size and contents");
        System.out.println("3. Print test file values and number of values");
        System.out.println("4. Quit");
        System.out.println("");

        System.out.print("What is your choice? ");
        response = scan.nextLine();
        // depending on response, call appropriate method or exit loop
        if (response.equals("1")) {
          System.out.println("");
          System.out.println("Please enter in a sentence that you would like to analyze (TIP: The analysis works best with a sentence that only uses letters and numbers): ");
          response = scan.nextLine(); // get sentence

          printSentenceScore(response); // run analysis method
        } else if (response.equals("2")) {
          printFile();
        } else if (response.equals("3")) {
          printTestFile();
        } else if (response.equals("4")) {
          break;
        } else {
          System.out.println("");
          System.out.println("Option not available! Please choose one of the available options.");
        }
      }
      scan.close();
      System.out.println("");
      System.out.println("Thank you for using this program. Goodbye!");

    }
}

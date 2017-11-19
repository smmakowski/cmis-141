/**
  * File: GUitar.java
  * Author: Stephen Makowski
  * Date: November 19, 2017
  * Purpose: Guitar class constructors and methods
*/
import java.awt.Color;
import java.util.Random;

public class Guitar {
  //private fields per instructions
  private int numStrings;
  private double guitarLength;
  private String guitarManufacturer;
  private Color guitarColor;

  // constructor methods
  public Guitar() {
    this.numStrings = 6;
    this.guitarLength = 28.2;
    this.guitarManufacturer = "Gibson";
    this.guitarColor = Color.red;
  }

  public Guitar(int strings, double length, String maker, Color color) {
    this.numStrings = strings;
    this.guitarLength = length;
    this.guitarManufacturer = maker;
    this.guitarColor = color;
  }

  // get methods that return field values
  public int getNumStrings() {
    return this.numStrings;
  }

  public double getGuitarLength() {
    return this.guitarLength;
  }

  public String getGuitarManufacturer() {
    return this.guitarManufacturer;
  }

  public Color getGuitarColor() {
    return this.guitarColor;
  }
  // method that plays random notes
  public String playGuitar() {
    // instantiate random object
    Random rand = new Random();
    // create arrays of tones and times
    final String[] TONES = {"A", "B", "C", "D", "E", "F", "G"};
    final String[] TIMES = {".25", ".5", "1", "2", "4"};

    String[] randomSequence = new String[16]; // setup sequence to hold notes
    String notes = ""; // initialize empty notes string
    // declare random int variables to be used in loop
    int randomTone;
    int randomTime;
    // loop to repeat 16 times that fills up randomSequence array
    for (int i = 0; i < randomSequence.length; i++) {
      // generate random indexes
      randomTone = rand.nextInt(TONES.length);
      randomTime = rand.nextInt(TIMES.length);
      //generate random note and assign index (i) in randomSequence
      randomSequence[i] = TONES[randomTone].concat("(").concat(TIMES[randomTime]).concat(")");
    }
    // use .join method to join the random sequence and append it it brackets
    notes = "[" + String.join(", ", randomSequence)+ "]";

    // return the final value;
    return notes;
  }

  public String toString() {
    //assign variable to 'stringified' object and return
    String toString ="(numStrings=" + this.numStrings + ", Length=" + this.guitarLength +
    ", manufacturer=" + this.guitarManufacturer + ", color=" + this.guitarColor + ")";
    return toString;
  }

}

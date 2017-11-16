import java.awt.Color;
import java.util.Random;

public class Guitar {
  private int numStrings;
  private double guitarLength;
  private String guitarManufacturer;
  private Color guitarColor;

  public Guitar() {
    numStrings = 6;
    guitarLength = 28.2;
    guitarManufacturer = "Gibson";
    guitarColor = Color.red;
  }

  public int getNumStrings() {
    return numStrings;
  }

  public double getGuitarLength() {
    return guitarLength;
  }

  public String getGuitarManufacturer() {
    return guitarManufacturer;
  }

  public Color getGuitarColor() {
    return guitarColor;
  }

  public String playGuitar() {
    Random rand = new Random();
    final String[] TONES = {"A", "B", "C", "D", "E", "F", "G"};
    final String[] TIMES = {".25", ".5", "1", "2", "4"};
    String[] randomSequence = new String[16];
    String notes = "";
    int randomTone;
    int randomTime;

    for (int i = 0; i < randomSequence.length; i++) {
      randomTone = rand.nextInt();
      randomTime = rand.nextInt();
      randomSequence[i] = TONES[randomTone].concat("(").concat(TIMES[randomTime]).concat(")");
    }
    notes += "[" + String.join(", ", notes)+ "]";

    System.out.println(notes);
    return notes;
  }

  public String toString() {
    String toString ="(numStrings=" + numStrings + ", Length=" + guitarLength +
    ", manufacturer=" + guitarManufacturer + ", color=" + guitarColor + ")";
    return toString;
  }

}

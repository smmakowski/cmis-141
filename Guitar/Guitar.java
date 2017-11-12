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

  public getNumStrings() {
    return numStrings;
  }

  public getGuitarLength() {
    return guitarLength;
  }

  public getGuitarManufacturer() {
    return guitarManufacturer;
  }

  public getGuitarColor() {
    return guitarColor;
  }

  public playGuitar() {
    Random rand = new Random();
    final char[] tone = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    final String[] time = {".25", ".5", "1", "2", "4"};
    String[] notes
    String notes = "[";

    notes.concat("]");

  }

  public toString() {
    System.out.println("(numStrings=" + numStrings + ", Length=" + guitarLength +
    ", manufacturer=" + guitarManufacturer + ", color=" + guitarColor + ")");
  }

}

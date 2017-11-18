public class Homework2 {
  public static void main (String[] args) {
    // instantiate guitars
    Guitar guitar1 = new Guitar();
    Guitar guitar2 = new Guitar();
    Guitar guitar3 = new Guitar();
    // create an array of guitars that contains above instances
    Guitar[] guitars = new Guitar[]{guitar1, guitar2, guitar3};
    // iterate through Array and print return values for each methods for each Guitar
    for (int i = 0; i < guitars.length; i++) {
      System.out.println("***** guitar" + (i + 1) + "*****");
      System.out.println("getNumStrings(): " + guitars[i].getNumStrings());
      System.out.println("getGuitarLength(): " + guitars[i].getGuitarLength());
      System.out.println("getGuitarManufacturer(): " + guitars[i].getGuitarManufacturer());
      System.out.println("getGuitarColor(): " + guitars[i].getGuitarColor());
      System.out.println("playGuitar(): " + guitars[i].playGuitar());
      System.out.println("");
    }

    System.out.println("~~~~ END ~~~~");
  }
}

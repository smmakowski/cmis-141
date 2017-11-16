import java.util.Scanner;
import java.util.Random;

public class Moves {
  public String name;
  int power;
  double accuracy;
  int maxPp;
  int pp;
  String type;
  String category;

  public Moves(String n, int p, double a, int mP, String t, String c) {
    this.name = n;
    power = p;
    accuracy = a;
    maxPp = mP;
    pp = maxPp;
    type = t;
    category = c;
  }

  public int makeNormalMove(Pokemon attacker, Pokemon defender) {
    Random rand = new Random();
    int damage = 0;
    double hitChance = rand.nextDouble();
    // check pp levels
    if (this.pp > 0) {
      //do nothing 
    } else {
      System.out.println("You do not have to pp for this move");
      return 0;
    }

    //check to make sure hit lands
    if (hitChance <= accuracy) {
      System.out.println("The attack hits");

    } else {
      System.out.println("The attack misses!");
    }
    // decrement pp if possible
    if (this.pp > 0) {
      pp--;
    }

    return damage;
  }

  public void makeSpecialMove() {

  }
}

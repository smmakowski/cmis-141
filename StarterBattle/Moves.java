import java.util.Scanner;
import java.util.Random;

public class Moves {
  String name;
  int power;
  double accuracy;
  int maxPp;
  int pp;
  String type;
  String category;
  String status;

  public Moves(String n, int p, double a, int mP, String t, String c, String s) {
    this.name = n.toUpperCase();
    power = p;
    accuracy = a;
    maxPp = mP;
    pp = maxPp;
    type = t.toUpperCase();
    category = c.toUpperCase();
    status = s.toUpperCase();
  }


  public void makeMove(Pokemon attacker, Pokemon defender) {
    if (this.category.equals("PHYSICAL")) {
      this.makeNormalMove(attacker, defender);
    } else if (this.category.equals("STATUS")) {
      this.makeStatusMove(attacker, defender);
    }
  }

  public void makeNormalMove(Pokemon attacker, Pokemon defender) {
    Random rand = new Random();
    int damage = 0;
    double hitChance = rand.nextDouble();
    // check pp levels
    if (this.pp > 0) {
      // check to see if attack lands
      if (hitChance <= accuracy) {
        damage = calculateDamage(attacker, defender);
        defender.takeDamage(damage);
      } else {
        System.out.println("The attack misses!");
      }
      // decrement pp if possible
      if (this.pp > 0) {
        pp--;
      }
    } else {
      System.out.println("You do not have to pp for this move!");
    }
  }

  public void makeStatusMove(Pokemon attacker, Pokemon defender) {
    Random rand = new Random();
    int damage = 0;
    double hitChance = rand.nextDouble();
    // check pp levels
    if (this.pp > 0) {
      // check to see if attack lands
      if (hitChance <= accuracy) { // if it lands
        defender.debuffStatus(this.status);
      } else {
        System.out.println("The attack fails!");
      }
      // decrement pp after usage
        pp--;
    } else {
      System.out.println("You do not have to pp for this move!");
    }
  }

  public int calculateDamage(Pokemon attacker, Pokemon defender) {
    Random rand = new Random();
    int randomMod = rand.nextInt(attacker.level);
    double damage = (((((2.0 * attacker.level) / 5.0) + 2.0) * this.power * (attacker.attack / defender.defense)) / 50.0) + 2.0;
    if (isCritical()) {
      System.out.println("It's a critical hit!");
      damage = damage * 2.0;
    }

    damage += randomMod;
    return (int)damage;
  }

  public boolean isCritical() {
    Random rand = new Random();
    return rand.nextBoolean();
  }

  public void makeSpecialMove() {

  }
}

import java.util.Scanner;
import java.util.Random;

public class Pokemon {
  // public variables
  String name;
  String type;
  int level;
  int maxHp;
  int hp;
  int attack;
  int defense;
  int sAttack;
  int sDefense;
  int speed;
  Moves[] moves;

  public Pokemon(String n, String t, int l, int h, int a, int d, int sA, int sD, int s, Moves m1, Moves m2, Moves m3, Moves m4) {
    this.name = n;
    this.type = t;
    this.level = l;
    maxHp = h;
    hp = maxHp;
    attack = a;
    defense = d;
    sAttack = sA;
    sDefense = sD;
    speed = s;
    moves = new Moves[] {m1, m2, m3, m4};
  }
  public void setNickname() {
    Scanner scan = new Scanner(System.in);
    String nickname = name;
    String choice = "";
    boolean pickingName = true;
    while (true) {
      System.out.println("Would you like to give " + this.name + " a nickname ('y' for yes 'n' for no, non case-sensitive)?");
      choice = scan.next().toLowerCase();

      if (choice.equals("y")) {
        break;
      } else if (choice.equals("n")) {
        System.out.println("Okay then! The default name is cool too...");
        return;
      } else {
        System.out.println("Invalid input! Please try again!");
      }
    }  
    
    while (pickingName) {
      System.out.println("What nickname would you like to give a nickname to " + name + "?");
      nickname = scan.next().toUpperCase();
      System.out.println("You have chosen the nickname \"" + nickname + ".");

      while (true) {
        System.out.println("Are you sure? This is literally the only part of the game where we'll try to confirm your choice!");
        System.out.println("Enter 'Yes' to confirm or 'No' to change name (Answer is not case-sensitive):");
        choice = scan.next().toLowerCase();
        if (choice.equals("yes")) {
          this.name = nickname;
          pickingName = false;
          break;
        } else if (choice.equals("no")) {
          break;
        } else {
          System.out.println("That's not a valid answer!");
        }
      }
    }
  }

  public void printMoves() {
    System.out.println("Your " + this.name + " can do the following moves:");
    for (int i = 0; i < moves.length; i++) {
      if (moves[i] != null) {
        System.out.println("\t" + "(" + (i + 1) + ") " + moves[i].name + " ( " + moves[i].pp + " / " + moves[i].maxPp + " )");
      }
    }
  }

  public void call() {
    System.out.println(this.name + "-" + name + "!!!");
  }

  public void takeDamage(int damage) {
    if (damage > 0) {
      System.out.println(this.name + " takes " + damage + " damage!");
    }

    if (damage >= this.hp) {
      this.hp = 0;
      System.out.println(this.name + " has fainted!");
    } else {
      this.hp -= damage;
    }
  }

  public void heal() {
    hp += 10;
    if (hp > maxHp) {
      hp = maxHp;
    }

    System.out.println(this.name + "is healed for 10hp!");
  }

  public int hasMove(String move) {
    for (int i = 0; i < moves.length; i++) {
      if (moves [i] != null && moves[i].name.equals(move.toUpperCase())) {
        return i;
      }
    }
    return -1;
  }
}

import java.util.Scanner;
import java.util.Random;

public class Pokemon {
  // public fields
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

  // constructor
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
  // method to set nickname for pokemon 
  public void setNickname() {
    Scanner scan = new Scanner(System.in);
    String nickname = name;
    String choice = "";
    boolean pickingName = true;
    // ask user if you would like to give anickname
    while (true) {
      System.out.println("Would you like to give " + this.name + " a nickname ('y' for yes 'n' for no, non case-sensitive)?");
      choice = scan.next().toLowerCase();
      // give user option to continue 
      if (choice.equals("y")) {
        break;
      } else if (choice.equals("n")) {
        System.out.println("Okay then! The default name is cool too...");
        return; // exit funtion if no desire to enter nickname
      } else {
        System.out.println("Invalid input! Please try again!");
      }
    }  
    // loop to enter nickname
    while (pickingName) {
      System.out.println("What nickname would you like to give a nickname to " + name + "?");
      nickname = scan.next().toUpperCase();
      System.out.println("You have chosen the nickname \"" + nickname + ".");
      // loop to confirm choice
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
  // method to print moves
  public void printMoves() {
    System.out.println("Your " + this.name + " can do the following moves:");
    // iterate through Moves array
    for (int i = 0; i < moves.length; i++) {
      if (moves[i] != null) { // if there is a move in array index print
        System.out.println("\t" + "(" + (i + 1) + ") " + moves[i].name + " ( " + moves[i].pp + " / " + moves[i].maxPp + " )");
      }
    }
  }
  // method that prints pokemon call
  public void call() {
    System.out.println(this.name + "-" + name + "!!!");
  }

  // method that allows damage to be taken
  public void takeDamage(int damage) {
    // if damage is take print amout
    if (damage > 0) {
      System.out.println(this.name + " takes " + damage + " damage!");
    }
    // adjust hp to damage with min of 0
    if (damage >= this.hp) {
      this.hp = 0;
      System.out.println(this.name + " has fainted!");
    } else {
      this.hp -= damage;
    }
  }

  // mehtod to heal pokemon 
  public void heal() {
    hp += 10;
    if (hp > maxHp) {
      hp = maxHp;
    }
    System.out.println(this.name + " used a POTION!");
    System.out.println(this.name + "is healed for 10hp!");
  }

  public void debuffStatus(String status) {
    int mod;
    switch (status) {
      case "ATTACK":
        mod = this.attack / 10;
        System.out.println(mod);
        System.out.println(this.name + "'S ATTACK has been lowered!");
        this.attack -= mod;
        break;
      case "DEFENSE":
        mod = this.defense / 10;
        System.out.println(mod);
        System.out.println(this.name + "'S DEFENSE has been lowered!");
        this.defense -= mod;
        break;
      default:
        System.out.print(this.name + " is unaffected!");
    }
  }
  // mehtod to see if pokemon has move
  public int hasMove(String move) {
    //iterate through array
    for (int i = 0; i < moves.length; i++) {
      if (moves [i] != null && moves[i].name.equals(move.toUpperCase())) {
        return i; // if move is fount return index
      }
    }
    return -1; // return -1 if not found
  }
}

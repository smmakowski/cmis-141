import java.util.Scanner;
import java.util.Random;

public class Pokemon {
  // public variables
  public String name;
  public String type;
  public int level;
  int hp;
  int attack;
  int defense;
  int sAttack;
  int sDefense;
  int speed;

  public Pokemon(String n, String t, int l, int h, int a, int d, int sA, int sD, int s) {
    this.name = n;
    this.type = t;
    this.level = l;
    hp = h;
    attack = a;
    defense = d;
    sAttack = sA;
    sDefense = sD;
    speed = s;
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
      nickname = scan.next();
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

  public void call() {
    System.out.println(this.name + "-" + name + "!!!");
  }
}

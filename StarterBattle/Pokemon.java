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
  // public void setNickname(String name) {
  //   Scanner scan = new Scanner(System.in);
  //   String resp;
  //   String nickname = name;
  //   boolean pickingName = true;
  //   while (pickingName) {
  //     while ()
  //     System.out.println("Would you like to give a nickname to " + name + "?");
  //     nickname = scan.nextLine();
  //
  //     System.out.println("You have chosen the nickname \"" + nickname + "")
  //
  //   }
  //   System.out.println("Would you like to give a nickname to " + name + "?");
  //   nickname = scan.nextLine();
  //
  //   System.out.println("You have chosen the nickname \"" + nickname + "")
  //
  // }
  public void call() {
    System.out.println(this.name + "-" + name + "!!!");
  }
}

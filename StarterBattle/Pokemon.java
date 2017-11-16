import java.util.Scanner;
import java.util.Random;

public class Pokemon {
  String name;
  String type;
  int hp;
  int level;

  public Pokemon(String n, String t, int h, int l) {
    name = n;
    type = t;
    hp = h;
    level = l;
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
    System.out.println(name + "-" + name + "!!!");
  }
}

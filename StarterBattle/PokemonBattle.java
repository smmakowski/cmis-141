import java.util.Scanner;

public class PokemonBattle {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean choosingPokemon = true;
    
    String pick = "";
    String conf = "";
    String yourName = "";
    Pokemon yourPokemon = null;
    String rivalName = "";
    Pokemon rivalPokemon= null;
    boolean firstToGo = false;
    boolean inBattle = true;

    Moves tackle = new Moves("Tackle", 50, 1.0, 35, "Normal", "Physical");
    Moves growl = new Moves("Growl", 0, 1.0, 40, "Normal", "Status");
    Moves scratch = new Moves("Scratch", 40, 1.0, 40, "Normal", "Status");
    Moves tailWhip = new Moves("tailWhip", 0, 1.0, 30, "Normal", "Status");

    Pokemon bulbasaur = new Pokemon("Bulbasaur", "Grass", 5, 45, 49, 49, 65, 65, 45, tackle, growl, null, null);
    Pokemon charmander = new Pokemon("Charmander", "Fire", 5, 39, 52, 43, 60, 50, 65, scratch, growl, null, null);
    Pokemon squirtle = new Pokemon("Squirtle", "Water", 5, 44, 48, 65, 50, 64, 43, tackle, tailWhip, null, null);

    bulbasaur.printMoves();

    System.out.println("Professor: Welcome to my lab! I see you're here about the ad I put up for human test subjects!?");
    System.out.println("Professor: No? oh you must be here to pick your Pokemon, then! Why didn't you day so?");
    System.out.println("Professor: Oops, I didn't catch your name! What was it again (Please enter name)?");
    yourName = scan.next();
    System.out.println("Professor: " + yourName + " is it? Well nice to meet you!");

    System.out.println("Oh, and this is my ___. He's looking to start his adventure too. I think his name is... (Please enter name):");
    rivalName = scan.next();
    System.out.println(rivalName + ": That's right! my name is " + rivalName + ", and don't you forget it!");

    System.out.println("Professor: Well.. let's get to it! I have three Pokemon on the table here. Sorry.. but all the others were taken!");
    System.out.println("Professor: We have... "); // insert names and bsaci type
    System.out.println("Professor: Think hard! because once you call dibs, you cannot undo it!");

    while (choosingPokemon) {
        pick = scan.next();
        switch (pick) {
          case "bulbasaur" :
            yourPokemon = bulbasaur;
            rivalPokemon = charmander;
            choosingPokemon = false;
            break;
          case "charmander" :
          yourPokemon = charmander;
            rivalPokemon = squirtle;
            choosingPokemon = false;
            break;
          case "squirtle" :
            yourPokemon = squirtle;
            rivalPokemon = bulbasaur;
            choosingPokemon = false;
            break;
          default:
            System.out.println("I don't have that one! Please try picking again");
        }
      }


    System.out.println("You have chosen " + yourPokemon.name + ", the " + yourPokemon.type + " Pokemon.");
    yourPokemon.setNickname();

    System.out.println(rivalName + ": Fine Noob, I'll take " + rivalPokemon.name + "! It's a " + rivalPokemon.type +
    " , so it's better anyway!");

    System.out.println(rivalName + ": Hey I have an idea! Let's battle!");
    System.out.println("asdfj");

    // determine who does first
    if (yourPokemon.speed > rivalPokemon.speed) {
        firstToGo = true;
        System.out.println("Your " + yourPokemon.name + " Is faster! You'll go first!");
        yourPokemon.call();
    } else {
        System.out.println(rivalName +"'s " + yourPokemon.name + " Is faster! You'll go second!");
    }

    // begin inBattletle
    while (inBattle) {
        // if (firstToGo) {
        //     yourPokemon
        // } else {

        // }
        
        yourPokemon.takeDamage(100);
        // test victory 
        if (checkVictory(yourPokemon, rivalPokemon) < 3) {
            inBattle = false;
        }


    }

  }

  public static int checkVictory(Pokemon a, Pokemon b) {
    if (a.hp == 0 && b.hp == 0) {
        return 0;
    } else if (a.hp == 0) {
        return 1;
    } else if (b.hp == 0) {
        return 2;
    } else {
        return 3;
    }
  }
}

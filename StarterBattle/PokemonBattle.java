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
    Pokemon bulbasaur = new Pokemon("Bulbasaur", "Grass", 5, 45, 49, 49, 65, 65, 45);
    Pokemon charmander = new Pokemon("Charmander", "Fire", 5, 39, 52, 43, 60, 50, 65);
    Pokemon squirtle = new Pokemon("Squirtle", "Water", 5, 44, 48, 65, 50, 64, 43);

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


    // // begin battle
    // while (inBattle) {
    //
    // }

  }
}

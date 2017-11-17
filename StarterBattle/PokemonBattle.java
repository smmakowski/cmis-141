import java.util.Scanner;
import java.util.Random;

public class PokemonBattle {
  public static void main(String[] args) {
    // instantiate scann/ random objects
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    
    // game states
    boolean choosingPokemon = true;
    String pick = "";
    String conf = "";
    String yourName = "";
    Pokemon yourPokemon = null;
    String rivalName = "";
    Pokemon rivalPokemon= null;
    boolean firstToGo = false;
    boolean inBattle = true;
    int victor = 3;
    int choices = 0;
    int randInt = 0;
    int turn = 1;
    // potions inventory
    int yourPotions = 0;
    int rivalPotions = 0;

    // instantiate starter moves
    Moves tackle = new Moves("Tackle", 50, 1.0, 35, "Normal", "Physical", "");
    Moves growl = new Moves("Growl", 0, 1.0, 40, "Normal", "Status", "attack");
    Moves scratch = new Moves("Scratch", 40, 1.0, 40, "Normal", "Physical", "");
    Moves tailWhip = new Moves("Tail Whip", 0, 1.0, 30, "Normal", "Status", "defense");

    // instantiate starter pokemon
    Pokemon bulbasaur = new Pokemon("BULBASAUR", "Grass", 5, 45, 49, 49, 65, 65, 45, tackle, growl, null, null);
    Pokemon charmander = new Pokemon("CHARMANDER", "Fire", 5, 39, 52, 43, 60, 50, 65, scratch, growl, null, null);
    Pokemon squirtle = new Pokemon("SQUIRTLE", "Water", 5, 44, 48, 65, 50, 64, 43, tackle, tailWhip, null, null);


    // Print opening lines and dialogue
    // Logo taken from https://www.ascii-code.com/ascii-art/video-games/pokemon.php
    // warning: logos do not contain backslashes for escape characters tehy need to be added!
    System.out.println("                                          ,'\\");
    System.out.println("        _.----.        ____         ,'  _\\   ___    ___     ____");
    System.out.println("    _,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.");
    System.out.println("    \\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |");
    System.out.println("     \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |");
    System.out.println("       \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |");
    System.out.println("        \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |");
    System.out.println("         \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |");
    System.out.println("          \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |");
    System.out.println("           \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |");
    System.out.println("            \\_.-'       |__|    `-._ |              '-.|     '-.| |   |");
    System.out.println("                                    `'                            '-._|");
    
    System.out.print("NARRATOR: It's a sunny day in Pallet Town, and today is the day you get to go pick your first Pokemon! You forgot to set your alarm and wake up 4"); 
    System.out.print(" hours late.  You run over to the professor's lab as fast as you can!\n");
    System.out.println("");

    System.out.println("PROFESSOR: Welcome to my lab! I see you're here about the ad I put up for human test subjects!");
    System.out.println("PROFESSOR: No? oh you must be here to pick your Pokemon, then! Why didn't you say so?");
    
    // prompt user for name 
    System.out.println("PROFESSOR: Oops, I didn't catch your name! What was it again (Please enter name)?");
    yourName = scan.next().toUpperCase();
    System.out.println("PROFESSOR: " + yourName + " is it? Well nice to meet you!");
    System.out.println("");
    // prompt user for rival name
    System.out.println("PROFESSOR: Oh, and this is one of my kid relatives. He's looking to start his adventure too, maybe. I think his name is... (Please enter name):");
    rivalName = scan.next().toUpperCase();
    System.out.println(rivalName + ": That's right! my name is " + rivalName + ", and don't you forget it!");

    // prompt user for pokemon
    System.out.println("");
    System.out.println("PROFESSOR: Well.. let's get to it! You can pick first! I have three Pokemon on the table here. Sorry.. but all the others were taken!");
    System.out.println("PROFESSOR: We have... ");
    System.out.println("\t(1) BULBASAUR the GRASS type POKEMON.");
    System.out.println("\t(2) CHARMANDER the FIRE type POKEMON.");
    System.out.println("\t(3) SQUIRTLE the WATER type POKEMON.");
    System.out.println("PROFESSOR: Think hard! because once you call dibs, you cannot undo it!");


    while (choosingPokemon) {
        // if more than 3 invlaid choices, pokemon is chosen using random number
        if (choices == 3) {
            System.out.println("");    
            System.out.println("PROFESSOR: Okay! Let's not be indecisive here... I'll pick one for you!");
            System.out.println(rivalName + ": Yeah, Brah! we ain't got all day!");
            randInt = rand.nextInt(3) + 1;
            switch (randInt) {
                case 1:
                    pick = "bulbasaur";
                    break;
                case 2:
                    pick = "charmander";
                    break;
                case 3:
                    pick ="squirtle";
                    break;
                default:
                    // do nothing 
                    break;
            }
        }  else { // prompt user for choice
            pick = scan.next().toLowerCase();
        }
        // select you and rival 's pokemon
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
          default: // handle impormpoer input
            choices++;
            System.out.println("");
            System.out.println("PROFESSOR: I don't have that one! Please try picking one of the below choices");
            System.out.println("\t(1) BULBASAUR the GRASS type POKEMON.");
            System.out.println("\t(2) CHARMANDER the FIRE type POKEMON.");
            System.out.println("\t(3) SQUIRTLE the WATER type POKEMON.");
        }
    }

    // set nickname in Pokemon class print pre batter
    System.out.println("");
    System.out.println("You have chosen " + yourPokemon.name + ", the " + yourPokemon.type + " Pokemon.");
    yourPokemon.setNickname();

    System.out.println("");
    System.out.println(rivalName + ": Fine Noob, I'll take " + rivalPokemon.name + "! It's a " + rivalPokemon.type +
    " type, so it's better anyway!");
    System.out.println(rivalName + ": Hey I have an idea! Let's battle!");

    while (true) {
        System.out.println("");
        System.out.println("Ready to battle ('y' for 'n' for no)?");
        System.out.println("(If you hit no, the program will end)");
        conf = scan.next();

        if (conf.equals("y")) {
            break;
        } else if (conf.equals("n")) {
            System.out.println("");
            System.out.println(yourName + ": Nah, I'm good!");
            System.out.println("NARRATOR: Realizing that Pokemon isn't for you, you place the pokeball down and go home.");
            System.out.println("~~~~~ END ~~~~~");
            System.exit(0);
        } else {
            System.out.println("Please enter a valid response");
        }
    }
    System.out.println("");
    System.out.println("IT'S BATTLE TIME!!!");
    // determine who does first using speed 
    if (yourPokemon.speed > rivalPokemon.speed) {
        firstToGo = true;
        System.out.println("Your " + yourPokemon.name + " Is faster! You'll go first!");
        yourPokemon.call();
    } else {
        System.out.println(rivalName +"'s " + yourPokemon.name + " Is faster! You'll go second!");
    }

    // Enter battle Loop
    while (true) {
        // print turn header
        System.out.println("");
        System.out.println("***************** TURN " +  turn + " *****************");
        
        // take turns based on speed
        if (firstToGo) {
            userTurn(yourPokemon, rivalPokemon);
        } else {
            rivalTurn(yourPokemon, rivalPokemon, rivalName);
        }
        // check for victor after each turn
        victor = checkVictory(yourPokemon, rivalPokemon);
        if (victor < 3) {
            break;
        }

        if (firstToGo) {
            rivalTurn(yourPokemon, rivalPokemon, rivalName);
        } else {
            userTurn(yourPokemon, rivalPokemon);
        }

        victor = checkVictory(yourPokemon, rivalPokemon);
        if (victor < 3) {
            break;
        }
        //increment turn number
        turn++;
    }
    System.out.println("");
    // print victory dependent dialogue;
    if (victor == 0) {
        System.out.println("***********************************************************");
        System.out.println("");
        System.out.println("Both your pokemon have been knocked out!");
        System.out.println(rivalName + ": gg, brah! Did not expect that to happen at... all!");
    } else if (victor == 1) {
        System.out.println("***********************************************************");
        System.out.println("");
        System.out.println("You win!");
        System.out.println(rivalName + ": Hmmm... You just got lucky... I'm still the best...");
    } else {
        System.out.println("***********************************************************");
        System.out.println("");
        System.out.println(rivalName + " has won!");                                 
        System.out.println("");
        System.out.println(rivalName + ": See! I knew I was the best! Perhaps another time!");
    }
    System.out.println("");
    // print closing text/
    System.out.println("PROFESSOR: Well, that was an interesting battle!");
    System.out.println("PROFESSOR: It's time for you to venture out! A world of excitement awaits!");
    System.out.println("PROFESSOR: ... ... ...");
    System.out.println("PROFESSOR: Well maybe not, this is the only part of the game that's available for now... Oops!");
    System.out.println("PROFESSOR: Thanks for playing though! BYE!");
    System.out.println("");
    System.out.println("~~~~~ END ~~~~~");
  }

  public static int checkVictory(Pokemon player, Pokemon rival) {
    // check hp values using conditional chain 0 = tie 1 = player winner; 2 == comp winner 3 == continue
    if (player.hp == 0 && rival.hp == 0) {
        return 0;
    } else if (rival.hp == 0) {
        return 1;
    } else if (player.hp == 0) {
        return 2;
    } else {
        return 3;
    }
  }

  public static void userTurn(Pokemon yourPokemon, Pokemon rivalPokemon) {
    // prompt for attack while attack not chosen
    Scanner scan = new Scanner(System.in);
    String move = "";
    // print turn headers and available moves
    System.out.println("");
    System.out.println("< YOUR TURN >");
    System.out.println(yourPokemon.name + "'S HP: " + yourPokemon.hp +" | " + rivalPokemon.name + "'S HP: " + rivalPokemon.hp);
    System.out.println("");
    yourPokemon.printMoves();
    System.out.println("\t(ITEM) POTION (//add functionality later)");
    //prompt user for move choice
    System.out.println("Enter a move (Be careful, while your pokemon is not case-sensitive, it is word sensitive, and will not be able to do actions it doesn't understand!)");
    move = scan.nextLine(); 
    System.out.println("");
    // handle potion choice
    if (move.toUpperCase().equals("POTION")) {
        yourPokemon.heal();
    } else { // check for move availability
        int selected = yourPokemon.hasMove(move); // checks for move using cusotm indexOf mehtod
        if (selected != -1) { // if move is availale run move
            System.out.println(yourPokemon.name + " tries to use " + yourPokemon.moves[selected].name);
            yourPokemon.moves[selected].makeMove(yourPokemon, rivalPokemon);
        } else { // else pokemon loses turn
            System.out.println("You tell " + yourPokemon.name + " to use " + move.toUpperCase() + ".");
            System.out.println(yourPokemon.name + " cannot understand you! It sits there looking confused...");
        }  
    }
  }

  public static void rivalTurn(Pokemon yourPokemon, Pokemon rivalPokemon, String rivalName) {
    //generate random number for move
    Random rand = new Random();
    int action = rand.nextInt(4);
    //pritn headers 
    System.out.println("");
    System.out.println("< " + rivalName + "'S TURN >");
    System.out.println(yourPokemon.name + "'S HP: " + yourPokemon.hp +" | " + rivalPokemon.name + "'S HP: " + rivalPokemon.hp);
    System.out.println("");
    // conditionls based on move choice
    if (action < 2) { // if move is available (hardcoded since starters only have 2 moves)
        System.out.println(rivalPokemon.name + " tries to " + rivalPokemon.moves[action].name);
        rivalPokemon.moves[action].makeMove(rivalPokemon, yourPokemon);
        // calcul
    } else if (action == 2) { // if pokemon doesnt understand move generate random string for display
        String randString = generateRandomString();
        System.out.println(rivalName + " tries to tell " + rivalPokemon.name + " to use " + randString + ".");
        System.out.println(rivalPokemon.name + " sits there looking confused");
    } else if (action == 3) { // use potion
        System.out.println(rivalName + " uses a POTION!");
        rivalPokemon.heal();
    }
  }

  public static String generateRandomString() {
    Random rand = new Random();
    int len = rand.nextInt(9); // generate random string length
    int ascii = 0; // init random ascii value
    String randString = "";
    String randChar = "";
    // for the length of random string
    for (int i = 0; i < len; i++) {
        ascii = rand.nextInt(255); // generate random value
        randChar = Character.toString((char)ascii); // convert ot char
        randString += randChar; // append to random string
    }

    return randString;
  }
}  

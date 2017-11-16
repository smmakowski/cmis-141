public class PokemonBattle {
  public static void main(String[] args) {
    Pokemon charmander = new Pokemon("Bulbasaur", "Grass", 5, 45, 49, 49, 65, 65, 45);
    Pokemon bulbasaur = new Pokemon("Charmander", "Fire", 5, 39, 52, 43, 60, 50, 65);
    Pokemon squirtle = new Pokemon("Squirtle", "Water", 5, 44, 48, 65, 50, 64, 43);
    charmander.call();
  }
}

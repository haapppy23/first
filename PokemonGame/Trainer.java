package PokemonGame.PokemonGame;

import java.util.*;

public class Trainer {
    private String name;
    private List<Pokemon> pokemons;

    private static Trainer playerTrainer;
    private static List<Trainer> trainers = initializeTrainers();

    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = pokemons;
    }

    private static List<Trainer> initializeTrainers() {
        List<Pokemon> playerPokemons = Arrays.asList(
                Pokemon.initializePokemons().get(0), //Charmander
                Pokemon.initializePokemons().get(1), //Squirtle
                Pokemon.initializePokemons().get(2)  //Bulbasaur
        );
        List<Pokemon> gymLeaderPokemons = Arrays.asList(
                Pokemon.initializePokemons().get(3), // Magnemite
                Pokemon.initializePokemons().get(4), // Voltorb
                Pokemon.initializePokemons().get(5)  // Onyx
        );

        playerTrainer = new Trainer("Player", playerPokemons);

        return Arrays.asList(
                playerTrainer,
                new GymLeader("Gym Leader", gymLeaderPokemons)
        );
    }

    public static void setPlayerName(String name) {
        playerTrainer.name = name;
    }


    public static Trainer getTrainerByName(String name) {
        for (Trainer trainer : trainers) {
            if (trainer.getName().equals(name)) {
                return trainer;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public Pokemon getAvailablePokemon() {
        for (Pokemon pokemon : pokemons) {
            if (!pokemon.isFainted()) {
                return pokemon;
            }
        }
        return null;
    }
}

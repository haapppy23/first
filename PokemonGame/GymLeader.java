package PokemonGame.PokemonGame;

import java.util.List;

public class GymLeader extends Trainer {
    public GymLeader(String name, List<Pokemon> pokemons) {
        super(name, pokemons);
    }

    public Move chooseMove(Pokemon attacker, Pokemon defender) {
        Move optimalMove = null;
        double maxEffectiveness = 0.0;

        for (Move move : attacker.getMoves()) {
            double effectiveness = Type.getEffectiveness(move.getType(), defender.getType1(), defender.getType2());
            if (effectiveness > maxEffectiveness) {
                optimalMove = move;
                maxEffectiveness = effectiveness;
            }
        }

        if (optimalMove == null) {
            optimalMove = attacker.getMoves().get(0);
        }

        return optimalMove;
    }
}

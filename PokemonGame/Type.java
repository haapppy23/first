package PokemonGame.PokemonGame;

import java.util.HashMap;
import java.util.Map;

public class Type {
    private static final Map<String, Map<String, Double>> typeChart = new HashMap<>();

    static {
        Map<String, Double> normal = new HashMap<>();
        normal.put("Rock", 0.5);
        normal.put("Ghost", 0.0);
        normal.put("Steel", 0.5);
        typeChart.put("Normal", normal);

        Map<String, Double> fire = new HashMap<>();
        fire.put("Fire", 0.5);
        fire.put("Water", 0.5);
        fire.put("Grass", 2.0);
        fire.put("Ice", 2.0);
        fire.put("Bug", 2.0);
        fire.put("Rock", 0.5);
        fire.put("Dragon", 0.5);
        fire.put("Steel", 2.0);
        typeChart.put("Fire", fire);

        Map<String, Double> water = new HashMap<>();
        water.put("Fire", 2.0);
        water.put("Water", 0.5);
        water.put("Grass", 0.5);
        water.put("Ground", 2.0);
        water.put("Rock", 2.0);
        water.put("Dragon", 0.5);
        typeChart.put("Water", water);

        Map<String, Double> grass = new HashMap<>();
        grass.put("Fire", 0.5);
        grass.put("Water", 2.0);
        grass.put("Grass", 0.5);
        grass.put("Poison", 0.5);
        grass.put("Ground", 2.0);
        grass.put("Flying", 0.5);
        grass.put("Bug", 0.5);
        grass.put("Rock", 2.0);
        grass.put("Dragon", 0.5);
        grass.put("Steel", 0.5);
        typeChart.put("Grass", grass);

        Map<String, Double> electric = new HashMap<>();
        electric.put("Water", 2.0);
        electric.put("Grass", 0.5);
        electric.put("Electric", 0.5);
        electric.put("Ground", 0.0);
        electric.put("Flying", 2.0);
        electric.put("Dragon", 0.5);
        typeChart.put("Electric", electric);

        Map<String, Double> ice = new HashMap<>();
        ice.put("Fire", 0.5);
        ice.put("Water", 0.5);
        ice.put("Grass", 2.0);
        ice.put("Ice", 0.5);
        ice.put("Ground", 2.0);
        ice.put("Flying", 2.0);
        ice.put("Dragon", 2.0);
        ice.put("Steel", 0.5);
        typeChart.put("Ice", ice);

        Map<String, Double> fighting = new HashMap<>();
        fighting.put("Normal", 2.0);
        fighting.put("Ice", 2.0);
        fighting.put("Poison", 0.5);
        fighting.put("Flying", 0.5);
        fighting.put("Psychic", 0.5);
        fighting.put("Bug", 0.5);
        fighting.put("Rock", 2.0);
        fighting.put("Ghost", 0.0);
        fighting.put("Dark", 2.0);
        fighting.put("Steel", 2.0);
        fighting.put("Fairy", 0.5);
        typeChart.put("Fighting", fighting);

        Map<String, Double> poison = new HashMap<>();
        poison.put("Grass", 2.0);
        poison.put("Poison", 0.5);
        poison.put("Ground", 0.5);
        poison.put("Rock", 0.5);
        poison.put("Ghost", 0.5);
        poison.put("Steel", 0.0);
        poison.put("Fairy", 2.0);
        typeChart.put("Poison", poison);

        Map<String, Double> ground = new HashMap<>();
        ground.put("Fire", 2.0);
        ground.put("Electric", 2.0);
        ground.put("Grass", 0.5);
        ground.put("Poison", 2.0);
        ground.put("Flying", 0.0);
        ground.put("Bug", 0.5);
        ground.put("Rock", 2.0);
        ground.put("Steel", 2.0);
        typeChart.put("Ground", ground);

        Map<String, Double> flying = new HashMap<>();
        flying.put("Electric", 0.5);
        flying.put("Grass", 2.0);
        flying.put("Fighting", 2.0);
        flying.put("Bug", 2.0);
        flying.put("Rock", 0.5);
        typeChart.put("Flying", flying);

        Map<String, Double> psychic = new HashMap<>();
        psychic.put("Fighting", 2.0);
        psychic.put("Poison", 2.0);
        psychic.put("Psychic", 0.5);
        psychic.put("Dark", 0.0);
        psychic.put("Steel", 0.5);
        typeChart.put("Psychic", psychic);

        Map<String, Double> bug = new HashMap<>();
        bug.put("Fire", 0.5);
        bug.put("Grass", 2.0);
        bug.put("Fighting", 0.5);
        bug.put("Flying", 0.5);
        bug.put("Poison", 0.5);
        bug.put("Ghost", 0.5);
        bug.put("Steel", 0.5);
        bug.put("Fairy", 0.5);
        bug.put("Psychic", 2.0);
        bug.put("Dark", 2.0);
        typeChart.put("Bug", bug);

        Map<String, Double> rock = new HashMap<>();
        rock.put("Fire", 2.0);
        rock.put("Ice", 2.0);
        rock.put("Fighting", 0.5);
        rock.put("Ground", 0.5);
        rock.put("Flying", 2.0);
        rock.put("Bug", 2.0);
        rock.put("Steel", 0.5);
        typeChart.put("Rock", rock);

        Map<String, Double> ghost = new HashMap<>();
        ghost.put("Normal", 0.0);
        ghost.put("Psychic", 2.0);
        ghost.put("Ghost", 2.0);
        ghost.put("Dark", 0.5);
        typeChart.put("Ghost", ghost);

        Map<String, Double> dragon = new HashMap<>();
        dragon.put("Dragon", 2.0);
        dragon.put("Steel", 0.5);
        dragon.put("Fairy", 0.0);
        typeChart.put("Dragon", dragon);

        Map<String, Double> dark = new HashMap<>();
        dark.put("Fighting", 0.5);
        dark.put("Psychic", 2.0);
        dark.put("Ghost", 2.0);
        dark.put("Dark", 0.5);
        dark.put("Fairy", 0.5);
        typeChart.put("Dark", dark);

        Map<String, Double> steel = new HashMap<>();
        steel.put("Fire", 0.5);
        steel.put("Water", 0.5);
        steel.put("Electric", 0.5);
        steel.put("Ice", 2.0);
        steel.put("Rock", 2.0);
        steel.put("Steel", 0.5);
        steel.put("Fairy", 2.0);
        typeChart.put("Steel", steel);

        Map<String, Double> fairy = new HashMap<>();
        fairy.put("Fire", 0.5);
        fairy.put("Fighting", 2.0);
        fairy.put("Poison", 0.5);
        fairy.put("Dragon", 2.0);
        fairy.put("Dark", 2.0);
        fairy.put("Steel", 0.5);
        typeChart.put("Fairy", fairy);
    }

    public static double getEffectiveness(String attackType, String defenseType1, String defenseType2) {
        double effectiveness = 1.0;
        effectiveness *= typeChart.getOrDefault(attackType, new HashMap<>()).getOrDefault(defenseType1, 1.0);
        if (defenseType2 != null && !defenseType2.isEmpty()) {
            effectiveness *= typeChart.getOrDefault(attackType, new HashMap<>()).getOrDefault(defenseType2, 1.0);
        }
        return effectiveness;
    }
}


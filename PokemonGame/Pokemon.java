package PokemonGame.PokemonGame;

import java.util.*;

public class Pokemon {
    private String name;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private int level;
    private String type1;
    private String type2;
    private List<Move> moves;
    private int currentHp;

    public Pokemon(String name, int hp, int attack, int defense, int speed, String type1, String type2, List<Move> moves, int level) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.type1 = type1;
        this.type2 = type2;
        this.moves = moves;
        this.currentHp = hp;
        this.level = level;
    }

    static List<Pokemon> initializePokemons() {
        // 포켓몬 초기화
        return Arrays.asList(
                new Pokemon("파이리", 39, 52, 43, 65, "불", null, Arrays.asList(
                        new Move("Ember", "불", 40, 100),
                        new Move("Scratch", "노말", 40, 100)), 5),
                new Pokemon("꼬부기", 44, 46, 65, 43, "물", null, Arrays.asList(
                        new Move("Water Gun", "물", 40, 100),
                        new Move("Scratch", "노말", 40, 100)), 5),
                new Pokemon("이상해씨", 45, 49, 49, 45, "풀", "독", Arrays.asList(
                        new Move("Vine Whip", "풀", 45, 100),
                        new Move("Tackle", "노말", 40, 100)), 5),
                new Pokemon("코일", 25, 35, 70, 45, "전기", "강철", Arrays.asList(
                        new Move("Thundershock", "전기", 40, 100),
                        new Move("Scratch", "노말", 40, 100)), 5),
                new Pokemon("찌리리공", 40, 30, 50, 100, "전기", null, Arrays.asList(
                        new Move("Spark", "전기", 65, 100)), 5),
                new Pokemon("롱스톤", 35, 45, 160, 70, "바위", "땅", Arrays.asList(
                        new Move("Rock Throw", "바위", 50, 90)), 5)
        );
    }


    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }


    public int getLevel() {
        return level;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public boolean isFainted() {
        return currentHp <= 0;
    }

    public void takeDamage(int damage) {
        currentHp = Math.max(currentHp - damage, 0);
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setHp(int currentHp) {
    }

    public void setLevel(int level){
        this.level = level;
    }
}

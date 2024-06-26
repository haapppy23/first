package PokemonGame.PokemonGame;

public class Battle {
    private Trainer trainer1;
    private Trainer trainer2;

    public Battle(Trainer trainer1, Trainer trainer2) {
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
    }

    public Trainer getTrainer1() {
        return trainer1;
    }

    public Trainer getTrainer2() {
        return trainer2;
    }

    public void performMove(Pokemon attacker, Pokemon defender, Move move) {
        if (attacker == null || defender == null || move == null) return;

        // 각 포켓몬이 서로를 공격하도록 설정
        double stab = 1.0;
        if (attacker.getType1().equals(move.getType()) || (attacker.getType2() != null && attacker.getType2().equals(move.getType()))) {
            stab = 1.5;
        }
        double effectiveness = Type.getEffectiveness(move.getType(), defender.getType1(), defender.getType2());
        int damage = calculateDamage(attacker, defender, move, effectiveness, stab);
        defender.takeDamage(damage);
        // GUI로 효과성 나타내기: gui.updateEffectiveness(effectiveness > 1 ? "super effective!" : effectiveness < 1 ? "not very effective..." : "effective.");
    }

    private int calculateDamage(Pokemon attacker, Pokemon defender, Move move, double effectiveness,double stab) {
        int basePower = move.getPower();
        double random=(double)((Math.random()*100)+85)*0.01;
        int attack = attacker.getAttack();
        int defense = defender.getDefense();
        return (int) ((int)((basePower * attack / defense) / 50 + 2) *effectiveness*stab*random);
    }

    public boolean isBattleOver() {
        Pokemon trainer1Pokemon = trainer1.getAvailablePokemon();
        Pokemon trainer2Pokemon = trainer2.getAvailablePokemon();


        if (trainer1Pokemon == null || trainer2Pokemon == null) {
            return true;
        }


        return false;
    }

    public Trainer getWinner() {
        Pokemon trainer1Pokemon = trainer1.getAvailablePokemon();
        Pokemon trainer2Pokemon = trainer2.getAvailablePokemon();

        if (trainer1Pokemon == null && trainer2Pokemon == null) {
            return null; // 둘 다 포켓몬이 없는 경우
        } else if (trainer1Pokemon == null) {
            return trainer2; // 트레이너 1의 포켓몬이 없는 경우
        } else if (trainer2Pokemon == null) {
            return trainer1; // 트레이너 2의 포켓몬이 없는 경우
        } else if (trainer1Pokemon.isFainted()) {
            return trainer2; // 트레이너 1의 포켓몬이 쓰러진 경우
        } else if (trainer2Pokemon.isFainted()) {
            return trainer1; // 트레이너 2의 포켓몬이 쓰러진 경우
        } else {
            return null; // 아직 승자가 결정되지 않은 경우
        }
    }


}

package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Ludoman extends Hero{
    public Ludoman(int health, int damage,String name) {

        super(health, damage, name, SuperAbility.ROLL_DICE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int dice1 = RPG_Game.random.nextInt(6) + 1;
        int dice2 = RPG_Game.random.nextInt(6) + 1;
        System.out.println(this.getName() + " бросает кости: " + dice1 + " и " + dice2);
        if (dice1==dice2){
            int damageToBoss = dice1 * dice2;
            boss.setHealth(boss.getHealth() - damageToBoss);
            System.out.println(this.getName() +   "нанес боссу"  + damageToBoss +   "урона" );
        } else {
           int damageToTeam = dice1 * dice2;
           Hero randomHero = heroes[RPG_Game.random.nextInt(heroes.length)];
           if (randomHero != this && randomHero.getHealth() > 0){
               randomHero.setHealth(randomHero.getHealth() - damageToTeam);
               System.out.println(this.getName() +  "нанес тиммейтам" +  damageToTeam +  "урона");
           }
        }

    }
}

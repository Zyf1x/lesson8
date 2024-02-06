package kg.geeks.game.players;
public class Magic extends Hero {
    private int attackBoost;

    public Magic(int health, int damage, int attackBoost, String name) {
        super(health, damage, SuperAbility.BOOST, name);
        this.attackBoost = attackBoost;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boostAllHeroesAttack(heroes);
    }

    private void boostAllHeroesAttack(Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                int newDamage = hero.getDamage() + attackBoost;
                hero.setDamage(newDamage);
                System.out.println(getName() + " boosts " + hero.getName() + "'s attack by " + attackBoost);
            }
        }
    }
}

package kg.geeks.game.players;
public class Hacker extends Hero {
    private int stealHealthAmount;

    public Hacker(int health, int damage, int stealHealthAmount, String name) {
        super(health, damage, SuperAbility.TRANSFER, name);
        this.stealHealthAmount = stealHealthAmount;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        // Hacker's unique ability
        stealHealthFromBoss(boss, heroes);
    }

    private void stealHealthFromBoss(Boss boss, Hero[] heroes) {
        int stolenHealth = boss.getHealth() >= stealHealthAmount ? stealHealthAmount : boss.getHealth();
        boss.setHealth(boss.getHealth() - stolenHealth);

        int randomHeroIndex = (int) (Math.random() * heroes.length);
        Hero targetHero = heroes[randomHeroIndex];
        targetHero.setHealth(targetHero.getHealth() + stolenHealth);

        System.out.println(getName() + " steals " + stolenHealth + " health from Boss and transfers it to " + targetHero.getName());
    }
}


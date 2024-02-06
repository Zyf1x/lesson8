package kg.geeks.game.players;

public class Witcher extends Hero {
    public Witcher (int health, int damage, String name) {
        super(health, damage, SuperAbility.REVIVE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

        reviveFirstFallenHero(heroes);
    }

    private void reviveFirstFallenHero(Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() <= 0) {
                System.out.println("Witcher revives " + hero.getName());
                hero.setHealth(100);
                this.setHealth(this.getHealth() - 100);
                break;
            }
        }
    }
}

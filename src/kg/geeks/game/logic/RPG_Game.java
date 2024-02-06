package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

import static kg.geeks.game.players.SuperAbility.REVIVE;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss(3000, 50, "Kraken");

        Warrior warrior1 = new Warrior(270, 15, "Arthur");
        Warrior warrior2 = new Warrior(280, 10, "Toya");
        Magic magic = new Magic(290, 20, 5,"Merlin" );
        Berserk berserk = new Berserk(260, 10, "Gatz");
        Medic doc = new Medic(250, 5, 15, "Aibolit");
        Medic assistant = new Medic(300, 5, 5, "Junior");
        Witcher witcher = new Witcher(200, 0, "Minako");
        Hacker hacker = new Hacker(150, 5,5, "Mintik");

        Hero[] heroes = {warrior1, warrior2, magic, doc, berserk, assistant, witcher};

        showStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0
                    && boss.getDefence() != hero.getAbility()) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        showStatistics(boss, heroes);
    }


    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void showStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -------------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }
}

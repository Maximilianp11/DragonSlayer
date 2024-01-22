public class Dragon {
    private int level;
    private int health;
    private int attackDamage;

    public Dragon() {
        level = (int) (Math.random() * 3) + 1;
        health = 55 + 15 * level;
        attackDamage = 5 + 2 * level;
    }

    public int getHealth() {
        return health;
    }

    public int attack() {
        int damage = attackDamage;
        int randomness = (int) (Math.random() * 5) + 1;
        if (Math.random() > .5) {
            damage += randomness;
        } else {
            damage -= randomness;
        }
        return damage;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public static void deathOutcome(Player player, Sword sword) {
        int rnd = (int ) (Math.random() * 10) + 1;
        if (rnd > 8) {
            rnd = (int) (Math.random() * 26) + 10;
            System.out.println("You receive " + rnd + " gold from the Dragon!");
            player.addGold(rnd);
        } else if (rnd > 5) {
            rnd = (int) (Math.random() * 3) + 1;
            if (rnd == 1) {
                System.out.println("You upgraded your sword with a scale from the dragon and it's attack damage has increased by 10!");
                sword.upgradeAP();
            } else if (rnd == 2) {
                System.out.println("You upgraded your sword with a scale from the dragon and it's dodge rating has increased by 10!");
                sword.upgradeDodge();
            } else {
                System.out.println("You upgraded your sword with a scale from the dragon and it's attack damage and dodge rating have increased by 5!");
                sword.upgradeBoth();
            }
        } else if (rnd > 1) {
            int healAmount = (int) ((player.getMaxHealth() - player.getHealth()) * 0.5);
            System.out.println("You healed " + healAmount + " health!");
            player.heal(healAmount);
        } else {
            System.out.println("The dragon did not drop anything useful");
        }
        player.killedADragon();
    }

}

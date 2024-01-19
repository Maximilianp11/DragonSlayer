import jdk.swing.interop.DragSourceContextWrapper;

public class Player {
    private String playerName;
    private int maxHealth;
    private int health;
    private int gold;
    private boolean healthPotStatus;
    private Sword sword;

    public Player(String playerName) {
        this.playerName = playerName;
        health = 100;
        gold = 10;
        healthPotStatus = false;
        Sword playerSword = new Sword();
    }

    public int attack() {
        int damage = sword.getAttackPower();
        int randomness = (int) (Math.random() * 5) + 1;
        if (Math.random() > .5) {
            damage += randomness;
        } else {
            damage -= randomness;
        }
        return damage;
    }

    public void takeDamage(int damage) {
        if ((int) (Math.random() * 100) + 1 < sword.getDodgeRating()) {
            health = health;
        }
        health -= damage;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public void heal(int heal) {
        health += heal;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public Sword getSword() {
        return sword;
    }

}

public class Player {
    private String playerName;
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
        int damage = 0;
        return damage;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public void heal(int heal) {
        health += heal;
    }

}

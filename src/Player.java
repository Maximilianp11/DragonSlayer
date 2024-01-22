public class Player {
    private String playerName;
    private int maxHealth;
    private int health;
    private int gold;
    private boolean healthPotStatus;
    private Sword sword;
    private int dragonsKilled;
    private int highestScore;

    public Player(String playerName) {
        this.playerName = playerName;
        health = 150;
        maxHealth = 150;
        gold = 10;
        healthPotStatus = true;
        sword = new Sword();
        dragonsKilled = 0;
        highestScore = 0;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }
    public String getPlayerName() {
        return playerName;
    }

    public boolean getHealthPotStatus() {
        return healthPotStatus;
    }
    public int getHighestScore() {
        return highestScore;
    }
    public Sword getSword() {
        return sword;
    }
    public void setHealthPotStatusTrue() {
        healthPotStatus = true;
    }

    public void setHealthPotStatusFalse() {
        healthPotStatus = false;
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
            System.out.println(ColorsUtility.BLUE + "You dodged the dragon's attack!" + ColorsUtility.RESET);
        } else {
            health -= damage;
        }
        if (health < 0) {
            health = 0;
        }
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public void heal(int heal) {
        health += heal;
        if (health > maxHealth) {
            health = 150;
        }
    }

    public void killedADragon() {
        dragonsKilled++;
    }

    public int calculateScore() {
        int score = 0;
        score += dragonsKilled * 20;
        score += gold * 5;
        score += sword.getAttackPower() * 10;
        score += sword.getDodgeRating() * 10;
        if (score > highestScore) {
            highestScore = score;
        }
        return score;
    }
}

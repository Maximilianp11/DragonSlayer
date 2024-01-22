public class Sword {
    private int attackPower;
    private int dodgeRating;

    public Sword() {
        attackPower = 12;
        dodgeRating = 22;
    }
    public int getAttackPower() {
        return attackPower;
    }

    public int getDodgeRating() {
        return dodgeRating;
    }

    public void upgradeAP() {
        attackPower += 10;
    }

    public void upgradeDodge() {
        dodgeRating += 10;
    }

    public void upgradeBoth() {
        attackPower += 5;
        dodgeRating += 5;
    }

}

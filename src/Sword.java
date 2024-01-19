public class Sword {
    private int attackPower;
    private int dodgeRating;

    public Sword() {
        attackPower = 15;
        dodgeRating = 15;
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

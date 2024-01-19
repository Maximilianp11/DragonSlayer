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

    public void UpgradeDodge() {
        dodgeRating += 10;
    }

    public void UpgradeBoth() {
        attackPower += 5;
        dodgeRating += 5;
    }
}

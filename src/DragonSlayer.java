import java.util.Scanner;
public class DragonSlayer {
    private Scanner scan = new Scanner(System.in);
    private Player player;
    private Sword sword;
    private boolean gameOver;

    public DragonSlayer() {
        gameOver = false;
        System.out.println("Ho there adventurer! What is your name?");
        String name = scan.nextLine();
        player = new Player(name);
        sword = player.getSword();
        play();
    }

    public void play() {
        boolean killedDragon;
        boolean chargedUp = false;
        int roomNumber = 1;
        System.out.println("Welcome to Dragon Slayer!");
        System.out.println("Your task is to kill every dragon in the lair!");
        Room room1 = new Room();
        Room room2 = new Room();
        Room room3 = new Room();
        Room room4 = new Room();
        Room room5 = new Room();
        while (!gameOver) {
            killedDragon = false;
            if (roomNumber == 1) {
                System.out.println("You enter the " + room1.getRoomName());
                System.out.println("As you enter " + room1.getRoomName() + " you see " + room1.getDragonsInRoom() + " dragons!");
                System.out.println("You ready your sword and prepare to fight!");
                    while (room1.getNextDragon().getHealth() != 0) {
                        System.out.println("Your health: " + player.getHealth());
                        System.out.println("Dragon's health: " + room1.getNextDragon().getHealth());
                        System.out.println("What would you like to do?" + "\n1. Attack\n2. Use bandage\n3. Charge attack");
                        String answer = scan.nextLine();
                        if (answer.equals("1") || answer.equalsIgnoreCase("attack")) {
                            int damage = player.attack();
                            if (Math.random() > 0.95) {
                                damage *= 2;
                                System.out.println("Critical hit!");
                            }
                            if (chargedUp) {
                                System.out.println("Charged attack!");
                                damage = (int) (damage * (Math.random() * 1.5 + 1));
                            }
                            System.out.println("You attack the dragon for " + damage + " damage!");
                            if (room1.getNextDragon().getHealth() <= damage) {
                                killedDragon = true;
                                room1.getNextDragon().takeDamage(damage);
                                chargedUp = false;
                                System.out.println("The dragon has 0 health remaining");
                                System.out.println("You slayed a dragon!");
                                Dragon.deathOutcome(player, sword);
                            } else {
                                room1.getNextDragon().takeDamage(damage);
                                chargedUp = false;
                                System.out.println("The dragon has " + room1.getNextDragon().getHealth() + " health remaining");
                            }
                        } else if (answer.equals("2") || answer.equalsIgnoreCase("use bandage")) {
                            System.out.println("You use a bandage and heal 5 health!");
                            player.heal(5);
                        } else if (answer.equals("3") || answer.equalsIgnoreCase("Charge up")) {
                            System.out.println("You are charging up a powerful attack!");
                            chargedUp = true;
                        }
                        int dragonDamage = room1.getNextDragon().attack();
                        System.out.println("The dragon attacked you for " + dragonDamage + " damage");
                        player.takeDamage(dragonDamage);
                    }
            } else if (roomNumber == 2) {
                System.out.println("You enter the " + room2.getRoomName());
            } else if (roomNumber == 3) {
                System.out.println("You enter the " + room3.getRoomName());
            } else if (roomNumber == 4) {
                System.out.println("You enter the " + room4.getRoomName());
            } else {
                System.out.println("You enter the " + room5.getRoomName());
            }
        }
    }
}

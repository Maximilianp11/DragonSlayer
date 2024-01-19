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
        int roomNumber = 1;
        System.out.println("Welcome to Dragon Slayer!");
        System.out.println("Your task is to kill every dragon in the lair!");
        Room room1 = new Room();
        Room room2 = new Room();
        Room room3 = new Room();
        Room room4 = new Room();
        Room room5 = new Room();
        while (!gameOver) {
            if (roomNumber == 1) {
                System.out.println("You enter the " + room1.getRoomName());
                System.out.println("As you enter " + room1.getRoomName() + " you see " + room1.getDragonsInRoom() + " dragons!");
                System.out.println("You ready your sword and prepare to fight!");
                    while (room1.getNextDragon().getHealth() != 0) {
                        System.out.println("Your health: " + player.getHealth());
                        System.out.println("Dragon's health: " + room1.getNextDragon().getHealth());
                        System.out.println("What would you like to do?" + "\n1. Attack\n2. Use bandage");
                        String answer = scan.nextLine();
                        if (answer.equals("1") || answer.equalsIgnoreCase("attack")) {
                            int damage = player.attack();
                            System.out.println("You attack the dragon for " + damage + " damage!");
                            room1.getNextDragon().takeDamage(damage);
                            System.out.println("The dragon has " + room1.getNextDragon().getHealth() + " health remaining");
                        } else if (answer.equals("2") || answer.equalsIgnoreCase("use bandage")) {
                            System.out.println("You use a bandage and heal 5 health!");
                            player.heal(5);
                        }
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

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
        System.out.println("Hello " + player.getPlayerName() + " Welcome to Dragon Slayer!");
        System.out.println("Your task is to kill every dragon in the lair!");
        playRoom1();
        if (player.getHealth() != 0) {
            playRoom2();
        }
        if (player.getHealth() != 0) {
            playRoom3();
        }
        if (player.getHealth() != 0) {
            playRoom4();
        }
        if (player.getHealth() != 0) {
            playRoom5();
        }
        if (player.getHealth() == 0) {
            System.out.println("You lose!");
            System.out.println("Your final score was: " + player.calculateScore());
        } else {
            System.out.println("Congratulations " +  player.getPlayerName() + " You slayed all the dragons in the liar!");
            System.out.println("Your final score was " + player.calculateScore());
        }
    }

    public void playRoom1() {
        while (player.getHealth() != 0) {
            Room room1 = new Room();
            boolean chargedUp = false;
            System.out.println("You enter the " + room1.getRoomName());
            System.out.println("As you enter " + room1.getRoomName() + " you see " + room1.getDragonsInRoom() + " dragons!");
            System.out.println("You ready your sword and prepare to fight!");
            while (room1.getNextDragon().getHealth() != 0) {
                System.out.println("Your health: " + player.getHealth());
                System.out.println("Dragon's health: " + room1.getNextDragon().getHealth());
                System.out.println("What would you like to do?" + "\n1. Attack\n2. Charge attack");
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
                } else if (answer.equals("2") || answer.equalsIgnoreCase("Charge up")) {
                    System.out.println("You are charging up a powerful attack!");
                    chargedUp = true;
                }
                int dragonDamage = room1.getNextDragon().attack();
                System.out.println("The dragon attacked you for " + dragonDamage + " damage");
                player.takeDamage(dragonDamage);
            }
        }
    }

    public void playRoom2() {
        while (player.getHealth() != 0) {
            Room room2 = new Room();
            boolean chargedUp = false;
            System.out.println("You enter the " + room2.getRoomName());
            System.out.println("As you enter " + room2.getRoomName() + " you see " + room2.getDragonsInRoom() + " dragons!");
            System.out.println("You ready your sword and prepare to fight!");
            while (room2.getNextDragon().getHealth() != 0) {
                System.out.println("Your health: " + player.getHealth());
                System.out.println("Dragon's health: " + room2.getNextDragon().getHealth());
                System.out.println("What would you like to do?" + "\n1. Attack\n2. Charge attack");
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
                    if (room2.getNextDragon().getHealth() <= damage) {
                        room2.getNextDragon().takeDamage(damage);
                        chargedUp = false;
                        System.out.println("The dragon has 0 health remaining");
                        System.out.println("You slayed a dragon!");
                        Dragon.deathOutcome(player, sword);
                    } else {
                        room2.getNextDragon().takeDamage(damage);
                        chargedUp = false;
                        System.out.println("The dragon has " + room2.getNextDragon().getHealth() + " health remaining");
                    }
                } else if (answer.equals("2") || answer.equalsIgnoreCase("Charge up")) {
                    System.out.println("You are charging up a powerful attack!");
                    chargedUp = true;
                }
                int dragonDamage = room2.getNextDragon().attack();
                System.out.println("The dragon attacked you for " + dragonDamage + " damage");
                player.takeDamage(dragonDamage);
            }
        }
    }

    public void playRoom3() {
        while (player.getHealth() != 0) {
            Room room3 = new Room();
            boolean chargedUp = false;
            System.out.println("You enter the " + room3.getRoomName());
            System.out.println("As you enter " + room3.getRoomName() + " you see " + room3.getDragonsInRoom() + " dragons!");
            System.out.println("You ready your sword and prepare to fight!");
            while (room3.getNextDragon().getHealth() != 0) {
                System.out.println("Your health: " + player.getHealth());
                System.out.println("Dragon's health: " + room3.getNextDragon().getHealth());
                System.out.println("What would you like to do?" + "\n1. Attack\n2. Charge attack");
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
                    if (room3.getNextDragon().getHealth() <= damage) {
                        room3.getNextDragon().takeDamage(damage);
                        chargedUp = false;
                        System.out.println("The dragon has 0 health remaining");
                        System.out.println("You slayed a dragon!");
                        Dragon.deathOutcome(player, sword);
                    } else {
                        room3.getNextDragon().takeDamage(damage);
                        chargedUp = false;
                        System.out.println("The dragon has " + room3.getNextDragon().getHealth() + " health remaining");
                    }
                } else if (answer.equals("2") || answer.equalsIgnoreCase("Charge up")) {
                    System.out.println("You are charging up a powerful attack!");
                    chargedUp = true;
                }
                int dragonDamage = room3.getNextDragon().attack();
                System.out.println("The dragon attacked you for " + dragonDamage + " damage");
                player.takeDamage(dragonDamage);
            }
        }
    }

    public void playRoom4() {
        while (player.getHealth() != 0) {
            Room room4 = new Room();
            boolean chargedUp = false;
            System.out.println("You enter the " + room4.getRoomName());
            System.out.println("As you enter " + room4.getRoomName() + " you see " + room4.getDragonsInRoom() + " dragons!");
            System.out.println("You ready your sword and prepare to fight!");
            while (room4.getNextDragon().getHealth() != 0) {
                System.out.println("Your health: " + player.getHealth());
                System.out.println("Dragon's health: " + room4.getNextDragon().getHealth());
                System.out.println("What would you like to do?" + "\n1. Attack\n2. Charge attack");
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
                    if (room4.getNextDragon().getHealth() <= damage) {
                        room4.getNextDragon().takeDamage(damage);
                        chargedUp = false;
                        System.out.println("The dragon has 0 health remaining");
                        System.out.println("You slayed a dragon!");
                        Dragon.deathOutcome(player, sword);
                    } else {
                        room4.getNextDragon().takeDamage(damage);
                        chargedUp = false;
                        System.out.println("The dragon has " + room4.getNextDragon().getHealth() + " health remaining");
                    }
                } else if (answer.equals("2") || answer.equalsIgnoreCase("Charge up")) {
                    System.out.println("You are charging up a powerful attack!");
                    chargedUp = true;
                }
                int dragonDamage = room4.getNextDragon().attack();
                System.out.println("The dragon attacked you for " + dragonDamage + " damage");
                player.takeDamage(dragonDamage);
            }
        }
    }

    public void playRoom5() {
        while (player.getHealth() != 0) {
            Room room5 = new Room();
            boolean chargedUp = false;
            System.out.println("You enter the " + room5.getRoomName());
            System.out.println("As you enter " + room5.getRoomName() + " you see " + room5.getDragonsInRoom() + " dragons!");
            System.out.println("You ready your sword and prepare to fight!");
            while (room5.getNextDragon().getHealth() != 0) {
                System.out.println("Your health: " + player.getHealth());
                System.out.println("Dragon's health: " + room5.getNextDragon().getHealth());
                System.out.println("What would you like to do?" + "\n1. Attack\n2. Charge attack");
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
                    if (room5.getNextDragon().getHealth() <= damage) {
                        room5.getNextDragon().takeDamage(damage);
                        chargedUp = false;
                        System.out.println("The dragon has 0 health remaining");
                        System.out.println("You slayed a dragon!");
                        Dragon.deathOutcome(player, sword);
                    } else {
                        room5.getNextDragon().takeDamage(damage);
                        chargedUp = false;
                        System.out.println("The dragon has " + room5.getNextDragon().getHealth() + " health remaining");
                    }
                } else if (answer.equals("2") || answer.equalsIgnoreCase("Charge up")) {
                    System.out.println("You are charging up a powerful attack!");
                    chargedUp = true;
                }
                int dragonDamage = room5.getNextDragon().attack();
                System.out.println("The dragon attacked you for " + dragonDamage + " damage");
                player.takeDamage(dragonDamage);
            }
        }
    }


}

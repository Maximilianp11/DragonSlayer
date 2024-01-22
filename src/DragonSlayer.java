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
        String playerAnswer = "";
        System.out.println("Main menu:");
        System.out.println("1. Start game\n2. Quit game\n3. View highest score");
        playerAnswer = scan.nextLine();
        if (playerAnswer.equalsIgnoreCase("1") ||  playerAnswer.equalsIgnoreCase("Start game")) {

        } else if (playerAnswer.equalsIgnoreCase("2") || playerAnswer.equalsIgnoreCase("Quit game")) {
            System.out.println("Thank you for playing Dragon Slayer!");
            System.out.println("Your highest score was: " + player.getHighestScore());
            endGame();
        } else if (playerAnswer.equalsIgnoreCase("3") || playerAnswer.equalsIgnoreCase("View highest score")) {
            System.out.println("Your highest score is " + player.getHighestScore());
            play();
        } else {
            play();
        }
        Room room1 = new Room(false);
        Room room2 = new Room(false);
        Room room3 = new Room(false);
        Room room4 = new Room(false);
        Room room5 = new Room(true);
        System.out.println("Hello " + player.getPlayerName() + " Welcome to Dragon Slayer!");
        System.out.println("Your task is to kill every dragon in the lair!");
        if (player.getHealth() != 0) {
            playRoom1(room1);
        }
        if (player.getHealth() != 0) {
            afterCombat(room1);
            playRoom2(room2);
        }
        if (player.getHealth() != 0) {
            afterCombat(room2);
            playRoom3(room3);
        }
        if (player.getHealth() != 0) {
            afterCombat(room3);
            playRoom4(room4);
        }
        if (player.getHealth() != 0) {
            afterCombat(room4);
            playRoom5(room5);
        }
        if (player.getHealth() == 0) {
            System.out.println(ColorsUtility.RED + "You lose!");
            System.out.println("Your final score was: " + player.calculateScore() + ColorsUtility.RESET);
        } else {
            System.out.println( ColorsUtility.YELLOW + "Congratulations " +  player.getPlayerName() + " You slayed all the dragons in the lair!");
            System.out.println("Your final score was " + player.calculateScore() + ColorsUtility.RESET);
        }
        play();
    }

    public void afterCombat(Room room) {
        String playerAnswer = "";
        System.out.println("You look around the room and see no dragons remaining");
        while (!(playerAnswer.equalsIgnoreCase("continue onwards") || playerAnswer.equalsIgnoreCase("2"))) {
            System.out.println("What would you like to do?");
            System.out.println("1. Search the room\n2. Continue onwards");
            playerAnswer = scan.nextLine();
            if (playerAnswer.equalsIgnoreCase("1") || playerAnswer.equalsIgnoreCase("Search the room")) {
                room.searchRoom(player);
                if (player.getHealthPotStatus()) {
                    System.out.println("Your health :" + player.getHealth());
                    System.out.println("Would you like to use a healing potion? (Yes/No)");
                    playerAnswer = scan.nextLine();
                    if (playerAnswer.equalsIgnoreCase("Yes")) {
                        System.out.println(ColorsUtility.GREEN + "You use the health potion and heal 75 health!" + ColorsUtility.RESET);
                        player.heal(75);
                        player.setHealthPotStatusFalse();
                    } else {
                        System.out.println("You pocket the healing potion and save it for later");
                    }
                }
            }
        }
    }

    public void playRoom1(Room room1) {
        while (player.getHealth() != 0 && room1.getNextDragon().getHealth() != 0) {
            boolean chargedUp = false;
            System.out.println("You enter the " + room1.getRoomName());
            System.out.println("As you enter " + room1.getRoomName() + " you see " + room1.getDragonsInRoom() + " dragons!");
            System.out.println("You ready your sword and prepare to fight!");
            while (room1.getNextDragon().getHealth() != 0 && player.getHealth() != 0) {
                System.out.println("Your health: " + ColorsUtility.GREEN + player.getHealth() + ColorsUtility.RESET);
                System.out.println("Dragon's health: " + ColorsUtility.GREEN + room1.getNextDragon().getHealth() + ColorsUtility.RESET);
                System.out.println("What would you like to do?" + "\n1. Attack\n2. Charge attack\n3. Use healing potion");
                String answer = scan.nextLine();
                if (answer.equals("1") || answer.equalsIgnoreCase("attack")) {
                    int damage = player.attack();
                    if (Math.random() > 0.95) {
                        damage *= 2;
                        System.out.println(ColorsUtility.RED + "Critical hit!" + ColorsUtility.RESET);
                    }
                    if (chargedUp) {
                        System.out.println(ColorsUtility.BLUE + "Charged attack!" + ColorsUtility.RESET);
                        damage = (int) (damage * (Math.random() * 1.5 + 1));
                    }
                    System.out.println(ColorsUtility.BLUE + "You attack the dragon for " + damage + " damage!" + ColorsUtility.RESET);
                    if (room1.getNextDragon().getHealth() <= damage) {
                        room1.getNextDragon().takeDamage(damage);
                        chargedUp = false;
                        System.out.println("The dragon has 0 health remaining");
                        System.out.println(ColorsUtility.YELLOW + "You slayed a dragon!" + ColorsUtility.RESET);
                        Dragon.deathOutcome(player, sword);
                    } else {
                        room1.getNextDragon().takeDamage(damage);
                        chargedUp = false;
                        System.out.println(ColorsUtility.GREEN + "The dragon has " +  room1.getNextDragon().getHealth() + " health remaining" + ColorsUtility.RESET);
                        int dragonDamage = room1.getNextDragon().attack();
                        System.out.println(ColorsUtility.RED + "The dragon attacked you for " + dragonDamage + " damage" + ColorsUtility.RESET);
                        player.takeDamage(dragonDamage);
                    }
                } else if (answer.equals("2") || answer.equalsIgnoreCase("Charge up")) {
                    System.out.println("You are charging up a powerful attack!");
                    chargedUp = true;
                    int dragonDamage = room1.getNextDragon().attack();
                    System.out.println(ColorsUtility.RED + "The dragon attacked you for " + dragonDamage + " damage" + ColorsUtility.RESET);
                    player.takeDamage(dragonDamage);
                } else if (answer.equals("3") || answer.equalsIgnoreCase("Use healing potion")) {
                    if (player.getHealthPotStatus()) {
                        System.out.println(ColorsUtility.GREEN +"You use a potion and heal 75 health" + ColorsUtility.RESET);
                        player.heal(75);
                        player.setHealthPotStatusFalse();
                        int dragonDamage = room1.getNextDragon().attack();
                        System.out.println(ColorsUtility.RED + "The dragon attacked you for " + dragonDamage + " damage" + ColorsUtility.RESET);
                        player.takeDamage(dragonDamage);
                    } else {
                        System.out.println("You do not have a healing potion");
                    }
                }
            }
        }
    }

    public void playRoom2(Room room2) {
        while (player.getHealth() != 0 && room2.getNextDragon().getHealth() != 0) {
            boolean chargedUp = false;
            System.out.println("You enter the " + room2.getRoomName());
            System.out.println("As you enter " + room2.getRoomName() + " you see " + room2.getDragonsInRoom() + " dragons!");
            System.out.println("You ready your sword and prepare to fight!");
            while (room2.getNextDragon().getHealth() != 0 && player.getHealth() != 0) {
                System.out.println("Your health: " + ColorsUtility.GREEN + player.getHealth() + ColorsUtility.RESET);
                System.out.println("Dragon's health: " + ColorsUtility.GREEN + room2.getNextDragon().getHealth() + ColorsUtility.RESET);
                System.out.println("What would you like to do?" + "\n1. Attack\n2. Charge attack\n3. Use healing potion");
                String answer = scan.nextLine();
                if (answer.equals("1") || answer.equalsIgnoreCase("attack")) {
                    int damage = player.attack();
                    if (Math.random() > 0.95) {
                        damage *= 2;
                        System.out.println(ColorsUtility.RED + "Critical hit!" + ColorsUtility.RESET);
                    }
                    if (chargedUp) {
                        System.out.println(ColorsUtility.BLUE + "Charged attack!" + ColorsUtility.RESET);
                        damage = (int) (damage * (Math.random() * 1.5 + 1));
                    }
                    System.out.println(ColorsUtility.BLUE + "You attack the dragon for " + damage + " damage!" + ColorsUtility.RESET);
                    if (room2.getNextDragon().getHealth() <= damage) {
                        room2.getNextDragon().takeDamage(damage);
                        chargedUp = false;
                        System.out.println("The dragon has 0 health remaining");
                        System.out.println(ColorsUtility.YELLOW + "You slayed a dragon!" + ColorsUtility.RESET);
                        Dragon.deathOutcome(player, sword);
                    } else {
                        room2.getNextDragon().takeDamage(damage);
                        chargedUp = false;
                        System.out.println(ColorsUtility.GREEN + "The dragon has " +  room2.getNextDragon().getHealth() + " health remaining" + ColorsUtility.RESET);
                        int dragonDamage = room2.getNextDragon().attack();
                        System.out.println(ColorsUtility.RED + "The dragon attacked you for " + dragonDamage + " damage" + ColorsUtility.RESET);
                        player.takeDamage(dragonDamage);
                    }
                } else if (answer.equals("2") || answer.equalsIgnoreCase("Charge up")) {
                    System.out.println("You are charging up a powerful attack!");
                    chargedUp = true;
                    int dragonDamage = room2.getNextDragon().attack();
                    System.out.println(ColorsUtility.RED + "The dragon attacked you for " + dragonDamage + " damage" + ColorsUtility.RESET);
                    player.takeDamage(dragonDamage);
                } else if (answer.equals("3") || answer.equalsIgnoreCase("Use healing potion")) {
                    if (player.getHealthPotStatus()) {
                        System.out.println(ColorsUtility.GREEN +"You use a potion and heal 75 health" + ColorsUtility.RESET);
                        player.heal(75);
                        player.setHealthPotStatusFalse();
                        int dragonDamage = room2.getNextDragon().attack();
                        System.out.println(ColorsUtility.RED + "The dragon attacked you for " + dragonDamage + " damage" + ColorsUtility.RESET);
                        player.takeDamage(dragonDamage);
                    } else {
                        System.out.println("You do not have a healing potion");
                    }
                }
            }
        }
    }

    public void playRoom3(Room room3) {
        while (player.getHealth() != 0 && room3.getNextDragon().getHealth() != 0) {
            boolean chargedUp = false;
            System.out.println("You enter the " + room3.getRoomName());
            System.out.println("As you enter " + room3.getRoomName() + " you see " + room3.getDragonsInRoom() + " dragons!");
            System.out.println("You ready your sword and prepare to fight!");
            while (room3.getNextDragon().getHealth() != 0 && player.getHealth() != 0) {
                System.out.println("Your health: " + ColorsUtility.GREEN + player.getHealth() + ColorsUtility.RESET);
                System.out.println("Dragon's health: " + ColorsUtility.GREEN + room3.getNextDragon().getHealth() + ColorsUtility.RESET);
                System.out.println("What would you like to do?" + "\n1. Attack\n2. Charge attack\n3. Use healing potion");
                String answer = scan.nextLine();
                if (answer.equals("1") || answer.equalsIgnoreCase("attack")) {
                    int damage = player.attack();
                    if (Math.random() > 0.95) {
                        damage *= 2;
                        System.out.println(ColorsUtility.RED + "Critical hit!" + ColorsUtility.RESET);
                    }
                    if (chargedUp) {
                        System.out.println(ColorsUtility.BLUE + "Charged attack!" + ColorsUtility.RESET);
                        damage = (int) (damage * (Math.random() * 1.5 + 1));
                    }
                    System.out.println(ColorsUtility.BLUE + "You attack the dragon for " + damage + " damage!" + ColorsUtility.RESET);
                    if (room3.getNextDragon().getHealth() <= damage) {
                        room3.getNextDragon().takeDamage(damage);
                        chargedUp = false;
                        System.out.println("The dragon has 0 health remaining");
                        System.out.println(ColorsUtility.YELLOW + "You slayed a dragon!" + ColorsUtility.RESET);
                        Dragon.deathOutcome(player, sword);
                    } else {
                        room3.getNextDragon().takeDamage(damage);
                        chargedUp = false;
                        System.out.println(ColorsUtility.GREEN + "The dragon has " +  room3.getNextDragon().getHealth() + " health remaining" + ColorsUtility.RESET);
                        int dragonDamage = room3.getNextDragon().attack();
                        System.out.println(ColorsUtility.RED + "The dragon attacked you for " + dragonDamage + " damage" + ColorsUtility.RESET);
                        player.takeDamage(dragonDamage);
                    }
                } else if (answer.equals("2") || answer.equalsIgnoreCase("Charge up")) {
                    System.out.println("You are charging up a powerful attack!");
                    chargedUp = true;
                    int dragonDamage = room3.getNextDragon().attack();
                    System.out.println(ColorsUtility.RED + "The dragon attacked you for " + dragonDamage + " damage" + ColorsUtility.RESET);
                    player.takeDamage(dragonDamage);
                } else if (answer.equals("3") || answer.equalsIgnoreCase("Use healing potion")) {
                    if (player.getHealthPotStatus()) {
                        System.out.println(ColorsUtility.GREEN +"You use a potion and heal 75 health" + ColorsUtility.RESET);
                        player.heal(75);
                        player.setHealthPotStatusFalse();
                        int dragonDamage = room3.getNextDragon().attack();
                        System.out.println(ColorsUtility.RED + "The dragon attacked you for " + dragonDamage + " damage" + ColorsUtility.RESET);
                        player.takeDamage(dragonDamage);
                    } else {
                        System.out.println("You do not have a healing potion");
                    }
                }
            }
        }
    }

    public void playRoom4(Room room4) {
        while (player.getHealth() != 0 && room4.getNextDragon().getHealth() != 0) {
            boolean chargedUp = false;
            System.out.println("You enter the " + room4.getRoomName());
            System.out.println("As you enter " + room4.getRoomName() + " you see " + room4.getDragonsInRoom() + " dragons!");
            System.out.println("You ready your sword and prepare to fight!");
            while (room4.getNextDragon().getHealth() != 0 && player.getHealth() != 0) {
                System.out.println("Your health: " + ColorsUtility.GREEN + player.getHealth() + ColorsUtility.RESET);
                System.out.println("Dragon's health: " + ColorsUtility.GREEN + room4.getNextDragon().getHealth() + ColorsUtility.RESET);
                System.out.println("What would you like to do?" + "\n1. Attack\n2. Charge attack\n3. Use healing potion");
                String answer = scan.nextLine();
                if (answer.equals("1") || answer.equalsIgnoreCase("attack")) {
                    int damage = player.attack();
                    if (Math.random() > 0.95) {
                        damage *= 2;
                        System.out.println(ColorsUtility.RED + "Critical hit!" + ColorsUtility.RESET);
                    }
                    if (chargedUp) {
                        System.out.println(ColorsUtility.BLUE + "Charged attack!" + ColorsUtility.RESET);
                        damage = (int) (damage * (Math.random() * 1.5 + 1));
                    }
                    System.out.println(ColorsUtility.BLUE + "You attack the dragon for " + damage + " damage!" + ColorsUtility.RESET);
                    if (room4.getNextDragon().getHealth() <= damage) {
                        room4.getNextDragon().takeDamage(damage);
                        chargedUp = false;
                        System.out.println("The dragon has 0 health remaining");
                        System.out.println(ColorsUtility.YELLOW + "You slayed a dragon!" + ColorsUtility.RESET);
                        Dragon.deathOutcome(player, sword);
                    } else {
                        room4.getNextDragon().takeDamage(damage);
                        chargedUp = false;
                        System.out.println(ColorsUtility.GREEN + "The dragon has " +  room4.getNextDragon().getHealth() + " health remaining" + ColorsUtility.RESET);
                        int dragonDamage = room4.getNextDragon().attack();
                        System.out.println(ColorsUtility.RED + "The dragon attacked you for " + dragonDamage + " damage" + ColorsUtility.RESET);
                        player.takeDamage(dragonDamage);
                    }
                } else if (answer.equals("2") || answer.equalsIgnoreCase("Charge up")) {
                    System.out.println("You are charging up a powerful attack!");
                    chargedUp = true;
                    int dragonDamage = room4.getNextDragon().attack();
                    System.out.println(ColorsUtility.RED + "The dragon attacked you for " + dragonDamage + " damage" + ColorsUtility.RESET);
                    player.takeDamage(dragonDamage);
                } else if (answer.equals("3") || answer.equalsIgnoreCase("Use healing potion")) {
                    if (player.getHealthPotStatus()) {
                        System.out.println(ColorsUtility.GREEN +"You use a potion and heal 75 health" + ColorsUtility.RESET);
                        player.heal(75);
                        player.setHealthPotStatusFalse();
                        int dragonDamage = room4.getNextDragon().attack();
                        System.out.println(ColorsUtility.RED + "The dragon attacked you for " + dragonDamage + " damage" + ColorsUtility.RESET);
                        player.takeDamage(dragonDamage);
                    } else {
                        System.out.println("You do not have a healing potion");
                    }
                }
            }
        }
    }

    public void playRoom5(Room room5) {
        while (player.getHealth() != 0 && room5.getNextDragon().getHealth() != 0) {
            boolean chargedUp = false;
            System.out.println("You enter the " + room5.getRoomName());
            System.out.println("As you enter " + room5.getRoomName() + " you see one giant golden dragon!");
            System.out.println("You ready your sword and prepare to fight!");
            while (room5.getNextDragon().getHealth() != 0 && player.getHealth() != 0) {
                System.out.println("Your health: " + ColorsUtility.GREEN + player.getHealth() + ColorsUtility.RESET);
                System.out.println("Dragon's health: " + ColorsUtility.GREEN + room5.getNextDragon().getHealth() + ColorsUtility.RESET);
                System.out.println("What would you like to do?" + "\n1. Attack\n2. Charge attack\n3. Use healing potion");
                String answer = scan.nextLine();
                if (answer.equals("1") || answer.equalsIgnoreCase("attack")) {
                    int damage = player.attack();
                    if (Math.random() > 0.95) {
                        damage *= 2;
                        System.out.println(ColorsUtility.RED + "Critical hit!" + ColorsUtility.RESET);
                    }
                    if (chargedUp) {
                        System.out.println(ColorsUtility.BLUE + "Charged attack!" + ColorsUtility.RESET);
                        damage = (int) (damage * (Math.random() * 1.5 + 1));
                    }
                    System.out.println(ColorsUtility.BLUE + "You attack the dragon for " + damage + " damage!" + ColorsUtility.RESET);
                    if (room5.getNextDragon().getHealth() <= damage) {
                        room5.getNextDragon().takeDamage(damage);
                        chargedUp = false;
                        System.out.println("The dragon has 0 health remaining");
                        System.out.println(ColorsUtility.YELLOW + "You slayed a dragon!" + ColorsUtility.RESET);
                        Dragon.deathOutcome(player, sword);
                    } else {
                        room5.getNextDragon().takeDamage(damage);
                        chargedUp = false;
                        System.out.println(ColorsUtility.GREEN + "The dragon has " +  room5.getNextDragon().getHealth() + " health remaining" + ColorsUtility.RESET);
                        int dragonDamage = room5.getNextDragon().attack();
                        System.out.println(ColorsUtility.RED + "The dragon attacked you for " + dragonDamage + " damage" + ColorsUtility.RESET);
                        player.takeDamage(dragonDamage);
                    }
                } else if (answer.equals("2") || answer.equalsIgnoreCase("Charge up")) {
                    System.out.println("You are charging up a powerful attack!");
                    chargedUp = true;
                    int dragonDamage = room5.getNextDragon().attack();
                    System.out.println(ColorsUtility.RED + "The dragon attacked you for " + dragonDamage + " damage" + ColorsUtility.RESET);
                    player.takeDamage(dragonDamage);
                } else if (answer.equals("3") || answer.equalsIgnoreCase("Use healing potion")) {
                    if (player.getHealthPotStatus()) {
                        System.out.println(ColorsUtility.GREEN +"You use a potion and heal 75 health" + ColorsUtility.RESET);
                        player.heal(75);
                        player.setHealthPotStatusFalse();
                        int dragonDamage = room5.getNextDragon().attack();
                        System.out.println(ColorsUtility.RED + "The dragon attacked you for " + dragonDamage + " damage" + ColorsUtility.RESET);
                        player.takeDamage(dragonDamage);
                    } else {
                        System.out.println("You do not have a healing potion");
                    }
                }
            }
        }
    }

    public void endGame() {
        System.exit(0);
    }

}

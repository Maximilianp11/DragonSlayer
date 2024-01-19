import java.util.Scanner;
public class DragonSlayer {
    private Scanner scan = new Scanner(System.in);
    private Player player;
    private Sword sword;

    public DragonSlayer() {
        System.out.println("Ho there adventurer! What is your name?");
        String name = scan.nextLine();
        player = new Player(name);
        sword = player.getSword();

    }
}

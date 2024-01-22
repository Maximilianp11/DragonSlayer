public class Room {
    private String[] roomList = {"The Roaring Hall", "Flameforge Chamber",  "The Ember Sanctum", "The Den", "The Vault"};
    private String roomName;
    private int dragonsInRoom;
    private boolean roomSearched;
    private static int numRooms = 0;
    private Dragon nextDragon;
    private Dragon dragon1;
    private Dragon dragon2;
    private Dragon dragon3;


    public Room(boolean lastRoom) {
        if (lastRoom) {
            roomName = roomList[numRooms];
            dragonsInRoom = 1;
            dragon1 = new Dragon(true);
        } else {
            roomName = roomList[numRooms];
            dragonsInRoom = (int) (Math.random() * 3) + 1;
            dragon1 = new Dragon(false);
            dragon2 = new Dragon(false);
            dragon3 = new Dragon(false);
            roomSearched = false;
            numRooms++;
        }
    }

    public String getRoomName() {
        return roomName;
    }

    public int getDragonsInRoom() {
        return dragonsInRoom;
    }

    public Dragon getNextDragon() {
        if (dragonsInRoom == 1) {
            nextDragon = dragon1;
        } else if (dragonsInRoom  == 2) {
            if (dragon1.getHealth() != 0) {
                nextDragon = dragon1;
            } else {
                nextDragon = dragon2;
            }
        } else {
            if (dragon1.getHealth() != 0) {
                nextDragon = dragon1;
            } else if (dragon2.getHealth() != 0) {
                nextDragon = dragon2;
            } else {
                nextDragon = dragon3;
            }
        }
        return nextDragon;
    }

    public void searchRoom(Player player) {
        if (roomSearched) {
            System.out.println("You have already searched this room");
        } else {
            if (Math.random() > 0.5) {
                if (player.getHealthPotStatus()) {
                    System.out.println("You found another potion, and since you already had one you drank it and healed for 75 health");
                    player.heal(75);
                } else {
                    System.out.println("You search the room and find a health potion!");
                    player.setHealthPotStatusTrue();
                }
            } else {
                int rndGold = (int) (Math.random() * 51);
                System.out.println("You search the room and find " + rndGold + " gold!") ;
                player.addGold(rndGold);
            }

        }
        roomSearched = true;
    }
}

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


    public Room() {
        roomName = roomList[numRooms];
        dragonsInRoom = (int) (Math.random() * 3) + 1;
        dragon1 = new Dragon();
        dragon2 = new Dragon();
        dragon3 = new Dragon();
        roomSearched = false;
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
                nextDragon = getNextDragon();
            }
        }
        return nextDragon;
    }
}

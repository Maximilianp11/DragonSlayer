public class Room {
    private String[] roomList = {"The Roaring Hall", "Flameforge Chamber",  "The Ember Sanctum", "The Den", "The Vault"};
    private String roomName;
    private int dragonsInRoom;
    private boolean roomSearched;
    private static int numRooms = 0;
    public Room() {
        roomName = roomList[numRooms];
        dragonsInRoom = (int) (Math.random() * 3) + 1;
        roomSearched = false;
    }
}

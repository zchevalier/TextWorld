import java.util.ArrayList;

public abstract class Creature {

    protected Graph.Node currentRoom;
    protected Player player;
    protected String name;
    protected String description;

    public Creature (Graph.Node currentRoom, String name, String description, Player player){
        this.currentRoom = currentRoom;
        currentRoom.addCreature(this);
        this.name = name;
        this.description = description;
        this.player = player;
    }

    public Graph.Node getCurrentRoom(){
        return currentRoom;
    }

    public Graph.Node getPlayerRoom(){
        return player.getCurrentRoom();
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        name = name;
    }

    public void setCurrentRoom(Graph.Node currentRoom){
        this.currentRoom = currentRoom;
    }

    public abstract void move();

    public void moveRandom(){
        Graph.Node nextRoom = currentRoom.getRandomNeighbor();
        changeRooms(nextRoom);
    }

    public void moveRandom(ArrayList<Graph.Node> roomsToGo, ArrayList<Graph.Node> roomsToAvoid){
        if(roomsToAvoid.size() == 0 || roomsToGo.size() == 0) moveRandom();
        else {
            int randIndex = (int)(Math.random()*roomsToGo.size());
            Graph.Node nextRoom = roomsToGo.get(randIndex);
            changeRooms(nextRoom);
        }
    }

    public void changeRooms(Graph.Node nextRoom){
        currentRoom.removeCreature(this);
        setCurrentRoom(nextRoom);
        currentRoom.addCreature(this);
    }
}

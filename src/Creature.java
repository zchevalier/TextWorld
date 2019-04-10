import java.util.ArrayList;

public abstract class Creature {

    protected Graph.Node currentRoom;
    protected Player player;
    protected String name;
    protected String description;

    public Creature (Graph.Node currentRoom, String name, String description, Player player){
        this.currentRoom = currentRoom;
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

    public void changeRooms(Graph.Node nextRoom){
        System.out.println("next room: " + nextRoom.getName());
        currentRoom.removeCreature(this);
        setCurrentRoom(nextRoom);
        currentRoom.addCreature(this);
    }
}

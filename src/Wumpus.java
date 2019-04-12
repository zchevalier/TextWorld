import java.util.ArrayList;

public class Wumpus extends Creature {

    public Wumpus(Graph.Node currentRoom, String name, String description, Player player){
        super(currentRoom, name, description, player);
    }

    @Override
    public void move() {
        moveAway();
    }

    public void moveAway(){
        Graph.Node playerRoom = getPlayerRoom();
        Graph.Node wumpusRoom = this.currentRoom;

        ArrayList<Graph.Node> roomsToAvoid = new ArrayList<>();
        ArrayList<Graph.Node> roomsToGo = new ArrayList<>();
        String playerNeighborNames = playerRoom.getNeighborNames();

        for(int i = 0; i < wumpusRoom.getNeighbors().size(); i ++){
            if(playerNeighborNames.contains(wumpusRoom.getNeighbors().get(i).getName())) {
                roomsToAvoid.add(wumpusRoom.getNeighbors().get(i));
            } else roomsToGo.add(wumpusRoom.getNeighbors().get(i));
        }

        moveRandom(roomsToGo, roomsToAvoid);
    }
}

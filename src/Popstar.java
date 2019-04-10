import java.util.ArrayList;

public class Popstar extends Creature{

    public Popstar(Graph.Node currentRoom, String name, String description, Player player){
        super(currentRoom, name, description, player);
    }
    @Override
    public void move() {
        moveTowards();
    }

    private void moveTowards() {
        Graph.Node playerRoom = player.getCurrentRoom();
        Graph.Node popstarRoom = this.currentRoom;

        ArrayList<Graph.Node> roomsToAvoid = new ArrayList<>();
        ArrayList<Graph.Node> roomsToGo = new ArrayList<>();
        String playerNeighborNames = playerRoom.getNeighborNames();

        for(int i = 0; i < popstarRoom.getNeighbors().size(); i ++){
            if(playerNeighborNames.contains(popstarRoom.getNeighbors().get(i).getName())) {
                roomsToGo.add(popstarRoom.getNeighbors().get(i));
            } else roomsToAvoid.add(popstarRoom.getNeighbors().get(i));
        }

        moveRandom(roomsToGo, roomsToAvoid);
    }
}

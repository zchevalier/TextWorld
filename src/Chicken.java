import java.util.ArrayList;

public class Chicken extends Creature {

    public Chicken(Graph.Node currentRoom, String name, String description, Player player){
        super(currentRoom, name, description, player);
    }

    @Override
    public void move() {
        super.moveRandom();
    }
}

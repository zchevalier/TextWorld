import java.util.ArrayList;

public class Player {
    String name, description;
    ArrayList<Item> items;
    Graph.Node currentRoom;

    public Player(String name, String description, Graph.Node currentRoom) {
        this.name = name;
        this.description = description;
        this.currentRoom = currentRoom;
        items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Graph.Node getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Graph.Node currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public Item removeItem(String name){
        for(Item i : items){
            if(i.getName().equals(name)) {
                items.remove(i);
                return i;
            }
        } return null;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void displayItems(){
        String output = "";
        for(Item i : items){
            output += i + ", ";
        }
        System.out.println(output);
    }

    public String getItemNames(){
        if(items.size() == 0) return "";
        String output = "";
        for(Item i : items){
            output += i.getName() + ", ";
        }
        return output;
    }

    public boolean goToRoom(String name){
        if(currentRoom.getNeighbor(name) == null) return false;
        else currentRoom = currentRoom.getNeighbor(name);
        return true;
    }
}

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private HashMap<String, Node> nodes;

    public Graph(){
        nodes = new HashMap<>();
    }

    public void addNode(String name, String description) {
        nodes.put(name, new Node(name, description));
    }

    public void addDirectedEdge(String name1, String name2) {
        Node node1 = getNode(name1);
        Node node2 = getNode(name2);
        node1.addNeighbor(node2);
    }

    public void addUndirectedEdge(String name1, String name2) {
        Node node1 = getNode(name1);
        Node node2 = getNode(name2);
        node1.addNeighbor(node2);
        node2.addNeighbor(node1);
    }

    public Node getNode(String name) {
        for(Node node : nodes.values()){
            if(node.getName().equals(name)){
                return node;
            }
        } return null;
    }


    public class Node{
        private String name;
        private ArrayList<Node> neighbors;
        private String description;
        private ArrayList<Item> items;
        private ArrayList<Creature> creatures;

        public Node(String name, String description) {
            this.name = name;
            this.description = description;
            this.neighbors = new ArrayList<>();
            items = new ArrayList<>();
            creatures = new ArrayList<>();
        }

        public ArrayList<Node> getNeighbors() {
            return neighbors;
        }

        public ArrayList<Item> getItems() {
            return items;
        }

        public Creature getCreature(String name){
            for(Creature c : creatures){
                if(c.getName().equals(name)) return c;
            } return null;
        }

        public Item getItem(String name){
            for(Item i : items){
                if(i.getName().equals(name)) return i;
            } return null;
        }
        public void addItem(String name, String description){
            items.add(new Item(name, description));
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

        public boolean destroyItem(String name){
            if(getItem(name) == null) return false;
            else removeItem(name);
            return true;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void addNeighbor(Node n){
            neighbors.add(n);
        }

        public String getNeighborNames(){
            String output = "";
            for(Node n : neighbors){
                output += n.getName() + ", ";
            }
            return output;
        }

        public Node getNeighbor(String name){
            for(Node n : neighbors){
                if(n.getName().equals(name)){
                    return n;
                }
            } return null;
        }

        public String getItemNames() {
            if(items.size() == 0) return "No items";
            String output = "";
            for(Item i : items){
                output += i.getName() + ", ";
            } return output;
        }

        public Node getRandomNeighbor(){
            if(neighbors.size() == 0) return null;
            int randIndex = (int)(Math.random()*neighbors.size());
            return neighbors.get(randIndex);
        }

        public Creature removeCreature(String name){
            for(Creature c : creatures){
                if(c.getName().equals(name)) {
                    creatures.remove(c);
                    return c;
                }
            } return null;
        }

        public void removeCreature(Creature c){
            creatures.remove(c);
        }

        public void addCreature(Creature c){
            creatures.add(c);
        }
    }
}

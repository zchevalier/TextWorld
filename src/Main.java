import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Graph g = new Graph();

        g.addNode("hall", "a long dark hallway");
        g.addNode("closet", "a dark, dark, closet");
        g.addNode("dungeon", "a scary dungeon");

        g.addDirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "closet");

        g.getNode("hall").addItem("box", "a big cardboard box");

        Player p = new Player("Bill", "a player", g.getNode("hall"));

        ArrayList<Creature> creatures = new ArrayList<>();
        for(int i = 0; i < 10; i ++){
            initializeCreatures(creatures, p, g);
        }

        String response = "";
        Scanner s = new Scanner(System.in);


        do{

            Graph.Node currentRoom = p.getCurrentRoom();

            for(Creature c : creatures){
                c.move();
            }

            System.out.println("You are currently in the " + currentRoom.getName() + ", " + currentRoom.getDescription());

            for(int i =0 ; i < g.getNodes().size(); i ++){
                Graph.Node node = g.getNodes().get(i);
                System.out.println("The " + node.getName() + " has ");
                node.displayCreatures();
            }

            System.out.println("You can go to a room, look, add new rooms or items, or quit. What do you want to do?");
            response = s.nextLine();

            String[] words = response.split(" ");

            if(words[0].equals("go") && words[1].equals("to")){
                if(p.goToRoom(words[2]) == false) System.out.println(words[2] + " is not a room");

            } else if(words[0].equals("look")){
                System.out.println("neighbors: " + currentRoom.getNeighborNames());
                System.out.println("items in room: " + currentRoom.getItemNames());
                System.out.println("items you have: " + p.getItemNames());

            } else if(words[0].equals("add") && words[1].equals("room")){
                String response2 = "";
                System.out.println("write a description");
                response2 = s.nextLine();

                g.addNode(words[2], response2);
                g.addDirectedEdge(currentRoom.getName(), words[2]);

            } else if (words[0].equals("take")) {
                p.addItem(currentRoom.removeItem(words[1]));

            } else if(words[0].equals("add") && words[1].equals("item")){
                String response3 = "";
                System.out.println("write a description");
                response3 = s.nextLine();

                currentRoom.addItem(words[2], response3);

            } else if(words[0].equals("drop")){
                currentRoom.addItem(p.removeItem(words[1]));

            } else if (words[0].equals("quit")) {
                break;

            } else {
                System.out.println("You can go to a room, look at the existing neighbors and items, add a new room, or quit");
            }

        } while(!response.equals("quit"));


    }

    private static void initializeCreatures(ArrayList<Creature> creatures, Player p, Graph g) {
        Creature chicken = new Chicken(g.getNode("hall"), "chicken", "a strange chicken", p);
        creatures.add(chicken);
        Creature wumpus = new Wumpus(g.getNode("closet"), "wumpus", "a weird wumpus", p);
        creatures.add(wumpus);
        Creature popstar = new Popstar(g.getNode("dungeon"), "popstar", "a scary popstar", p);
        creatures.add(popstar);
    }
}

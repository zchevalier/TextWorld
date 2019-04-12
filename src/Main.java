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

        String[] response;
        Scanner s = new Scanner(System.in);


        do{

            Graph.Node currentRoom = p.getCurrentRoom();

            for(Creature c : creatures){
                c.move();
            }

            System.out.println("You are currently in the " + currentRoom.getName() + ", " + currentRoom.getDescription());
            System.out.println("You can go to a room, look, add new rooms or items, or quit. What do you want to do?");

            response = s.nextLine().split(" ");
            response = s.nextLine().split(" ");
            Command command = parseCommand(response, g, p);

            boolean success = command.execute();
            if (success == false) {
                System.out.println("You can go to a room, look, add new rooms or items, or quit. What do you want to do?");
            }

        } while(!response.equals("quit"));


    }

    private static Command parseCommand(String[] userString, Graph graph, Player player){
        if (userString[0].equals("go") && userString[1].equals("to")) return new GoToCommand(userString, player);
        if (userString[0].equals("look")) return new LookCommand(graph, userString, player);
        if (userString[0].equals("add") && userString[1].equals("room")) return new AddRoomCommand(userString, graph, player);
        if (userString[0].equals("take")) return new TakeCommand(userString, player);
        if (userString[0].equals("drop")) return new DropCommand(userString, player);
        if(userString[0].equals("add") && userString[1].equals("item")) return new AddItemCommand(userString, player);
        else return null;
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

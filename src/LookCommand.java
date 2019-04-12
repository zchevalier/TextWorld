public class LookCommand extends Command {
    Graph g;

    public LookCommand(Graph g, String[] response, Player player) {
        super(response, player);
        this.g = g;
    }

    @Override
    public boolean execute() {
        if (response.length == 1) {
            System.out.println("neighbors: " + player.getCurrentRoom().getNeighborNames());
            System.out.println("items in room: " + player.getCurrentRoom().getItemNames());
            System.out.println("items you have: " + player.getItemNames());
            for(int i =0 ; i < g.getNodes().size(); i ++){
                Graph.Node node = g.getNodes().get(i);
                System.out.println("The " + node.getName() + " has ");
                node.displayCreatures();
            }
            return true;
        }

        return false;
    }
}

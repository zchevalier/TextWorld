public class AddRoomCommand extends Command {

    private Graph g;

    public AddRoomCommand(String[] response, Graph g, Player player) {
        super(response, player);
        this.g = g;
    }

    @Override
    public boolean execute() {
        g.addNode(response[2], response[3]);
        g.addDirectedEdge(player.getCurrentRoom().getName(), response[2]);
        return true;
    }
}

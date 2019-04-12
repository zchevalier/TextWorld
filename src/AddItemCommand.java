public class AddItemCommand extends Command {

    public AddItemCommand(String[] response, Player player) {
        super(response, player);
    }

    @Override
    public boolean execute() {
        Graph.Node currentRoom = player.getCurrentRoom();
        currentRoom.addItem(response[2], response[3]);
        return true;
    }

}

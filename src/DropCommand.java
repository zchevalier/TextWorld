public class DropCommand extends Command{

    public DropCommand(String[] response, Player player) {
        super(response, player);
    }

    public boolean execute() {
        if (response.length == 2) {
            Item i = player.removeItem(response[1]);
            return player.getCurrentRoom().addItem(i);
        }
        return false;
    }
}

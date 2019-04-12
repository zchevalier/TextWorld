public class TakeCommand extends Command {

    public TakeCommand(String[] in, Player player) {
        super(in, player);
    }

    @Override
    public boolean execute() {
        if (response.length == 2) {
            Item i = player.getCurrentRoom().removeItem(response[1]);
            return player.addItem(i);
        }
        return false;
    }
}

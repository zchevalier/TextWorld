public class GoToCommand extends Command{

    public GoToCommand(String[] response, Player player) {
        super(response, player);
    }

    @Override
    public boolean execute() {
        return player.goToRoom(response[2]);
    }
}

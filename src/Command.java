public abstract class Command {
    public String[] response;
    public Player player;

    public Command(String[] response, Player player) {
        this.response = response;
        this.player = player;
    }

    public abstract boolean execute();

}

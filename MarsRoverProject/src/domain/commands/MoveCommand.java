package domain.commands;
import core.Rover;
public class MoveCommand implements Command {
    private final Rover rover;
    public MoveCommand(Rover r){ this.rover = r; }
    public void execute(){ rover.moveForward(); }
}
package core;
import domain.direction.Direction;
import domain.grid.GridComposite;
public class Rover {
    protected Position pos;
    protected Direction dir;
    protected final GridComposite grid;
    public Rover(Position start, Direction dir, GridComposite grid){
        this.pos = start;
        this.dir = dir;
        this.grid = grid;
    }
    public void moveForward(){
        Position next = dir.move(pos);
        if(!grid.isObstacle(next.x(), next.y())){
            pos = next;
        } else {
            System.out.println("⚠ Obstacle or boundary ahead! Staying at " + status());
        }
    }
    public void turnLeft(){ dir = dir.turnLeft(); }
    public void turnRight(){ dir = dir.turnRight(); }
    public String status(){
        return "(" + pos.x() + ", " + pos.y() + ", " + dir.name() + ")";
    }
    public Position statusPosition(){ return pos; }
    public Direction statusDirection(){ return dir; }
    public GridComposite getGrid(){ return grid; }
}
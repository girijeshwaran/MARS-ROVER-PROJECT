package domain.grid;
import java.util.*;
public class GridComposite implements GridComponent {
    private final int width, height;
    private final List<GridComponent> children = new ArrayList<>();
    
    public GridComposite(int w, int h) { 
        width = w; 
        height = h; 
    }
    
    public void add(GridComponent c) { 
        children.add(c); 
    }
    
    public boolean isObstacle(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) return true; // boundary
        return children.stream().anyMatch(c -> c.isObstacle(x, y));
    }
    
    public String getObstaclesString() {
        if (children.isEmpty()) {
            return "No obstacles";
        }
        StringBuilder sb = new StringBuilder();
        for (GridComponent component : children) {
            if (component instanceof Obstacle) {
                Obstacle obs = (Obstacle) component;
                sb.append("(").append(obs.getX()).append(",").append(obs.getY()).append(") ");
            }
        }
        return sb.toString().trim();
    }
}
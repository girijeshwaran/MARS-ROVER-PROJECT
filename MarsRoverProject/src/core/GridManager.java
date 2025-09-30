package core;
import domain.grid.GridComposite;
public class GridManager {
    private static GridManager instance;
    private final GridComposite grid;
    private GridManager(int width, int height){
        grid = new GridComposite(width,height);
    }
    public static synchronized GridManager init(int w,int h){
        if(instance==null) instance = new GridManager(w,h);
        return instance;
    }
    public static GridManager getInstance(){
        if(instance==null) throw new IllegalStateException("Grid not initialised");
        return instance;
    }
    public GridComposite getGrid(){ return grid; }
}
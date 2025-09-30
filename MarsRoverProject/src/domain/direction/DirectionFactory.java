package domain.direction;
public class DirectionFactory {
    public static Direction create(char code){
        return switch(code){
            case 'N' -> new North();
            case 'S' -> new South();
            case 'E' -> new East();
            case 'W' -> new West();
            default  -> throw new IllegalArgumentException("Invalid direction: " + code);
        };
    }
}
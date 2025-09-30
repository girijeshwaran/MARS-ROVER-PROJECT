package core;
import domain.commands.*;
import domain.direction.*;
import domain.grid.*;
import domain.decorator.*;
import java.util.*;
import java.util.regex.Pattern;
public class MarsRoverApp {
    private static final Pattern COORDINATE_PATTERN = Pattern.compile("\\d+\\s*,\\s*\\d+");
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get grid dimensions
        int width = getPositiveIntInput(sc, "Enter grid width (default 10): ", 10);
        int height = getPositiveIntInput(sc, "Enter grid height (default 10): ", 10);
        
        GridManager.init(width, height);
        GridComposite grid = GridManager.getInstance().getGrid();
        
        // Add obstacles
        System.out.println("\n=== Add Obstacles ===");
        System.out.println("Enter obstacle positions as 'x,y' (e.g., 2,2). Enter 'done' when finished.");
        
        while (true) {
            System.out.print("Obstacle position (or 'done'): ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("done")) break;
            
            if (COORDINATE_PATTERN.matcher(input).matches()) {
                String[] coords = input.split(",");
                int x = Integer.parseInt(coords[0].trim());
                int y = Integer.parseInt(coords[1].trim());
                
                if (x >= 0 && x < width && y >= 0 && y < height) {
                    grid.add(new Obstacle(x, y));
                    System.out.println("Added obstacle at (" + x + "," + y + ")");
                } else {
                    System.out.println("Coordinates out of bounds! Grid size is " + width + "x" + height);
                }
            } else {
                System.out.println("Invalid format. Please use 'x,y' format (e.g., 2,2)");
            }
        }
        
        // Get starting position and direction
        System.out.println("\n=== Set Starting Position ===");
        int startX = getIntInput(sc, "Enter starting X coordinate (0 to " + (width-1) + "): ", 0, width-1);
        int startY = getIntInput(sc, "Enter starting Y coordinate (0 to " + (height-1) + "): ", 0, height-1);
        
        char direction = ' ';
        while (true) {
            System.out.print("Enter starting direction (N, E, S, W): ");
            String dirInput = sc.nextLine().trim().toUpperCase();
            if (dirInput.matches("[NESW]")) {
                direction = dirInput.charAt(0);
                break;
            }
            System.out.println("Invalid direction. Please enter N, E, S, or W.");
        }
        
        Rover baseRover = new Rover(new Position(startX, startY),
                                  DirectionFactory.create(direction),
                                  grid);
        // Decorator: wrap rover with Logging capability
        Rover rover = new LoggingRover(baseRover);
        Map<Character,Command> commandMap = new HashMap<>();
        commandMap.put('M', new MoveCommand(rover));
        commandMap.put('L', new LeftCommand(rover));
        commandMap.put('R', new RightCommand(rover));
        System.out.println("\n=== Mars Rover Simulator (with Logging Decorator) ===");
        System.out.println("Grid size: " + width + "x" + height);
        System.out.println("Obstacles: " + grid.getObstaclesString());
        System.out.println("Starting at (" + startX + "," + startY + "," + direction + ")");
        System.out.println("\n=== Available Commands ===");
        System.out.println("M - Move forward");
        System.out.println("L - Turn left");
        System.out.println("R - Turn right");
        System.out.println("exit - Quit the program");
        while(true){
            System.out.print("> ");
            String line = sc.nextLine();
            if(line.equalsIgnoreCase("exit")) break;
            for(char c : line.toCharArray()){
                Command cmd = commandMap.get(c);
                if(cmd!=null) cmd.execute();
                else System.out.println("Invalid command: " + c);
            }
            System.out.println("Rover Status: " + rover.status());
        }
        sc.close();
    }
    
    private static int getPositiveIntInput(Scanner sc, String prompt, int defaultValue) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                return defaultValue;
            }
            try {
                int value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                }
                System.out.println("Please enter a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    
    private static int getIntInput(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
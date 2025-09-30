# Mars Rover Programming

## Problem
Simulate a rover moving on a grid using commands:

- `M` = move forward  
- `L` = turn left  
- `R` = turn right  

The rover must navigate around obstacles, and grid boundaries are enforced.

## Features
- Move rover with commands (`M`, `L`, `R`)  
- Detect and avoid obstacles  
- Enforce grid boundaries  
- Logging of rover actions  
- Extensible command system  

## Design Patterns Used
- **Command Pattern** – encapsulates rover actions  
- **State/Strategy + Factory** – for directions (`N`, `S`, `E`, `W`)  
- **Singleton** – for `GridManager`  
- **Composite** – to manage grid and obstacles  
- **Decorator** – for `LoggingRover`  

## How to Run
1. Navigate to the `src` folder:  
   ```bash
   cd src ```

2. Compile all Java files:

   ```bash
   javac core/*.java domain/commands/*.java domain/direction/*.java domain/grid/*.java domain/decorator/*.java
   ```

3. Run the application:

   ```bash
   java core.MarsRoverApp
   ```

## Usage

* Enter grid size when prompted.
* Optionally, enter obstacle positions.
* Enter the rover's starting position and direction.
* Input commands (`M`, `L`, `R`) to move the rover.
* The program repeats until you type `exit`.

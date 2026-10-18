import java.util.*;
public class WalkingRobotSimulation {
    public static int robotSim(int[] commands, int[][] obstacles) {
        int maxDist = 0;
        int x = 0, y = 0;

        // Direction vectors for North, East, South, West
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0; // Initially facing North

        // Convert obstacles array to a set of strings for quick lookup
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        for (int command : commands) {
            if (command == -1) {
                // Turn right 90 degrees
                if (directionIndex == 3) {
                    directionIndex = 0;
                } else {
                    directionIndex++;
                }
            } else if (command == -2) {
                // Turn left 90 degrees
                if (directionIndex == 0) {
                    directionIndex = 3;
                } else {
                    directionIndex--;
                }
            } else {
                // Move forward `command` units
                for (int i = 0; i < command; i++) {
                    int newX = x + directions[directionIndex][0];
                    int newY = y + directions[directionIndex][1];

                    // Check if the next position is an obstacle
                    if (obstacleSet.contains(newX + "," + newY)) {
                        break; // Stop moving if there's an obstacle
                    }

                    // Update the position
                    x = newX;
                    y = newY;
                }
                // Update the maximum distance squared from the origin
                maxDist = Math.max(maxDist, x * x + y * y);
            }
        }

        return maxDist;
    }
    public static void main(String[] args) {
        int commands[] = { 4,-1,4,-2,4};
        int obstacles[][] = {{2,4}};
        System.out.println(robotSim(commands,obstacles));
    }
}

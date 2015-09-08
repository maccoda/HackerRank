package artificialintelligence;

import java.util.Scanner;

public class BotSavesPrincess2 {
    // My function to complete
    /**
     *
     * @param n
     *            - size of board
     * @param r
     *            - row index of bot
     * @param c
     *            - column index of bot
     * @param grid
     *            - string array of the grid
     */
    static void nextMove(int n, int r, int c, String[] grid) {
        int prinRow = 0, prinCol = 0;
        // First need to find the princess (p)
        for (int row = 0; row < n; row++) {
            char[] splitGrid = grid[row].toCharArray();
            for (int col = 0; col < n; col++) {
                if (splitGrid[col] == 'p') {
                    prinRow = row;
                    prinCol = col;
                    break;
                }
            }
        }
        // Now work out the movement
        // First is looking at the rows
        if (prinRow > r) {
            System.out.println("DOWN");
        } else if (prinRow < r) {
            System.out.println("UP");
        }
        // Now for columns
        if (prinCol > c) {
            System.out.println("RIGHT");
        } else if (prinCol < c) {
            System.out.println("LEFT");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, r, c;
        n = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        in.useDelimiter("\n");
        String grid[] = new String[n];

        for (int i = 0; i < n; i++) {
            grid[i] = in.next();
        }

        nextMove(n, r, c, grid);
        in.close();

    }
}

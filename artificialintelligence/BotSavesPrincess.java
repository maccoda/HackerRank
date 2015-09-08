package artificialintelligence;

import java.util.Scanner;

public class BotSavesPrincess {

    static void displayPathtoPrincess(int n, String[] grid) {
        // Need to find where the princess is. We know she is in one of the
        // corners so this restricts our search

        // We know the bot is in the centre
        int[] botPos = { (n / 2), (n / 2) };
        // Construct the search pattern, search (0,0), (0,n), (n,n), (n,0)
        // Rows need to search
        int[] rowPos = { 0, n - 1 };
        int[] princessPos = { 0, 0 };
        for (int i : rowPos) {
            char[] test = grid[i].toCharArray();
            if (test[0] == 'p') {
                princessPos[0] = i;
                princessPos[1] = 0;
            } else if (test[n - 1] == 'p') {
                princessPos[0] = i;
                princessPos[1] = n - 1;
            }
        }
        // Now need to move the bot to the princess!
        while (botPos[0] != princessPos[0] && botPos[1] != princessPos[1]) {
            // Look at row first
            if (botPos[0] > princessPos[0]) {
                System.out.println("UP");
                botPos[0]--;
            } else if (botPos[0] < princessPos[0]) {
                System.out.println("DOWN");
                botPos[0]++;
            }

            // Now work on column
            if (botPos[1] > princessPos[1]) {
                System.out.println("LEFT");
                botPos[1]--;
            } else if (botPos[1] < princessPos[1]) {
                System.out.println("RIGHT");
                botPos[1]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[] = new String[m];
        for (int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

        displayPathtoPrincess(m, grid);

        in.close();
    }
}
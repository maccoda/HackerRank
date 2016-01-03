package algorithms.graphtheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class SnakesAndLadders {

  /**
   * Given a board find the minimum number of rolls(edges traversed) required to
   * go from the start to the finish.
   * 
   * @return Minimum number of rolls
   */
  public static int quickestWay(BoardGraph board) {
    int result = 0;

    // This is simply a breadth first traversal of our graph so just need to
    // implement that
    result = board.minDistance(1, 100);

    return result;

  }

  public static void main(String[] args) {
    // First we need to make the board
    BoardGraph board = new BoardGraph();

    // User input
    Scanner in = new Scanner(System.in);
    int tests = in.nextInt();
    for (int i = 0; i < tests; i++) {
      // Get number of ladders
      int numLadders = in.nextInt();
      for (int l = 0; l < numLadders; l++) {
        // Change the connections in the board
        int start = in.nextInt();
        int end = in.nextInt();

        board.setConnections(start - 1, new ArrayList<Integer>(Arrays.asList(end)));
      }

      // Get the number of snakes
      int numSnakes = in.nextInt();
      for (int s = 0; s < numSnakes; s++) {
        // Change the connections in the board
        int start = in.nextInt();
        int end = in.nextInt();

        board.setConnections(start - 1, new ArrayList<Integer>(Arrays.asList(end)));
      }

      // Now minimum distance search
      System.out.println(quickestWay(board));

    }

    in.close();
  }

  /**
   * This class creates a 100 node graph to represent the 100 value board for
   * the snakes and ladders board game. It will initialize the 100 nodes as well
   * as have the ability to add snakes or ladders. This will be done by
   * adjusting the connections of the node as usually it can move 1-6 spaces
   * ahead whereas if it has a snake or ladder on it the only option is to take
   * that path
   * 
   * @author dmaccora
   *
   */
  private static class BoardGraph {

    private List<Node<Integer>> nodes;
    private static final int BOARD_SIZE = 100;

    public BoardGraph() {
      // Make 100 node graph only need index to the first one
      nodes = new ArrayList<Node<Integer>>();
      for (int i = 0; i < BOARD_SIZE; i++) {
        nodes.add(new Node<Integer>(i + 1));
        // Initially all nodes will have connections to the next 6 elements,
        // need to ensure that each is less than 100 though!
        ArrayList<Integer> connections = new ArrayList<Integer>();
        for (int nextIndex = i + 2; nextIndex < i + 8; nextIndex++) {
          if (nextIndex <= 100) {
            connections.add(nextIndex);
          }
        }

        nodes.get(i).setConnections(connections);
      }

    }

    // Usually want to be able to add or remove edges but since we know the
    // exact working of this design, it is known that will need to set the
    // connections/edges not modify
    public void setConnections(int index, ArrayList<Integer> connections) {
      nodes.get(index).setConnections(connections);
    }

    public ArrayList<Integer> getConnections(int index) {
      return nodes.get(index).getConnections();
    }

    public int getSize() {
      return nodes.size();
    }

    /**
     * TODO Fix this breadth first minimum distance algorithm.
     * 
     * @param startIndex
     *          - start index
     * @param endIndex
     *          - end index
     * @return minimum distance
     */
    public int minDistance(int startIndex, int endIndex) {
      // Need a queue to implement breadth first search, holds index of nodes
      Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
      // Need to keep track of nodes visited
      // Add 1 so can have 1 indexed to match game
      boolean[] visited = new boolean[getSize() + 1];
      // Initialize this to false
      for (boolean node : visited) {
        node = false;
      }
      // To find minimum distance require storage of previous node and
      // distance from start
      int[] distance = new int[getSize() + 1];
      int[] prevNode = new int[getSize() + 1];

      // Start the search at the start index
      queue.add(startIndex);
      distance[startIndex] = 0;
      // Cannot be valid
      prevNode[startIndex] = -1;
      visited[startIndex] = true;

      // While there are elements in the queue
      while (!queue.isEmpty()) {
        int currentIndex = queue.remove();
        Node<Integer> currentNode = nodes.get(currentIndex - 1);
        // Check all of current index's connections
        for (Integer vertex : currentNode.getConnections()) {
          // Check hasn't already been visited
          if (!visited[vertex]) {
            // Store previous node and distance
            prevNode[vertex] = currentIndex;
            distance[vertex] = distance[currentIndex] + 1;
            visited[vertex] = true;
            // Add this vertex to the queue
            queue.add(vertex);
          }
        }

      }
      return distance[endIndex];
    }

    @Override
    public String toString() {
      return nodes.toString();
    }

    /**
     * Class to handle the nodes within the graphs. This just keeps track of its
     * available connections and its index or id
     * 
     * @author dmaccora
     *
     * @param <T>
     *          This is the type of the index that represents the node.
     *          Typically this will simply be an Integer
     */
    private class Node<T> {
      // Index stores the index of the node in the graph
      private T index;
      private ArrayList<T> connections;

      public Node(T index) {
        this.index = index;
      }

      public void setConnections(ArrayList<T> connections) {
        this.connections = connections;
      }

      public ArrayList<T> getConnections() {
        return connections;
      }

      public T getIndex() {
        return index;
      }

      @Override
      public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(index);
        for (T con : connections) {
          builder.append(" - ");
          builder.append(con);
        }
        builder.append("\n");

        return builder.toString();
      }
    }
  }
}

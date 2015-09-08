package algorithms;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Problem Statement

 You are given a tree (a simple connected graph with no cycles). You have to remove as many edges from the tree
 as possible to obtain a forest with the condition that : Each connected component of the forest should contain
 an even number of vertices.

 To accomplish this, you will remove some edges from the tree. Find out the number of removed edges.

 * Input Format
 The first line of input contains two integers N and M. N is the number of vertices and M is the number of edges.
 The next M lines contain two integers ui and vi which specifies an edge of the tree. (1-based index)

 * Output Format
 Print the answer, a single integer.

 * Constraints
 2 <= N <= 100.
 */

public class EvenTree {

    public static void main(String[] args) {
        final int ROOT = 0;
        Scanner in = new Scanner(System.in);
        // Take the inputs and create the tree
        int numNodes = in.nextInt();
        int numEdges = in.nextInt();
        // Create all the nodes
        Node[] nodes = new Node[numNodes];

        // Just from the test case it looks like the parent is on the right and
        // the child on the right hence can assume we can find the root

        // Need to initialise all the nodes
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
        }
        // Root node has no parents
        nodes[ROOT].setParent(null);

        // Create the tree
        int child, parent;
        for (int i = 0; i < numEdges; i++) {
            child = in.nextInt();
            parent = in.nextInt();
            // Need to subtract 1 as input is 1 indexed
            // Set parent
            nodes[child - 1].setParent(nodes[parent - 1]);
            // Set children
            nodes[parent - 1].addChild(nodes[child - 1]);
        }

        // Now need to traverse and see if there are even or odd number of nodes
        // for each subtree
        System.out.println(nodes[ROOT].getNumberOfChildren());

        in.close();
    }

}

/*
 * Going to use an OO approach to make a tree class and work from there
 */
class Node {
    private int id;
    private Node parent;
    private ArrayList<Node> children = new ArrayList<Node>();
    private boolean isLeaf = true;

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isALeaf() {
        return isLeaf;
    }

    public void addChild(Node child) {
        isLeaf = false;
        children.add(child);
    }

    public void setParent(Node iParent) {
        parent = iParent;
    }

    /*
     * Need to work on this part!!!!
     */
    public int getNumberOfChildren() {
        int result = children.size();
        return result;
    }

    @Override
    public String toString() {
        String result = "Node: " + id + " Children: ";
        for (int i = 0; i < children.size(); i++) {
            result += children.get(i).getId() + ", ";
        }
        return result;
    }
}

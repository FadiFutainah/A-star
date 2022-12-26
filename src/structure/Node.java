package structure;

import java.util.ArrayList;

public class Node {
    public int x;
    public int y;
    public double busCallingTime;
    public double taxiCallingTime;
    public ArrayList<Edge> edges;

    public Node(int x, int y, double busCallingTime, double taxiCallingTime) {
        this.x = x;
        this.y = y;
        this.edges = new ArrayList<>();
        this.taxiCallingTime = taxiCallingTime;
        this.busCallingTime = busCallingTime;
    }
}

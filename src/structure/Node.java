package structure;

import java.util.ArrayList;

public class Node {
    public int x;
    public int y;
    public double tiktokCallingTime;
    public double taxiCallingTime;
    public ArrayList<Edge> edges;

    public Node(int x, int y, double tiktokCallingTime, double taxiCallingTime) {
        this.x = x;
        this.y = y;
        this.edges = new ArrayList<>();
        this.taxiCallingTime = taxiCallingTime;
        this.tiktokCallingTime = tiktokCallingTime;
    }
}

package structure;

import java.util.ArrayList;

public class Node {
    public double tiktokCallingTime;
    public double taxiCallingTime;
    public ArrayList<Edge> edges;

    public Node(double tiktokCallingTime, double taxiCallingTime) {
        this.tiktokCallingTime = tiktokCallingTime;
        this.taxiCallingTime = taxiCallingTime;
        this.edges = new ArrayList<>();
    }
}

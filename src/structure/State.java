package structure;

public class State {
    public Node node;
    public String tiktokPath;
    public State parent;
    public double cost;
    public double distance;
    public double time;
    public double health;

    public State(Node node, String tiktokPath, State parent, double cost, double distance, double time, double health) {
        this.node = node;
        this.tiktokPath = tiktokPath;
        this.parent = parent;
        this.cost = cost;
        this.distance = distance;
        this.time = time;
        this.health = health;
    }
}

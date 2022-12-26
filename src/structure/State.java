package structure;

public class State {
    public Node node;
    public String busPath;
    public State parent;
    public double cost;
    public double distance;
    public double time;
    public double health;

    public Vehicle vehicle;

    public State(Node node, String busPath, State parent, double cost, double distance, double time, double health, Vehicle vehicle) {
        this.node = node;
        this.busPath = busPath;
        this.parent = parent;
        this.cost = cost;
        this.distance = distance;
        this.time = time;
        this.health = health;
        this.vehicle = vehicle;
    }
}

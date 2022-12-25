package structure;

public class Edge {
    public int destination;
    public double length;
    public boolean impossibleToDrive;
    public String tiktokPath;
    public double tiktokSpeed;
    public double taxiSpeed;

    public Edge(int destination, double length, boolean impossibleToDrive, String tiktokPath, double tiktokSpeed, double taxiSpeed) {
        this.destination = destination;
        this.length = length;
        this.impossibleToDrive = impossibleToDrive;
        this.tiktokPath = tiktokPath;
        this.tiktokSpeed = tiktokSpeed;
        this.taxiSpeed = taxiSpeed;
    }


}

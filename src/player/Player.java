package player;

import structure.Edge;
import structure.Node;
import structure.State;
import structure.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public ArrayList<String> lineTable;
    public ArrayList<Node> stations;
    double walkingSpeed;
    double health;
    double pocket;
    double busCost;
    double taxiCost;

    public Player(double walkingSpeed, double health, double pocket, double busCost, double taxiCost) {
        this.health = health;
        this.pocket = pocket;
        this.taxiCost = taxiCost;
        this.busCost = busCost;
        this.walkingSpeed = walkingSpeed;
        this.stations = new ArrayList<>();
    }

    public void setStations(ArrayList<Node> stations) {
        this.stations = stations;
    }

    public void setLineTable(ArrayList<String> lineTable) {
        this.lineTable = lineTable;
    }

    public List<State> play() {
        List<State> path = new ArrayList<>();

        return path;
    }

    public void search() {
    }

    private void takeABus(State current, Edge edge, List<State> nextStates) {
        int index = stations.indexOf(current.node);
        double health = current.health - 5 * edge.length;
        double distance = current.distance + edge.length;
        double time = current.time + edge.length / edge.busSpeed;
        double cost = current.cost;
        if (current.health < 0) return;
        if (current.busPath.contains(String.valueOf(edge.destination))) {
            nextStates.add(new State(stations.get(edge.destination), current.busPath, current, cost, distance, time, health, Vehicle.BUS));
        }
        cost += 400;
        if (cost > pocket) return;
        for (String path : lineTable) {
            if (path.contains(String.valueOf(index))) {
                nextStates.add(new State(stations.get(edge.destination), path, current, cost, distance, time, health,Vehicle.BUS));
            }
        }
    }

    private void takeATaxi(State current, Edge edge, List<State> nextStates) {
        String path = "";
        double health = current.health + 5 * edge.length;
        double distance = current.distance + edge.length;
        double cost = current.cost + taxiCost * edge.length;
        double time = current.time + edge.length / edge.taxiSpeed;
        if (cost > pocket) return;
        nextStates.add(new State(stations.get(edge.destination), path, current, cost, distance, time, health, Vehicle.TAXI));
    }

    private void takeAWalk(State current, Edge edge, List<State> nextStates) {
        double cost = 0;
        String path = "";
        double distance = current.distance + edge.length;
        double health = current.health - 10 * edge.length;
        double time = current.time + edge.length / walkingSpeed;
        if (current.health < 0) return;
        nextStates.add(new State(stations.get(edge.destination), path, current, cost, distance, time, health, Vehicle.WALK));
    }

    public List<State> lookAround(State current) {
        List<State> nextStates = new ArrayList<>();
        for (Edge edge : current.node.edges) {
            takeABus(current, edge, nextStates);
            takeATaxi(current, edge, nextStates);
            takeAWalk(current, edge, nextStates);
        }
        return nextStates;
    }

    public void report() {
    }
}

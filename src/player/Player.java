package player;

import structure.Edge;
import structure.Node;
import structure.State;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public ArrayList<String> lineTable;
    public ArrayList<Node> stations;
    double walkingSpeed;
    double health;
    double pocket;
    double tikTokCost;
    double taxiCost;

    public Player(double walkingSpeed, double health, double pocket, double tikTokCost, double taxiCost) {
        this.health = health;
        this.pocket = pocket;
        this.taxiCost = taxiCost;
        this.tikTokCost = tikTokCost;
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

    private void takeATikTok(State current, Edge edge, List<State> nextStates) {
        int index = stations.indexOf(current.node);
        double health = current.health - 5 * edge.length;
        double distance = current.distance + edge.length;
        double time = current.time + edge.length / edge.tiktokSpeed;
        double cost = current.cost;
        if (current.health < 0) return;
        if (current.tiktokPath.contains(String.valueOf(edge.destination))) {
            nextStates.add(new State(stations.get(edge.destination), current.tiktokPath, current, cost, distance, time, health));
        }
        cost += 400;
        if (cost > pocket) return;
        for (String path : lineTable) {
            if (path.contains(String.valueOf(index))) {
                nextStates.add(new State(stations.get(edge.destination), path, current, cost, distance, time, health));
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
        nextStates.add(new State(stations.get(edge.destination), path, current, cost, distance, time, health));
    }

    private void takeAWalk(State current, Edge edge, List<State> nextStates) {
        double cost = 0;
        String path = "";
        double distance = current.distance + edge.length;
        double health = current.health - 10 * edge.length;
        double time = current.time + edge.length / walkingSpeed;
        if (current.health < 0) return;
        nextStates.add(new State(stations.get(edge.destination), path, current, cost, distance, time, health));
    }

    public List<State> lookAround(State current) {
        List<State> nextStates = new ArrayList<>();
        for (Edge edge : current.node.edges) {
            takeATikTok(current, edge, nextStates);
            takeATaxi(current, edge, nextStates);
            takeAWalk(current, edge, nextStates);
        }
        return nextStates;
    }

    public void report() {
    }
}

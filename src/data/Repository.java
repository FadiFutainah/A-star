package data;

import game.Game;
import player.Player;
import structure.Edge;
import structure.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Repository {
    Scanner loader;
    ArrayList<String> lineTable = new ArrayList<>();

    public Repository() {
    }

    private Scanner getLoader(String level) {
        String file = "src/resources/" + level + ".txt";
        try {
            return new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Game loadGame(String level) {
        loader = getLoader(level);
        Game game = new Game();
        ArrayList<Node> nodes = new ArrayList<>();
        while (loader.hasNext()) {
            String ch = loader.next();
            switch (ch) {
                case "N" -> game.setPlayer(scanPlayer());
                case "E" -> nodes.get(nodes.size() - 1).edges.add(scanEdge());
                case "D", "S", "P" -> nodes.add(scanNode());
            }
        }
        game.player.setStations(nodes);
        game.player.setLineTable(lineTable);
        loader.close();
        return game;
    }

    private Player scanPlayer() {
        double walkingSpeed = loader.nextDouble();
        double health = loader.nextDouble();
        double money = loader.nextDouble();
        double busCost = loader.nextDouble();
        double taxiCost = loader.nextDouble();
        return new Player(walkingSpeed, health, money, busCost, taxiCost);
    }

    private Edge scanEdge() {
        int destination = loader.nextInt();
        double length = loader.nextDouble();
        boolean impossibleToDrive = loader.next().equals("1");
        String tiktokPath = loader.next();
        double tiktokSpeed = loader.nextDouble();
        double taxiSpeed = loader.nextDouble();
        lineTable.add(tiktokPath);
        return new Edge(destination, length, impossibleToDrive, tiktokPath, tiktokSpeed, taxiSpeed);
    }

    private Node scanNode() {
        double tiktokCallingTime = loader.nextDouble();
        double taxiCallingTime = loader.nextDouble();
        return new Node(tiktokCallingTime, taxiCallingTime);
    }
}
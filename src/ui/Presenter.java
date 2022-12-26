package ui;

import structure.Edge;
import structure.Node;
import utils.Colors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Presenter {
    private final String padding = " ".repeat(45);

    private final Map<String, String> colors = new HashMap<>();

    public String[][] map;

    public Presenter(int w, int h) {
        map = new String[w][h];
        colors.put("   ", Colors.GREEN);
        colors.put(" S ", Colors.PURPLE);
        colors.put(" H ", Colors.CYAN);
        colors.put(" E ", Colors.RED);
        colors.put(" - ", Colors.BLACK);
        colors.put(" | ", Colors.BLACK);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[j][i] = "   ";
            }
        }
    }

    public void initMap(ArrayList<Node> nodes) {
        for (Node n : nodes) {
            map[n.y][n.x] = " S ";
            for (Edge e : n.edges) {
                Node d = nodes.get(e.destination);
                if (d.x == n.x) {
                    for (int i = Math.min(d.y, n.y) + 1; i < Math.max(d.y, n.y); ++i) {
                        if(Objects.equals(map[i][n.x], "   ")) map[i][n.x] = " - ";
                    }
                } else {
                    for (int i = Math.min(d.x, n.x) + 1; i < Math.max(d.x, n.x); ++i) {
                        if(Objects.equals(map[n.y][i], "   ")) map[n.y][i] = " | ";
                    }
                }
            }
        }
        map[nodes.get(0).y][nodes.get(0).x] = " H ";
        map[nodes.get(nodes.size() - 1).y][nodes.get(nodes.size() - 1).x] = " E ";
    }

    private void printCell(String cell){
        System.out.print(colors.get(cell));
        System.out.print(cell);
        System.out.print(Colors.RESET);
    }

    public void printMap(){
        for (int i = 0; i < map[0].length; i++) {
            System.out.print(padding);
            for (String[] strings : map) {
                printCell(strings[i]);
            }
            System.out.println();
        }
    }
}

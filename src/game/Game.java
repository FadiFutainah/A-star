package game;

import player.Player;

public class Game {
    public Player player;

    public Game() {
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void start(){
        System.out.println(player);
    }
}

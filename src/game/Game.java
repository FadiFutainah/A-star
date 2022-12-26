package game;

import player.Player;
import ui.Presenter;

public class Game {
    public Player player;
    public Presenter presenter;

    public Game() {
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void start(){
        presenter.initMap(player.stations);
        presenter.printMap();
    }
}

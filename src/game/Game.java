package game;

import player.Player;
import structure.State;
import ui.Presenter;

import java.util.ArrayList;
import java.util.List;

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
//        presenter.printMap();
        List<State> sulotion = player.play();
        for (State state : sulotion) {
            presenter.printMap();
        }
    }
}

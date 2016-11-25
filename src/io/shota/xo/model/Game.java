package io.shota.xo.model;

/**
 * Created by 1 on 25.11.2016.
 */
public class Game {

    private static final String name = "XO";

    private Player[] players = new Player[2];

    private Field field = new Field();

    public String getName(){
        return name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getField() {
        return field;
    }
}

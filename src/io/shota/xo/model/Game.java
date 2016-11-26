package io.shota.xo.model;


public class Game {

    private static final String name = "XO";

    private Player[] players = new Player[2];

    private Field field = new Field();

    public Game(Player[] players, Field field) {
        this.players = players;
        this.field = field;
    }

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

package io.shota.xo.model;


import java.awt.*;

public class Field {

    private static int FIELD_SIZE = 3;

    private Figure[][] figures = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return FIELD_SIZE;
    }

    public void setFigure(Point point, Figure figure){
        this.figures[point.x][point.y] = figure;
    }

    public Figure getFigure(Point point){
        return this.figures[point.x][point.y];
    }
}

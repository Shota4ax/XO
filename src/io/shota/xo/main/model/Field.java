package io.shota.xo.main.model;


import io.shota.xo.main.model.exceptions.AlreadyOccupiedPointException;
import io.shota.xo.main.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {

    private final int fieldSize;

    private static final int MIN_FIELD_SIZE = 0;

    private final Figure[][] figures;

    public Field(final int fieldSize) {
        this.fieldSize = fieldSize;
        this.figures = new Figure[fieldSize][fieldSize];
    }

    public int getSize() {
        return fieldSize;
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if(!checkPoint(point)){
            throw new InvalidPointException();
        }
        this.figures[point.x][point.y] = figure;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if(!checkPoint(point)){
            throw new InvalidPointException();
        }
        return this.figures[point.x][point.y];
    }

    private boolean checkPoint(final Point point) {
        return checkCoord(point.x, figures.length) && checkCoord(point.y,figures[point.x].length);
    }

    private boolean checkCoord(final int coordinate, final int maxFieldSize){

        return coordinate >= MIN_FIELD_SIZE && coordinate < maxFieldSize;
    }
}

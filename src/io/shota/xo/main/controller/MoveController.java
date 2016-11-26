package io.shota.xo.main.controller;

import io.shota.xo.main.model.Field;
import io.shota.xo.main.model.Figure;
import io.shota.xo.main.model.exceptions.AlreadyOccupiedPointException;
import io.shota.xo.main.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(Field field, Point point, Figure figure) throws InvalidPointException, AlreadyOccupiedPointException {
            if(field.getFigure(point) != null) {
                throw new AlreadyOccupiedPointException();
            }
            field.setFigure(point,figure);
    }
}

package io.shota.xo.main.controller;


import io.shota.xo.main.model.Field;
import io.shota.xo.main.model.Figure;
import io.shota.xo.main.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field){
        try {
            for (int i = 0; i < 3; i++) {

                if (check(field, new Point(i, 0), point -> new Point(point.x, point.y + 1))) {
                    return field.getFigure(new Point(i, 0));
                }
            }
            for (int i = 0; i < 3; i++) {

                if (check(field, new Point(0, i), point -> new Point(point.x + 1, point.y))) {
                    return field.getFigure(new Point(0, i));
                }

            }

            if(check(field, new Point(0,0), point -> new Point(point.x+1,point.y+1))){
                return field.getFigure(new Point(0, 0));
            }

            if(check(field, new Point(0,2), point -> new Point(point.x+1,point.y-1))){
                return field.getFigure(new Point(0, 2));
            }

        }catch(final InvalidPointException e){e.printStackTrace();};


        return null;

    }


    //проверка на то одинаковая ли фигура стоит в следующей координате что и в предыдущей

    private boolean check(final Field field, Point currentPoint, IPointGenerator pointGenerator){
        Figure currentFig;
        Figure nextFig;
        Point nextPoint = pointGenerator.next(currentPoint);
        try {
            currentFig = field.getFigure(currentPoint);

            if(currentFig == null) {
                return false;
            }
            nextFig = field.getFigure(nextPoint);
        } catch (InvalidPointException e) {
            return true;
        }


        if(currentFig != nextFig){
            return false;
        }


        return check(field, nextPoint, pointGenerator);


    }

    private interface IPointGenerator{
        public Point next(Point point);
    }

}

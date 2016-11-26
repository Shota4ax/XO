package io.shota.xo.main.controller;

import io.shota.xo.main.model.Field;
import io.shota.xo.main.model.Figure;
import io.shota.xo.main.model.exceptions.InvalidPointException;

import java.awt.*;

/**
 * Created by 1 on 26.11.2016.
 */
public class CurrentMoveController {

    public Figure currentMove(final Field field){
        int numFig = 0;
        for(int row=0;row<field.getSize();row++){
            numFig += calculateFigRow(field,row);
        }

        if(numFig == field.getSize() * field.getSize()){
            return null;
        }

        if(numFig % 2 == 0){
            return Figure.X;
        }

        return Figure.O;

    }

    private int calculateFigRow(final Field field, final int row){
        int numFig = 0;
        for(int i=0;i<field.getSize();i++){
            try {
                if(field.getFigure(new Point(row,i)) != null){
                    numFig++;
                }
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }


        return numFig;

    }


}

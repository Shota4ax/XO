package io.shota.xo.model;

import io.shota.xo.main.model.exceptions.AlreadyOccupiedPointException;
import io.shota.xo.main.model.exceptions.InvalidPointException;
import io.shota.xo.main.model.Field;
import io.shota.xo.main.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by 1 on 25.11.2016.
 */
public class FieldTest {

    @Test
    public void testGetSize() throws Exception {

        final int size = 3;

        final Field field = new Field(3);

        assertEquals(3,field.getSize());
    }

    @Test
    public void testSetFigure() throws Exception {
        final int size = 3;

        final Field field = new Field(size);

        final Point point = new Point(0,0);

        final Figure expected = Figure.X;

        field.setFigure(point,expected);

        final Figure actual = field.getFigure(point);

        assertEquals(expected,actual);

    }

    @Test
    public void testGetFigure() throws Exception {
        final int size = 3;

        final Field field = new Field(size);

        final Point point = new Point(0,0);

        final Figure figure = Figure.X;

        field.setFigure(point,figure);

        final Figure expected = figure;

        final Figure actual = field.getFigure(point);

        assertEquals(expected,actual);

    }



    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final int size = 3;

        final Field field = new Field(size);

        final Point point = new Point(0,0);

        final Figure figure = Figure.X;

        final Figure expected = field.getFigure(point);

        assertNull(expected);

    }

    @Test
    public void testGetFigureWhenPointXIsIncorrect() throws Exception {

        final int size = 3;

        final Field field = new Field(size);

        final Point point = new Point(-1,0);

        try{

            final Figure figure = field.getFigure(point);
            fail();

        }catch (final InvalidPointException e){};

    }

    @Test
    public void testGetFigureWhenPointYIsIncorrect() throws Exception {
        final int size = 3;

        final Field field = new Field(size);

        final Point point = new Point(0,-1);

        try{

            final Figure figure = field.getFigure(point);
            fail();

        }catch (final InvalidPointException e){};

    }

    @Test
    public void testSetFigureWhenPointXIsMoreThanMaxSize() throws Exception {

        final int size = 3;

        final Field field = new Field(size);

        final Point point = new Point(5,0);

        try{
            field.setFigure(point,Figure.X);

            if(point.x > size || point.y >size){
                fail();
            }

        }catch (final InvalidPointException e){};


    }

}
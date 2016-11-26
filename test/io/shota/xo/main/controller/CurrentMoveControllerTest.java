package io.shota.xo.main.controller;

import io.shota.xo.main.model.Field;
import io.shota.xo.main.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by 1 on 26.11.2016.
 */
public class CurrentMoveControllerTest {

    @Test
    public void testCurrentMoveO() throws Exception {
        CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.O);
            assertEquals(Figure.O,currentMoveController.currentMove(field));
        }

    }

    @Test
    public void testCurrentMoveX() throws Exception {
        CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.O);
            assertEquals(Figure.X,currentMoveController.currentMove(field));
        }

    }

    @Test
     public void testCurrentMoveWhenNoNextMove() throws Exception {
                final CurrentMoveController currentMoveController = new CurrentMoveController();
                final Field field = new Field(3);
                field.setFigure(new Point(0, 0), Figure.O);
                field.setFigure(new Point(0, 1), Figure.X);
                field.setFigure(new Point(0, 2), Figure.O);
                field.setFigure(new Point(1, 0), Figure.O);
                field.setFigure(new Point(1, 1), Figure.X);
                field.setFigure(new Point(1, 2), Figure.O);
                field.setFigure(new Point(2, 0), Figure.O);
                field.setFigure(new Point(2, 1), Figure.X);
                field.setFigure(new Point(2, 2), Figure.O);
                assertNull(currentMoveController.currentMove(field));

    }
}
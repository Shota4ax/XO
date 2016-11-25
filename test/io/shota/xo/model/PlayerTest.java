package io.shota.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;


public class PlayerTest {

    @Test
    public void testGetName() throws Exception {

        final String name = "Shota";

        Player player = new Player(name, null);

        final String expected = name;

        final String actual = player.getName();

        assertEquals(expected,actual);

    }

    @Test
    public void testGetFigure() throws Exception {

        final Figure figure = Figure.X;

        Player player = new Player(null, figure);

        final Figure expected = figure;

        final Figure actual = player.getFigure();

        assertEquals(expected,actual);
    }
}
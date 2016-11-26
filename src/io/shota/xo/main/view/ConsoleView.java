package io.shota.xo.main.view;

import io.shota.xo.main.controller.CurrentMoveController;
import io.shota.xo.main.controller.MoveController;
import io.shota.xo.main.controller.WinnerController;
import io.shota.xo.main.model.Field;
import io.shota.xo.main.model.Figure;
import io.shota.xo.main.model.Game;
import io.shota.xo.main.model.exceptions.AlreadyOccupiedPointException;
import io.shota.xo.main.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.Scanner;

public class ConsoleView {
    private final WinnerController winnerController = new WinnerController();

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final MoveController moveController = new MoveController();

    // показывает поле с символами

    public void show(final Game game){
        System.out.println("Welcome to: "+game.getName());
        Field field = game.getField();
        for(int i = 0; i<field.getSize();i++){
            printLine(field,i);
            System.out.println();
            printSeparator();
        }
    }

    //просто отрисовывает символы в поле после каждого хода в наше поле(т.е. после move())

    private void printLine(final Field field, final int row){

        for(int i=0; i<field.getSize();i++){
            if(i!=0)
                System.out.print("|");
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(row,i));
            } catch (InvalidPointException e) {
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
    }

    public boolean move(final Game game){
        final Field field = game.getField();
        Figure currentFig = currentMoveController.currentMove(field); // узнаем кто ходит следующий
        final Figure winner = winnerController.getWinner(field);
        if(winner!= null){
            System.out.format("... And winner is : %s",winner);
            return false;
        }
        //если заполнено все поле проверяем победителя
        if(currentFig == null){
                System.out.println("It's draw, no one wins!");
                return false;
            }

        System.out.format("Please enter point for %s",currentFig);
        Point point = makePoint();

        try {
            moveController.applyFigure(field,point,currentFig);
        } catch (InvalidPointException | AlreadyOccupiedPointException e) {
            System.out.println("Point is invalid!");
        }

        return true;
    }



    private Point makePoint(){
        int coordX = askCoord("x");
        int coordY = askCoord("y");
        return new Point(coordX-1,coordY-1);
    }

    private  int askCoord(String coordName){
        System.out.print("Please enter "+coordName);
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void printSeparator(){
        System.out.println("~~~~~~~~~~~~");
    }
}

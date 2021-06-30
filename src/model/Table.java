package model;
import java.util.ArrayList;
import java.util.Collections;

public class Table {
    private final char[][] gameField;

    public Table(){
        this.gameField = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameField[i][j] = ' ';
            }
        }
    }

    public char[][] getGameField(){
        return gameField;
    }

    public char checkWin(){
        ArrayList<GameElem> listX = new ArrayList<>();
        ArrayList<GameElem> list0 = new ArrayList<>();
        int empty = 9;
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j] != ' ') {
                    empty--;
                    if (gameField[i][j] == 'X') listX.add(new GameElem(j, i, gameField[i][j]));
                    else list0.add(new GameElem(j, i, gameField[i][j]));
                }
            }
        }
        Collections.sort(listX);
        Collections.sort(list0);
        Vector vector;
        for (int i = 0; i < listX.size(); i++) {
            for (int j = 0; j < listX.size(); j++) {
                if (i == j || !listX.get(i).isNearBy(listX.get(j))) continue;
                vector = Vector.getVector(listX.get(i), listX.get(j));
                if (GameElem.getNextElemByVector(listX, listX.get(j), vector) != null){
                    return 'X';
                } else vector = null;
            }
        }
        vector = null;
        for (int i = 0; i < list0.size(); i++) {
            for (int j = 0; j < list0.size(); j++) {
                if (i == j || !list0.get(i).isNearBy(list0.get(j))) continue;
                vector = Vector.getVector(list0.get(i), list0.get(j));
                if (GameElem.getNextElemByVector(list0, list0.get(j), vector) != null){
                    return '0';
                } else vector = null;
            }
        }
        if (empty == 0) return '/';
        return '-';
    }

    public void setElem(int y, int x, char elem){
        if (y > 3 || y < 1 || x > 3 || x < 1) throw new IllegalArgumentException();
        if (gameField[x - 1][y - 1] != ' ') throw new IllegalArgumentException();
        gameField[x - 1][y - 1] = elem;
    }
}

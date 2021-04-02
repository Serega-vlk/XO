package model;

import java.util.ArrayList;

public class GameElem implements Comparable<GameElem> {
    final int x;
    final int y;
    final char elem;

    public GameElem(int x, int y, char elem) {
        this.x = x;
        this.y = y;
        this.elem = elem;
    }

    @Override
    public int compareTo(GameElem o) {
        if (Math.abs(this.x - o.x) > 1) return -1;
        if (Math.abs(this.y - o.y) > 1) return -1;
        if (this.x == o.x && this.y == o.y) return 0;
        else return 1;
    }

    public boolean isNearBy(GameElem o){
        return Math.abs(this.x - o.x) <= 1 && Math.abs(this.y - o.y) <= 1;
    }

    public static GameElem getNextElemByVector(ArrayList<GameElem> list, GameElem past, Vector to){
        GameElem next = new GameElem(past.x + to.dx, past.y + to.dy, past.elem);
        for (GameElem elem : list){
            if (elem.compareTo(next) == 0){
                return elem;
            }
        }
        return null;
    }
}

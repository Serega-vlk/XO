package model;

public enum Vector{
    Up(0, -1),
    Down(0, 1),
    Left(-1, 0),
    Right(1, 0),
    Up_Left(-1, -1),
    Up_Right(1, -1),
    Down_Left(-1, 1),
    Down_Right(1, 1),
    Point(0,0);

    int dx;
    int dy;

    Vector(int dx, int dy){
        this.dx = dx;
        this.dy = dy;
    }

    public static Vector getVector(GameElem a, GameElem b){
        if (b.x > a.x){
            if (b.y > a.y){
                return Down_Right;
            } else if (b.y == a.y){
                return Right;
            } else {
                return Up_Right;
            }
        } else if (b.x == a.x){
            if (b.y > a.y){
                return Down;
            } else if (b.y == a.y){
                return Point;
            } else {
                return Up;
            }
        } else {
            if (b.y > a.y){
                return Down_Left;
            } else if (b.y == a.y){
                return Left;
            } else {
                return Up_Left;
            }
        }
    }
}

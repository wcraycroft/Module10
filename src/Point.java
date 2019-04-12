
public class Point {

    private int mX;
    private int mY;

    public Point(int x, int y) {
        setX(x);
        setY(y);
    }

    public Point() {
        setX(0);
        setY(0);
    }

    public int getX() {
        return mX;
    }

    public void setX(int x) {
        mX = x;
    }

    public int getY() {
        return mY;
    }

    public void setY(int y) {
        mY = y;
    }

    public String toString() {
        return "Point{" +
                "x=" + mX +
                ", y=" + mY +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return mX == point.mX &&
                mY == point.mY;
    }

}

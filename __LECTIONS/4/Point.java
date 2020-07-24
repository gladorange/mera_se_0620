import java.text.ParsePosition;

public class Point {
    final int x;
    final int y;
    final int z;

    public Point() {
        this(1, 1, 1);
    }
   /*
   public Point() {
        this(1, 1,1);
    }*/

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public static void main(String[] args) {
        final Point p = new Point();
       // p = new Point(2, 2, 2);
        //p.x = 42;
        System.out.println(p);
/*
        final Point p2 = new Point(42, 42, 42);
        System.out.println(p2);*/
    }
}

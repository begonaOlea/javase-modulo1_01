package demo;

public class Punto implements Comparable<Punto> {

    private int x;
    private int y;
    private Colores color;

    public Punto(int x, int y, Colores color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Colores getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Punto{" + "x=" + x + ", y=" + y + ", color=" + color + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.x;
        hash = 59 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Punto other = (Punto) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Punto o) {

        int res = 0;

        int xComp = this.x - o.x;
        int yComp = this.y - o.y;

        if (xComp == 0 && yComp == 0) {
            res = 0;
        } else if (xComp != 0) {
            res = xComp;
        } else {
            res = yComp;
        }

        return res;

    }

}

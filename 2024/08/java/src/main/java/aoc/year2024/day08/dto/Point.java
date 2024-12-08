package aoc.year2024.day08.dto;

public record Point(int x, int y) {

    public Point plus(Point point) {
        return new Point(x + point.x, y + point.y);
    }

    public Point minus(Point point) {
        return new Point(x - point.x, y - point.y);
    }

    public Point multiply(int m) {
        return new Point(x * m, y * m);
    }

    public boolean withinBounds(int x1, int y1, int x2, int y2) {
        if (x < x1 || y < y1) return false;
        if (x >= x2 || y >= y2) return false;
        return true;
    }

    public boolean withinBounds(Rectangle bounds) {
        if (x < bounds.p1().x || y <  bounds.p1().y) return false;
        if (x >=  bounds.p2().x || y >=  bounds.p2().y) return false;
        return true;
    }
}

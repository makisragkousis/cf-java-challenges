package gr.aueb.cf.ch15;

public class Line extends AbstractShape{
    private double length;

    public Line() {}

    public Line(long id, double length) {
        super(id);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}

package gr.aueb.cf.ch15;

public abstract class AbstractShape implements IShape {
    private long id;

    public AbstractShape() {}

    public AbstractShape(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

package quadtree;

public abstract class Node {
    protected float xMin, yMin, xMax, yMax;

    public Node(float xMin, float yMin, float xMax, float yMax) {
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public abstract void insert(Rectangle rect);
    public abstract void delete(Rectangle rect);
    public abstract void update(Rectangle rect, float newX, float newY, float newWidth, float newHeight);
    public abstract void dump();
    public abstract Rectangle find(float x, float y);

    protected boolean contains(Rectangle rect) {
        return rect.getX() >= xMin && rect.getX() + rect.getWidth() <= xMax &&
               rect.getY() >= yMin && rect.getY() + rect.getHeight() <= yMax;
    }
}




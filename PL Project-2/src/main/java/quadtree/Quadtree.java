package quadtree;

public class Quadtree {
    private Node root;

    public Quadtree(float xMin, float yMin, float xMax, float yMax) {
        this.root = new LeafNode(xMin, yMin, xMax, yMax);
    }

    public void insert(Rectangle rect) {
        root.insert(rect);
    }

    public void delete(Rectangle rect) {
        root.delete(rect);
    }

    public void update(Rectangle rect, float newX, float newY, float newWidth, float newHeight) {
        root.update(rect, newX, newY, newWidth, newHeight);
    }

    public Rectangle find(float x, float y) {
        return root.find(x, y);
    }

    public void dump() {
        root.dump();
    }
}



package quadtree;

import java.util.ArrayList;

public class LeafNode extends Node {
    private ArrayList<Rectangle> rectangles = new ArrayList<>();
    private static final int MAX_CAPACITY = 5;

    public LeafNode(float xMin, float yMin, float xMax, float yMax) {
        super(xMin, yMin, xMax, yMax);
    }

    @Override
    public void insert(Rectangle rect) {
        if (contains(rect)) {
            rectangles.add(rect);
            if (rectangles.size() > MAX_CAPACITY) {
                split();
            }
        }
    }

    @Override
    public void delete(Rectangle rect) {
        rectangles.remove(rect);
        if (rectangles.isEmpty()) {
            revertToLeaf();  // Optionally handle reverting here if needed
        }
    }

    @Override
    public void update(Rectangle rect, float newX, float newY, float newWidth, float newHeight) {
        // First, we should ensure the rectangle exists in the node
        if (rectangles.contains(rect)) {
            delete(rect); // Remove the old rectangle
            rect.set(newX, newY, newWidth, newHeight); // Update its properties
            insert(rect); // Insert the updated rectangle back
            System.out.println("Updated and re-inserted rectangle: " + rect);
        } else {
            System.out.println("Rectangle not found for update.");
        }
    }

    @Override
    public void dump() {
        System.out.println("LeafNode: " + rectangles);
    }

    @Override
    public Rectangle find(float x, float y) {
        for (Rectangle rect : rectangles) {
            if (rect.contains(x, y)) {
                return rect;
            }
        }
        return null;
    }

    private void split() {
        InternalNode internal = new InternalNode(xMin, yMin, xMax, yMax);
        for (Rectangle r : rectangles) {
            internal.insert(r);
        }
        rectangles.clear(); // Clear the leaf's rectangles after splitting
    }

    private void revertToLeaf() {
        // Implement logic to revert an internal node to a leaf node when rectangles are deleted
    }

    public int getRectangleCount() {
        return rectangles.size(); // Return the current rectangle count
    }

    public Rectangle[] getRectangles() {
        return null;
    }
}

package quadtree;

public class InternalNode extends Node {
    private Node[] children;
    private static final int MAX_CAPACITY = 5;

    public InternalNode(float xMin, float yMin, float xMax, float yMax) {
        super(xMin, yMin, xMax, yMax);
        float midX = (xMin + xMax) / 2;
        float midY = (yMin + yMax) / 2;

        // Initialize the four children as LeafNodes
        children = new Node[4];
        children[0] = new LeafNode(xMin, yMin, midX, midY); // Bottom-left
        children[1] = new LeafNode(midX, yMin, xMax, midY); // Bottom-right
        children[2] = new LeafNode(xMin, midY, midX, yMax); // Top-left
        children[3] = new LeafNode(midX, midY, xMax, yMax); // Top-right
    }

    @Override
    public void insert(Rectangle rect) {
        for (Node child : children) {
            if (child.contains(rect)) {
                child.insert(rect);
                return;
            }
        }
    }

    @Override
    public void delete(Rectangle rect) {
        for (Node child : children) {
            child.delete(rect);
        }
        checkAndRevertToLeaf(); // Check if this node needs to be reverted to a leaf
    }

    @Override
    public void update(Rectangle rect, float newX, float newY, float newWidth, float newHeight) {
        for (Node child : children) {
            child.update(rect, newX, newY, newWidth, newHeight);
        }
    }

    @Override
    public void dump() {
        System.out.println("InternalNode:");
        for (Node child : children) {
            child.dump();
        }
    }

    @Override
    public Rectangle find(float x, float y) {
        for (Node child : children) {
            Rectangle found = child.find(x, y);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    private void checkAndRevertToLeaf() {
        // Count total rectangles in all child nodes
        int totalRectangles = 0;
        for (Node child : children) {
            if (child instanceof LeafNode) {
                totalRectangles += ((LeafNode) child).getRectangleCount(); // Get count of rectangles in LeafNode
            }
        }

        // If the total rectangle count is below the MAX_CAPACITY threshold, revert to a LeafNode
        if (totalRectangles <= MAX_CAPACITY) {
            LeafNode leaf = new LeafNode(xMin, yMin, xMax, yMax);
            for (Node child : children) {
                if (child instanceof LeafNode) {
                    for (Rectangle rect : ((LeafNode) child).getRectangles()) {
                        leaf.insert(rect); // Transfer rectangles back into a single LeafNode
                    }
                }
            }
            // Replace current children with the single LeafNode
            children = new Node[]{leaf};
        }
    }
}

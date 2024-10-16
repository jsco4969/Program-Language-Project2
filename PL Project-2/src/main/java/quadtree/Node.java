package quadtree;

public abstract class Node {
    // The x and y coordinates of the bottom-left corner of the node's bounding box.
    protected double x, y;
    // The width and height define the size of the node's bounding box.
    protected double width, height;


    // Constructor for the Node class, initializing its position and size.
    public Node(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    // Inserts a rectangle into the node. Depending on whether this node is a leaf or internal, it may store the rectangle or pass it on to one of its children.
    public abstract void insert(Rectangle rectangle);

    // Deletes a rectangle located at the specified (x, y) position from the node.The rectangle will either be deleted from this node or one of its children.
    public abstract void delete(double x, double y);

    // Finds a rectangle located at the specified (x, y) position. This search is typically recursive, passing through child nodes if necessary.
    public abstract Rectangle find(double x, double y);

    // Dumps a visual representation of the node structure, printing its children recursively. The level parameter indicates the depth of the node in the quadtree.
    //This method is used for debugging purposes to visualize the tree structure.
    public abstract void dump(int level);

    //Checks if the point (x2, y2) is contained within the node's bounding box.
    public boolean contains(double x2, double y2) {
        // Check if the point (x2, y2) falls within this node's bounding box.
        // This basic implementation just returns false and should be overridden by subclasses if needed.
        return false;
    }
}

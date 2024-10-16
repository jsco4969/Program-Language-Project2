package quadtree;

public class Quadtree {
    // Root node of the quadtree, which could be either a LeafNode or an InternalNode
    private Node root;



    // Constructor: Initializes the quadtree with a single root LeafNode that spans a 100x100 space.
    // The space is centered at (-50, -50) with width and height of 100 units.
    public Quadtree() {
        root = new LeafNode(-50, -50, 100, 100); // Initialize with 100x100 space
    }



    // Insert a new rectangle into the quadtree. The x and y parameters specify the bottom-left corner of the rectangle,
    // and the length and width define the size of the rectangle.
    public void insert(double x, double y, double length, double width) {
        // Create a new Rectangle object and pass it to the root node's insert method.
        root.insert(new Rectangle(x, y, length, width));
    }



    // Delete a rectangle from the quadtree based on its position. The x and y parameters represent the bottom-left corner of the rectangle.
    public void delete(double x, double y) {
        // Call the root node's delete method, passing the coordinates of the rectangle.
        root.delete(x, y);
    }



    // Find a rectangle in the quadtree based on a specific point. The x and y parameters represent the point we're looking for.
    // Returns the Rectangle object if found, otherwise null.
    public Rectangle find(double x, double y) {
        // Call the root node's find method to search for the rectangle at the given coordinates.
        return root.find(x, y);
    }



    // Dump the entire structure of the quadtree to the console, showing its hierarchy.
    // This method is useful for debugging and visualizing the tree.
    public void dump() {
        // Call the root node's dump method, starting at level 0 (the root level).
        root.dump(0);
    }


                    /**IMPORTANT CHANGE IF NO WORK (THE STEPS)*/

    // Update an existing rectangle in the quadtree with new dimensions. The x and y parameters represent the original bottom-left corner of the rectangle.
    public void update(double x, double y, double length, double width) {

    // Step 1: Find the existing rectangle at the given coordinates (x, y)
    Rectangle existingRectangle = find(x, y);
    
    // Step 2: If the rectangle is found, delete the old one
    if (existingRectangle != null) {
        delete(x, y);  // Remove the old rectangle
        
        // Step 3: Insert the updated rectangle with new dimensions
        insert(x, y, length, width);
        
        System.out.println("Rectangle updated at (" + x + ", " + y + ")");
    } else {
        System.out.println("No rectangle found at (" + x + ", " + y + ") to update.");
        }

    }


}

package quadtree;

import java.util.ArrayList;
import java.util.List;

public class LeafNode extends Node {
    private List<Rectangle> rectangles;  // List to store rectangles in this leaf node.

    //Constructor for creating a LeafNode.
    public LeafNode(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.rectangles = new ArrayList<>();  // Initialize the list of rectangles.
    }

    // Insert a rectangle into the leaf node. If the number of rectangles exceeds 5, this node converts into an InternalNode.
    @Override
    public void insert(Rectangle rectangle) {
        if (rectangles.size() < 5) {
            // If there's space, add the rectangle to the list.
            rectangles.add(rectangle);
        } else {
            // If the limit is reached, convert to an InternalNode.
            InternalNode internalNode = new InternalNode(x, y, width, height);
            
            // Transfer all current rectangles to the new InternalNode.
            for (Rectangle r : rectangles) {
                internalNode.insert(r);
            }
            
            // Insert the new rectangle into the InternalNode.
            internalNode.insert(rectangle);
        }
    }



    //Deletes a rectangle from the node based on the (x, y) point. The method checks if any rectangle contains the given point.
    @Override
    public void delete(double x, double y) {
        // Remove the rectangle if it's area contains the (x, y) point.
        rectangles.removeIf(r -> r.containsPoint(x, y));
    }



    //Finds and returns the first rectangle in this node that contains the (x, y) point.
    @Override
    public Rectangle find(double x, double y) {
        // Use Java Streams to filter rectangles by whether they contain the point.
        return rectangles.stream()
                .filter(r -> r.containsPoint(x, y))
                .findFirst()  // Return the first matching rectangle, or null if none found.
                .orElse(null);
    }



    //Outputs the structure of this leaf node and it's rectangles in a formatted way. This method is useful for debugging and visualizing the quadtree.
    @Override
    public void dump(int level) {
        // Print the description of the LeafNode with indentation based on its level in the tree.
        System.out.println("\t".repeat(level) + "Leaf Node - Rectangle at (" + x + ", " + y + "): " + width + "x" + height);
        
        // Print each rectangle stored in this LeafNode.
        for (Rectangle rectangle : rectangles) {
            System.out.println("\t".repeat(level + 1) + rectangle);
        }
    }
}

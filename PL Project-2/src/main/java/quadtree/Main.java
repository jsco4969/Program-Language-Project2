package quadtree;

public class Main {
    public static void main(String[] args) {
        Quadtree quadtree = new Quadtree(-50, -50, 50, 50);
        Rectangle rect1 = new Rectangle(10, 10, 30, 30);
        Rectangle rect2 = new Rectangle(60, 60, 10, 10);

        quadtree.insert(rect1);
        quadtree.insert(rect2);

        quadtree.dump(); // Show the current state of the Quadtree

        Rectangle found = quadtree.find(65, 65);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("No rectangle found at the given point.");
        }

        quadtree.update(rect1, 50, 50, 20, 20);
        quadtree.dump(); // After updating
    }
}



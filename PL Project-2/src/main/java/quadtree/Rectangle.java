package quadtree;

public class Rectangle {
    private float x, y, width, height;

    public Rectangle(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public float getX() { return x; }
    public float getY() { return y; }
    public float getWidth() { return width; }
    public float getHeight() { return height; }

    public void set(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean contains(float x, float y) {
        float epsilon = 0.0001f; // Tolerance for floating-point comparison
        return (x >= this.x - epsilon && x <= this.x + this.width + epsilon &&
                y >= this.y - epsilon && y <= this.y + this.height + epsilon);
    }
    

    public boolean contains(Rectangle other) {
        return other.x >= this.x && other.x + other.width <= this.x + this.width &&
               other.y >= this.y && other.y + other.height <= this.y + this.height;
    }

    @Override
    public String toString() {
        return String.format("Rectangle[x=%.2f, y=%.2f, width=%.2f, height=%.2f]", x, y, width, height);
    }
}



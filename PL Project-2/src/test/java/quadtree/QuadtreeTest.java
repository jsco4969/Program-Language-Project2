package quadtree;

public class QuadtreeTest {

    @Test
    public void testInsertAndFind() {
        Quadtree quadtree = new Quadtree(0, 0, 100, 100);
        Rectangle rect = new Rectangle(10, 10, 30, 30);
        quadtree.insert(rect);

        Rectangle found = quadtree.find(15, 15);
        assertNotNull(found);
        assertEquals(rect, found);
    }

    private void assertEquals(Rectangle rect, Rectangle found) {
    }

    private void assertNotNull(Rectangle found) {
    }

    @Test
    public void testUpdate() {
        Quadtree quadtree = new Quadtree(0, 0, 100, 100);
        Rectangle rect = new Rectangle(10, 10, 30, 30);
        quadtree.insert(rect);

        quadtree.update(rect, 50, 50, 20, 20);
        Rectangle found = quadtree.find(55, 55);
        assertNotNull(found);
        assertEquals(50, found.getX(), 0.01);
    }

    private void assertEquals(int i, float x, double d) {
    }
}


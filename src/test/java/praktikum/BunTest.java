package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void bunShouldReturnCorrectName() {
        Bun bun = new Bun("white bun", 2.0f);

        assertEquals("white bun", bun.getName());
    }

    @Test
    public void bunShouldReturnCorrectPrice() {
        Bun bun = new Bun("black bun", 3.5f);

        assertEquals(3.5f, bun.getPrice(), 0.0001f);
    }
}

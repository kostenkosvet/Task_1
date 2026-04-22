package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseTest {
    @Test
    public void shouldReturnCorrectNumberOfBuns() {
        Database db = new Database();

        assertEquals(3, db.availableBuns().size());
    }

    @Test
    public void shouldReturnCorrectNumberOfIngredients() {
        Database db = new Database();

        assertEquals(6, db.availableIngredients().size());
    }

    @Test
    public void shouldContainCorrectBuns() {
        Database db = new Database();

        assertEquals("black bun", db.availableBuns().get(0).getName());
        assertEquals(100f, db.availableBuns().get(0).getPrice(), 0.0001f);

        assertEquals("white bun", db.availableBuns().get(1).getName());
        assertEquals("red bun", db.availableBuns().get(2).getName());
    }

    @Test
    public void shouldContainCorrectIngredients() {
        Database db = new Database();

        Ingredient first = db.availableIngredients().get(0);

        assertEquals(IngredientType.SAUCE, first.getType());
        assertEquals("hot sauce", first.getName());
        assertEquals(100f, first.getPrice(), 0.0001f);
    }

    @Test
    public void shouldContainBothSauceAndFilling() {
        Database db = new Database();

        boolean hasSauce = false;
        boolean hasFilling = false;

        for (Ingredient ingredient : db.availableIngredients()) {
            if (ingredient.getType() == IngredientType.SAUCE) {
                hasSauce = true;
            }
            if (ingredient.getType() == IngredientType.FILLING) {
                hasFilling = true;
            }
        }

        assertTrue(hasSauce);
        assertTrue(hasFilling);
    }
}

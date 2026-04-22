package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void burgerShouldSetBun() {
        Bun bun = new Bun("black bun", 2.0f);

        Burger burger = new Burger();
        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    public void burgerShouldAddIngredient() {
        burger.addIngredient(ingredient1);

        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void burgerShouldAddIngredients() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void burgerShouldRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void burgerShouldMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);

        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void burgerShouldCalculatePriceCorrectly() {
        when(bun.getPrice()).thenReturn(2.0f);

        when(ingredient1.getPrice()).thenReturn(1.5f);
        when(ingredient2.getPrice()).thenReturn(2.5f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float price = burger.getPrice();

        assertEquals(2.0f * 2 + 1.5f + 2.5f, price, 0.0001f);
    }

    @Test
    public void burgerShouldReturnCorrectReceipt() {
        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(2.0f);

        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("ketchup");
        when(ingredient1.getPrice()).thenReturn(1.0f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        String receipt = burger.getReceipt();

        assertTrue(receipt.contains("(==== black bun ====)"));
        assertTrue(receipt.contains("= sauce ketchup ="));
        assertTrue(receipt.contains("Price:"));
    }
}

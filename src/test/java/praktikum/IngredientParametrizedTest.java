package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParametrizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "ketchup", 1.5f},
                {IngredientType.FILLING, "cheese", 2.0f},
                {IngredientType.SAUCE, "bbq", 2.5f}
        });
    }

    @Test
    public void ingredientShouldReturnCorrectType() {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(type, ingredient.getType());

    }

    @Test
    public void ingredientShouldReturnCorrectName() {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(name, ingredient.getName());
    }

    @Test
    public void ingredientShouldReturnCorrectPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(price, ingredient.getPrice(), 0.0001f);
    }
}

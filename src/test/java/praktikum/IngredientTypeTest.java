package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String expectedName;
    private final IngredientType ingredientType;

    public IngredientTypeTest(String expectedName, IngredientType ingredientType) {
        this.expectedName = expectedName;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        IngredientType[] values = IngredientType.values();

        return Arrays.asList(new Object[][]{
                {"SAUCE", values[0]},
                {"FILLING", values[1]}
        });
    }

    @Test
    public void enumShouldContainCorrectValueLength() {
        IngredientType[] values = IngredientType.values();

        assertEquals(2, values.length);
    }

    @Test
    public void enumShouldReturnCorrectName() {
        assertEquals(expectedName, ingredientType.name());
    }


}

package colorbusterdev;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TileTest {

    @Test
    public void testGetColor() {
        // Create a new Tile object with a specific color
        String expectedColor = "red";
        Tile tile = new Tile(expectedColor);

        // Call the getColor method and verify that it returns the expected color
        String actualColor = tile.getColor();
        assertEquals(expectedColor, actualColor);
    }
} 
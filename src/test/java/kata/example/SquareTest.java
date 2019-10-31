package kata.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void shouldReturnTheSide() {
        Square square = new Square(2);
        assertEquals(square.side(), 2);
    }

    @Test
    void theHeightShouldBeEqualToTheSide() {
        Square square = new Square(2);
        assertEquals(square.getHeight(), 2);
    }

    @Test
    void shouldReturnThePerimeter() {
        Square square = new Square(2);
        assertEquals(square.perimeter(), 8);
    }

    @Test
    void shouldReturnTheArea() {
        Square square = new Square(2);
        assertEquals(square.area(), 4);
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class StringCalculatorShould {
    @Test
    void print_zero_when_receiving_an_empty_character() {
        String character = "";
        int mathOperation = StringCalculator.Add(character);
        Assertions.assertEquals(0,  mathOperation);
    }

}
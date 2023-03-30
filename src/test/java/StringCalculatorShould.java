import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class StringCalculatorShould {
    @Test
    void print_zero_when_receiving_an_empty_character() {
        String character = "";
        int mathOperation = StringCalculator.Add(character);
        Assertions.assertEquals(0,  mathOperation);
    }

    @Test
    void print_the_same_number() {
        String number = "1";
        int mathOperation  = StringCalculator.Add(number);
        Assertions.assertEquals(1,mathOperation);
    }

    @Test
    void print_sum_of_the_numbers() {
        String numbers = "1,2,3,4";
        int mathOperation = StringCalculator.Add(numbers);
        Assertions.assertEquals(10,mathOperation);
    }

    @Test
    void print_sum_of_numbers_without_line_break() {
        var number = "1\n2\n3";
        int mathOperation = StringCalculator.Add(number);
        Assertions.assertEquals(6, mathOperation);
    }

}
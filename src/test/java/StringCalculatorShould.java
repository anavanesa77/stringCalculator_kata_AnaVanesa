import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


class StringCalculatorShould {
    @Test
    void print_zero_when_receiving_an_empty_character() throws NegativeNumberException {
        String character = "";
        int mathOperation = StringCalculator.Add(character);
        Assertions.assertEquals(0, mathOperation);
    }

    @Test
    void print_the_same_number() throws NegativeNumberException {
        String number = "1";
        int mathOperation = StringCalculator.Add(number);
        Assertions.assertEquals(1, mathOperation);
    }

    @Test
    void print_sum_of_the_numbers() throws NegativeNumberException {
        String numbers = "1,2,3,4";
        int mathOperation = StringCalculator.Add(numbers);
        Assertions.assertEquals(10, mathOperation);
    }

    @Test
    void print_sum_of_numbers_without_line_break() throws NegativeNumberException {
        var number = "1\n2\n3";
        int mathOperation = StringCalculator.Add(number);
        Assertions.assertEquals(6, mathOperation);
    }

    @Test
    void print_sum_of_numbers_with_any_delimiter() throws NegativeNumberException {
        var number = "//;\n1;2";
        int mathOperation = StringCalculator.Add(number);
        Assertions.assertEquals(3, mathOperation);
    }

    @Test
    void print_exception_if_there_are_negative_numbers() {
        var errorMessage = "error: negatives not allowed -1 -2";
        NegativeNumberException capturedExcepcion = assertThrows(NegativeNumberException.class, () ->
                StringCalculator.Add("//;\n-1;-2"));
        Assertions.assertEquals(errorMessage, capturedExcepcion.getMessage());
    }
}
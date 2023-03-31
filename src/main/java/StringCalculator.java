import javax.naming.directory.Attribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringCalculator {
    public static int Add(String numbers) throws NegativeNumberException {
        if (numbers.equals("")) {
            return 0;
        }

        if (numbers.startsWith("/")) {
            var delimiter = numbers.substring(2, 3);
            var sumOfNumbers = extractNumbersWithDelimiter(numbers, delimiter);
            executeErrorIfThereAreNegativeNumbers(sumOfNumbers);
            return addNumbers(sumOfNumbers);
        }
        var sumOfNumbers = extractNumbersWithoutDelimiter(numbers);
        executeErrorIfThereAreNegativeNumbers(sumOfNumbers);
        return addNumbers(sumOfNumbers);
    }

    private static Integer addNumbers(List<Integer> operationNumbers) {
        var suma = operationNumbers.stream().reduce(0, Integer::sum);
        var longitud = Integer.toString(suma).length();
        var sumaMil = 0;
        if (longitud >= 4) {
            for (int i = 0; i < longitud; i++) {
                String sumaNumero = String.valueOf(Integer.toString(suma).charAt(i));
                sumaMil += Integer.parseInt((sumaNumero));
            }
            System.out.println(sumaMil);
            return sumaMil;
        }
        return suma;
    }

    private static List<Integer> extractNumbersWithDelimiter(String text, String delimiter) {
        var textOperationNumbers = List.of(text.substring(4).split(delimiter));
        return textOperationNumbers.stream().map(Integer::valueOf).toList();
    }

    private static List<Integer> extractNumbersWithoutDelimiter(String text) {
        var textOperationNumbers = List.of(text.replaceAll("\n", ",").split(","));
        return textOperationNumbers.stream().map(Integer::valueOf).toList();
    }

    private static List<Integer> extractListNegativeNumber(List<Integer> operationNumbers) {
        List negativeNumbers = new ArrayList();
        for (int numbers : operationNumbers) {
            if (numbers < 0) {
                negativeNumbers.add(numbers);
            }
        }
        return negativeNumbers;
    }

    private static void failIfThereAreNegativeNumbers(List<Integer> negativeNumbers) throws NegativeNumberException {
        if (!negativeNumbers.isEmpty()) {
            var errorMessage = createErrorMessage(negativeNumbers);
            throw new NegativeNumberException(errorMessage);
        }
    }

    private static String createErrorMessage(List<Integer> negativeNumbers) {
        var errorMessage = "error: negatives not allowed";
        for (int number : negativeNumbers) {
            if (number < 0) {
                errorMessage = errorMessage + (" ") + number;
            }
        }
        return errorMessage;

    }

    private static void executeErrorIfThereAreNegativeNumbers(List<Integer> sumOfNumbers) throws NegativeNumberException {
        var negativeNumbers = extractListNegativeNumber(sumOfNumbers);
        failIfThereAreNegativeNumbers(negativeNumbers);
    }

}


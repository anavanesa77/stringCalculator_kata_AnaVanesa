import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static int Add(String numbers) throws NegativeNumberException {
        if (numbers.equals("")) {
            return 0;
        }
        if (numbers.startsWith("/")) {
            var delimiter = numbers.substring(2, 3);
            var sumOfNumbers = extractNumbersWithDelimiter(numbers, delimiter);
            var negativeNumbers = extractListNegativeNumber(sumOfNumbers);
            failIfThereAreNegativeNumbers(negativeNumbers);
            return toAddNumbers(sumOfNumbers);
        }
        var sumOfNumbers = extractNumbersWithoutDelimiter(numbers);
        var negativeNumbers = extractListNegativeNumber(sumOfNumbers);
        failIfThereAreNegativeNumbers(negativeNumbers);
        return toAddNumbers(sumOfNumbers);
    }
    private static List<Integer> extractNumbersWithoutDelimiter(String text) {
        var textOperationNumbers = List.of(text.replaceAll("\n", ",").split(","));
        return textOperationNumbers.stream().map(Integer::valueOf).toList();
    }
    private static Integer toAddNumbers(List<Integer> operationNumbers) {
        return operationNumbers.stream().reduce(0, Integer::sum);
    }
    private static List<Integer> extractNumbersWithDelimiter(String text, String delimiter) {
        var textNumbers = List.of(text.substring(4).split(delimiter));
        return textNumbers.stream().map(Integer::valueOf).toList();
    }
    private static List<Integer> extractListNegativeNumber(List<Integer> operationNumbers) throws NegativeNumberException {
        List negativeNumbers = new ArrayList();
        for (int numbers : operationNumbers) {
            if (numbers < 0) {
                negativeNumbers.add(numbers);
            }
        }
        return negativeNumbers;
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
    private static void failIfThereAreNegativeNumbers(List<Integer> negativeNumbers) throws NegativeNumberException {
        if (!negativeNumbers.isEmpty()) {
            var errorMessage = createErrorMessage(negativeNumbers);
            throw new NegativeNumberException(errorMessage);
        }
    }
}


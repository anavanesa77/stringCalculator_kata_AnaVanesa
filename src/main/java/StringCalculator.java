import java.util.List;

public class StringCalculator {
    public static int Add(String numbers) {
        if (numbers.equals("")) {
            return 0;
        }
        var sumOfNumbers = extractNumbers(numbers);
        return  toAddNumbers(sumOfNumbers);
    }

    private static List<Integer> extractNumbers(String text) {
        var textOperationNumbers = List.of(text.replaceAll("\n",",").split(","));
        return textOperationNumbers.stream().map(Integer::valueOf).toList();
    }

    private static Integer toAddNumbers(List<Integer> operationNumbers) {
        return operationNumbers.stream().reduce(0, Integer::sum);

    }

}


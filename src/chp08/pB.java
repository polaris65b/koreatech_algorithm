package chp08;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class pB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();  // 테스트케이스 개수

        while (T-- > 0) {
            int N = scanner.nextInt();  // 정수의 개수
            String[] numbers = readNumbers(scanner, N);
            sortNumbers(numbers);
            String result = buildLargestNumber(numbers);
            System.out.println(removeLeadingZeros(result));
        }
        scanner.close();
    }

    private static String[] readNumbers(Scanner scanner, int N) {
        String[] numbers = new String[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.next();
        }
        return numbers;
    }

    private static void sortNumbers(String[] numbers) {
        Arrays.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });
    }

    private static String buildLargestNumber(String[] numbers) {
        StringBuilder result = new StringBuilder();
        for (String number : numbers) {
            result.append(number);
        }
        return result.toString();
    }

    private static String removeLeadingZeros(String result) {
        return result.replaceAll("^0+", "0");
    }
}
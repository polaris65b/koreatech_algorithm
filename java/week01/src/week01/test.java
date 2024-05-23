package week01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();
        
        for(int i = 0; i < T; i++) {
        	String input = s.nextLine();
            String[] numbersAsString = input.split(" ");
            int[] numbers = new int[numbersAsString.length];

            for(int j = 0; j < numbersAsString.length; j++) {
                numbers[j] = Integer.parseInt(numbersAsString[i]);
            }

            // Find harmonic subsequences
            List<List<Integer>> harmonicSubsequences = findHarmonicSubsequences(numbers);

            // Print the harmonic subsequences
            System.out.println("Harmonic Subsequences:");
            for (List<Integer> subsequence : harmonicSubsequences) {
                System.out.println(subsequence);
            }
        }
        s.close();
    }

    public static List<List<Integer>> findHarmonicSubsequences(int[] numbers) {
        List<List<Integer>> harmonicSubsequences = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            int min = numbers[i];
            int max = numbers[i];
            
            List<Integer> subsequence = new ArrayList<>();
            subsequence.add(numbers[i]);

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == min + 1 || numbers[j] == max - 1) {
                    subsequence.add(numbers[j]);
                    min = Math.min(min, numbers[j]);
                    max = Math.max(max, numbers[j]);
                }
            }

            if (subsequence.size() > 1 && Math.abs(min - max) == 1) {
                harmonicSubsequences.add(subsequence);
            }
        }

        return harmonicSubsequences;
    }
}

package week02;


import java.util.ArrayList;
import java.util.Scanner;

public class pd {
    static boolean isPossible = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int t = 0; t < T; t++) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int[] numbers = new int[N];

            for (int i = 0; i < N; i++)
                numbers[i] = scanner.nextInt();

            ArrayList<Integer> combination = new ArrayList<>();
            isPossible = false;
            findCombination(M, numbers, combination, 0);

            if (!isPossible)
                System.out.println(-1);
        }
        scanner.close();
    }

    public static void findCombination(int M, int[] numbers, ArrayList<Integer> combination, int start) {
        if (M == 0) {
            isPossible = true;
            for (int num : combination)
                System.out.print(num + " ");
            System.out.println();
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            if (M - numbers[i] >= 0) {
                combination.add(numbers[i]);
                findCombination(M - numbers[i], numbers, combination, i);
                combination.remove(combination.size() - 1);
                if (isPossible)
                	return;
            }
        }
    }
}
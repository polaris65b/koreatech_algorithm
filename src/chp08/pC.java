package chp08;

import java.util.Arrays;
import java.util.Scanner;

public class pC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int[] prices = new int[N];

            for (int i = 0; i < N; i++)
                prices[i] = scanner.nextInt();

            System.out.println(maxCandies(prices, M));
        }
        scanner.close();
    }

    private static int maxCandies(int[] prices, int budget) {
        Arrays.sort(prices);
        int count = 0;

        for (int price : prices) {
            if (budget - price >= 0) {
                budget -= price;
                count++;
            }
            else	break;
        }

        return count;
    }
}
package week01;

import java.util.Scanner;

public class ta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[] seq = new int[2000001];

            for (int i = 0; i < N; i++) {
                int num = scanner.nextInt();
                seq[num + 1000000]++;
            }

            int max = find(seq);

            System.out.println(max);
        }

        scanner.close();
    }

    public static int find(int[] seq) {
        int max = 0;

        for (int i = 0; i < seq.length - 1; i++) {
            if (seq[i] > 0 && seq[i + 1] > 0)
                max = Math.max(max, seq[i] + seq[i + 1]);
        }

        return max;
    }
}
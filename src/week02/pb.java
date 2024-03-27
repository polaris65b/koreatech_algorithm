package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[] numbers = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                numbers[i] = Integer.parseInt(st.nextToken());

            System.out.println(canSum(M, numbers));
        }
    }

    public static boolean canSum(int M, int[] numbers) {
        if (M == 0)
            return true;
        if (M < 0)
            return false;
        for (int num : numbers) {
            if (canSum(M - num, numbers)) {
                return true;
            }
        }
        return false;
    }
}
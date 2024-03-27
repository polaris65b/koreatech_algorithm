package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class pe {
    private static int[] bestSum(int target, int[] numbers) {
        int[] memo[] = new int[target + 1][];
        return bestSumHelper(target, numbers, memo);
    }

    private static int[] bestSumHelper(int target, int[] numbers, int[][] memo) {
        if (target == 0) return new int[0];
        if (target < 0) return null;
        if (memo[target] != null) return memo[target];

        int[] shortestCombination = null;

        for (int num : numbers) {
            int remainder = target - num;
            int[] remainderCombination = bestSumHelper(remainder, numbers, memo);
            if (remainderCombination != null) {
                int[] combination = new int[remainderCombination.length + 1];
                System.arraycopy(remainderCombination, 0, combination, 0, remainderCombination.length);
                combination[combination.length - 1] = num;
                
                if (shortestCombination == null || combination.length < shortestCombination.length)
                    shortestCombination = combination;
            }
        }
        memo[target] = shortestCombination;
        return shortestCombination;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[] numbers = new int[N];
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < N; i++)
                numbers[i] = Integer.parseInt(st.nextToken());

            int[] result = bestSum(M, numbers);
            if (result != null) {
                bw.write(result.length + " ");
                
                for (int num : result)
                    bw.write(num + " ");
                
                bw.newLine();
                
            }
            else
                bw.write("-1\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

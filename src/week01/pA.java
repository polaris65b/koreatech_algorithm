package week01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class pA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int max = find(seq);

            bw.write(max + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int[] seq) {
        int max = 0;

    	Arrays.sort(seq);

        for (int i = 0; i < seq.length - 1; i++) {
            int cnt = 0;
            for (int j = i + 1; j < seq.length; j++) {
                if (Math.abs(seq[i] - seq[j]) == 1) {
                    cnt = j - i + 1;
                }
            }
            max = Math.max(max, cnt);
        }

        return max;
    }
}

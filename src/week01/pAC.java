package week01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class pAC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] seq = new int[2000001];


            String[] input = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(input[i]);
                seq[num + 1000000]++;
            }

            int max = find(seq);

            bw.write(max + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int[] seq) {
        int max = 0;

        for (int i = 0; i < seq.length - 1; i++) {
            if (seq[i] > 0 && seq[i + 1] > 0) {
                max = Math.max(max, seq[i] + seq[i + 1]);
            }
        }

        return max;
    }
}

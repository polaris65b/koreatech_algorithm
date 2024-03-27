package week02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class pc {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 목표 정수
            int N = Integer.parseInt(st.nextToken()); // 숫자 배열의 길이
            int[] numbers = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken()); // 숫자 입력 받기
            }

            int result = findWays(M, numbers);
            bw.write(result + "\n");
        }
        bw.flush(); // 출력 버퍼를 비움
        br.close();
        bw.close();
    }

    public static int findWays(int M, int[] numbers) {
        int[] dp = new int[M + 1];
        dp[0] = 1; // 0을 만드는 방법은 아무것도 선택하지 않는 1가지 방법뿐임

        for (int num : numbers) {
            for (int i = num; i <= M; i++) {
                dp[i] += dp[i - num];
            }
        }

        return dp[M];
    }
}

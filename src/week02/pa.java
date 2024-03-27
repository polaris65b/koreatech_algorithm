package week02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class pa {
    static int H, W, ans;
    static int[][] map;
    static int[][][] block = { 
        { { 0, 0 }, { 0, 1 }, { 1, 1 } }, 
        { { 0, 0 }, { 0, 1 }, { 1, 0 } },
        { { 0, 0 }, { 1, 0 }, { 1, 1 } }, 
        { { 0, 0 }, { 1, 0 }, { 1, -1 } }, 
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < C; tc++) {
            String[] inputHW = br.readLine().split(" ");
            H = Integer.parseInt(inputHW[0]);
            W = Integer.parseInt(inputHW[1]);

            map = new int[H][W];
            int cnt = 0;
            for (int i = 0; i < H; i++) {
                String input = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = input.charAt(j) == '.' ? 0 : 1;
                    if (map[i][j] == 0)
                        cnt++;
                }
            }

            if (cnt % 3 != 0) {
                bw.write("0\n");
            } else {
                ans = 0;
                solve(cnt);
                bw.write(ans + "\n");
            }
        }
        bw.flush();
    }

    private static void solve(int cnt) throws IOException {
        if (cnt == 0) {
            ans++;
            return;
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        if (check(k, i, j)) {
                            set(k, i, j, 1);
                            solve(cnt - 3);
                            set(k, i, j, 0);
                        }
                    }
                    return;
                }
            }
        }
    }

    private static void set(int k, int r, int c, int v) {
        for (int i = 0; i < 3; i++) {
            int nexRow = r + block[k][i][0];
            int nextCol = c + block[k][i][1];
            map[nexRow][nextCol] = v;
        }
    }

    private static boolean check(int k, int r, int c) {
        for (int i = 0; i < 3; i++) {
            int nextRow = r + block[k][i][0];
            int nextCol = c + block[k][i][1];
            if (!isRange(nextRow, nextCol) || map[nextRow][nextCol] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isRange(int nextRow, int nextCol) {
        return 0 <= nextRow && nextRow < H && 0 <= nextCol && nextCol < W;
    }
}

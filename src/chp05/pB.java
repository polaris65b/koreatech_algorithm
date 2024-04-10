package chp05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

public class pB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        Random rand = new Random();
        
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] nums = new int[N];
            
            for (int i = 0; i < N; i++)
                nums[i] = Integer.parseInt(input[i]);

            
            while (true) {
                int candidate = nums[rand.nextInt(N)];
                int count = 0;
                
                for (int num : nums)
                    if (num == candidate) count++;

                if (count > N / 2) {
                    System.out.println(candidate);
                    break;
                }
            }
        }
    }
}

package chp06;

import java.util.Scanner;

public class pA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); 
        
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); 
            int[] A = new int[N];
            
            for (int i = 0; i < N; i++)
                A[i] = scanner.nextInt();
            
            int max, min;
            
            if (A[0] < A[1]) {
                max = A[1];
                min = A[0];
            }
            else {
                max = A[0];
                min = A[1];
            }
            
            if (N % 2 != 0) {
                if (A[N-1] > max) max = A[N-1];
                if (A[N-1] < min) min = A[N-1];
            }
            
            for (int i = 2; i < N - 1; i += 2) {
                if (A[i] < A[i+1]) {
                    if (A[i] < min)
                    	min = A[i];
                    if (A[i+1] > max)
                    	max = A[i+1];
                }
                else {
                    if (A[i+1] < min)
                    	min = A[i+1];
                    if (A[i] > max)
                    	max = A[i];
                }
            }
            
            System.out.println(max + " " + min);
        }
        
        scanner.close();
    }
}

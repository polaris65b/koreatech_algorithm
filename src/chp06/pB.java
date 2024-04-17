package chp06;

import java.util.Scanner;

public class pB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); 
        
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); 
            int[] A = new int[N];
            
            for (int i = 0; i < N; i++)
                A[i] = scanner.nextInt();
            
            int max, secondMax;
            
            if (A[0] < A[1]) {
                max = A[1];
                secondMax = A[0];
            }
            else {
                max = A[0];
                secondMax = A[1];
            }
            
            for (int i = 2; i < N; i++) {
                if (A[i] > max) {
                    secondMax = max;
                    max = A[i];
                }
                else if (A[i] > secondMax && A[i] != max) {
                    secondMax = A[i];
                }
            }
            
            System.out.println(secondMax);
        }
        
        scanner.close();
    }
}
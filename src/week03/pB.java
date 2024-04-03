package week03;

import java.util.Scanner;

public class pB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        while (T-- > 0) {
            String S = scanner.nextLine();
            int k = Integer.parseInt(scanner.nextLine());
            System.out.println(findLongestSubstringLength(S, k));
        }
        scanner.close();
    }

    private static int findLongestSubstringLength(String s, int k) {
        if (s.length() < k)
        	return 0;
        
        return divideAndConquer(s, 0, s.length(), k);
    }

    private static int divideAndConquer(String s, int start, int end, int k) {
        if (end - start < k) 
        	return 0;

        int[] counts = new int[26];
        for (int i = start; i < end; i++)
            counts[s.charAt(i) - 'a']++;
        

        for (int i = start; i < end; i++) {
            if (counts[s.charAt(i) - 'a'] < k) {
                int leftPartLength = divideAndConquer(s, start, i, k);
                int rightPartLength = divideAndConquer(s, i + 1, end, k);
                
                return Math.max(leftPartLength, rightPartLength);
            }
        }
        return end - start;
    }
}
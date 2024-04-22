package midt;

import java.util.Scanner;

public class kt {
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
    // 주어진 문자열에서 k번 이상 등장하는 문자로 이루어진 가장 긴 부분 문자열의 길이를 찾는 메서드
    private static int findLongestSubstringLength(String s, int k) {
        if (s.length() < k) return 0; // 문자열의 길이가 k보다 작으면 0 반환
        return divideAndConquer(s, 0, s.length(), k); // 분할 정복 방식을 사용하여 길이를 계산
    }
    // 분할 정복 방식으로 주어진 범위에서 가장 긴 부분 문자열의 길이를 찾는 메서드
    private static int divideAndConquer(String s, int start, int end, int k) {
        if (end - start < k)  return 0; // 주어진 범위의 길이가 k보다 작으면 0 반환
        int[] counts = new int[26]; // 알파벳별 등장 횟수를 저장할 배열
        for (int i = start; i < end; i++) counts[s.charAt(i) - 'a']++; // 주어진 범위 내에서 각 알파벳의 등장 횟수를 계산

        for (int i = start; i < end; i++) {
            if (counts[s.charAt(i) - 'a'] < k) {
                // k번 미만으로 등장하는 알파벳을 기준으로 문자열을 나눔
                int leftPartLength = divideAndConquer(s, start, i, k); // 왼쪽 부분 문자열의 최대 길이를 계산
                int rightPartLength = divideAndConquer(s, i + 1, end, k); // 오른쪽 부분 문자열의 최대 길이를 계산
                return Math.max(leftPartLength, rightPartLength); // 두 부분 중 더 긴 부분의 길이를 반환
            }
        }
        return end - start; // 모든 문자가 k번 이상 등장하면 현재 범위의 길이를 반환
    }
}
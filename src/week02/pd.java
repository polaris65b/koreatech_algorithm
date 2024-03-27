package week02;


import java.util.ArrayList;
import java.util.Scanner;

public class pd {
    static boolean isPossible = false; // 목표 정수를 만들 수 있는지 여부를 저장하는 변수

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스의 수

        for (int t = 0; t < T; t++) {
            int M = scanner.nextInt(); // 목표 정수
            int N = scanner.nextInt(); // 배열의 길이
            int[] numbers = new int[N];

            for (int i = 0; i < N; i++) {
                numbers[i] = scanner.nextInt(); // 숫자 입력 받기
            }

            ArrayList<Integer> combination = new ArrayList<>(); // 현재 조합을 저장할 리스트
            isPossible = false; // 이 테스트 케이스에 대해 가능 여부 초기화
            findCombination(M, numbers, combination, 0);

            if (!isPossible) {
                System.out.println(-1); // 만들 수 없는 경우 -1 출력
            }
        }
        scanner.close();
    }

    // 목표 정수 M을 만들 수 있는 조합을 찾는 재귀 함수
    public static void findCombination(int M, int[] numbers, ArrayList<Integer> combination, int start) {
        if (M == 0) {
            isPossible = true; // 목표 정수를 만들었으므로 true로 설정
            for (int num : combination) { // 조합 출력
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            if (M - numbers[i] >= 0) { // 현재 숫자를 포함시켜도 목표 정수를 초과하지 않는 경우
                combination.add(numbers[i]);
                findCombination(M - numbers[i], numbers, combination, i); // 현재 숫자 포함 재귀 호출
                combination.remove(combination.size() - 1); // 다음 탐색을 위해 마지막 숫자 제거
                if (isPossible) return; // 하나의 조합을 찾으면 더 이상 탐색 중단
            }
        }
    }
}
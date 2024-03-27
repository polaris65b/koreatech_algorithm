package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class pc {

    static boolean found = false; // 목표 정수를 만들 수 있는지 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            found = false; // 각 테스트 케이스마다 found 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 목표 정수
            int N = Integer.parseInt(st.nextToken()); // 주어진 숫자의 개수

            int[] numbers = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken()); // 숫자 읽기
            }

            findCombination(M, numbers, new ArrayList<>());
            if (!found) {
                System.out.println(-1);
            }
        }
    }

    // 목표 정수 M을 만들 수 있는 조합을 찾는 함수
    public static void findCombination(int M, int[] numbers, ArrayList<Integer> combination) {
        if (M == 0) { // 목표 정수를 만들 수 있으면
            found = true; // 찾았다고 표시
            System.out.print(combination.size() + " "); // 조합을 구성하는 수의 개수 출력
            for (int num : combination) {
                System.out.print(num + " "); // 조합 출력
            }
            System.out.println();
            return;
        }
        if (M < 0 || found) { // 목표 정수를 초과하거나 이미 찾은 경우
            return;
        }
        for (int num : numbers) {
            ArrayList<Integer> newCombination = new ArrayList<>(combination); // 새 조합 생성
            newCombination.add(num); // 현재 숫자 추가
            findCombination(M - num, numbers, newCombination); // 재귀 호출
            if (found) return; // 하나의 조합을 찾으면 탐색 종료
        }
    }
}
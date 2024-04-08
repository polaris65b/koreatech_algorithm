package week02;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class pf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            List<Integer> digits = new ArrayList<>();
            for (int i = 0; i < N; i++)
                digits.add(scanner.nextInt());
            
            Collections.sort(digits);
            Set<Integer> evenNumbers = new HashSet<>();

            for (int i = 0; i < digits.size(); i++) {
                if (digits.get(i) == 0) continue; // 첫 번째 자리에 0을 배제
                for (int j = 0; j < digits.size(); j++) {
                    if (i == j) continue;
                    for (int k = 0; k < digits.size(); k++) {
                        if (k == j || k == i) continue;
                        if (digits.get(k) % 2 == 0) { // 마지막 자리가 짝수인지 확인
                            int num = digits.get(i) * 100 + digits.get(j) * 10 + digits.get(k);
                            evenNumbers.add(num);
                        }
                    }
                }
            }

            List<Integer> sortedNumbers = new ArrayList<>(evenNumbers);
            Collections.sort(sortedNumbers);

            for (int num : sortedNumbers)
                System.out.print(num + " ");
            
            System.out.println();
        }

        scanner.close();
    }
}
# 독특한 공통 부분 문자열 수
def count_subsequences(A, B):
    m, n = len(A), len(B)
    dp = [[0] * (n + 1) for _ in range(m + 1)]

    for i in range(m + 1):
        dp[i][0] = 1

    for i in range(1, m + 1):
        for j in range(1, n + 1):
            dp[i][j] = dp[i - 1][j]
            if A[i - 1] == B[j - 1]:
                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % 1000000007

    return dp[m][n]

def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    
    index = 0
    T = int(data[index])
    index += 1
    results = []

    for _ in range(T):
        A = data[index]
        B = data[index + 1]
        index += 2
        result = count_subsequences(A, B)
        results.append(result)

    for result in results:
        print(result)

if __name__ == "__main__":
    main()


"""
독특한 공통 부분 문자열 수

문제 설명
두 개의 영소문자로 구성된 문자열 A와 B가 주어집니다.
A 문자열에 B 문자열이 몇 번 나타나는지 찾아주세요.
B 문자열이 연속해서 나타날 필요는 없지만 순서는 유지해야 합니다.
예를 들어, A = "csecse"이고 B = "cse"이면 "cse***", "cs***e", "c***se", "***cse", 총 4번 나타납니다.

입력 설명
첫 줄에는 테스트케이스 T(1<=T<=100)가 주어집니다.
각 테스트케이스는 두 줄로 주어집니다.
각 테스트케이스의 첫 줄에는 문자열 A(1<=len(A)<=1,000)가 주어지고, 둘째 줄에는 문자열 B(1<=len(B)<=1,000)가 주어집니다.
두 문자열은 모두 영소문자로만 구성되어 있습니다.

출력 설명
각 테스트케이스마다 B 문자열이 A에 부분 문자열로 몇 번 등장하는지 출력하여 주세요.
너무 많이 등장할 수 있으므로 결과 값을 1,000,000,007로 나누었을 때, 나머지를 대신 출력하여 주세요.

입력 예시
2
appple
apple
csecse
cse

출력 예시
3
4
입출력은 터미널창에서 확인 바로 가능하게
"""
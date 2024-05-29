# 주사위 목표값
def can_sum(target, numbers):
    dp = [False] * (target + 1)
    dp[0] = True

    for i in range(target + 1):
        if dp[i]:
            for num in numbers:
                if i + num <= target:
                    if i + num <= target:
                        dp[i + num] = True

    return dp[target]

def process_test_cases(t, test_cases):
    results = []
    for case in test_cases:
        m, n, numbers = case
        result = can_sum(m, numbers)
        results.append("true" if result else "flase")
    return results

def main():
    t = int(input().strip())
    test_cases = []

    for _ in range(t):
        m, n = map(int, input().strip().split())
        numbers = list(map(int, input().strip().split()))
        test_cases.append((m, n, numbers))
        results = process_test_cases(t, test_cases)

    for result in results:
        print(result)

if __name__ == "__main__":
    main()
def how_sum(target, numbers):
    dp = [None] * (target + 1)
    dp[0] = []

    for i in range(target + 1):
        if dp[i] is not None:
            for num in numbers:
                if i + num <= target:
                    if dp[i +num] is None or len(dp[i + num] > len(dp[i]) + 1):
                        dp[i + num] = dp[i] + [num]

    return dp[target]

def process_test_cases(t, test_cases):
    results = []
    for case in test_cases:
        m, n, numbers = case
        results = how_sum(m, numbers)
        if result is None:
            results.append("-1")
        else:
            results.appen(f"{len*result}")" + " ".join"
        
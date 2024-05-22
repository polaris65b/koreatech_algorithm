# 테뷸레이션
def knapsack_tabulation(W, items):
    n = len(items)
    dp = [[0 for _ in range(W + 1)] for _ in range(n + 1)]
    
    for i in range(1, n + 1):
        value, weight = items[i - 1]
        for w in range(W + 1):
            if weight <= w:
                dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weight] + value)
            else:
                dp[i][w] = dp[i - 1][w]
    
    return dp[n][W]

def solve_test_cases_tab():
    import sys
    input = sys.stdin.read
    data = input().split()
    
    index = 0
    T = int(data[index])
    index += 1
    results = []
    
    for _ in range(T):
        W = int(data[index])
        N = int(data[index + 1])
        index += 2
        items = []
        for _ in range(N):
            value = int(data[index])
            weight = int(data[index + 1])
            items.append((value, weight))
            index += 2
        
        result = knapsack_tabulation(W, items)
        results.append(result)
    
    for result in results:
        print(result)

if __name__ == "__main__":
    solve_test_cases_tab()
def knapsack(W, N, items):
    dp = [0] * (W + 1)
    
    for i in range(N):
        v, w = items[i]
        for j in range(W, w - 1, -1):
            dp[j] = max(dp[j], dp[j - w] + v)
    
    return dp[W]

def main():
    T = int(input().strip())
    results = []
    
    for _ in range(T):
        W, N = map(int, input().strip().split())
        items = []
        values_and_weights = list(map(int, input().strip().split()))
        
        for i in range(N):
            v = values_and_weights[2 * i]
            w = values_and_weights[2 * i + 1]
            items.append((v, w))
        
        result = knapsack(W, N, items)
        results.append(result)
    
    for result in results:
        print(result)

if __name__ == "__main__":
    main()

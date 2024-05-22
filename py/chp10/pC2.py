#테뷸레이션
def can_partition_tabulation(nums):
    total_sum = sum(nums)
    if total_sum % 2 != 0:
        return False
    target = total_sum // 2
    
    dp = [False] * (target + 1)
    dp[0] = True
    
    for num in nums:
        for i in range(target, num - 1, -1):
            dp[i] = dp[i] or dp[i - num]
    
    return dp[target]

def solve_test_cases_tab():
    import sys
    input = sys.stdin.read
    data = input().split()
    
    index = 0
    T = int(data[index])
    index += 1
    results = []
    
    for _ in range(T):
        N = int(data[index])
        index += 1
        nums = list(map(int, data[index:index + N]))
        index += N
        
        result = can_partition_tabulation(nums)
        results.append("true" if result else "false")
    
    for result in results:
        print(result)

if __name__ == "__main__":
    solve_test_cases_tab()
# 메모이제이션
def can_sum_memo(m, nums, memo=None):
    if memo is None:
        memo = {}
    if m in memo:
        return memo[m]
    if m == 0:
        return True
    if m < 0:
        return False
    
    for num in nums:
        remainder = m - num
        if can_sum_memo(remainder, nums, memo):
            memo[m] = True
            return True
    
    memo[m] = False
    return False

def solve_test_cases_memo():
    import sys
    
    T = int(input().strip())
    results = []
    
    for _ in range(T):
        M, N = map(int, input().strip().split())
        nums = list(map(int, input().strip().split()))
        
        result = can_sum_memo(M, nums)
        results.append(result)
    
    for result in results:
        print("true" if result else "false")

if __name__ == "__main__":
    solve_test_cases_memo()
# 메모이제이션
def how_sum_memo(m, nums, memo=None):
    if memo is None:
        memo = {}
    if m in memo:
        return memo[m]
    if m == 0:
        return []
    if m < 0:
        return None
    
    for num in nums:
        remainder = m - num
        result = how_sum_memo(remainder, nums, memo)
        if result is not None:
            memo[m] = result + [num]
            return memo[m]
    
    memo[m] = None
    return None

def solve_test_cases_memo():
    import sys
    input = sys.stdin.read
    data = input().split()
    
    index = 0
    T = int(data[index])
    index += 1
    results = []
    
    for _ in range(T):
        M = int(data[index])
        N = int(data[index + 1])
        index += 2
        nums = list(map(int, data[index:index + N]))
        index += N
        
        result = how_sum_memo(M, nums)
        if result is not None:
            results.append(f"{len(result)} " + " ".join(map(str, result)))
        else:
            results.append("-1")
    
    for result in results:
        print(result)

if __name__ == "__main__":
    solve_test_cases_memo()
# 테뷸레이션
def can_sum_tabulation(m, nums):
    table = [False] * (m + 1)
    table[0] = True
    
    for i in range(m + 1):
        if table[i]:
            for num in nums:
                if i + num <= m:
                    table[i + num] = True
    
    return table[m]

def solve_test_cases_tab():
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
        
        result = can_sum_tabulation(M, nums)
        results.append(result)
    
    for result in results:
        print("true" if result else "false")

if __name__ == "__main__":
    solve_test_cases_tab()
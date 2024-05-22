# 테뷸레이션
def how_sum_tabulation(m, nums):
    table = [None] * (m + 1)
    table[0] = []
    
    for i in range(m + 1):
        if table[i] is not None:
            for num in nums:
                if i + num <= m:
                    if table[i + num] is None or len(table[i + num]) > len(table[i]) + 1:
                        table[i + num] = table[i] + [num]
    
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
        
        result = how_sum_tabulation(M, nums)
        if result is not None:
            results.append(f"{len(result)} " + " ".join(map(str, result)))
        else:
            results.append("-1")
    
    for result in results:
        print(result)

if __name__ == "__main__":
    solve_test_cases_tab()
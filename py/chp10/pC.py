# 메모이제이션
def can_partition_memo(nums):
    total_sum = sum(nums)
    if total_sum % 2 != 0:
        return False
    target = total_sum // 2
    
    memo = {}
    
    def can_partition_recursive(current_index, current_sum):
        if current_sum == target:
            return True
        if current_sum > target or current_index >= len(nums):
            return False
        if (current_index, current_sum) in memo:
            return memo[(current_index, current_sum)]
        
        include_current = can_partition_recursive(current_index + 1, current_sum + nums[current_index])
        exclude_current = can_partition_recursive(current_index + 1, current_sum)
        
        memo[(current_index, current_sum)] = include_current or exclude_current
        return memo[(current_index, current_sum)]
    
    return can_partition_recursive(0, 0)

def solve_test_cases_memo():
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
        
        result = can_partition_memo(nums)
        results.append("true" if result else "false")
    
    for result in results:
        print(result)

if __name__ == "__main__":
    solve_test_cases_memo()
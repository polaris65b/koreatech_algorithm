def bestsum(m, A):
    if m < 0:
        return None
    if m == 0:
        return []
    best = None
    for x in A:
        result = bestsum(m - x, A)
        if result is not None:
            combination = result + [x]
            if best is None or len(combination) < len(best):
                best = combination
    return best

# 예제 실행
m = 7
A = [5, 3, 4, 7]
result = bestsum(m, A)
print(result)

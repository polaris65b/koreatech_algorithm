def floyd_warshall(n, edges):
    INF = float('inf')
    dist = [[INF] * n for _ in range(n)]
    
    for i in range(n):
        dist[i][i] = 0
    
    for u, v, w in edges:
        dist[u][v] = w
    
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if dist[i][k] < INF and dist[k][j] < INF:
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
    
    for i in range(n):
        if dist[i][i] < 0:
            return -1, None
    
    max_dist = -INF
    start = end = -1
    for i in range(n):
        for j in range(n):
            if i != j and dist[i][j] < INF and dist[i][j] > max_dist:
                max_dist = dist[i][j]
                start = i
                end = j
    
    return max_dist, (start, end, max_dist)

def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    
    index = 0
    t = int(data[index])
    index += 1
    results = []

    for _ in range(t):
        n = int(data[index])
        e = int(data[index + 1])
        index += 2
        edges = []
        for _ in range(e):
            u = int(data[index])
            v = int(data[index + 1])
            w = int(data[index + 2])
            edges.append((u, v, w))
            index += 3
        
        max_dist, result = floyd_warshall(n, edges)
        if max_dist == -1:
            results.append("-1")
        else:
            results.append(f"{result[0]} {result[1]} {result[2]}")
    
    for result in results:
        print(result)

if __name__ == "__main__":
    main()

"""
중복 문자 제거하기

문제 설명
영소문자로만 구성된 문자열이 주어집니다. 이 문자열에서 중복된 문자를 제거하여 각 문자가 하나만 등장하도록 바꾸어 주세요. 가능한 것이 여러 개 있으면 사전 순서 상에서 가장 앞에 오는 문자열로 만들어 주세요. 예를 들어 "bcabc"가 주어지면 각 문자가 정확하게 하나만 남도록 중복된 문자를 제거한 결과로 "bca", "cab", "bac", "abc"를 얻을 수 있는데, 이 중 "abc"가 사전 순서에서 가장 앞에 등장하므로 "abc"를 결과로 주어야 합니다.

입력 설명
첫 줄에는 테스트케이스 T(1<=T<=1,000)가 주어집니다. 각 테스트케이스는 한 줄로 주어지며, 각 줄에는 영소문자로만 구성된 문자열 S(1<=len(S)<=10,000)가 하나 주어집니다.
출력 설명

각 테스트케이스마다 등장하는 문자가 하나만 있도록 나머지 중복된 문자를 제거한 문자열을 출력합니다. 출력하는 문자열은 가능한 것 중 사전 순서 상에 제일 앞에 오는 것이어야 합니다. 
입력 예시

2
bcabc
cbacdcbc

출력 예시
abc
acdb
"""
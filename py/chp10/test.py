def floyd_warshall(n, edges):
    # 무한대를 나타내는 큰 값
    INF = float('inf')
    
    # 거리 행렬 초기화
    dist = [[INF] * n for _ in range(n)]
    
    # 자기 자신으로 가는 거리는 0으로 설정
    for i in range(n):
        dist[i][i] = 0
    
    # 간선 정보로 거리 행렬 초기화
    for (u, v, w) in edges:
        dist[u][v] = w
    
    # Floyd-Warshall 알고리즘 수행
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if dist[i][j] > dist[i][k] + dist[k][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]
    
    # 음의 사이클 확인
    for i in range(n):
        if dist[i][i] < 0:
            return -1, None
    
    # 최단 경로 중 가장 먼 경로 찾기
    max_dist = -INF
    start = end = -1
    for i in range(n):
        for j in range(n):
            if i != j and dist[i][j] < INF:
                if dist[i][j] > max_dist:
                    max_dist = dist[i][j]
                    start, end = i, j
    
    return max_dist, (start, end, max_dist)

def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    
    index = 0
    T = int(data[index])
    index += 1
    results = []
    
    for _ in range(T):
        N = int(data[index])
        E = int(data[index + 1])
        index += 2
        
        edges = []
        for _ in range(E):
            S = int(data[index])
            D = int(data[index + 1])
            W = int(data[index + 2])
            edges.append((S, D, W))
            index += 3
        
        result = floyd_warshall(N, edges)
        if result[0] == -1:
            results.append("-1")
        else:
            results.append(f"{result[1][0]} {result[1][1]} {result[1][2]}")
    
    for res in results:
        print(res)

if __name__ == "__main__":
    main()
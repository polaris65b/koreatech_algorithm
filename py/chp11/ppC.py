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
    T = int(input().strip())
    results = []

    for _ in range(T):
        n, e = map(int, input().strip().split())
        edges = []
        edge_data = list(map(int, input().strip().split()))
        for i in range(e):
            u = edge_data[i*3]
            v = edge_data[i*3 + 1]
            w = edge_data[i*3 + 2]
            edges.append((u, v, w))
        
        max_dist, result = floyd_warshall(n, edges)
        if max_dist == -1:
            results.append("-1")
        else:
            results.append(f"{result[0]} {result[1]} {result[2]}")

    for result in results:
        print(result)

if __name__ == "__main__":
    main()
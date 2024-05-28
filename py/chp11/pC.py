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
    
    max_dist = 0
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
    data = input().strip().split()
    
    idx = 0
    T = int(data[idx])
    idx += 1

    for _ in range(T):
        n = int(data[idx])
        e = int(data[idx + 1])
        idx += 2
        edges = []
        for _ in range(e):
            u = int(data[idx])
            v = int(data[idx + 1])
            w = int(data[idx + 2])
            edges.append((u, v, w))
            idx += 3
        
        max_dist, result = floyd_warshall(n, edges)
        if max_dist == -1:
            print("-1")
        else:
            print(f"{result[0]} {result[1]} {result[2]}")

if __name__ == "__main__":
    main()

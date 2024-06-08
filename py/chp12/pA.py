def promising(row, x, col):
    for i in range(x):
        if row[i] == col or abs(row[i] - col) == abs(i - x):
            return False
    return True

def print_Queens(row, n):
    for i in range(n):
        for j in range(n):
            if row[i] == j:
                print('Q', end='')
            else:
                print('X', end='')
        print()

def n_Queens(row, n, x):
    if x == n:
        print_Queens(row, n)
        return 1
    
    count = 0
    for i in range(n):
        if promising(row, x, i):
            row[x] = i
            count += n_Queens(row, n, x+1)
            
    return count
    

def main():
    Tcase = int(input())
    for _ in range(Tcase):
        Chess_size = int(input())
        row = [0] * Chess_size
        if n_Queens(row, Chess_size, 0) == 0 : print()

if __name__ == "__main__":
    main()

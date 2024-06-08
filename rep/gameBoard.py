def countWhiteCells(board):
    count = 0
    for row in board:
        count += row.count('.')
    return count

def findNextWhiteCell(board, startR, startC):
    for r in range(startR, len(board)):
        for c in range(startC, len(board[0])):
            if board[r][c] == '.':
                return r, c
    return -1, -1

def canPlace(board, r, c, shape):
    for dr, dc in shape:
        nr, nc = r + dr, c + dc
        if nr < 0 or nr >= len(board) or nc < 0 or nc >= len(board[0]) or board[nr][nc] != '.':
            return False
    return True

def placeShape(board, r, c, shape):
    for dr, dc in shape:
        board[r + dr][c + dc] = '#'

def removeShape(board, r, c, shape):
    for dr, dc in shape:
        board[r + dr][c + dc] = '.'

LShapes = [
    [(0, 0), (1, 0), (0, 1)],
    [(0, 0), (0, 1), (1, 1)],
    [(0, 0), (1, 0), (1, -1)],
    [(0, 0), (0, 1), (-1, 1)]
]

def coverCount(H, W, board):
    if countWhiteCells(board) % 3 != 0:
        return 0
    return coverCountRec(H, W, board, 0, 0)

def coverCountRec(H, W, board, startR, startC):
    nextR, nextC = findNextWhiteCell(board, startR, startC)
    if nextR == -1:
        return 1
    count = 0
    for shape in LShapes:
        if canPlace(board, nextR, nextC, shape):
            placeShape(board, nextR, nextC, shape)
            count += coverCountRec(H, W, board, nextR, nextC)
            removeShape(board, nextR, nextC, shape)
    return count

# 예제 실행
H = 3
W = 7
board = [
    ['#', '.', '.', '#', '.', '.', '#'],
    ['#', '.', '.', '.', '.', '#', '#'],
    ['#', '#', '.', '#', '.', '.', '.']
]

result = coverCount(H, W, board)
print(result)
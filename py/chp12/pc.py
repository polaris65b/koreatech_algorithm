import sys
input = sys.stdin.readline

class TreeNode:
    def __init__(self, value=0):
        self.value = value
        self.left = None
        self.right = None

def construct_tree(nodes, index=0):
    if index >= len(nodes) or nodes[index] == 0:
        return None
    
    node = TreeNode(nodes[index])
    node.left = construct_tree(nodes, 2 * index + 1)
    node.right = construct_tree(nodes, 2 * index + 2)
    return node

def find_paths(node, current_sum, target):
    if not node:
        return 0
    
    current_sum += node.value
    if not node.left and not node.right:
        return 1 if current_sum == target else 0
    
    return find_paths(node.left, current_sum, target) + find_paths(node.right, current_sum, target)

def path_sum(target, nodes):
    root = construct_tree(nodes)
    return find_paths(root, 0, target)

def main():
    T = int(input().strip())
    results = []
    
    for _ in range(T):
        W, M = map(int, input().strip().split())
        nodes = list(map(int, input().strip().split()))
        result = path_sum(W, nodes)
        print(result)

if __name__ == "__main__":
    main()
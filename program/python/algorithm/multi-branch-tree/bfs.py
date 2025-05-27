from collections import deque

#         A
#      /  |  \
#     B   C   D
#         /\
#        E  F

class Node:
    def __init__(self, val) -> None:
        self.val = val
        self.children = []


def bfs(root):
    """
    BFS(Breadth-First Search，广度优先搜索)：先访问根节点，再访问它的所有子节点，再访问它们的子节点...依次向下。
    通常用队列（Queue）来实现。
    :param root:
    :return:
    """
    if not root:
        return
    queue = deque([root])
    while queue:
        node = queue.popleft()
        print(node.val)
        for child in node.children:
            queue.append(child)


if __name__ == '__main__':
    A = Node('A')
    B = Node('B')
    C = Node('C')
    D = Node('D')
    E = Node('E')
    F = Node('F')

    A.children = [B, C, D]
    C.children = [E, F]

    bfs(A)
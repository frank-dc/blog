#         A
#      /  |  \
#     B   C   D
#         /\
#        E  F


class Node:
    def __init__(self, val) -> None:
        self.val = val
        self.children = []

def dfs(node):
    """
    DFS(Deepth-First Search，深度优先搜索):从当前节点开始，尽可能往深走，直到不能再往下走了，再回头。
    通常用递归或栈来实现。
    :param node:
    :return:
    """
    if not node:
        return
    print(node.val)
    for child in node.children:
        dfs(child)


if __name__ == '__main__':
    A = Node('A')
    B = Node('B')
    C = Node('C')
    D = Node('D')
    E = Node('E')
    F = Node('F')

    A.children = [B, C, D]
    C.children = [E, F]

    dfs(A)
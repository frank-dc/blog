def fib(n):
    # 返回斐波拉契数列第 n 位的值，使用递归。
    # [1, 1, 2, 3, 5, 8, 13, 21, ...]
    if n == 1 or n == 2:
        return 1
    else:
        return fib(n - 1) + fib(n - 2)


def fib1(n):
    # 返回斐波拉契数列第 n 位的值，使用迭代。
    # [1, 1, 2, 3, 5, 8, 13, 21, ...]
    fib_data = [1, 1]
    if n == 1 or n == 2:
        return fib_data[n - 1]
    else:
        for i in range(2, n):
            fib_data.append(fib_data[i - 1] + fib_data[i - 2])
        return fib_data[n - 1]


def fib2(n):
    # 返回斐波拉契数列第 n 位的值，使用迭代。
    # [1, 1, 2, 3, 5, 8, 13, 21, ...]
    a, b = 1, 1
    for i in range(n - 1):
        a, b = b, a + b
    return a

def fib_sum(n):
    # 获取前 n 位的斐波拉契数列及其和。
    # [1, 1, 2, 3, 5, 8, 13, 21, ...]
    fib_data = [1, 1]
    if n == 1 or n == 2:
        return sum(fib_data[:n]), fib_data[:n]
    else:
        for i in range(2, n):
            fib_data.append(fib_data[i - 1] + fib_data[i - 2])
        return sum(fib_data[:n]), fib_data[:n]


print(fib(5))
print(fib1(5))
print(fib2(5))
print(fib_sum(5))


def main(arrays):
    for i in range(0, len(arrays)):
        for j in range(0, len(arrays) - i - 1):
            if arrays[j] > arrays[j + 1]:
                arrays[j], arrays[j + 1] = arrays[j + 1], arrays[j]
    return arrays


def optimized_main(arrays):
    n = len(arrays)
    for i in range(0, n):
        print(i)
        swapped = False # 标志位：记录本轮是否发生交换
        for j in range(0, n - i - 1):
            if arrays[j] > arrays[j + 1]:
                # 交换相邻元素
                arrays[j], arrays[j + 1] = arrays[j + 1], arrays[j]
                swapped = True  # 发生了交换
        if not swapped:
            # 如果一整轮都没有交换，说明已经有序，提前结束
            break
    return arrays



if __name__ == '__main__':
    data = [0, 4, 0, 10, 10, 8, 2, 6, 4, 2]
    print(main(data))
    data1 = [0, 1, 2, 3, 4, 5, 6, 7, 10, 9]
    print(optimized_main(data1))
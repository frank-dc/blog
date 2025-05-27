def bubble_sort(arrays) -> list:
    """
    冒泡排序（Bubble Sort）的特点是相邻元素比较并交换，让大的元素一步步“冒泡”到右边。
    :param arrays:
    :return:
    """
    for i in range(len(arrays)):
        for j in range(len(arrays) - i - 1):
            if arrays[j] > arrays[j + 1]:
                arrays[j], arrays[j + 1] = arrays[j + 1], arrays[j]
    return arrays


def insertion_sort(arrays) -> list:
    for i in range(1, len(arrays)):
        key = arrays[i]
        j = i - 1
        while j >= 0 and key < arrays[j]:
            arrays[j + 1] = arrays[j]
            j -= 1
        arrays[j + 1] = key
    return arrays


def quick_sort(arrays) -> list:
    if len(arrays) <= 1:
        return arrays
    else:
        pivot = arrays[0]
        lesser = [x for x in arrays[1:] if x <= pivot]
        greater = [x for x in arrays[1:] if x > pivot]
        return quick_sort(lesser) + [pivot] + quick_sort(greater)


def selection_sort(arrays) -> list:
    for i in range(len(arrays)):
        min_index = i
        for j in range(i + 1, len(arrays)):
            if arrays[j] < arrays[min_index]:
                min_index = j
        arrays[i], arrays[min_index] = arrays[min_index], arrays[i]
    return arrays


if __name__ == '__main__':
    arrays = [5, 2, 9, 1, 5, 6]
    print(bubble_sort(arrays))
def quick_sort(array, low, high):
    if low < high:
        q = partition(array, low, high)
        quick_sort(array, low, q - 1)
        quick_sort(array, q + 1, high)
    return array


def partition(array, low, high):
    x = array[high]
    i = low - 1
    for j in range(low, high):
        if array[j] <= x:
            i += 1
            array[i], array[j] = array[j], array[i]
    array[i + 1], array[high] = array[high], array[i + 1]
    return i + 1


if __name__ == '__main__':
    data = [0, 4, 0, 10, 10, 8, 2, 6, 4, 2]
    print(quick_sort(data, 0, len(data) - 1))
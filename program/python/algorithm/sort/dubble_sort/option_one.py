def dubble_sort(array):
    for i in range(len(array) - 1):
        for j in range(i + 1, len(array)):
            if array[i] > array[j]:
                array[i], array[j] = array[j], array[i]
    return array


if __name__ == '__main__':
    data = [0, 4, 0, 10, 10, 8, 2, 6, 4, 2]
    print(dubble_sort(data))
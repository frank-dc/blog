def insertion_sort(array):
    for i in range(1, len(array)):
        j = i
        while j > 0 and array[j - 1] > array[i]:
            j -= 1
        array.insert(j, array[i])
        array.pop(i + 1)
    return array


if __name__ == '__main__':
    data = [0, 4, 0, 10, 10, 8, 2, 6, 4, 2]
    print(insertion_sort(data))
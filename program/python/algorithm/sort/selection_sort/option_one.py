def main(array):
    for i in range(len(array) - 1):
        min_idx = i
        for j in range(i + 1, len(array)):
            if array[j] < array[min_idx]:
                min_idx = j
        if min_idx != i:
            array[min_idx], array[i] = array[i], array[min_idx]
    return array


if __name__ == '__main__':
    data = [0, 4, 0, 10, 10, 8, 2, 6, 4, 2]
    print(main(data))
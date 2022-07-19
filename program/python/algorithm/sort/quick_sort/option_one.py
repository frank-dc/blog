def quick_sort(array, low, high):
    if low < high:
        key_index = partition(array, low, high)
        quick_sort(array, low, key_index - 1)
        quick_sort(array, key_index + 1, high)
    return array


def partition(array, low, high):
    k = array[low]
    while low < high:
        while low < high and array[high] >= k:
            high -= 1
        array[low], array[high] = array[high], array[low]

        while low < high and array[low] <= k:
            low += 1
        array[low], array[high] = array[high], array[low]
    return low
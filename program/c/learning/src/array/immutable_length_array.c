#include <stdio.h>

int sum_array(int [], int);
int sum_two_dimensional_array(int [][4], int);

int main(void) {
    int a[] = {3, 5, 7, 8, 9};
    int sum_oda = sum_array(a, 5);
    printf("SumOneDimensionalArray: %d\n", sum_oda);

    int b[2][4] = {
            {1, 2, 3, 4},
            {8, 9, 10, 11}
    };
    int sum_tda = sum_two_dimensional_array(b, 2);

    printf("SumTwoDimensionalArray: %d\n", sum_tda);
}

int sum_array(int a[], int n) {
    int total = 0;
    for (int i = 0; i < n; i++) {
        total += a[i];
    }
    return total;
}

int sum_two_dimensional_array(int b[][4], int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 4; j++) {
            sum += b[i][j];
        }
    }
    return sum;
}

package com.lisi4ka.part2;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Извлечение элементов из кучи по одному
        for (int i = n - 1; i > 0; i--) {
            // Перемещаем текущий корень в конец
            swap(arr, 0, i);

            // Вызываем heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int heapSize, int rootIndex) {
        int largest = rootIndex;  // Инициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        // Если левый дочерний элемент больше корня
        if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // Если самый большой элемент не корень
        if (largest != rootIndex) {
            swap(arr, rootIndex, largest);

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, heapSize, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Исходный массив: " + Arrays.toString(arr));

        heapSort(arr);

        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }


}

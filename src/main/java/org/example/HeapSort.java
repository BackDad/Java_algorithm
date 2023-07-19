package org.example;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] array) {
        int n = array.length;

        // Построение кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i > 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }

    // Преобразование поддерева с корнем в позиции i в максимальную кучу
    private static void heapify(int[] array, int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int left = 2 * i + 1; // Левый дочерний элемент
        int right = 2 * i + 2; // Правый дочерний элемент

        // Если левый дочерний элемент больше корня
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // Если правый дочерний элемент больше, чем наибольший элемент на данный момент
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // Если наибольший элемент не является корнем
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Рекурсивно вызываем heapify для поддерева
            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        // Пример использования пирамидальной сортировки

        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Исходный массив: " + Arrays.toString(arr1));
        heapSort(arr1);
        System.out.println("Отсортированный массив: " + Arrays.toString(arr1));

        int[] arr2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Исходный массив: " + Arrays.toString(arr2));
        heapSort(arr2);
        System.out.println("Отсортированный массив: " + Arrays.toString(arr2));
    }
}

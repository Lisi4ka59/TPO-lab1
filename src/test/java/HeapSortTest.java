import com.lisi4ka.part2.HeapSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class HeapSortTest {

    @Test
    void testTwoElementsArray() {
        int[] arr = {5, 2};
        HeapSort.heapSort(arr);
        int[] expected = {2, 5};
        assertArrayEquals(expected, arr, "Сортировка массива из двух элементов не удалась");
    }

    @Test
    void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        HeapSort.heapSort(arr);
        int[] expected = {1, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(expected, arr, "Сортировка уже отсортированного массива не удалась");
    }

    @Test
    void testRandomArray() {
        int[] arr = {12, 7, 5, 19, 1, 3};
        HeapSort.heapSort(arr);
        int[] expected = {1, 3, 5, 7, 12, 19};
        assertArrayEquals(expected, arr, "Сортировка рандомного массива не удалась");
    }

    @Test
    void testHeapSort() {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int[] expected = {5, 6, 7, 11, 12, 13};

        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr, "Массив должен быть отсортирован по возрастанию");
    }

    @Test
    void testHeapSortWithDuplicates() {
        int[] arr = {4, 10, 4, 3, 1, 10};
        int[] expected = {1, 3, 4, 4, 10, 10};

        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr, "Массив с дубликатами должен быть отсортирован корректно");
    }

    @Test
    void testHeapSortReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr, "Обратный порядок должен быть отсортирован по возрастанию");
    }

    @Test
    void testHeapSortSingleElement() {
        int[] arr = {42};
        int[] expected = {42};

        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr, "Массив из одного элемента должен остаться неизменным");
    }

    @Test
    void testHeapSortEmptyArray() {
        int[] arr = {};
        int[] expected = {};

        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr, "Пустой массив должен остаться пустым");
    }

    @Test
    void testHeapify() {
        int[] arr = {4, 10, 3, 5, 1};
        int[] expected = {10, 5, 3, 4, 1};

        HeapSortTestWrapper.heapify(arr, arr.length, 0);
        assertArrayEquals(expected, arr, "После heapify корень должен быть самым большим элементом");
    }

    @Test
    void testSwap() {
        int[] arr = {1, 2, 3};
        HeapSortTestWrapper.swap(arr, 0, 2);
        assertArrayEquals(new int[]{3, 2, 1}, arr, "Должен произойти обмен элементов в массиве");
    }

    @Test
    void testIdealHeapSort() {
        int[] arr = {926, 97, 435, 359, 701, 85, 39, 402, 381, 390, 157, 213, 144, 667, 620, 81, 820, 145, 52, 812, 374, 960, 501, 679, 225, 356, 508, 163, 398, 755, 146};
        int[] expected = {39, 52, 81, 85, 97, 144, 145, 146, 157, 163, 213, 225, 356, 359, 374, 381, 390, 398, 402, 435, 501, 508, 620, 667, 679, 701, 755, 812, 820, 926, 960};

        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr, "Массив должен быть отсортирован по возрастанию");
    }

    static class HeapSortTestWrapper {
        static void heapify(int[] arr, int heapSize, int rootIndex) {
            try {
                var method = HeapSort.class.getDeclaredMethod("heapify", int[].class, int.class, int.class);
                method.setAccessible(true);
                method.invoke(null, arr, heapSize, rootIndex);
            } catch (Exception e) {
                fail("Ошибка доступа к heapify: " + e.getMessage());
            }
        }

        static void swap(int[] arr, int i, int j) {
            try {
                var method = HeapSort.class.getDeclaredMethod("swap", int[].class, int.class, int.class);
                method.setAccessible(true);
                method.invoke(null, arr, i, j);
            } catch (Exception e) {
                fail("Ошибка доступа к swap: " + e.getMessage());
            }
        }
    }
}

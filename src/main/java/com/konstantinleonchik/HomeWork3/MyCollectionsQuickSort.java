package com.konstantinleonchik.HomeWork3;

import java.util.Comparator;

public class MyCollectionsQuickSort<T> {

    /**
     * Метод сортировки, принимает список любого типа и сортирует его.
     *
     * @param MyList     - мой список
     * @param comparator - интерфейс для сравнения объектов
     * @param <T>        - обобщенный тип
     */
    public static <T> void qSort(MyList<T> MyList, Comparator<T> comparator) {
        int low = 0;
        int high = MyList.size() - 1;
        quickSort(MyList, low, high, comparator);
    }


    /**
     * Вспомогательный метод для метода sort с использованием рекурсии
     *
     * @param MyList     - мой список передаваемый из метода sort
     * @param low        - первый элемент
     * @param high       - последний элемент списка
     * @param comparator - интерфейс для сравнения объектов
     * @param <T>        обобщенный тип
     */
    private static <T> void quickSort(MyList<T> MyList, int low, int high, Comparator<T> comparator) {
        if (MyList.size() == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбираем опорный элемент в середине списка
        int middle = low + (high - low) / 2;
        T opora = MyList.get(middle);

        // делим на два под-массива, левее и правее опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (comparator.compare(MyList.get(i), opora) < 0) {
                i++;
            }
            while (comparator.compare(MyList.get(j), opora) > 0) {
                j--;
            }

            //меняем местами
            if (i <= j) {
                T temp = MyList.get(i);
                MyList.set(MyList.get(j), i);
                MyList.set(temp, j);
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(MyList, low, j, comparator);

        if (high > i)
            quickSort(MyList, i, high, comparator);
    }
}
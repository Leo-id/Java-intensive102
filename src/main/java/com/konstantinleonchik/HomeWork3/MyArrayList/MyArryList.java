package com.konstantinleonchik.HomeWork3.MyArrayList;

import com.konstantinleonchik.HomeWork3.MyList;

public class MyArryList<T> implements MyList<T> {

    /**
     * Создаем коллекцию
     *
     * @param def_capasity начальная вместимость коллекции
     * @param size начальный размер коллекции
     * @throws IllegalArgumentException будет выброшено исключение
     * при попытке создать коллекцию размером меньше 1.
     */

    private T[] list;
    private int size = 0;
    private final int def_capasity = 10;

    MyArryList(int capasity) {
        if (capasity <= 0) {
            throw new IllegalArgumentException("Capasity<=0");
        } else
            list = (T[]) new Object[capasity];
    }

    public MyArryList() {
        list = (T[]) new Object[def_capasity];
    }

    @Override
    public void add(T element) {
        if (size >= list.length) {
            T[] newlist = (T[]) new Object[list.length * 2];
            for (int i = 0; i < list.length; i++) {
                newlist[i] = list[i];
            }
            list = newlist;
        }
        list[size] = element;
        size++;
    }

    @Override
    public void add(T element, int index) {
        chekIndex(index);
        if (size >= list.length) {
            T[] newlist = (T[]) new Object[list.length * 2];
            for (int i = 0; i < list.length; i++) {
                newlist[i] = list[i];
            }
            list = newlist;
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = element;
        size++;
    }

    @Override
    public T get(int index) {
        chekIndex(index);
        T newList = list[index];
        return newList;
    }

    @Override
    public void removeAt(int index) {
        chekIndex(index);
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        size--;
    }

    @Override
    public void clear() {
        list = (T[]) new Object[def_capasity];
        size = 0;
    }

    @Override
    public void print() {
        System.out.print("[");
        for (T element : list) {
            if (element != null) {
                System.out.print(element + " ");
            }
        }
        System.out.println("]");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void set(T element, int index) {
        chekIndex(index);
        list[index] = element;
    }

    /**
     * Метод проверяет что бы индекс не был меньше size
     *
     * @param index индекс
     * @throws IndexOutOfBoundsException если меньше 0 или index больше либо равен
     *                                   размера коллекции, то будет выброшено исключение "The index is incorrect!"
     *                                   используем данный метод во всех других методах гле в параметре есть index
     */
    private void chekIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The index is incorrect!");
        }
    }

    /**
     * Метод запускает сортировку слиянием
     */
    public void mergeSort() {
        if (size > 1) {   // проверят что в списке больше одного элемента для сортировки
            Object[] newList = new Object[size];
            mergeSort(0, size - 1, newList);   // вызывает рекурсивный метод
        }
    }

    private void mergeSort(int left, int right, Object[] newList) {
        if (left < right) {
            int mid = left + (right - left) / 2; // определяем середину списка
            mergeSort(left, mid, newList);     // сортировка левой части
            mergeSort(mid + 1, right, newList); // сортировка правой части
            merge(left, mid, right, newList);   // вызываем метод merge для слияния двух половин
        }
    }

    private void merge(int left, int mid, int right, Object[] newList) {
        for (int i = left; i <= right; i++) {
            newList[i] = list[i];
        }

        int i = left;       // Индекс левой части
        int j = mid + 1;    // Индекс правой части
        int k = left;       // Индекс для массива куда будет помещен результат

        /* сравниваем каждый элемент одного массива с элементами другого
     и помещаем меньшее значение в финальный массив */

        while (i <= mid && j <= right) {
            if (((Comparable<T>) newList[i]).compareTo((T) newList[j]) <= 0) {
                list[k++] = (T) newList[i++];
            } else {
                list[k++] = (T) newList[j++];
            }
        }
        while (i <= mid) {
            list[k++] = (T) newList[i++];
        }
        while (j <= right) {
            list[k++] = (T) newList[j++];
        }
    }
}
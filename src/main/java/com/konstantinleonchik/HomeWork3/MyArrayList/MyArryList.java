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


}
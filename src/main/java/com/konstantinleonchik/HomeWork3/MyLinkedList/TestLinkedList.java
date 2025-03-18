package com.konstantinleonchik.HomeWork3.MyLinkedList;

import com.konstantinleonchik.HomeWork3.MyCollectionsQuickSort;

import java.util.Comparator;

public class TestLinkedList {
    public static void main(String[] args) {

        MyLinkedList<Integer> list=new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(65);
        list.add(87);
        list.add(2);

        list.print();

        MyLinkedList<String> list2=new MyLinkedList<>();
        list2.add("Я");
        list2.add("изучаю");
        list2.add("Java");

        list2.print();

        list2.removeFirst();
        list2.removeAt(1);
        list2.removeLast();

        list2.print();

        list2.add("Я");
        list2.add("изучаю");
        list2.add("Java");

        list2.set("Spring", 2);

        list2.print();

        MyCollectionsQuickSort.qSort(list, Comparator.naturalOrder());
        list.print();

        list2.add("Г");
        list2.add("В");
        list2.add("а");
        MyCollectionsQuickSort.qSort(list2, Comparator.comparing(Object::toString));
        list2.print();












    }


}

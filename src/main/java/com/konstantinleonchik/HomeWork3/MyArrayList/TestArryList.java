package com.konstantinleonchik.HomeWork3.MyArrayList;

import com.konstantinleonchik.HomeWork3.MyCollectionsQuickSort;

import java.util.Comparator;

/**
 * Класс для тестирования MyArrayList и всех его методов
 */

public class TestArryList {
    public static void main(String[] args) {

        /**
         * Создаем MyArryList1 и добавляем в него 100000 элементов
         * затем удаляем второй элемент
         * выводим на экран
         * и проверяем пустой лист или нет (должно быть false)
         */
        MyArryList<String> myArryList1 = new MyArryList<>();

        for (int i = 0; i < 100000; i++) {
            myArryList1.add("mama" + i);
        }
        myArryList1.removeAt(1);
        myArryList1.print();
        System.out.println(myArryList1.isEmpty());


        /**
         * Создаем MyArryList2 и добавляем в него 5 int элементов
         * выводим на экран
         * производим сортировку
         * выводим на экран
         * очищаем всю коллекцию
         * выводим на экран
         * и проверяем пустой лист или нет (должно быть true)
         */
        MyArryList<Integer> myArryList2 = new MyArryList<>();
        myArryList2.add(5);
        myArryList2.add(2);
        myArryList2.add(9);
        myArryList2.add(8);
        myArryList2.add(3);
        myArryList2.add(5);

        myArryList2.print();

        MyCollectionsQuickSort.qSort(myArryList2, Comparator.naturalOrder());

        myArryList2.print();
        myArryList2.clear();
        myArryList2.print();
        System.out.println(myArryList2.isEmpty());


        /**
         * Создаем MyArryList3 и добавляем в него 4 String элемента
         * выводим на экран
         * производим быструю сортировку
         * выводим на экран
         */
        MyArryList<Object> myArryList3 = new MyArryList<>();
        myArryList3.add("Привет! ");
        myArryList3.add("Меня ");
        myArryList3.add("зовут ");
        myArryList3.add("Костя!");

        myArryList3.print();

        MyCollectionsQuickSort.qSort(myArryList3, Comparator.comparing(Object::toString));

        myArryList3.print();


        /**
         *  Создаем MyArryList4 и добавляем в него 5 String элементов
         *  выводим на экран
         *  производим сортировку слиянием
         *  выводим на экран
         **/
        MyArryList<Object> myArryList4 = new MyArryList<>();
        myArryList4.add("Привет! ");
        myArryList4.add("D ");
        myArryList4.add("F ");
        myArryList4.add("C!");
        myArryList4.add("A");

        myArryList4.print();

        myArryList4.mergeSort();

        myArryList4.print();
    }
}


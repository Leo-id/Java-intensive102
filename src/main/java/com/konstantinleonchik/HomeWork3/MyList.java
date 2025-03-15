package com.konstantinleonchik.HomeWork3;



public interface MyList<T> {


    void add(T element);



    void add(T element, int index);


    T get(int index);


    void removeAt(int index);


    void clear();
    void print();


    int size();


    boolean isEmpty();


    void set(T element, int index);
}
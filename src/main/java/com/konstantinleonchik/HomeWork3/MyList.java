package com.konstantinleonchik.HomeWork3;

/**
 * Домашнее зание: Реализазия MyArrayList.
 *
 * @param <T> обобщенный тип
 *            Автор: Константин Леончик
 */

public interface MyList<T> {

    /**
     * Добавление элемента в конец коллекции
     *
     * @param element добавляемый элемент
     */
    void add(T element);


    /**
     * Добавление элемента в коллекции на определенную позицию index
     *
     * @param element - добавляемый элемент
     * @param index   - позиция куда добавляем элемент
     */
    void add(T element, int index);

    /**
     * Получение элемента по индексу
     *
     * @param index - позиция элемента
     * @return возвращает элемент по индексу
     */
    T get(int index);

    /**
     * Удаление элемента из коллекции по index
     *
     * @param index - позиция удаляемого элемента
     */
    void removeAt(int index);

    /**
     * Удаление всех элементов коллекции
     */
    void clear();

    /**
     * Выводим на экран коллекцию
     */
    void print();

    /**
     * Получаем размер коллекции
     *
     * @return - текущий размер коллекции
     */
    int size();

    /**
     * Проверяем наличие элементов в коллекции
     *
     * @return вернет true если коллекция пустая
     */
    boolean isEmpty();

    /**
     * Перезаписывает определенный элемент коллекции
     *
     * @param element - новый элемент
     * @param index   - позиция на которую нужно перезаписать
     */
    void set(T element, int index);
}
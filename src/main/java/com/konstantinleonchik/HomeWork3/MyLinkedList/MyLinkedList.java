package com.konstantinleonchik.HomeWork3.MyLinkedList;

import com.konstantinleonchik.HomeWork3.MyList;

public class MyLinkedList<T> implements MyList<T> {

    private Node<T> first;  //ссылка на первый элемент
    private Node<T> last;   //ссылка на последний элемент
    private int size = 0;   //начальный размер коллекции

    /**
     * Создаем дополнительный внутренний класс Node
     *
     * @value previous ссылку на предыдущий элемент
     * @value value значение элемента
     * @value next ссылка на следующий элемент
     */
    private static class Node<T> {
        private Node<T> previous;
        private T value;
        private Node<T> next;

        public Node(Node<T> previous, T value, Node<T> next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Метод для получения объекта класса Node
     *
     * @param index индекс элемента
     * @throws IndexOutOfBoundsException будет выброшено исключение если задать индекс несуществующего элемента
     * @return
     */
    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public void add(T element) {
        if (size == 0) {
            first = new Node<>(null, element, null);
            last = first;
        } else {
            Node<T> secondLast = last;
            last = new Node<>(secondLast, element, null);
            secondLast.next = last;
        }
        size++;
    }

    @Override
    public void add(T element, int index) {
        chekIndex(index);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(element);
            return;
        }
        Node<T> nodeNext = getNode(index);
        Node<T> nodePrevious = nodeNext.previous;
        Node<T> newNode = new Node<>(nodePrevious, element, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            first = newNode;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Методы для удаления элемента с конца и начала списка
     * @throws IndexOutOfBoundsException будет выброшено исключение если нет элементов для удаления
     */
    public void removeLast() {
        if (last == null) {
            throw new IndexOutOfBoundsException("Список уже пустой");
        }
        if (first == last) {
            first = null;
            last = null;
        } else {
            last = last.previous;
            last.next = null;
        }
        size--;
    }

    public void removeFirst() {
        if (first == null) {
            throw new IndexOutOfBoundsException("Список уже пустой");
        }
        if (first == last) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.previous = null;
        }
        size--;
    }

    @Override
    public void removeAt(int index) {
        chekIndex(index);
        Node<T> node = getNode(index);
        Node<T> nodeNext = node.next;
        Node<T> nodePrevious = node.previous;
        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = first;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" # ");  // разделяем элементы просто для читаемости
            }
            current = current.next;
        }
        return sb.toString();
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("Список пуст!");
        } else {
            System.out.println("Список: " + this.toString());
        }
    }

    @Override
    public void set(T element, int index) {
        chekIndex(index);
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next; // Переходим к элементу с нужным индексом
        }
        current.value = element; // Перезаписываем данные
    }


    /**
     * Метод проверяет что бы индекс не был меньше size
     *
     * @param index индекс
     * @throws IndexOutOfBoundsException если индекс меньше 0 или больше либо равен
     *                                   размеру коллекции, то будет выброшено исключение "The index is incorrect!"
     *                                   используем данный метод во всех других методах гле в параметре есть index
     */
    private void chekIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The index is incorrect!");
        }
    }
}
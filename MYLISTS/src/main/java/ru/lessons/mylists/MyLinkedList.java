package ru.lessons.mylists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    /**
     * Класс-элемент списка
     * @param <T>
     * Дата 21.11.17
     */
    private static class Node<T> {
        private T item;
        private Node<T> prev;
        private Node<T> next;

        Node(Node<T> prev, Node<T> next, T item) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        Node(Node<T> node) {
            this.item = node.item;
            this.prev = node.prev;
            this.next = node.next;
        }

        Node() {
            this.item = null;
            this.prev = null;
            this.next = null;
        }
    }

    private int size;
    private Node<T> head;
    private Node<T> tail;

    /**
     * Конструктор по умолчанию
     * Дата 22.11.17
     */
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Получить первый элемент списка
     * @return
     * Дата 22.11.17
     */
    public T getFirst() {
        MyLinkedList.Node node = this.head;
        if(node == null) {
            throw new NoSuchElementException("No such element!");
        } else {
            return (T)node.item;
        }
    }
    /**
     * Получить последний элемент списка
     * @return
     * Дата 22.11.17
     */
    public T getLast() {
        MyLinkedList.Node node = this.tail;
        if(node == null) {
            throw new NoSuchElementException("No such element!");
        } else {
            return (T)node.item;
        }
    }

    /**
     * Содержится элемент в списке
     * @param element искомый элемент
     * @return
     * Дата
     */
    public boolean contains(T element) {
        //TODO доделать
        return true;
    }

    /**
     * Возвращает размер списка
     * @return
     * Дата 22.11.17
     */
    public int size() {
        return this.size;
    }

    /**
     * Добавление элемента
     * @param element
     * @return
     * Дата 22.11.17
     */
    public boolean add(T element) {
        if(isValidElement(element)) {
            //если список пуст
            if (this.size == 0) {
                Node<T> node = new Node<T>(null, null, element);
                this.head = node;
                this.tail = node;
            } else {
                Node<T> node = new Node<T>(this.tail, null, element);
                this.tail.next = node;
                this.tail = node;
            }
            this.size++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Добавление первого элемента
     * @param element добавляемый элемент
     * Дата
     */
    public boolean addFirst(T element) {
        //TODO доделать
        return true;
    }

    /**
     * Добавление элемента по индексу
     * @param index
     * @param element
     * @return
     * Дата
     */
    public boolean add(int index, T element) {
        //TODO доделать
        return true;
    }


    /**
     * Удаление элемента из конца списка
     * @param element
     * @return
     * Дата
     */
    public boolean remove(T element) {
        //TODO доделать
        return true;
    }

    /**
     * Удаление первого элемента
     * @return
     * Дата
     */
    public boolean removeFirst() {
        //TODO доделать
        return true;
    }

    /**
     * Очистка списка
     * Дата
     */
    public void clear() {
        //TODO доделать
    }

    /**
     * Получить элемент по текущему индексу
     * @param index
     * @return
     * Дата 22.11.17
     */
    public T get(int index) {
        this.isValidIndex(index);
        Node<T> tmp = this.head;
        for(int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.item;
    }

    /**
     * Заменить элемент с позиции index на новый элемент
     * @param index
     * @param element добавляемый элемент
     * @return
     * Дата 22.11.17
     */
    public T set(int index, T element) {
        this.isValidIndex(index);
        Node<T> tmp = this.head;
        for(int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        T ret = tmp.item;
        tmp.item = element;
        return ret;
    }

    /**
     * Возвращает индекс первого вхождения искомого элемента
     * @param element
     * @return
     * Дата
     */
    public int indexOf(T element) {
        //TODO доделать
        return -1;
    }

    /**
     * Возвращает индекс последнего вхождения искомого элемента
     * @param element
     * @return
     * Дата
     */
    public int lastIndexOf(T element) {
        //TODO доделать
        return -1;
    }

    /**
     * Возвращает массив из элементов списка
     * @return
     * Дата
     */
    public Object[] toArray() {
        //TODO доделать
        return new Object[10];
    }

    /**
     * Обращает список в строку
     * @return
     * Дата
     */
    public String toString() {
        //TODO доделать
        return "";
    }

    /**
     * Валидный ли объект для добавления
     * @param element
     * @return
     * Дата 22.11.17
     */
    private boolean isValidElement(T element) {
        if(element == null) return false;
        else return true;
    }

    /**
     * Валидный ли индекс
     * @param index
     * @return
     * Дата 22.11.17
     */
    private void isValidIndex(int index) {
        if(index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException();
    }

    /**
     * Валидный ли индекс для добавления
     * @param index
     * @return
     * Дата 22.11.17
     */
    private void isValidIndexForAdd(int index) {
        if(index < 0 || index > this.size)
            throw new IndexOutOfBoundsException();
    }

    /**
     *Возвращает итератор
     * @return
     * Дата 22.11.17
     */
    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    /**
     * Класс-итератор для массива
     * Дата 21.11.17
     */
    private class MyLinkedListIterator implements Iterator<T> {

        /**
         * Существует ли следующий элемент
         * @return
         * Дата
         */
        @Override
        public boolean hasNext() {
            return true;
        }

        /**
         * Возвращает следущщий элемент
         * @return
         * Дата
         */
        @Override
        public T next() {
            return (T)(new Object());
        }

        /**
         * Удаление выбранного элемента
         * Дата
         */
        @Override
        public void remove() {

        }
    }
}

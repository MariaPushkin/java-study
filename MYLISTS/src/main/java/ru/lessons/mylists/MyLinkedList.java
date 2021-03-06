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
     * Дата 23.11.17
     */
    public boolean contains(T element) {
        return (this.indexOf(element) >= 0);
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
     * Дата 23.11.17
     */
    public boolean addFirst(T element) {
        Node<T> node = new Node<T>(null, this.head, element);
        this.head.prev = node;
        this.head = node;
        this.size++;
        return true;
    }

    /**
     * Добавление элемента по индексу
     * @param index
     * @param element
     * @return
     * Дата 23.11.17
     */
    public boolean add(int index, T element) {
        this.isValidIndexForAdd(index);
        if(index == 0) return this.addFirst(element);
        Node<T> tmp = this.head;
        for(int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }
        Node<T> tmpPrev = tmp.prev;
        Node<T> tmpNext = tmp.next;
        Node<T> node = new Node<T>(tmpPrev, tmpNext, element);
        tmpNext.prev = node;
        tmp.next = node;
        this.size++;
        return true;
    }


    /**
     * Удаление элемента из конца списка
     * @return
     * Дата 23.11.17
     */
    public boolean remove() {
        Node<T> del = this.tail;
        if(del.prev != null) {
            Node<T> delPrev = del.prev;
            this.tail = delPrev;
            delPrev.next = null;
        }
        del.prev = del.next = null;
        del.item = null;
        this.size--;
        return true;
    }

    /**
     * Удаление первого элемента
     * @return
     * Дата 23.11.17
     */
    public boolean removeFirst() {
        Node<T> del = this.head;
        if(del.next != null) {
            Node<T> delNext = del.next;
            this.head = delNext;
            delNext.prev = null;
        }
        del.prev = del.next = null;
        del.item = null;
        this.size--;
        return true;
    }

    /**
     * Удаление элемента
     * @param element удаляемый элемент
     * @return
     * Дата 23.11.17
     */
    public boolean remove(T element) {
        if(element.equals(this.head)) removeFirst();
        if(element.equals(this.tail)) remove();
        while(this.contains(element)) {
            this.remove(this.indexOf(element));
        }
        return true;
    }

    /**
     * Удаление элемента по индексу
     * @param index
     * @return
     * Дата 23.11.17
     */
    public boolean remove(int index) {
        this.isValidIndex(index);
        if(index == 0) return this.removeFirst();
        if(index == this.size - 1) return this.remove();
        Node<T> del = this.head;
        for(int i = 0; i < index; i++) {
            del = del.next;
        }
        Node<T> delPrev = del.prev;
        Node<T> delNext = del.next;
        delPrev.next = delNext;
        delNext.prev = delPrev;
        del.prev = del.next = null;
        del.item = null;
        this.size--;
        return true;
    }

    /**
     * Очистка списка
     * Дата 23.11.17
     */
    public void clear() {
        for(int i = 0; i < this.size; i++) {
            this.removeFirst();
        }
        this.removeFirst();
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
     * @return индекс элемента, если найден, -1 если нет
     * Дата 23.11.17
     */
    public int indexOf(T element) {
        Node<T> tmp = this.head;
        for(int i = 0; i < this.size; i++) {
            if(element.equals(tmp.item)) return i;
            tmp = tmp.next;
        }
        return -1;
    }

    /**
     * Возвращает индекс последнего вхождения искомого элемента
     * @param element
     * @return
     * Дата 23.11.17
     */
    public int lastIndexOf(T element) {
        Node<T> tmp = this.tail;
        for(int i = size - 1; i >= 0; i--)  {
            if(element.equals(tmp.item)) return i;
            tmp = tmp.prev;
        }
        return -1;
    }

    /**
     * Возвращает массив из элементов списка
     * @return
     * Дата 24.11.17
     */
    public Object[] toArray() {
        Object[] array = new Object[this.size];
        Node<T> tmp = this.head;
        for(int i = 0; i < this.size; i++) {
            array[i] = tmp.item;
            if(i < this.size - 1) tmp = tmp.next;
        }
        return array;
    }

    /**
     * Обращает список в строку
     * @return
     * Дата 24.11.17
     */
    public String toString() {
        Node<T> tmp = this.head;
        StringBuilder str = new StringBuilder();
        str.append("[");
        for(int i = 0; i < this.size; i++) {
            str.append(this.get(i));
            if(i != this.size - 1) str.append(",");
            if(i < this.size - 1) tmp = tmp.next;
        }
        str.append("]");
        String completedString = str.toString();
        return completedString;
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
     * Класс-итератор для списка
     * Дата 24.11.17
     */
    private class MyLinkedListIterator implements Iterator<T> {
        private int pointer = -1; //текущая позиция
        private Node<T> currNode; //текущий узел

        public MyLinkedListIterator() {
            this.currNode = MyLinkedList.this.head;
        }

        /**
         * Существует ли следующий элемент
         * @return
         * Дата 24.11.17
         */
        @Override
        public boolean hasNext() {
            return this.currNode != null;
        }

        /**
         * Возвращает следущщий элемент
         * @return
         * Дата 24.11.17
         */
        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException("No next element");
            }
            T value = currNode.item;
            currNode = currNode.next;
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

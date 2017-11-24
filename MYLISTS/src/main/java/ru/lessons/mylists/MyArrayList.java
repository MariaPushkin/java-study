package ru.lessons.mylists;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable<T> {
    private int currMaxSize;
    private int size;
    private static final int MAX_SIZE = 2147483639;
    private static final int CUT_RATE = 4;
    private Object[] insArray;

    /**
     * Конструктор листа по умолчанию
     * Дата 18.11.17
     */
    public MyArrayList() {
        insArray = new Object[10];
        currMaxSize = 10;
        size = 10;
    }

    /**
     * Конструктор с параметром размера листа
     * @param size размер
     * Дата 18.11.17
     */
    public MyArrayList(int size) {
        if(size > 0) {
            insArray = new Object[size];
            this.currMaxSize = size;
            this.size = 0;
        } else {
            throw new IllegalArgumentException("Illegal size");
        }
    }

    /**
     *Возвращает текущий размер массива
     * Дата 18.11.17
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Проверка пустоты массива
     * @return true если пустой, false если нет
     * Дата 18.11.17
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * Проверяет, содержит ли список элемент
     * @param element искомый элемент
     * @return true если элемент найден, false если нет
     * Дата 18.11.17
     */
    public boolean contains(T element) {
        return (indexOf(element) >= 0);
    }

    /**
     * Возвращает первое вхождение искомого элемента
     * @param element искомый элемент
     * @return индекс найденного элемента, -1 - элемент не найден
     * Дата 19.11.17
     */
    public int indexOf(T element) {
        for(int i = 0; i < this.size; i++) {
            if(element.equals(this.insArray[i])) return i;
        }
        return -1;
    }

    /**
     * Возвращает последнее вхождение искомого элемента
     * @param element искомый элемент
     * @return индекс найденного элемента, -1 - элемент не найден
     * Дата 19.11.17
     */
    public int lastIndexOf(T element) {
        for(int i = size - 1; i >= 0; i--) {
            if(element.equals(this.insArray[i])) return i;
        }
        return -1;
    }

    /**
     * Получить элемент с определенной позиции
     * @param position позиция
     * @return T - искомый элемент
     * Дата 18.11.17
     */
    public T get(int position) {
        this.isValidIndex(position);
        return (T)this.insArray[position];
    }

    /**
     * Заменяет элемент на определенной позиции переданным элементом
     * @param position позиция
     * @param element новый элемент
     * @return T - старый элемент
     * Дата 18.11.17
     */
    public T set(int position, T element) {
        this.isValidIndex(position);
        T old = (T)this.insArray[position];
        this.insArray[position] = element;
        return old;
    }

    /**
     * Добавление элемента в конец массива
     * @param element элемент
     * @return true - удачно добавлен, false - элемент не добавлен
     * Дата 19.11.17
     */
    public boolean add(T element) {
        this.growArrayIfNeed();
        this.insArray[size] = element;
        size++;
        return true;
    }

    /**
     * Добавление элемента по индексу
     * @param index индекс
     * @param element элемент
     * @return
     * Дата 19.11.17
     */
    public boolean add(int index, T element) {
        this.isValidIndexForAdd(index);
        this.growArrayIfNeed();
        this.insArray[index] = element;
        if(index == size) size++;
        return  true;
    }

    /**
     * Удаление всех вхождений элемента из массива
     * @param element элемент
     * @return
     * Дата 20.11.17
     */
    public boolean remove(T element) {
        while(this.contains(element)) {
            this.remove(this.indexOf(element));
        }
        return true;
    }

    /**
     * Удаление элемента по индекса
     * @param index индекс
     * @return
     * Дата 19.11.17
     */
    public  boolean remove(int index) {
        this.isValidIndex(index);
        for(int i = index; i < size-1; i++) {
            this.insArray[i] = this.insArray[i + 1];
        }
        this.insArray[size - 1] = null;
        size--;
        this.reduceArrayIfNeed();
        return true;
    }

    /**
     * Возвращает массив из элементов списка
     * @return
     * Дата 19.11.17
     */
    public Object[] toArray() {
        Object[] findArray = new Object[this.size];
        System.arraycopy(this.insArray,0,findArray,0,this.size);
        return findArray;
    }

    /**
     * Обращает список в строку
     * @return
     * Дата 20.11.17
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for(int i = 0; i < this.size; i++) {
            str.append(this.insArray[i]);
            if(i != this.size - 1) str.append(",");
        }
        str.append("]");
        String completedString = str.toString();
        return completedString;
    }

    /**
     * Проверка индекса
     * @param index индекс
     * @return
     * Дата 18.11.17
     */
    private boolean isValidIndex(int index) {
        if(index >= this.size || index < 0)
            throw new IndexOutOfBoundsException("Wrong index");
        return true;
    }

    /**
     * Проверка индекса для добавления
     * @param index индекс
     * @return
     * Дата 18.11.17
     */
    private boolean isValidIndexForAdd(int index) {
        if(index > this.size || index < 0)
            throw new IndexOutOfBoundsException("Wrong index");
        return true;
    }

    /**
     * Масштабирование массива
     * Дата 19.11.17
     */
    private void growArrayIfNeed() {
        if(this.size == this.currMaxSize && this.currMaxSize*2 <= this.MAX_SIZE) {
            T[] oldArray = (T[]) new Object[this.size];
            System.arraycopy(this.insArray,0, oldArray, 0, this.size);
            int newMaxSize = this.currMaxSize * 2;
            this.insArray = new Object[newMaxSize];
            System.arraycopy(oldArray,0,this.insArray,0,this.size);
            this.currMaxSize = newMaxSize;
        }
    }

    /**
     * Уменьшение максимального размера массива
     * Дата 20.11.17
     */
    private void reduceArrayIfNeed() {
        //TODO сделать
        if(this.size <= this.currMaxSize / this.CUT_RATE) {
            T[] oldArray = (T[]) new Object[this.size];
            System.arraycopy(this.insArray,0, oldArray, 0, this.size);
            int newMaxSize = this.currMaxSize / 2;
            this.insArray = new Object[newMaxSize];
            System.arraycopy(oldArray,0,this.insArray,0,this.size);
            this.currMaxSize = newMaxSize;
        }
    }

    /**
     *Возвращает итератор
     * @return
     * Дата 21.11.17
     */
    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    /**
     * Класс-итератор для массива
     * Дата 21.11.17
     */
    private class MyArrayListIterator implements Iterator<T> {
        private int pointer = -1; //текущая позиция

        /**
         * Существует ли следующий элемент
         * @return
         * Дата 21.11.17
         */
        @Override
        public boolean hasNext() {
            if(this.pointer >= size - 1)
                return false;
            else
                return true;
        }

        /**
         * Возвращает следущий элемент
         * @return
         * Дата 21.11.17
         */
        @Override
        public T next() {
            if(!this.hasNext()) {
                throw new NoSuchElementException("No next element");
            } else
                return  (T) insArray[++this.pointer];
        }

        /**
         * Удаление выбранного элемента
         * Дата 21.11.17
         */
        @Override
        public void remove() {
            if(this.pointer >= 0) {
                MyArrayList.this.remove(this.pointer);
                this.pointer--;
            } else {
                throw new ConcurrentModificationException();
            }
        }
    }
}
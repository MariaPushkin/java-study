package ru.lessons.mylists;

public class MyLinkedList {
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
    }

}

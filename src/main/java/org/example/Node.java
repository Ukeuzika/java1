package org.example;

/**
 * класс простого списка
 * @param <T> тип данных Node
 */
public class Node<T> {
    T data;
    Node<T> next;

    /**
     * Конструктор
     * @param data значение
     */
    public Node(T data) {
        this.data = data;
        next = null;
    }
}
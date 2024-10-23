package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @param <T> тип данных List
 */
public class MyList<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    public MyList() {
        head = null;
        size = 0;
    }

    /**
     *
     * @return размер списка
     */
    public int size() {
        return size;
    }

    /**
     * Функция получения List
     * @param index индекс элемента
     * @return элемент List
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; ++i) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Функция добавления в List
     * @param data значение
     */
    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        ++size;
    }

    /**
     * Функция удаления из List
     * @param index индекс элемента
     * @return List
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (index == 0) {
            T data = head.data;
            head = head.next;
            --size;
            return data;
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; ++i) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = current.next.next;
        --size;
        return data;
    }

    /**
     * Функция печати List
     */
    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
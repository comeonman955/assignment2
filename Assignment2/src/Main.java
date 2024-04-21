import org.junit.Before;

interface MyList<T> {
    void add(T element);
    T get(int index);
    int size();
}

class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    @Override
    public void add(T element) {
        if (size == elements.length) {
            Object[] newArray = new Object[2 * elements.length];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
        elements[size++] = element;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    @Override
    public int size() {
        return size;
    }
}

class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T element;
        MyNode next;
        MyNode prev;

        MyNode(T element, MyNode prev, MyNode next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T element) {
        if (head == null) {
            head = new MyNode(element, null, null);
            tail = head;
        } else {
            MyNode newNode = new MyNode(element, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public int size() {
        return size;
    }
}

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {

    private MyArrayList<Integer> list;

    @Before
    public void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    public void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    public void testGet() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(Integer.valueOf(2), list.get(1));
    }

    @Test
    public void testSize() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }
}

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {

    private MyLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new MyLinkedList<>();
    }

    @Test
    public void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    public void testGet() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(Integer.valueOf(2), list.get(1));
    }

    @Test
    public void testSize() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }
}

/**
  *
  * @author (32465092 MSM Dhlamini)
  * @version (5 October 2023)
*/

public class MyLinkedList<E> {
    private Node<E> head, tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public E getFirst() {
        if (head == null) {
            return null;
        } else {
            return head.element;
        }
    }

    public E getLast() {
        if (head == null) {
            return null;
        } else {
            return tail.element;
        }
    }

    public void prepend(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;

        if (tail == null)
            tail = head;
    }

    public void append(E item) {
        Node<E> newNode = new Node<>(item);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public E removeFirst() {
        if (head == null) {
            return null;
        } else {
            E temp = head.element;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return temp;
        }
    }

    public boolean delete(E item) {
        Node<E> ptr = head;
        Node<E> prvPtr = null;
        while (ptr != null && ((Comparable) ptr.element).compareTo(item) != 0) {
            prvPtr = ptr;
            ptr = ptr.next;
        }
        if (ptr == null)
            return false;
        if (ptr == head)
            head = head.next;
        else
            prvPtr.next = ptr.next;
        if (ptr == tail)
            tail = prvPtr;
        return true;
    }

    public String toString() {
        String result = "[";

        Node<E> ptr = head;
        for (ptr = head; ptr != null; ptr = ptr.next) {
            result = result + ptr.element.toString();
            if (ptr.next != null)
                result = result + ",";
        }
        result += "]";
        return result;
    }

    public void clear() {
        head = tail = null;
    }

    public void findAndRemoveDuplicates() {
        if (head == null) {
            return;
        }

        Node<E> current = head;

        while (current != null) {
            Node<E> runner = current;

            while (runner.next != null) {
                if (runner.next.element.equals(current.element)) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
            next = null;
        }
    }
}
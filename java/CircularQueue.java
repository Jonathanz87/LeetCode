public class CircularQueue<T> {
    private Node<T> front;
    private Node<T> rare;
    private boolean isEmpty = true;

    public CircularQueue(int size) {
        if (size <= 0) {
            throw new RuntimeException("size cannot be less than one");
        }
        Node<T> beforeFirst = new Node<>();
        Node<T> current = beforeFirst;
        for (int i = 0; i < size; i++) {
            Node<T> newNode = new Node<>();
            current.next = newNode;
            current = newNode;
        }

        current.next = beforeFirst.next;
        front = beforeFirst.next;
        rare = beforeFirst.next;
    }

    public void produce(T value) {
        if (front == rare && !isEmpty) {
            front = front.next;
        }
        rare.value = value;
        rare = rare.next;
        isEmpty = false;
    }

    public T consume() {
        if (isEmpty) {
            return null;
        } else {
            T value = front.value;
            front = front.next;
            isEmpty = front == rare;
            return value;
        }
    }

    private static final class Node<T> {
        private T value;
        private Node<T> next;
    }

}
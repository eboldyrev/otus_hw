package eugene.boldyrev._6_basic_data_structures.prirority_queue;

import java.util.Objects;

public class PriorityQueueImpl<T> implements PriorityQueue<T>{

    static class PQItem<T>{
        final T value;
        final int priority;
        PQItem<T> next;

        public PQItem(T value, int priority, PQItem<T> next) {
            this.value = value;
            this.priority = priority;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PQItem<?> pqItem = (PQItem<?>) o;
            return priority == pqItem.priority && value.equals(pqItem.value) && Objects.equals(next, pqItem.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, priority, next);
        }
    }

    private PQItem<T> head = null;

    @Override
    public void enqueue(int priority, T item) {
        if (head != null) {
            PQItem<T> current = head;

            if (current.priority <= priority) {
                head = new PQItem<>(item, priority, head);
            } else {
                while (current.priority > priority) {
                    if ((current.next == null) || (current.next.priority < priority)) {
                        break;
                    }
                    current = current.next;
                }
                current.next = new PQItem<>(item, priority, current.next);
            }
        } else {
            head = new PQItem<>(item, priority, null);
        }
    }

    @Override
    public T dequeue() {
        if (head == null) {
            return null;
        }
        T result = head.value;
        head = head.next;
        return result;
    }

    public static void main(String[] args) {
        PriorityQueueImpl<String> priorityQueue = new PriorityQueueImpl<>();
        priorityQueue.enqueue(10, "Ten");
        priorityQueue.enqueue(5, "Five");
        priorityQueue.enqueue(1, "One");
        priorityQueue.enqueue(12, "Twelve");
        priorityQueue.enqueue(4, "Four");

        while (true) {
            String result = priorityQueue.dequeue();
            if (result == null) {
                break;
            }
            System.out.println("Item = " + result);
        }

        System.out.println("End");
    }
}

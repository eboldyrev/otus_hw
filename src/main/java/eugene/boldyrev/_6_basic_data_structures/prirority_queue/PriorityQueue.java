package eugene.boldyrev._6_basic_data_structures.prirority_queue;

public interface PriorityQueue<T> {
    void enqueue(int priority, T item);
    T dequeue();
}

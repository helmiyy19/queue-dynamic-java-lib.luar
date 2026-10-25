import java.util.concurrent.ArrayBlockingQueue;

public class StaticQueue<T> {
    private final ArrayBlockingQueue<T> items;

    public StaticQueue(int kapasitas) {
        items = new ArrayBlockingQueue<>(kapasitas);
    }

    public boolean enqueue(T data) {
        return items.offer(data);
    }

    public T dequeue() {
        return items.poll();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public boolean isFull() {
        return items.remainingCapacity() == 0;
    }

    public String show() {
        return items.isEmpty() ? "Kosong" : items.toString();
    }
}

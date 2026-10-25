import java.util.LinkedList;
import java.util.Queue;

public class DynamicQueue<T> {
    private final Queue<T> items = new LinkedList<>();

    public void enqueue(T data) {
        items.offer(data);
    }

    public T dequeue() {
        return items.poll();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public String show() {
        return items.isEmpty() ? "Kosong" : items.toString();
    }
}

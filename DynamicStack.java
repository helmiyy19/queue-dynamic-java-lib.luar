import java.util.Deque;
import java.util.LinkedList;

public class DynamicStack<T> {
    private final Deque<T> items = new LinkedList<>();

    public void push(T data) {
        items.push(data);
    }

    public T pop() {
        return items.poll();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public String show() {
        return items.isEmpty() ? "Kosong" : items.toString();
    }
}

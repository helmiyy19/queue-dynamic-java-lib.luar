import java.util.ArrayDeque;

public class StaticStack<T> {
    private final ArrayDeque<T> items = new ArrayDeque<>();
    private final int kapasitas;

    public StaticStack(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public boolean push(T data) {
        if (items.size() >= kapasitas) {
            return false;
        }
        items.push(data);
        return true;
    }


    public T pop() {
        return items.poll();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public boolean isFull() {
        return items.size() >= kapasitas;
    }

    public String show() {
        return items.isEmpty() ? "Kosong" : items.toString();
    }
}

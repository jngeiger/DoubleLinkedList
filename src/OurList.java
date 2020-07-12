import java.util.function.Function;

public abstract class OurList<T> {
    public abstract void insert(T ele);

    public abstract void insert(T ele, int pos);

    public abstract boolean delete(Function<T, Boolean> func);

    public abstract String toString();
}

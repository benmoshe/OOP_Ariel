package bt;

import java.util.Comparator;

public interface binary_search_tree<T> extends binary_tree<T> {
    public T search (T data);
    public Comparator<T> getComperator();
    public void setComperator(Comparator<T> comp);
}

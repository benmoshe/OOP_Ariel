package bt;

public class Node <T> {
	private T _data;
	private Node<T> _left;
	private Node<T> _right;
	
	public Node(T t) {
		set_data(t);
	}

	public T get_data() {
		return _data;
	}

	public void set_data(T _data) {
		this._data = _data;
	}

	public Node<T> get_left() {
		return _left;
	}

	public void set_left(Node<T> _left) {
		this._left = _left;
	}

	public Node<T> get_right() {
		return _right;
	}

	public void set_right(Node<T> _right) {
		this._right = _right;
	}
}

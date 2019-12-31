package bt;

import java.util.Iterator;

/**
 * This interface represents a simple binary tree;
 */
public interface binary_tree<T> {
	public static final int InOrder = 0, PostOrder = 1, PreOrder =2;
	public int size();
	public int height();
	public T get(int i);
	public boolean contains(T d);

	/**
	 * add a data in a random node
	 * @param d
	 */
	public void add(T d);

	/**
	 * compute and return an inOrder Iterator;
	 * @return
	 */
	public Iterator<T> iterator();

	/**
	 * return the mode count of this data structure - to allow iterator validation
	 * @return
	 */
	public int getMC();
}

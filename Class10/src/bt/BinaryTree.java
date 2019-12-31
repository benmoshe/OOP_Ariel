package bt;

import java.util.Iterator;

/**
 * This is a very simple example of Generics + iterator.
 * @param <T>
 */
public class BinaryTree<T> implements binary_tree<T>{
	protected Node<T> _root;
	protected int _mc;

	BinaryTree() {_root = null; _mc=0;}
	BinaryTree(Node<T> x) {
		this();
		_root = x;
	}
	public int size() {
		if(_root==null) {return 0;}
		BinaryTree<T> l = leftBT();
		BinaryTree<T> r = rightBT();
		return 1+ l.size()+r.size();
	}

	@Override
	public int height() {
		int ans=-1; // in case the tree is empty.
		if(!isEmpty()) {
			int hl = leftBT().height();
			int hr = rightBT().height();
			ans = 1+Math.max(hl,hr);
		}
		return ans;
	}
	public boolean isEmpty() {
		return _root==null;
	}
	/**
	 * traverse the tree (inOrder) and return the node data at the k'th position.
	 * @param ind
	 * @return
	 */
	public T get(int ind) {
		int s = size();
		if(ind<0 || ind>= s) {
			throw new RuntimeException("ERR: out of bound got "+ind+"  size="+s);
		}
		BinaryTree<T> l = leftBT();
		BinaryTree<T> r = rightBT();
		int ls = l.size();
		if(ind<ls) {return l.get(ind);}
		if(ind == ls) {return this._root.get_data();}
		int k = ind - (1+ls);
		return r.get(k);
	}

	@Override
	public boolean contains(T d) {
		return false;
	}

	public void add(T t) {
		Node<T> n = new Node<T>(t);
		if(_root==null) {_root=n;}
		else {
			double d = Math.random();
			if (d < 0.5) {
				if (_root.get_left() == null) {
					_root.set_left(n);
				} else {
					leftBT().add(t);
				}
			} else {
				if (_root.get_right() == null) {
					_root.set_right(n);
				} else {
					rightBT().add(t);
				}
			}
		}
		_mc++;
	}

	@Override
	public int getMC() {
		return _mc;
	}
	public Iterator<T> iterator() {return new InOrderIterator();}
/////////////////// Private /////////////////
	private BinaryTree<T> leftBT() {
		BinaryTree<T> l = new BinaryTree<T>(_root.get_left());
		return l;
	}
	private BinaryTree<T> rightBT() {
		BinaryTree<T> r = new BinaryTree<T>(_root.get_right());
		return r;
	}

	private class InOrderIterator implements Iterator<T> {
		private int _ind;
		private InOrderIterator() {_ind=0;}
		@Override
		public boolean hasNext() {
			return _ind<size();
		}

		@Override
		public T next() {
			T ans = get(_ind);
			_ind++;
			return ans;
		}
	}
}

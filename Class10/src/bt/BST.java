package bt;

import java.util.Comparator;
import java.util.Iterator;
import java.util.ArrayList;

public class BST<T> extends BinaryTree<T> implements binary_search_tree<T> {
    private Comparator<T> _comp;
    public BST() {
        super();
        init();
    }
    public BST(Node<T> t) {super(t);}

    @Override
    public void setComperator(Comparator<T> c) {
        if(c!=null) {
            _comp = c;
        }
    }
    public T search(T data) {
        if(isEmpty()) {return null;}
        return search(_root, data);
    }
    public void add(T t) {
        Node<T> n = new Node<T>(t);
        if(_root==null) {_root=n;}
        else {
            if (this.isSmaller(t, _root.get_data())) {
                if (_root.get_left() == null) {
                    _root.set_left(n);
                } else {
                    leftBST().add(t);
                }
            } else {
                if (_root.get_right() == null) {
                    _root.set_right(n);
                } else {
                    rightBST().add(t);
                }
            }
        }
        _mc++;
    }
    @Override
    public Comparator<T> getComperator() {
        return null;
    }

    private boolean isBigger(T n, T t) {
        return _comp.compare(n,t)>0;
    }
    private boolean isTheSame(T n, T t) {
        return _comp.compare(n,t)==0;
    }
    private boolean isSmaller(T n, T t) {
        return !isBigger(n,t) && !isTheSame(n,t);
    }
    ///////////////////////////////////////////////

    public T search(Node<T> curr, T data) {
        if(curr==null) return null;
        T c = curr.get_data();
        if(isTheSame(c, data)) {return c;}
        if(isBigger(c,data)) {return search(curr.get_left(),data);}
        return search(curr.get_right(),data);
    }
    /////////////////// Private /////////////////
    private BST<T> leftBST() {
        BST<T> l = new BST<T>(_root.get_left());
        l._comp = _comp;
        return l;
    }
    private BST<T> rightBST() {
        BST<T> r = new BST<T>(_root.get_right());
        r._comp = _comp;
        return r;
    }
    private void init() {
        _comp = new ToStringComp();
    }
    private class ToStringComp implements Comparator<T>{
        private ToStringComp() {;}

        @Override
        public int compare(T o1, T o2) {
            int ans =  o1.toString().compareTo(o2.toString());
            return ans;
        }
    }
    private class InOrderIterator implements Iterator<T> {
        private int _ind;
        private ArrayList<T> _data;
        private InOrderIterator() {
            _data = new ArrayList<T>();
            _ind=0;
            // ** now this is extremely unefficient!
            for(int i=0;i<size();i++) {
                _data.add(get(i));
            }
        }
        @Override
        public boolean hasNext() {
            return _ind<_data.size();
        }

        @Override
        public T next() {
            T ans = _data.get(_ind);
            _ind++;
            return ans;
        }
    }

}

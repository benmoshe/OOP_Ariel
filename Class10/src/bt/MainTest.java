package bt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class MainTest {
	public static void main(String[] a) {
		binary_search_tree<String> bt1 = new BST<String>();
		int size = 10; 
		ArrayList<String> data = new ArrayList<String>();
		for(int i=0;i<size;i++) {
			int r = new Random().nextInt();
			String d = ""+r;
			data.add(d);
			bt1.add(d);
		}
		
		size = bt1.size();
		System.out.println("size of be: "+size);
		for(int i=0;i<size;i++) {
			String c = bt1.get(i);
			System.out.println(i+")"+c);
		}
		Iterator<String> itr = bt1.iterator();
		while(itr.hasNext()) {
			String c = itr.next();
			System.out.println(c);
		}
	}
}

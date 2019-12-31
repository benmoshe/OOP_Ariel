package bt;

import java.util.ArrayList;

public class MainTest {
	public static void main(String[] a) {
		BinaryTree<String> bt1 = new BinaryTree<String>();
		int size = 10; 
		ArrayList<String> data = new ArrayList<String>();
		for(int i=0;i<size;i++) {
			String d = ""+i;
			data.add(d);
			bt1.add(d);
		}
		
		size = bt1.size();
		System.out.println("size of be: "+size);
		for(int i=0;i<size;i++) {
			String c = bt1.get(i);
			System.out.println(i+")"+c);
		}
	}
}

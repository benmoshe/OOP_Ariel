/**
 * This class represents a simple (not JUnot) tester for the Random class
 */
public class RandomTest {
    public static void main(String[] a) {
        test1();
        test2();
        test3();
    }
    public static void test1() {
        MyRandom r = new MyRandom(4);
        for(int i=0;i<10;i++) {
            System.out.println(i+") "+r.randomInt(1,7));
        }
    }
    public static void test2() {;}
    public static void test3() {;}
}

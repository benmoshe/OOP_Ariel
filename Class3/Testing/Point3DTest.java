import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class is a simple (and mostly partial) Junit tester for the class Point3D
 * Make sure you can compile it, run it, and add additional testing methods.
 */
public class Point3DTest {

    @Test
    /**
     * test if the add (aka translate) method is working as expected - as a simple vector translation.
     */
    public void add() {
        double x0=1,y0=2, z0=3;
        double x1=10,y1=100, z1=1000;
        Point3D p0 = new Point3D(x0,y0,z0);
        Point3D p1 = new Point3D(x1,y1,z1);
        p0.add(p1);
        Point3D r = new Point3D(x0+x1, y0+y1, z0+z1);
        assertEquals(p0,r);
    }

    @Test
    public void factor() {
        double f1 = 1, f2=2, f3 = -0.3;
        Point3D p0 = new Point3D(1,2,3);
        Point3D p1 = new Point3D(p0);
        p1.factor(1);
        assertEquals(p0,p1);
        p1.factor(f2);
        p1.factor(1/f2);
        assertEquals(p0,p1);
        p1.factor(f3);
        double d1 = p1.distance3D();
        double d0 = Math.abs(p0.distance3D()*f3);
        assertEquals(d0,d1,Point3D.EPS);
    }

    @Test
    public void toString1() {
    }

    @Test
    public void distance3D() {
        double x=3,y=4, z=0, r=5;
        Point3D p = new Point3D(x,y,z);
        double d2 = p.distance3D();
        assertEquals(d2,r,Point3D.EPS);
        double d3 = p.distance2D(new Point3D(Point3D.ORIGIN));
        assertEquals(d3,r,Point3D.EPS);
        int size=10;
        for(int i=0;i<size;i++) {
            x=Math.random();
            y=Math.random();
            z=Math.random();
            Point3D p2 = new Point3D(x,y,z);
            double d = p2.distance3D(p);
            double dx = x-p.x(), dy = y-p.y(), dz = z-p.z();
            double e = Math.pow(dx*dx+dy*dy+dz*dz, 0.5);
            assertEquals(d,e,Point3D.EPS);
        }
    }

    @Test
    public void equals1() {
        int size=10;
        for(int i=0;i<size;i++) {
            double x=Math.random();
            double y=Math.random();
            double z=Math.random();
            Point3D p1 = new Point3D(x,y,z);
            Point3D p2 = new Point3D(p1);
            Point3D p3 = new Point3D(p2.toString());
            assertEquals(p1,p2);
            assertEquals(p1.toString(),p3.toString());
            if(!p2.close2equals(p3)) {
                fail("Points: "+p2+","+p3+"  should be at least closeToEquale");
            }
            assertNotEquals(p1,null);
            assertNotEquals(p1.toString(),Point3D.ORIGIN.toString());
        }
    }

    /**
     * This testing method is a bit tricky - make sure you got it right.!
     */
    @Test
    public void pointLineTest2() {
    }
}
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * This class represents a collection of Points3D in space.
 * with the following public methods:
 * 1. Init
 * 2. Java.utils.collection <Point3D>
 * 3. save(String file_name)
 * 4. load(Stirng file_name)
 */
public class Points3D extends ArrayList<Point3D> {
    public Points3D() {super();}
    public boolean save(String file_name){ return false;}
    public boolean load(String file_name) throws IOException {
        return false;}
    public boolean equals(Object oth){
        boolean ans = false;
        if(oth!=null && oth instanceof Collection) {
            ans = true;
            Collection t = (Collection)oth;
            Iterator itr = t.iterator();
            while(ans && itr.hasNext()) {
                if(!this.contains(itr.next())) {
                    ans = false;
                }
            }
            itr = this.iterator();
            while(ans && itr.hasNext()) {
                if(!t.contains(itr.next())) {
                    ans = false;
                }
            }
        }

        return ans;
    }
 }

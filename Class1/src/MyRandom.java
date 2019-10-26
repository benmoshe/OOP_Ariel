import java.util.Random;
/**
 * This class represents a set of mathemticly function related to random number
 */
public class MyRandom {
    private long _seed;
    private Random _rand;
    public MyRandom(long seed) {
        _seed = seed;
        _rand = new Random(_seed);
    }
    public MyRandom() {
        this(new Random().nextLong());
    }
    public double random() {
        double ans = 0;
        ans = this._rand.nextDouble();
        return ans;
    }
    public double random(double min, double max) {
        if(min>max) {
            throw new RuntimeException("ERR: random(min,max) should get a valid range [min,max). got ["+min+","+max+")");
        }
        double ans = 0;
        double r = random();
        double dx = max-min;
        ans  = min + dx*r;
        return ans;
    }
    public double randomInt(int min, int max) {
        if(min>max) {
            throw new RuntimeException("ERR: randomInt(min,max) should get a valid range [min,max). got ["+min+","+max+")");
        }
        double ans = 0;
        double dx = max-min;
        int randPosInt = Math.abs(_rand.nextInt());
        double r = randPosInt % dx;
        ans  = min + r;
        return ans;
    }
}

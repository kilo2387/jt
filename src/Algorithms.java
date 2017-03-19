
import javax.xml.soap.SOAPElementFactory;

/**
 * Created by kilo on 2017/3/12.
 */
class Algorithms {

    public int age = 888;
    /**
     * 求最大公约数
     * @param p
     * @param q
     * @return
     */
//    public Algorithms(){
//        int a =this.age;
//    }
    public int gcd(int p, int q){
        if(q == 0)
            return p;
        int r = p % q;
        if(r == 0){
            return q;
        }
        return gcd(q, r);
    }

    public int sdfd(){
        int a = this.age;
        return a;
    }
}


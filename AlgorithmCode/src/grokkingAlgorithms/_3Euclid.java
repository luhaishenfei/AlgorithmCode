package grokkingAlgorithms;

public class _3Euclid {
    public static void main(String[] args) {
        //System.out.println(gcd(168,64));


    }

    static int gcd(int m,int n)
    {   if(n == 0){
        return m;
    }
        return gcd(n,m%n);
    }
}

package ebook.ComputerSystems_AProgrammer_sPerspective.chapter2;

public class C2_13ans {
    public static void main(String[] args) {
        C2_13ans ans = new C2_13ans();
        for (int i = 0; i < 10; i++) {
            int x = (int) Math.random() * 1000;
            int y = (int) Math.random() * 1000;
            System.out.println(ans.bool_xor(x, y) == (x ^ y));
        }
    }

    // x=10001010
    // m=00000111
    //re=10001111
    int bis(int x, int m) {
        return x | m;
    }

    // x=10001010
    // m=00000111
    //re=10001000
    int bic(int x, int m) {
        return ~bis(~x, m);
    }


    //x=0110
    //y=1100
    //r=1110
    int bool_or(int x, int y) {
        return bis(x, y);
    }



    /*
    x=0110
    y=1100

   ~x 1001
   bic y,~x   0100
   (bis y,x)  1110
   bic 1110,0100


    r=1010

     */

    int bool_xor(int x, int y) {
        /*
        int tmp=bic(y,~x);
        x=bis(y,x);
        return bic(x,tmp);
         */
        //优化后
        return bic(bis(y,x),bic(y,~x));
    }
}

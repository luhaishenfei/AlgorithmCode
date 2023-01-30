package ebook.ComputerSystems_AProgrammer_sPerspective.chapter2._1;

public class C2_12ans {
    public static void main(String[] args) {

        System.out.println("A:"+resolveA(0x87654321, 0x000000FF));
        System.out.println("B:"+resolveB(0x87654321, 0x000000FF));
        System.out.println("C:"+resolveC(0x87654321, 0x000000FF));

    }
    /*
    0x87654321
   &0xFFFFFF00
    -->
    1000 0111 0110 0101 0100 0011 0010 0001
    1111 1111 1111 1111 1111 1111 0000 0000
    ---------------------------------------
    1000 0111 0110 0101 0100 0011 0000 0000
     */
    public static int resolveA(int x, int w) {
        return x & w;
    }

    public static int resolveB(int x, int w) {
        return (~x & ~w) + (x & w);
        //优化后为：
        //return x^~w;
    }

    public static int resolveC(int x, int w) {
        return (x & ~w) +  w;
        //优化后为：
        //return x|w;
    }




    public void test(){
        System.out.println("test");

        System.out.println(0x12345678
                & 0x22222222);
        //                 0x02200220

        System.out.println(0x12345678
                | 0x22222222);
        //                 0x3236767A

        System.out.println(0x12345678
                ^ 0x22222222);
        //                 0x3016745A

        System.out.println(~0x12345678);
        //                 0xEDCBA987

        System.out.println("0xFFFFFFFF");
        System.out.println(0x12345678
                & 0xFFFFFFFF);
        //        0x12345678

        System.out.println(
                0x12345678
                        | 0xFFFFFFFF);
        //       0xFFFFFFFF

        System.out.println(
                0x12345678
                        ^
                        0xFFFFFFFF);
        //       0x3016745A

        System.out.println(~0x12345678);
        //                  0xEDCBA987


    }
}

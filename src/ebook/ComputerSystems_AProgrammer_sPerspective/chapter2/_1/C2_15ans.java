package ebook.ComputerSystems_AProgrammer_sPerspective.chapter2._1;

public class C2_15ans {
    public static void main(String[] args) {
//        int i = 0B0111 << 6;
        System.out.println(C2_15ans.isEqual(0x11, 0x13));
        System.out.println(C2_15ans.isEqual(0x1112, 0x1112));
    }


    /*
    10100
   ^0
   =11111
     */


    static boolean isEqual(int x,int y){
        return (x^y)==0?true:false;
    }
}

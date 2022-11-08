package ebook.ComputerSystems_AProgrammer_sPerspective.chapter2;

public class DecToHex {
    public static void main(String[] args) {
        System.out.println(DecToHex.toHex(7654360));
    }

    public static String toHex(int dec) {
        String res = "";
        if (dec == 0) {
            return "0x00";
        }
        while (dec != 0) {
            int left = dec % 16;
            dec = dec / 16;
            switch (left) {
                case 10:
                    res = 'A' + res;
                    break;
                case 11:
                    res = 'B' + res;
                    break;
                case 12:
                    res = 'C' + res;
                    break;
                case 13:
                    res = 'D' + res;
                    break;
                case 14:
                    res = 'E' +res;
                    break;
                case 15:
                    res = 'F' +res;
                    break;
                default:
                    res = left +res;
                    break;
            }
        }
        return "0x"+res;
    }
}
